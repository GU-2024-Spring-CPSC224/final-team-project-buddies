package edu.gonzaga.data;

import edu.gonzaga.notify.UIResponse;
import edu.gonzaga.tools.ScreenInfo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TrainBtnActionListener implements ActionListener 
{
    public JButton runTrainBtn;
    public JButton speedTrainBtn;
    public JButton enduranceTrainBtn;
    public UIResponse uiResponse;

    public void setUiResponse(UIResponse uiResponse) 
    {
        this.uiResponse = uiResponse;
    }

    public TrainBtnActionListener(JButton runTrainBtn, JButton speedTrainBtn, JButton enduranceTrainBtn)
    {
        this.runTrainBtn = runTrainBtn;
        this.speedTrainBtn = speedTrainBtn;
        this.enduranceTrainBtn = enduranceTrainBtn;

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==runTrainBtn) {
            training(15,"Skills");
        }
        else if (e.getSource()==speedTrainBtn){
            training(6,"Speed");
        }else {
            training(8,"Stamina");
        }

    }


    private void training(int time,String trainType)
    {
        JDialog trainDialog =new JDialog();
        trainDialog.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        int width = 300;
        int height = 230;
        trainDialog.setBounds((int)((ScreenInfo.getScreenSize().width-width)/2), (int)((ScreenInfo.getScreenSize().height-height)/2),width,height);
        trainDialog.setModal(true);
        trainDialog.setLayout(null);


        JLabel infoLabel =new JLabel()
        {
            public void setText(String text)
            {
                super.setText("Remaining time：" + text);
            }
        };
        infoLabel.setFont(new Font("Times New Roman",Font.BOLD,20));
        trainDialog.add(infoLabel);
        infoLabel.setBounds((int)(width*0.3),(int)(height*0.3),(int)(width*0.8),(int)(height*0.2));

        infoLabel.setText("--");

        trainDialog.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) 
            {
                super.windowClosing(e);
                int value=JOptionPane.showConfirmDialog(null, "Stop training", "Dialog", WindowConstants.DO_NOTHING_ON_CLOSE);
                if (value==JOptionPane.YES_OPTION)
                {
                    trainDialog.dispose();
                }
            }
        });

        new Thread()
        {
            public void run()
            {
                try 
                {
                    int i =0;
                    while (i<=time*1000) 
                    {
                        Thread.sleep(1000);
                        infoLabel.setText(" " + (time - i/1000));
                        i += 1000;
                    }
                    trainDialog.dispose();
                    uiResponse.trainResponse();

                } catch (InterruptedException e) 
                {
                    e.printStackTrace();
                }
            }
        }.start();
        trainDialog.setTitle(trainType);
        trainDialog.setVisible(true);

    }
}

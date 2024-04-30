package edu.gonzaga.notify;

import javax.swing.*;
import java.awt.*;

public class UIResponse 
{
    JLabel horseLabel;
    JPanel responsePanel;
    public UIResponse(JLabel horseLabel, JPanel responsePanel)
    {
        this.horseLabel = horseLabel;
        this.responsePanel = responsePanel;
    }

    public void trainResponse()
    {
        JLabel label=createRespLabel();
        label.setText("Finish training");
        handle(label);
    }

    public void raiseResponse(){
         JLabel label=createRespLabel();
        label.setText("Finish Feeding");
        handle(label);
    }

    private JLabel createRespLabel()
    {
        JLabel responseLabel = new JLabel();
        Font font =new Font("Times New Roman", Font.BOLD, 22);
        responseLabel.setFont(font);
        responseLabel.setForeground(Color.red);
        responseLabel.setSize(100,35);
        responsePanel.add(responseLabel);
        return responseLabel;
    }


    private void handle(JLabel responseLabel)
    {
        new Thread(){
            public void run()
            {
                int x = horseLabel.getX()+horseLabel.getWidth()+5;
                int y = horseLabel.getY()+10;
                responseLabel.setBounds(x,y,100,24);
                y-=20;
                while (responseLabel.getY()>=y)
                {
                    responseLabel.setLocation(x,responseLabel.getY()-1);
                    try {
                        Thread.sleep(40);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                responseLabel.setVisible(false);

            }
        }.start();
    }

}


package edu.gonzaga.view;

import edu.gonzaga.horse.HorseBase;

import javax.swing.*;
import java.awt.*;

public class Cul_InfoPanel extends JPanel 
{
    private JLabel wealthLabel ;
    private JLabel horseNameLabel;
    private JLabel levelLabel;
    private JLabel  tipLabel;

    public Cul_InfoPanel(int wealth, HorseBase horse)
    {
        this.wealthLabel = new JLabel()
        {
            public void setText(String text)
            {
                super.setText("Deposit："+text);
            }
        };

        this.horseNameLabel = new JLabel()
        {
            public void setText(String text)
            {
                super.setText("Name："+text);
            }
        };

        this.levelLabel = new JLabel()
        {
            public void setText(String text)
            {
                super.setText("Level: "+text);
            }
        };

        tipLabel = new JLabel("Recent horse：");

        setLayout(null);
        Font font = new Font("Times New Roman",Font.BOLD,20);
        Font tipFont = new Font("Times New Roman",Font.BOLD,25);
        wealthLabel.setFont(tipFont);
        horseNameLabel.setFont(font);
        levelLabel.setFont(font);
        tipLabel.setFont(tipFont);


        add(wealthLabel);
        add(tipLabel);
        add(horseNameLabel);
        add(levelLabel);

        wealthLabel.setText(wealth+"");
        horseNameLabel.setText(horse.getName());
        levelLabel.setText(horse.getLevel()+"");
    }


    public void setWealth(int wealth) 
    {
        this.wealthLabel.setText(wealth + " ");
    }

    public void setHorseName(String horseName) 
    {
        this.horseNameLabel.setText(horseName);
    }

    public void setLeveL(String leve) 
    {
        this.levelLabel.setText(leve);
    }


    public void setTextLocation(int x,int y,int space,int width,int height)
    {
        this.wealthLabel.setBounds(x,y,width,height);
        this.tipLabel.setBounds(x,y+space+height,width,height);
        this.horseNameLabel.setBounds(x+10,y+height*2+space,width,height);
        this.levelLabel.setBounds(x+10,y+height*3+space,width,height);

        System.out.print(wealthLabel.getText() + "\n");
    }
}
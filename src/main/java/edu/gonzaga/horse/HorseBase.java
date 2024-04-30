package edu.gonzaga.horse;

import javax.swing.*;
import java.awt.*;

public abstract class HorseBase extends JPanel {
    private String name;
    private int level;
    private  int stateImg=0;
    protected ImageIcon[] images = new ImageIcon[4];

    JLabel horseLabel = new JLabel();
    JLabel horseNameLabel = new JLabel();

    protected int raceRecord;

    {
        horseLabel.setPreferredSize(new Dimension(311,175));
        horseNameLabel.setFont(new Font("Times New Roman",Font.BOLD,30));
        horseNameLabel.setForeground(Color.white);
        this.setSize(311,220);
        this.add(horseLabel);
        this.add(horseNameLabel);
        setBackground(null);
        setOpaque(false);
    }


    protected HorseBase(String name, int level, String imgPath)
    {
        this.name = name;
        this.level = level;

        setName(name);

        for (int i = 0; i < 4; i++)
        {
            images[i]=new ImageIcon(imgPath + (i+1) + ".png");
        }

        if (images[0]!=null)
        {
            horseLabel.setIcon(images[0]);
        }
    }

    public abstract long getRateFactor();

    public int HorseRun()
    {
        this.setLocation(getX() + 1, getY());
        switchHorseImg();
        return getX();
    }


    public void switchHorseImg()
    {
        switch (stateImg)
        {
            case 0: horseLabel.setIcon(images[0]); stateImg++; break;
            case 1: horseLabel.setIcon(images[1]); stateImg++; break;
            case 2: horseLabel.setIcon(images[2]); stateImg++; break;
            case 3: horseLabel.setIcon(images[3]); stateImg=0; break;
        }

    }
    public void rest()
    {
        raceRecord=0;
    }



    public String getName() 
    {
        return name;
    }

    public void setName(String name) 
    {
        this.name = name;
        this.horseNameLabel.setText(name);
    }

    public int getLevel() 
    {
        return level;
    }
    public void setLevel(int level)
    {
        this.level=level;
    }

    public ImageIcon getDefaultHorseImg() 
    {
            return images[0];
    }
}
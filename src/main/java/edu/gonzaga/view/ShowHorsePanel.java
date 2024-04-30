package edu.gonzaga.view;

import edu.gonzaga.horse.HorseBase;

import javax.swing.*;
import java.awt.*;

public class ShowHorsePanel extends JPanel 
{
    private HorseBase horseBase ;
    public HorseBase getHorseBase() 
    {
        return horseBase;
    }
    
    JLabel levelLabel;
    JLabel nameLabel;
    JLabel showHorseLabel;

    public ShowHorsePanel(HorseBase horse)
    {
        newHorseBox(horse);
        horseBase=horse;
    }

    private void newHorseBox(HorseBase horse)
    {

        Color boxPanelBgColor = new Color(227, 227, 227);
        Font font = new Font("Times New Roman",Font.BOLD,20);

        setLayout(null);
        setBackground(boxPanelBgColor);

        //show label
        showHorseLabel = new JLabel();
        showHorseLabel.setIcon(horse.getDefaultHorseImg());
        add(showHorseLabel);
        showHorseLabel.setBounds(-20,-5,230,175);

        //show name
        nameLabel = new JLabel()
        {
            public void setText(String text)
            {
                super.setText("Name:"+text);
            }
        };
        nameLabel.setText(horse.getName());
        nameLabel.setFont(font);
        add(nameLabel);
        nameLabel.setBounds(50,175,100,25);

        //show level
        levelLabel = new JLabel(horse.getLevel() + " ")
        {
            public void setText(String text)
            {
                super.setText("Level: "+text);
            }
        };

        levelLabel.setFont(font);
        add(levelLabel);
        levelLabel.setBounds(50,210,100,25);
    }

    public void changeHorse(HorseBase horse)
    {
        showHorseLabel.setIcon(horse.getDefaultHorseImg());
        nameLabel.setText(horse.getName());
        levelLabel.setText(horse.getLevel() + " ");
    }
}

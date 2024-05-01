package edu.gonzaga.view;

import edu.gonzaga.horse.HorseBase;
import edu.gonzaga.notify.INotifyChange;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShowHorseBox extends ShowHorsePanel implements ActionListener 
{

    private JButton selectBtn;
    INotifyChange notifyChange;

    public ShowHorseBox(int pos_x, HorseBase horse, INotifyChange notifyChange)
    {
        super(horse);
        this.notifyChange = notifyChange;
        setBounds(100 + pos_x * 250, 100, 230, 300);
        selectBtn = new JButton("Choose");
        add(selectBtn);
        selectBtn.setBounds(50, 250, 100, 30);
        selectBtn.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        notifyChange.notifyChange(getHorseBase());
    }
}

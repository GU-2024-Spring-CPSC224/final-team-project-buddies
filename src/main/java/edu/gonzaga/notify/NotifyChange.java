package edu.gonzaga.notify;

import edu.gonzaga.horse.HorseBase;

import javax.swing.*;

public class NotifyChange 
{
     HorseBase curSelHorse;
     JLabel curSelHorseLabel;

    public NotifyChange(HorseBase curSelHorse,JLabel curSelHoreLabel)
    {
        this.curSelHorse = curSelHorse;
        this.curSelHorseLabel = curSelHoreLabel;
    }

    public NotifyChange()
    {

    }

    public void notifyCulSelHorseChange(HorseBase selectedHorse)
    {
        this.curSelHorse = selectedHorse;
        if (curSelHorseLabel!=null)
        {
            curSelHorseLabel.setText(selectedHorse.getName());
        }

    }


    public HorseBase getCurSelHorse() 
    {
        return curSelHorse;
    }

    public void setCurSelHorse(HorseBase curSelHorse) 
    {
        this.curSelHorse = curSelHorse;
    }

    public JLabel getCurSelHorseLabel() 
    {
        return curSelHorseLabel;
    }

    public void setCurSelHorseLabel(JLabel curSelHorseLabel) 
    {
        this.curSelHorseLabel = curSelHorseLabel;
    }
}
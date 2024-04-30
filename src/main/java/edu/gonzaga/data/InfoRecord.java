package edu.gonzaga.data;

import javax.swing.*;

public class InfoRecord 
{
    public int matchNum = 0;
    public int firstTimes =0;

    JLabel matchNumLabel;
    JLabel firstTimesLabel;

    public InfoRecord(JLabel matchNumLabel, JLabel firstTimesLabel)
    {
        this.matchNumLabel = matchNumLabel;
        this.firstTimesLabel = firstTimesLabel;
    }

    public void matchNumPlus()
    {
        matchNum++;
        matchNumLabel.setText(matchNum + " ");
    }

    public void firstTimesPlus()
    {
        firstTimes++;
        firstTimesLabel.setText(firstTimes + " ");
    }
}

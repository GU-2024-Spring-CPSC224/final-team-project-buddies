package edu.gonzaga.match;

import edu.gonzaga.data.Achievement;
import edu.gonzaga.data.InfoRecord;
import edu.gonzaga.horse.HorseBase;
import edu.gonzaga.info.MatchInfo;
import edu.gonzaga.view.MainView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HorseMatch implements Runnable {
    private HorseBase horse;

//    private int pos;
    private MatchInfo matchInfo;
    private InfoRecord infoRecord;

    public HorseMatch(HorseBase horse,MatchInfo matchInfo,InfoRecord infoRecord)
    {
        this.horse = horse;
        this.matchInfo = matchInfo;
//        pos=horse.getLocation().x;
        this.infoRecord = infoRecord;
    }

    @Override
    public void run() 
    {
        long startTime = System.currentTimeMillis();
        while (horse.HorseRun() < matchInfo.getDistance())
        {
            try {Thread.sleep(horse.getRateFactor());

            } catch (InterruptedException e) 
            {
                e.printStackTrace();
            }

        }
        matchInfo.achievements[matchInfo.getCurrentArriveNum()] = new Achievement(horse.getName(),(System.currentTimeMillis()-startTime)*0.001);
        arriveState();
    }


    private void arriveState()
    {
        if (matchInfo.arriveNumPlus())
        {
            horse.rest();
            MainView.toMacthSortShow(matchInfo.achievements);
            infoRecord.matchNumPlus();
        }
    }
}

package edu.gonzaga.notify;

import edu.gonzaga.data.MasterAssets;
import edu.gonzaga.horse.HorseBase;
import edu.gonzaga.match.HorseMatch;
import edu.gonzaga.match.MatchHorses;
import edu.gonzaga.notify.INotifyChange;
import edu.gonzaga.view.Cul_InfoPanel;
import edu.gonzaga.view.ShowHorseBox;
import edu.gonzaga.view.ShowHorsePanel;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class LevelUpChange implements INotifyChange 
{
    ShowHorsePanel showHorsePanel;
    MatchHorses matchHorses;
    Cul_InfoPanel cul_infoPanel;

    public void setCul_infoPanel(Cul_InfoPanel cul_infoPanel) {
        this.cul_infoPanel = cul_infoPanel;
    }

    public LevelUpChange()
    {
    }

    public boolean isLevelUp(){
        Random random = new Random();
        int n = random.nextInt(1000);
        if (n < 50)
        {
            notifyChange(matchHorses.getSelectedHorse().getLevel()+1);
            JOptionPane.showConfirmDialog(null,"Level Up","Information",JOptionPane.DEFAULT_OPTION);
            return true;
        }
        return false;
    }


    @Override
    public void notifyChange(Object obj) 
    {
        int level=0;
        if (obj!=null){
            level = (int)obj;
        }
        if (showHorsePanel!=null)
        {
            HorseBase horseBase=showHorsePanel.getHorseBase();
            horseBase.setLevel(level);
        }
        if (cul_infoPanel!=null)
        {
            cul_infoPanel.setLeveL(level + " ");
        }
        if (matchHorses!=null)
        {
            matchHorses.getSelectedHorse().setLevel(level);
        }


    }



    public void setShowHorsePanel(ShowHorsePanel showHorsePanel) {
        this.showHorsePanel = showHorsePanel;
    }
    public void setMatchHorses(MatchHorses matchHorses) {
        this.matchHorses = matchHorses;
    }

}



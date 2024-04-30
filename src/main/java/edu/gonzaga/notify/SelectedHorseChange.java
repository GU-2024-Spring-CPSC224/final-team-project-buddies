package edu.gonzaga.notify;

import edu.gonzaga.view.Cul_InfoPanel;
import edu.gonzaga.match.MatchHorses;
import edu.gonzaga.view.ShowHorsePanel;
import edu.gonzaga.horse.HorseBase;

import javax.swing.*;

public class SelectedHorseChange implements INotifyChange 
{
    HorseBase selectedHorse;
    JLabel selHorseLabel;
    ShowHorsePanel selectedHorsePanel;
    MatchHorses matchHorses;
    Cul_InfoPanel cul_infoPanel;
    JLabel cul_horseLabel;

    public SelectedHorseChange(MatchHorses matchHorses,JLabel selHorseLabel,ShowHorsePanel selectedHorsePanel,Cul_InfoPanel cul_infoPanel,JLabel cul_horseLabel)
    {
        this.selectedHorse = matchHorses.getSelectedHorse();
        this.selHorseLabel=selHorseLabel;
        this.selectedHorsePanel = selectedHorsePanel;
        this.matchHorses = matchHorses;
        this.cul_infoPanel = cul_infoPanel;
    }

    @Override
    public void notifyChange(Object obj) 
    {
        try {
            HorseBase selectedHorse = (HorseBase) obj;
            if (selHorseLabel!=null)
            {
                selHorseLabel.setText(selectedHorse.getName());
                matchHorses.setSelectedHorse(selectedHorse);
            }
            if (selectedHorsePanel==null)
            {
                System.out.print("panel\n");
            }
            selectedHorsePanel.changeHorse(selectedHorse);
            cul_infoPanel.setHorseName(selectedHorse.getName());
            cul_infoPanel.setLeveL(selectedHorse.getLevel()+"");
        }
        catch(Exception ex) 
        {
            throw ex;
        }


    }

    public void setSelectedHorse(HorseBase selectedHorse) 
    {
        this.selectedHorse = selectedHorse;
    }

    public void setSelHorseLabel(JLabel curSelHorseLabel) 
    {
        this.selHorseLabel = curSelHorseLabel;
    }
}

package edu.gonzaga.notify;

import edu.gonzaga.view.Cul_InfoPanel;
import edu.gonzaga.data.MasterAssets;

import javax.swing.*;

public class AssetsChange implements INotifyChange
{
    Cul_InfoPanel cul_wealthPanel;
    JLabel info_wealthLabel;
    MasterAssets masterAssets;
    public AssetsChange(JLabel info_wealthLabel,Cul_InfoPanel cul_infoPanel,MasterAssets masterAssets)
    {
        this.cul_wealthPanel =cul_infoPanel;
        this.info_wealthLabel = info_wealthLabel;
        this.masterAssets = masterAssets;
    }
    @Override
    public void notifyChange(Object obj) 
    {
        int wealth = (int) obj;
        cul_wealthPanel.setWealth(wealth);
        info_wealthLabel.setText(wealth + " ");
        masterAssets.wealth = wealth;
    }
}

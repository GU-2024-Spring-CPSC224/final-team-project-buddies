package edu.gonzaga.view;

import edu.gonzaga.data.MasterAssets;
import edu.gonzaga.notify.INotifyChange;
import edu.gonzaga.notify.LevelUpChange;
import edu.gonzaga.notify.UIResponse;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GoodsPanel extends JPanel implements ActionListener 
{
    JLabel imgLabel ;
    JLabel nameLabel;
    JLabel priceLabel;
    JButton buyBtn;
    int price;
    INotifyChange assetsChange;
    MasterAssets masterAssets;
    static UIResponse uiResponse;
    static LevelUpChange levelUpChange;

    public static void setLevelUpChange(LevelUpChange levelUpChange) 
    {
        GoodsPanel.levelUpChange = levelUpChange;
    }

    public GoodsPanel(String imgPath, String name, int price, MasterAssets masterAssets, INotifyChange assetsChange)
    {
        imgLabel = new JLabel();
        nameLabel = new JLabel();
        priceLabel = new JLabel();
        buyBtn = new JButton("Purchase");

        this.price = price;
        this.priceLabel.setText(price+" $");
        this.imgLabel.setIcon(new ImageIcon(imgPath));
        this.nameLabel.setText(name);
        this.assetsChange = assetsChange;
        this.masterAssets = masterAssets;

        Font font = new Font("Times new Roman",Font.BOLD,20);
        nameLabel.setFont(font);
        priceLabel.setFont(font);


        GridLayout layout = new GridLayout(1,4);

        setLayout(layout);
        add(imgLabel);
        add(nameLabel);
        add(priceLabel);
        add(buyBtn);

        buyBtn.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) 
    {

        if (masterAssets.wealth-price>0){
            int wealth = masterAssets.wealth - price;
            assetsChange.notifyChange(wealth);
            if (uiResponse!=null){
                uiResponse.raiseResponse();
            }
            levelUpChange.isLevelUp();
        }

    }

    public static void  setUiResponse(UIResponse uiResponse)
    {
        GoodsPanel.uiResponse = uiResponse;
    }
}

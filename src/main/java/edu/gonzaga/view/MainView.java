package edu.gonzaga.view;

import edu.gonzaga.data.*;
import edu.gonzaga.horse.HorseBase;
import edu.gonzaga.info.MainViewPanelInfo;
import edu.gonzaga.info.MatchInfo;
import edu.gonzaga.info.MatchPanelInfo;
import edu.gonzaga.match.HorseMatch;
import edu.gonzaga.match.MatchHorses;
import edu.gonzaga.notify.*;
import edu.gonzaga.tools.ScreenInfo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MainView extends JFrame implements ActionListener 
{
    public static MainViewPanelInfo mainViewPanelInfo= new MainViewPanelInfo();
    public static MatchPanelInfo matchPanelInfo = new MatchPanelInfo();
    public static MasterAssets  masterAssets = new MasterAssets();

    static InfoRecord infoRecord ;
    static MatchHorses matchHorses = new MatchHorses();

    JButton item1Btn;
    JButton item2Btn;
    JButton item3Btn;

    private static CardLayout matchLayout = new CardLayout();;

    JLabel selectedlHorseLabel;
    ShowHorsePanel selHorseShowPanel;
    JLabel wealthLabel;
    JLabel horseNumLabel;
    JLabel macthNumLabel;
    JLabel firstNumLabel;
    Cul_InfoPanel cul_infoPanel;
    JLabel cul_horseLabel;
    static JButton goBackBtn;
    JPanel showInfoPanel ;
    static JLabel gainMoneyLabel ;

    INotifyChange seldHorseNC ;
    static INotifyChange assetsChange;
    UIResponse uiResponse;
    LevelUpChange levelUpChange;
    /**
     * MainView 
     */
    public MainView() {
        propInit();
        windowInit();
        windowLayout();
        matchPanel_Init();
        culturePanel_Init();
        stablePanel_Init();
        infoPanel_Init();
    }


    /**
     * Switching boards for different purposes
     * @param matchSubPanelShow 
     */
    public static void adjustShow(MatchSubPanelShow matchSubPanelShow) 
    {
        if (matchSubPanelShow!=null)
        {
            if (matchSubPanelShow==matchSubPanelShow.levelSelectPanel)
                matchLayout.first(mainViewPanelInfo.matchPanel);
            if (matchSubPanelShow==matchSubPanelShow.racePanel){
                matchLayout.first(mainViewPanelInfo.matchPanel);
                matchLayout.next(mainViewPanelInfo.matchPanel);
            }
        }
    }

    public static void  toMacthSortShow(Achievement[] achievements)
    {

        JPanel sortPanel = matchPanelInfo.sortPanel;
        mainViewPanelInfo.matchPanel.add(sortPanel);
        matchLayout.last(mainViewPanelInfo.matchPanel);
        sortPanel.removeAll();

        sortPanel.setLayout(null);

        JTextArea sortTxtArea = new JTextArea();
        sortTxtArea.setEnabled(false);

        JLabel headLabel = new JLabel()
        {
            public void  setText(String text)
            {
                super.setText("The rank is "+text);
            }
        };

        gainMoneyLabel = new JLabel()
        {
            public void  setText(String text)
            {
                super.setText("You gain $ "+text);
            }
        };
        gainMoneyLabel.setLocation(200,600);
        gainMoneyLabel.setSize(200,40);
        gainMoneyLabel.setFont(new Font("Times New Roman",Font.BOLD,26));
        sortPanel.add(gainMoneyLabel);

        int n =0;

        for (Achievement achievement:achievements){

           if (achievement!=null)
           {
               sortTxtArea.append("No."+(n+1)+" "+achievement.name+"\t use time: "+achievement.time+"\n");
               if (achievement.name==matchHorses.getSelectedHorse().getName()) {
                   {
                       headLabel.setText((n+1) + " ");
                       switch (n){
                           case 0: infoRecord.firstTimesPlus();gainMoneyLabel.setText(15+"");assetsChange.notifyChange(masterAssets.wealth+15);break;
                           case 1: gainMoneyLabel.setText(5+"");assetsChange.notifyChange(masterAssets.wealth+5);break;
                           case 2: gainMoneyLabel.setText(-5+"");assetsChange.notifyChange(masterAssets.wealth-5);break;
                       }
                   }
               }
               n++;
           }
        }

        sortPanel.add(headLabel);
        sortPanel.add(sortTxtArea);
        sortTxtArea.setFont(new Font("Times New Roman",Font.BOLD,28));
        headLabel.setFont(new Font("Times New Roman",Font.BOLD,32));
        headLabel.setBounds(100,100,800,40);
        sortTxtArea.setBounds(130,200,900,200);

        goBackBtn = new JButton("Confirm");
        goBackBtn.setFont(new Font("Times New Roman",Font.BOLD,30));
        goBackBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                adjustShow(MatchSubPanelShow.levelSelectPanel);
            }
        });
        sortPanel.add(goBackBtn);
        goBackBtn.setBounds(400,450,240,80);
    }

    private void propInit()
    {
        selectedlHorseLabel = new JLabel()
        {
            public void setText(String txt)
            {
                super.setText("The horse for now："+txt);
            }
        };
        
        matchHorses.setSelectedHorse((HorseBase) masterAssets.horsesHashMap.values().toArray()[0]);
        selHorseShowPanel=new ShowHorsePanel(matchHorses.getSelectedHorse());
        cul_infoPanel = new Cul_InfoPanel(masterAssets.wealth,matchHorses.getSelectedHorse());
        seldHorseNC =new SelectedHorseChange(matchHorses,selectedlHorseLabel,selHorseShowPanel,cul_infoPanel,cul_horseLabel);

        wealthLabel = new JLabel()
        {
            public void setText(String text)
            {
                super.setText("Deposit："+text);
            }
        };

        firstNumLabel = new JLabel()
        {
            public void setText(String text){
                super.setText("No.1 Times："+text);
            }
        };

        macthNumLabel = new JLabel()
        {
            public void setText(String text)
            {
                super.setText("Times for enter game："+text);
            }
        };


        infoRecord = new InfoRecord(macthNumLabel,firstNumLabel);

        cul_horseLabel = new JLabel();
        showInfoPanel = new JPanel();
        uiResponse = new UIResponse(cul_horseLabel,showInfoPanel);
        GoodsPanel.setUiResponse(uiResponse);

        levelUpChange = new LevelUpChange();
        levelUpChange.setCul_infoPanel(cul_infoPanel);
        levelUpChange.setMatchHorses(matchHorses);
        levelUpChange.setShowHorsePanel(selHorseShowPanel);
        GoodsPanel.setLevelUpChange(levelUpChange);
    }

    /**
     * Set up the initial panel
     */
    private  void windowInit(){
        int width = 1200;
        int height = 800;
        setBounds((ScreenInfo.getScreenSize().width-width)/2,(ScreenInfo.getScreenSize().height-height)/2,width,height);

        this.setResizable(false);
        this.setTitle("Horse Racing");
        this.setIconImage(new ImageIcon("src/main/java/edu/gonzaga/Images/StartPageViewIcon.png").getImage());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }


    /**
     * Further setup
     */
    private void  windowLayout(){
        JTabbedPane tabPanel = new JTabbedPane();
        this.setContentPane(tabPanel);


        tabPanel.addTab("Start the game",mainViewPanelInfo.matchPanel);
        tabPanel.addTab("Training",mainViewPanelInfo.culturePanel);
        tabPanel.addTab("Stable",mainViewPanelInfo.stablePanel);
        tabPanel.addTab("Infomation",mainViewPanelInfo.infoPanel);

        tabPanel.setFont(new Font("Times New Roman",Font.BOLD,42));


    }




    private void matchPanel_Init(){
        mainViewPanelInfo.matchPanel.setLayout(matchLayout);
        itemLevelSelect();
        horseRace();
    }

    private void itemLevelSelect()
    {
        JPanel selectPanel =new JPanel()
        {
            // background setup here
            protected void paintComponent(Graphics g) {
                g.drawImage((Image) new ImageIcon("src/main/java/edu/gonzaga/Images/bg.jpeg").getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
            }
        };
        matchPanelInfo.levelSelectPanel = selectPanel;
        mainViewPanelInfo.matchPanel.add(selectPanel);

        Font font = new Font("Times New Roman",Font.BOLD,30);

        selectPanel.setLayout(null);

        JLabel tipLabel = new JLabel("Racing terms：");
        item1Btn = new JButton("4 miles");
        item2Btn = new JButton("6 miles");
        item3Btn = new JButton("8 miles");



        tipLabel.setFont(font);
        item1Btn.setFont(font);
        item2Btn.setFont(font);
        item3Btn.setFont(font);


        tipLabel.setSize(400,120);
        int width = 150;
        int height = 50;
        item1Btn.setSize(width,height);
        item2Btn.setSize(width,height);
        item3Btn.setSize(width,height);


        selectPanel.add(tipLabel);
        selectPanel.add(item1Btn);
        selectPanel.add(item2Btn);
        selectPanel.add(item3Btn);

        item1Btn.addActionListener(this);
        item2Btn.addActionListener(this);
        item3Btn.addActionListener(this);

        int x = 800;
        int y = 150;
        int spacing = 100;
        tipLabel.setLocation(x,y);

        item1Btn.setLocation(x,y+spacing);
        item2Btn.setLocation(x,y+spacing*2);
        item3Btn.setLocation(x,y+spacing*3);



        JLabel selHorseTipLabel = new JLabel("Recent horses：");
        matchPanelInfo.levelSelectPanel.add(selHorseTipLabel);
        selHorseTipLabel.setBounds(100,200,260,32);
        selHorseTipLabel.setFont(new Font("Times New Roman",Font.BOLD,30));

        selHorseShowPanel.setBounds(100,300,260,240);
        matchPanelInfo.levelSelectPanel.add(selHorseShowPanel);
    }
    private void horseRace(){
        JPanel racePanel = new JPanel()
        {
            protected void paintComponent(Graphics g) {
                g.drawImage((Image) new ImageIcon("src/main/java/edu/gonzaga/Images/trackField.jpg").getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
            }
        };
        mainViewPanelInfo.matchPanel.add(racePanel);
        matchPanelInfo.racePanel = racePanel;

        racePanel.setLayout(null);
    }


    @Override
    public void actionPerformed(ActionEvent e)
     {
        int disance = e.getSource() == item1Btn ? 400 : e.getSource( )== item2Btn ? 600 : e.getSource() == item3Btn ? 800 : 0;
        if (disance != 0)
        {
            adjustShow(MatchSubPanelShow.racePanel);
            toRace(disance);
            return;
        }
    }


    private  void toRace(int disance)
    {
        matchPanelInfo.racePanel.removeAll();
        Thread[] threads = new Thread[3];
        int x=100;
        int y=30;
        int spacing = 250;

        MatchInfo matchInfo=new MatchInfo(3,disance,x);

        int n =0;
        for (HorseBase horse:matchHorses.getHorses())
        {
            if (horse != null)
            {
                matchPanelInfo.racePanel.add(horse);
                horse.setLocation(x, y + spacing * n);
                horse.setSize(311,220);
                threads[n]=new Thread(new HorseMatch(horse,matchInfo,infoRecord));
                n++;
            }
        }

        JPanel endPointLabel = new JPanel();
        endPointLabel.setBackground(Color.red);
        endPointLabel.setBounds(matchInfo.getStartPos() + disance, 10, 5, 760);
        matchPanelInfo.racePanel.add(endPointLabel);

        for (Thread thread:threads)
        {
            thread.start();
        }

    }



    private void culturePanel_Init()
    {
        JPanel culturePanel = mainViewPanelInfo.culturePanel;
        culturePanel.setLayout(null);
        showInfoPanel.setBounds(30,30,700,500);
        showInfoPanel.setBackground(new Color(70, 70, 70));


        JPanel raisePanel = new JPanel();
        raisePanel.setBounds(750,30,500,500);
        raisePanel.setBackground(new Color(52, 201, 196));

        JPanel trainPanel = new JPanel();
        trainPanel.setBackground(new Color(137, 156, 43));
        trainPanel.setBounds(30,550,1220,185);

        culturePanel.add(showInfoPanel);
        culturePanel.add(raisePanel);
        culturePanel.add(trainPanel);

        showInfoPanel.setLayout(null);
        raisePanel.setLayout(null);
        trainPanel.setLayout(null);


        cul_infoPanel.setLocation(40,30);
        cul_infoPanel.setSize(350,200);
        showInfoPanel.add(cul_infoPanel);
        cul_infoPanel.setBackground(new Color(53, 168, 243));
        cul_infoPanel.setTextLocation(20,20,10,300,35);


        JLabel tipShopLabel = new JLabel("Store");
        tipShopLabel.setBounds(40,30,100,30);
        tipShopLabel.setFont(new Font("Times New Roman",Font.BOLD,26));
        raisePanel.add(tipShopLabel);
        assetsChange = new AssetsChange(wealthLabel,cul_infoPanel,masterAssets);
        GoodsPanel goods1 = new GoodsPanel("src/main/java/edu/gonzaga/images/greenBull.jpeg","greenBull",22,masterAssets,assetsChange);
        GoodsPanel goods2 = new GoodsPanel("src/main/java/edu/gonzaga/images/orangeBull.jpeg","orangeBull",23,masterAssets,assetsChange);
        GoodsPanel goods3 = new GoodsPanel("src/main/java/edu/gonzaga/images/yellowBull.png","yellowBull",24,masterAssets,assetsChange);
        GoodsPanel goods4 = new GoodsPanel("src/main/java/edu/gonzaga/images/redBull.jpeg","redBull",20,masterAssets,assetsChange);

        int x = 40, y = 85;
        int width = 400;
        int heigth = 60;
        int space = 80;
        goods1.setBounds(x,y,width,heigth);
        goods2.setBounds(x,y+space,width,heigth);
        goods3.setBounds(x,y+space*2,width,heigth);
        goods4.setBounds(x,y+space*3,width,heigth);
        raisePanel.add(goods1);
        raisePanel.add(goods2);
        raisePanel.add(goods3);
        raisePanel.add(goods4);



        JLabel tipTrainLabel = new JLabel("Training");
        tipTrainLabel.setFont(new Font("Times New Roman",Font.BOLD,22));
        tipTrainLabel.setBounds(80,30,100,24);

        Font btnFont = new Font ("Times New Roman",Font.BOLD,20);
        JButton runTrainBtn = new JButton("Skills");
        JButton speedTrainBtn = new JButton("Speed");
        JButton enduranceTrainBtn = new JButton("Stamina");

        runTrainBtn.setFont(btnFont);
        speedTrainBtn.setFont(btnFont);
        enduranceTrainBtn.setFont(btnFont);

        width = 200;
        heigth = 80;
        x = 100;
        y = 80;
        space = 300;

        runTrainBtn.setBounds(x,y,width,heigth);
        speedTrainBtn.setBounds(x+space,y,width,heigth);
        enduranceTrainBtn.setBounds(x+space*2,y,width,heigth);

        TrainBtnActionListener trainBtnActionListener = new TrainBtnActionListener(runTrainBtn,speedTrainBtn,enduranceTrainBtn);
        trainBtnActionListener.setUiResponse(uiResponse);
        runTrainBtn.addActionListener(trainBtnActionListener);
        speedTrainBtn.addActionListener(trainBtnActionListener);
        enduranceTrainBtn.addActionListener(trainBtnActionListener);

        trainPanel.add(tipTrainLabel);
        trainPanel.add(runTrainBtn);
        trainPanel.add(speedTrainBtn);
        trainPanel.add(enduranceTrainBtn);

        cul_horseLabel.setIcon(matchHorses.getSelectedHorse().getDefaultHorseImg());
        cul_horseLabel.setBounds(100,280,300,200);
        showInfoPanel.add(cul_horseLabel);
    }




    private void stablePanel_Init()
    {   
        JPanel stablePanel = mainViewPanelInfo.stablePanel;
        stablePanel.setLayout(null);

        int n =0;
        for (HorseBase horseBase:masterAssets.horsesHashMap.values()){
            stablePanel.add(new ShowHorseBox(n,horseBase,seldHorseNC));
            n++;
        }

        JLabel horseNumLabel = new JLabel()
        {
            public void setText(String txt)
            {
                super.setText("Having horses："+txt);
            }
        };
        horseNumLabel.setText(masterAssets.getHorseNum() + " ");
        horseNumLabel.setFont(new Font("Times New Roman",Font.BOLD,30));
        horseNumLabel.setBounds(10,10,400,35);
        stablePanel.add(horseNumLabel);

        selectedlHorseLabel.setBounds(10,48,400,35);
        selectedlHorseLabel.setText(""+matchHorses.getSelectedHorse().getName());
        selectedlHorseLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
        stablePanel.add(selectedlHorseLabel);
    }


    private void infoPanel_Init(){
        JPanel infoPanel=mainViewPanelInfo.infoPanel;
        infoPanel.setLayout(null);

        JPanel assetInfoPanel = new JPanel();
        JPanel recordPanel = new JPanel();

        infoPanel.add(assetInfoPanel);
        infoPanel.add(recordPanel);

        assetInfoPanel.setBackground(new Color(152, 152, 152));
        recordPanel.setBackground(new Color(197, 197, 197));

        assetInfoPanel.setBounds(30,50,450,700);
        recordPanel.setBounds(520,50,720,700);
        assetInfoPanel.setLayout(null);
        recordPanel.setLayout(null);

        Font titileFont =new Font("Times New Roman",Font.BOLD,35);
        Font itemFont =new Font("Times New Roman",Font.BOLD,30);


        JLabel assetTitleLabel = new JLabel("Deposit");
        assetTitleLabel.setFont(titileFont);
        assetInfoPanel.add(assetTitleLabel);


        wealthLabel.setText(masterAssets.wealth+"");
        assetInfoPanel.add(wealthLabel);
        wealthLabel.setFont(itemFont);

        horseNumLabel = new JLabel()
        {
          public void setText(String text)
          {
              super.setText("Having horses "+text);
          }
        };

        horseNumLabel.setText(masterAssets.getHorseNum() + " ");
        assetInfoPanel.add(horseNumLabel);
        horseNumLabel.setFont(new Font("Times New Roman",Font.BOLD,30));

        int x = 80;
        int y = 100;
        int space = 50;
        int width = 350;
        int height = 34;

        assetTitleLabel.setBounds(x-20,y,width,height);
        wealthLabel.setBounds(x,y+height+space,width,height);
        horseNumLabel.setBounds(x,y+(height+space)*2,width,height);

        JLabel recordTitleLabel = new JLabel("Record");
        recordPanel.add(recordTitleLabel);
        recordTitleLabel.setFont(titileFont);

        macthNumLabel.setText(infoRecord.matchNum+"");
        macthNumLabel.setFont(itemFont);
        recordPanel.add(macthNumLabel);

        firstNumLabel.setText(infoRecord.firstTimes+"");
        firstNumLabel.setFont(itemFont);
        recordPanel.add(firstNumLabel);

        recordTitleLabel.setBounds(x-20,y,width,height);
        macthNumLabel.setBounds(x,y+height+space,width,height);
        firstNumLabel.setBounds(x,y+(height+space)*2,width,height);

    }
}
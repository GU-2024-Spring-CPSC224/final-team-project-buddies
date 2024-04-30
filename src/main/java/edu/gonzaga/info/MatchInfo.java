package edu.gonzaga.info;

import edu.gonzaga.data.Achievement;

import java.awt.*;

public class MatchInfo 
{

    private int competitorNum=0;
    private int distance =100;
    private int startPos;
    private int currentArriveNum = 0;
    public Achievement[] achievements;

    public MatchInfo(int competitorNum,int distance,int startPos)
    {
        this.competitorNum = competitorNum;
        this.distance = distance;
        this.startPos = startPos;
        this.achievements = new Achievement[competitorNum];
    }

    public synchronized boolean arriveNumPlus()
    {
        currentArriveNum++;
        return competitorNum<=currentArriveNum;
    }

    public int getCompetitorNum() 
    {
        return competitorNum;
    }

    public void setCompetitorNum(int competitorNum) 
    {
        this.competitorNum = competitorNum;
    }

    public int getDistance() 
    {
        return distance;
    }

    public void setDistance(int distance) 
    {
        this.distance = distance;
    }

    public int getStartPos() 
    {
        return startPos;
    }

    public void setStartPos(int startPos) 
    {
        this.startPos = startPos;
    }

    public synchronized int getCurrentArriveNum() 
    {
        return currentArriveNum;
    }

    public synchronized void setCurrentArriveNum(int currentArriveNum) 
    {
        this.currentArriveNum = currentArriveNum;
    }
}

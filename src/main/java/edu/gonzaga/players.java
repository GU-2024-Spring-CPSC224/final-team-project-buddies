package edu.gonzaga;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Collection;

public class players 
{
    private int deposit = 1000;
    private int debt = 0;
	private HashMap<Integer, Integer> totalScores = new HashMap<Integer, Integer>();
	private int playerNumber;
	private int turnNumber = 1;
	private int rollNumber;
	private int gameScore = 0;
	private ArrayList<Integer> roundScores;
	private String playerName;

	public players(int playerNumber)
    {

        // basic constructor setup
        this.playerNumber = playerNumber;
		roundScores = new ArrayList<Integer>();
	}

	public void scoreRoll(int score) 
    {
		totalScores.put(rollNumber, score);
	}

    public int getTotalScores() 
    {

		int current = 0;

		for (int i : this.getTotalScore().values()) {
			current += i;
		}
		return current;
	}


	public HashMap<Integer, Integer> getTotalScore() 
    {
		return totalScores;
	}

    public void setTotalScore(HashMap<Integer, Integer> totalScores) 
    {
		this.totalScores = totalScores;
	}
	public void resetTotalScores() {
		this.totalScores.clear();
	}

	public String getPlayerName() 
    {
		return playerName;
	}

	public void setPlayerName(String playerName)
    {
		this.playerName = playerName;
	}

}

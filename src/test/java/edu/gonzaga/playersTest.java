package edu.gonzaga;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class playersTest {
    @Test
    void playerScoreInitialTest() {
        players p = new players(100);
        assertEquals(0, p.getTotalScores());
        
    }

    @Test
    void playerScoreTest() {
        players p = new players(100);
        p.scoreRoll(100);
        assertEquals(100, p.getTotalScores());
        
    }

    @Test
    void playerScoreMultipleTest() {
        players p = new players(100);
        p.scoreRoll(100);
        p.scoreRoll(200);
        assertEquals(300, p.getTotalScores());
        
    }

    @Test
    void playerScoreResetTest() {
        players p = new players(100);
        p.scoreRoll(100);
        p.resetTotalScores();
        assertEquals(0, p.getTotalScores());
        
    }

    @Test
    void playerScoreMultipleResetTest() {
        players p = new players(100);
        p.scoreRoll(100);
        p.scoreRoll(200);
        p.resetTotalScores();
        assertEquals(0, p.getTotalScores());
        
    }

    @Test
    void playerNameTest() {
        players p = new players(100);
        assertEquals(null, p.getPlayerName());
        
    }

    @Test
    void playerNameSetTest() {
        players p = new players(100);
        p.setPlayerName("Test");
        assertEquals("Test", p.getPlayerName());
        
    }
}

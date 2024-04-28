package edu.gonzaga;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class horseTest {
    @Test
    void horseStateTest() {
        horse h = new horse(new controlCenter());
        assertEquals(horseState.UNCHARGED, h.getState());
        
    }


}

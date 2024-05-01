package edu.gonzaga;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import edu.gonzaga.view.MainView;

public class MainGameTest {
    @Test
    void testMain4Miles() {
        App.main(new String[]{"4"});
        assertNotNull(MainView.getInstance());
    }

    @Test
    void testMain6Miles() {
        App.main(new String[]{"6"});
        assertNotNull(MainView.getInstance());
    }

    @Test
    void testMain8Miles() {
        App.main(new String[]{"8"});
        assertNotNull(MainView.getInstance());
    }
}
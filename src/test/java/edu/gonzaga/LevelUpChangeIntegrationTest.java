package edu.gonzaga;

import edu.gonzaga.horse.HorseBase;
import edu.gonzaga.horse.SlowBeforeFastHorse;
import edu.gonzaga.notify.LevelUpChange;
import edu.gonzaga.match.MatchHorses;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LevelUpChangeIntegrationTest {
    @Test
    void testIsLevelUpChangesSelectedHorseLevel() {

        MatchHorses matchHorses = new MatchHorses();
        HorseBase selectedHorse = new SlowBeforeFastHorse("SelectedHorse", 5, "src/main/java/edu/gonzaga/images/SelectedHorse");
        matchHorses.setSelectedHorse(selectedHorse);

        LevelUpChange levelUpChange = new LevelUpChange();

        levelUpChange.setMatchHorses(matchHorses);

        int initialLevel = matchHorses.getSelectedHorse().getLevel();

        levelUpChange.isLevelUp();

        assertNotEquals(initialLevel, matchHorses.getSelectedHorse().getLevel());
    }
}

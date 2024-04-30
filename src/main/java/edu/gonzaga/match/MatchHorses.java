package edu.gonzaga.match;

import edu.gonzaga.horse.HorseBase;
import edu.gonzaga.horse.SlowBeforeFastHorse;
import edu.gonzaga.horse.UniformVelocityHorse;

public class MatchHorses {


    private HorseBase[] horses = new HorseBase[3];

    public MatchHorses()
    {
        horses[0] = new SlowBeforeFastHorse("Opponent1",4,"src/main/java/edu/gonzaga/images/YellowHorse");
        horses[2] = new UniformVelocityHorse("Oppponent2",8,"src/main/java/edu/gonzaga/images/BlackHorse");
    }


    public void setSelectedHorse(HorseBase horse)
    {
        horses[1] = horse;
    }

    public void  setRival1(HorseBase horse)
    {
        horses[0] = horse;
    }

    public void setRival2(HorseBase horse)
    {
        horses[2] = horse;
    }

    public HorseBase[] getHorses() 
    {
        return horses;
    }


    public HorseBase getSelectedHorse()
    {
        return horses[1];
    }
}

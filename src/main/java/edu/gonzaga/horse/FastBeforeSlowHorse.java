package edu.gonzaga.horse;

public class FastBeforeSlowHorse extends HorseBase
{
    public FastBeforeSlowHorse(String name, int level, String imgPath) 
    {
        super(name, level, imgPath);
    }

    @Override
    public long getRateFactor() 
    {
        raceRecord++;
        if (this.raceRecord < 300)
        {
            long temp = (long)(50 - raceRecord*0.1 - getLevel() * 0.3);
            if (temp < 20)
            {
                temp = 20;
            }
            return temp;
        }
        else {
            return (long)(50 + raceRecord * 0.09 - getLevel() * 0.2);
        }
    }
}

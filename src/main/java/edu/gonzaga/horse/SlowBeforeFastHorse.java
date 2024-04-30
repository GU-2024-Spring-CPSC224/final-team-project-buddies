package edu.gonzaga.horse;

public class SlowBeforeFastHorse extends HorseBase 
{
    public SlowBeforeFastHorse(String name, int level, String imgPath) 
    {
        super(name, level, imgPath);
    }

    @Override
    public long getRateFactor() 
    {
        raceRecord++;
        if (this.raceRecord < 300)
        {
            return (long)(50 + raceRecord * 0.2 - getLevel() * 0.2);
        } else 
        {
            long temp = (long)(50 - raceRecord * 0.1 - getLevel() * 0.4);
            if (temp < 20)
            {
                temp = 20;
            }
            return temp;
        }
    }
}
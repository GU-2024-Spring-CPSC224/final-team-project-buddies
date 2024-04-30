package edu.gonzaga.horse;

public class UniformVelocityHorse extends HorseBase
{
    public UniformVelocityHorse(String name, int level, String imgPath) 
    {
        super(name, level, imgPath);
    }

    @Override
    public long getRateFactor() 
    {
        long temp = (long)(50 - getLevel() * 0.7);
        if (temp < 20)
        {
            temp = 20;
        }
        return temp;
    }
}
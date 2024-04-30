package edu.gonzaga.data;

import edu.gonzaga.horse.FastBeforeSlowHorse;
import edu.gonzaga.horse.HorseBase;
import edu.gonzaga.horse.SlowBeforeFastHorse;

import java.util.HashMap;

public class MasterAssets {
    public int wealth = 50;
    public HashMap<String, HorseBase> horsesHashMap = new HashMap<String, HorseBase>();

    public MasterAssets()
    {
        horsesHashMap.put("Yel",new SlowBeforeFastHorse("Yel",4,"src/main/java/edu/gonzaga/images/YellowHorse"));
        horsesHashMap.put("Red",new FastBeforeSlowHorse("Red",5,"src/main/java/edu/gonzaga/images/RedHorse"));
        horsesHashMap.put("Blk",new FastBeforeSlowHorse("Blk",6,"src/main/java/edu/gonzaga/images/BlackHorse"));
    }

    public int getHorseNum()
    {
        return horsesHashMap.size();
    }
}

package petermacdonald.valorgmcompanion.character.techniques.mods;

import java.util.ArrayList;

import petermacdonald.valorgmcompanion.character.enums.CoreAttribute;
import petermacdonald.valorgmcompanion.character.enums.CoreType;
import petermacdonald.valorgmcompanion.character.enums.ModType;
import petermacdonald.valorgmcompanion.character.techniques.Technique;


/**
 * This class represents the Line Attack mod, which makes a technique hit on a line. Line attack gets +1 to its length if the technique it's on is based on Spirit.
 * Otherwise the length is 3 * level.
 */

public class Line extends Mod {
    //Line Attack is 1/1 for cost, is not fixed, is not special, and can be put in Barrier, Boost, Damage, Healing, Weaken, and Ultimate Attack cores.
    //This constructor sets all of those properties, and creates a new Line Attack mod at level 1
    public Line() {
        super("Line Attack", 1, 1, false, ModType.TARGET, 1, new ArrayList<CoreType>());
        eligibleCores.add(CoreType.BARRIER_BLAST);
        eligibleCores.add(CoreType.BARRIER_LINE);
        eligibleCores.add(CoreType.BOOST);
        eligibleCores.add(CoreType.DAMAGE);
        eligibleCores.add(CoreType.HEALING);
        eligibleCores.add(CoreType.WEAKEN);
        eligibleCores.add(CoreType.ULTIMATE_ATTACK);
        level = 1;
    }

    public Line(int level) {
        super("Line Attack", 1, 1, false, ModType.TARGET, 1, new ArrayList<CoreType>());
        eligibleCores.add(CoreType.BARRIER_BLAST);
        eligibleCores.add(CoreType.BARRIER_LINE);
        eligibleCores.add(CoreType.BOOST);
        eligibleCores.add(CoreType.DAMAGE);
        eligibleCores.add(CoreType.HEALING);
        eligibleCores.add(CoreType.WEAKEN);
        eligibleCores.add(CoreType.ULTIMATE_ATTACK);
        this.level = level;
    }

    //Returns a description of the mod's effects.
    @Override
    public String getDescription(Technique technique) {
        int lineLength;
        if (technique.getCore().getAttribute() == CoreAttribute.SPIRIT) {
            lineLength = 4;
        } else {
            lineLength = 3;
        }
        lineLength += 3 *(level-1);
        return "Affects a line of length " + lineLength +".";
    }
}

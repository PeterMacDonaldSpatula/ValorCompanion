package petermacdonald.valorgmcompanion.character.techniques.mods;

import java.util.ArrayList;

import petermacdonald.valorgmcompanion.character.enums.CoreAttribute;
import petermacdonald.valorgmcompanion.character.enums.CoreType;
import petermacdonald.valorgmcompanion.character.enums.ModType;
import petermacdonald.valorgmcompanion.character.techniques.Technique;

/**
 * This class represents the Ranged Technique modifier, which can be applied to every core type save Ultimate Transformation
 */

public class Ranged extends Mod {

    //Ranged costs 1/1, is not fixed, is not special, and can be applied to every core type save Ultimate Transformation
    public Ranged() {
        super("Ranged Technique", 1, 1, false, ModType.TARGET, 1, new ArrayList<CoreType>());
        eligibleCores.add(CoreType.BARRIER_BLAST);
        eligibleCores.add(CoreType.BARRIER_LINE);
        eligibleCores.add(CoreType.BOOST);
        eligibleCores.add(CoreType.DAMAGE);
        eligibleCores.add(CoreType.HEALING);
        eligibleCores.add(CoreType.MIMIC);
        eligibleCores.add(CoreType.SUMMONING);
        eligibleCores.add(CoreType.ULTIMATE_ATTACK);
        eligibleCores.add(CoreType.WEAKEN);
        level = 1;
    }

    public Ranged(int level) {
        super("Ranged Technique", 1, 1, false, ModType.TARGET, 1, new ArrayList<CoreType>());
        eligibleCores.add(CoreType.BARRIER_BLAST);
        eligibleCores.add(CoreType.BARRIER_LINE);
        eligibleCores.add(CoreType.BOOST);
        eligibleCores.add(CoreType.DAMAGE);
        eligibleCores.add(CoreType.HEALING);
        eligibleCores.add(CoreType.MIMIC);
        eligibleCores.add(CoreType.SUMMONING);
        eligibleCores.add(CoreType.ULTIMATE_ATTACK);
        eligibleCores.add(CoreType.WEAKEN);
        this.level = level;
    }

    //This method returns the modifier's descriptions string.
    @Override
    public String getDescription(Technique technique) {
        return "Can target any space within a range of " + getRange(technique) + ".";
    }

    //This method returns the amount of range provided to the technique by this modifier, which varies according to level and the technique's core attribute
    public int getRange(Technique technique) {
        int multiplier;
        if (technique.getCore().getAttribute() == CoreAttribute.SPIRIT) {
            multiplier = 4;
        } else if (technique.getCore().getAttribute() == CoreAttribute.STRENGTH) {
            multiplier = 2;
        } else {
            multiplier = 3;
        }

        return level * multiplier;
    }
}

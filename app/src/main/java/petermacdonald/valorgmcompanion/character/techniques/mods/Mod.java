package petermacdonald.valorgmcompanion.character.techniques.mods;

import java.util.List;

import petermacdonald.valorgmcompanion.character.CharacterComponent;
import petermacdonald.valorgmcompanion.character.enums.CoreType;
import petermacdonald.valorgmcompanion.character.enums.ModType;
import petermacdonald.valorgmcompanion.character.techniques.Technique;

/**
 * Created by peter on 2017-05-30.
 */

public abstract class Mod extends CharacterComponent {
    protected final int firstLevelCost;
    protected final int furtherLevelCost;
    protected final boolean fixed;
    protected final ModType type;
    protected int level;
    protected final List<CoreType> eligibleCores;

    public Mod(String name, int firstLevelCost, int furtherLevelCost, boolean fixed, ModType type, int season, List<CoreType> eligibleCores) {
        super(name, false, season, false);
        this.firstLevelCost = firstLevelCost;
        this.furtherLevelCost = furtherLevelCost;
        this.fixed = fixed;
        this.type = type;
        this.eligibleCores = eligibleCores;
    }

    public String getName() {
        return name;
    }

    public int getFirstLevelCost() {
        return firstLevelCost;
    }

    public int getFurtherLevelCost() {
        return furtherLevelCost;
    }

    public int getLevel() {
        return level;
    }

    public ModType getType() {
        return type;
    }

    public List<CoreType> getEligibleCores() {
        return eligibleCores;
    }

    public boolean isSpecial() {
        return type==ModType.SPECIAL;
    }

    public int getTotalCost(Technique technique) {
        if (fixed) {
            return firstLevelCost;
        } else {
            int temp = firstLevelCost;
            temp += furtherLevelCost*(level-1);
            return temp;
        }
    }

    public void setLevel(int level) {
        if (!fixed) {
            this.level = level;
        } else {this.level = 1;}
    }

    //The description returned should always end with a period, with no space following.
    public abstract String getDescription(Technique technique);
}

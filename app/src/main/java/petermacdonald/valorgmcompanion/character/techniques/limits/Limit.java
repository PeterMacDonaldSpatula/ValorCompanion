package petermacdonald.valorgmcompanion.character.techniques.limits;

import java.util.List;

import petermacdonald.valorgmcompanion.character.CharacterComponent;
import petermacdonald.valorgmcompanion.character.enums.CoreType;
import petermacdonald.valorgmcompanion.character.techniques.Technique;

/**
 *  This abstract class represents technique Limits. All Limits are subclasses of this class.
 */

public abstract class Limit extends CharacterComponent{
    protected final int perLevelValue;
    protected final boolean fixed;
    protected int level;
    protected final List<CoreType> eligibleCores;

    public Limit(String name, int perLevelValue, boolean fixed, int season, List<CoreType> eligibleCores, boolean subtitleable, boolean multiplesAllowed) {
        super(name, subtitleable, season, multiplesAllowed);
        this.perLevelValue = perLevelValue;
        this.fixed = fixed;
        this.eligibleCores = eligibleCores;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public int getTotalValue() {
        if (fixed) {
            return perLevelValue;
        } else {
            return perLevelValue * level;
        }
    }

    public int getPerLevelValue() {
        return perLevelValue;
    }

    public boolean isFixed() {
        return fixed;
    }

    public int getSeason() {
        return season;
    }

    public List<CoreType> getEligibleCores() {
        return eligibleCores;
    }

    public void setLevel(int level) {
        if (!fixed) {
            this.level = level;
        } else {this.level = 1;}
    }

    public abstract String getDescription(Technique technique);


}

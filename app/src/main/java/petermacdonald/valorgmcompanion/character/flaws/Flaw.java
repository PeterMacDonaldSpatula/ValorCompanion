package petermacdonald.valorgmcompanion.character.flaws;

import android.support.annotation.NonNull;

import petermacdonald.valorgmcompanion.character.CharacterComponent;
import petermacdonald.valorgmcompanion.character.enums.FlawType;
import petermacdonald.valorgmcompanion.character.enums.LevelingSpeed;

/*
    All Flaws are subclasses of this class. Flaws can be sorted alphabetically according to their name.
 */
public abstract class Flaw extends CharacterComponent {
    private final LevelingSpeed speed;//The flaw's leveling speed. Fixed, Fast, or Slow. Set during creation and cannot be changed.
    protected int level;//The flaw's current level.
    protected FlawType type;//THe flaw's type (normal or weaken)
    private final int firstLevelValue, furtherLevelValue;//The SP given by the flaw at first level and at further levels. Set during creation and cannot be changed.
    private String subtitle;//If the Flaw has further information which the player can input (ie. what kind of non-proficiency) it goes here

    public Flaw(String name, FlawType type, LevelingSpeed speed, int firstLevelValue, int furtherLevelValue, boolean subtitleable, boolean multiplesAllowed) {
        super(name, subtitleable, 1, multiplesAllowed);
        this.type = type;
        this.speed = speed;
        this.firstLevelValue = firstLevelValue;
        this.furtherLevelValue = furtherLevelValue;
        level = 1;
    }

    /*
        This method applies any passive effects from the flaw to the provided character (e.g. if the skill is Fragile, this drops their HP by the appropriate amount)
        The method is left empty. Any flaws which need to apply passive effects need to override it.
     */
    public void applyPassiveEffect(){}

    /*
        This method returns the flaw's total value at its current level.
     */
    public int getValue(){
        switch(speed) {
            case FIXED: return firstLevelValue;
            default: return firstLevelValue + ((level-1) * furtherLevelValue);
        }
    }

    /*
        This method returns a string describing the Flaw's effects.
     */
    abstract public String getDescription();

    public String getName() {
        return name;
    }

    public LevelingSpeed getSpeed() {
        return speed;
    }

    public int getLevel() {
        return level;
    }

    public int getFirstLevelValue() {
        return firstLevelValue;
    }

    public int getFurtherLevelValue() {
        return furtherLevelValue;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public boolean isSubtitleable() {
        return subtitleable;
    }


    /*
            Can only set level above 1 if the Flaw is not Fixed
         */
    public void setLevel(int level) {
        if (this.speed != LevelingSpeed.FIXED) { this.level = level;}
        else {this.level = 1;}
    }

    /*
        The subtitle can only be set if the Flaw is subtitleable.
     */
    public void setSubtitle(String subtitle) {
        if (subtitleable) {
            this.subtitle = subtitle;
        }
    }
}

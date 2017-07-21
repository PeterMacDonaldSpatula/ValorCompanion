package petermacdonald.valorgmcompanion.character.skills;

import android.support.annotation.NonNull;

import petermacdonald.valorgmcompanion.character.CharacterComponent;
import petermacdonald.valorgmcompanion.character.enums.LevelingSpeed;
import petermacdonald.valorgmcompanion.character.enums.SkillType;

/**
 * All skills are subclasses of this class. Skills can be sorted in order of their name.
 */

public abstract class Skill extends CharacterComponent {
    private final LevelingSpeed speed;//Whether the skill levels fast, slow, or fixed. This is set in the constructor and cannot be changed.
    private final SkillType type;
    protected int level;//The level of the skill. If it's a Fixed skill, this is always 1
    private final int firstLevelCost, furtherLevelCost;//The cost for the first level of the skill, and for further levels. If the skill is fixed, further levels have a 0 cost
    protected String subtitle;//If the Skill has further information which the player can input (ie. what kind of proficiency) it goes here

    public Skill(String name, LevelingSpeed speed, SkillType type, int season, int firstLevelCost, int furtherLevelCost, boolean subtitleable, boolean multiplesAllowed) {
        super(name, subtitleable, season, multiplesAllowed);
        this.speed = speed;
        this.type = type;
        this.firstLevelCost = firstLevelCost;
        this.furtherLevelCost = furtherLevelCost;
        this.level = 1;
    }

    /*
        If the skill applies a passive effect, such as boosting HP total or improving initiative scores, this method should be overrided to apply those effects to the character sheet.
        If it's not overridden, it doesn't do anything.
     */
    public void applyPassiveEffect(){}

    /*
        Returns a description of the skill's effect at its current level as a string.
     */
    abstract public String getDescription();

    /*
        Returns the total cost of the skill at its current level.
     */
    public int getCost(){
        switch(speed) {
            case FIXED: return firstLevelCost;
            default: return firstLevelCost + ((level-1) * furtherLevelCost);
        }
    }


    public String getName() {
        return name;
    }

    public LevelingSpeed getSpeed() {
        return speed;
    }

    public int getLevel() {
        return level;
    }

    public int getSeason() {
        return season;
    }

    public SkillType getType() {
        return type;
    }

    public int getFirstLevelCost() {
        return firstLevelCost;
    }

    public int getFurtherLevelCost() {
        return furtherLevelCost;
    }

    public String getSubtitle() {
        return subtitle;
    }

    /*
            Can only set level above 1 if the skill is not Fixed
         */
    public void setLevel(int level) {
        if (this.speed != LevelingSpeed.FIXED) { this.level = level;}
        else {this.level = 1;}
    }

    /*
        The subtitle can only be set if the skill is subtitleable.
     */
    public void setSubtitle(String subtitle) {
        if (subtitleable) {
            this.subtitle = subtitle;
        }
    }

}

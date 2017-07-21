package petermacdonald.valorgmcompanion.character.skills;

import petermacdonald.valorgmcompanion.character.ValorCharacter;
import petermacdonald.valorgmcompanion.character.enums.LevelingSpeed;
import petermacdonald.valorgmcompanion.character.enums.SkillType;
import petermacdonald.valorgmcompanion.tools.ValorMath;

/**
 * This class represented the Tough skill, which gives bonus health.
 */

public class Tough extends Skill {
    private int healthAdded;//The amount of health to be added by the skill; depends on level and character type. Generated when the level is set.
    private ValorCharacter character;//THe character this skill is attached to. Needed for applying the passive effect and determining the level of health added

    /*
        6/3 cost, leveling Fast, no subtitles. Needs to know what ValorCharacter it's attached to so that it can apply the passive effect, so that gets passed into the constructor.
     */
    public Tough(ValorCharacter character) {
        super("Tough", LevelingSpeed.FAST, SkillType.PERMANENT, 1, 6, 3, false, false);
        this.character = character;
        setLevel(1);//Sets the level, which also generates the amount of health added
    }

    /*
        Returns a short string describing the effects of the Tough skill.
     */
    @Override
    public String getDescription() {
        return"+" + healthAdded + " health";
    }

    /*
        Increases the character's health.
     */
    @Override
    public void applyPassiveEffect() {
        int totalHealth = character.getHealth() + healthAdded;
        character.setHealth(totalHealth, this);
    }

    /*
        Sets the level, which also calculates the amount of health added to the character.
     */
    @Override
    public void setLevel(int level) {
        super.setLevel(level);
        healthAdded = 30;
        healthAdded += 15*(level-1);
        switch (character.getType()){
            case FLUNKY: healthAdded = 0;
                break;
            case SOLDIER: healthAdded = ValorMath.halfRoundUp(healthAdded);
                break;
            case MASTER: healthAdded *= 2;
                break;
            default: break;
        }
    }


}

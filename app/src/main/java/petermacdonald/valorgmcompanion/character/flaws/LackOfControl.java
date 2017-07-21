package petermacdonald.valorgmcompanion.character.flaws;

import petermacdonald.valorgmcompanion.character.ValorCharacter;
import petermacdonald.valorgmcompanion.character.enums.CharacterType;
import petermacdonald.valorgmcompanion.character.enums.FlawType;
import petermacdonald.valorgmcompanion.character.enums.LevelingSpeed;

/**
 * This class represents the Lack of Control Flaw, which drops the stamina total of characters it's attached to.
 */

public class LackOfControl extends Flaw {
    private ValorCharacter character;//The character this flaw is on
    private int staminaLost;//The amount of stamina the flaw removes

    /*
        Valued at 2/1, levels fast, no subtitles. We need the character it belongs to so we can apply the passive effect, so it gets passed in.
     */
    public LackOfControl(ValorCharacter character) {
        super("Lack of Control", FlawType.FLAW, LevelingSpeed.FAST, 2, 1, false, false);
        this.character = character;
        setLevel(1);//Setting the level also generates the amount of stamina lost.
    }

    /*
        Returns a string describing the flaw's effects (how many stamina points lost)
     */
    @Override
    public String getDescription() {
        return "-" + staminaLost + " stamina";
    }

    /*
        Lowers the character's stamina by the amount to be lost
     */
    @Override
    public void applyPassiveEffect() {
        character.setStamina(character.getStamina() - staminaLost, this);
    }

    /*
        Sets the flaw's level and generates the amount of stamina lost, varying depending on character type and the flaw level
     */
    @Override
    public void setLevel(int level) {
        super.setLevel(level);
        staminaLost = 8;
        staminaLost += 6 * (level-1);
        if (character.getType() == CharacterType.MASTER) {
            staminaLost *= 2;
        }
    }
}

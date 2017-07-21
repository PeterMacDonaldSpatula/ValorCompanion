package petermacdonald.valorgmcompanion.character.flaws;

import petermacdonald.valorgmcompanion.character.ValorCharacter;
import petermacdonald.valorgmcompanion.character.enums.FlawType;
import petermacdonald.valorgmcompanion.character.enums.LevelingSpeed;

/**
 * Created by peter on 2017-07-04.
 */

public class WeakDefender extends Flaw {
    ValorCharacter character;
    public WeakDefender(ValorCharacter character) {
        super("Weak Defender", FlawType.FLAW, LevelingSpeed.FIXED, 2, 1, false, false);
        this.character = character;
    }

    @Override
    public String getDescription() {
        return "-" + calculateDefenseLost() + " Defense.";
    }

    @Override
    public void applyPassiveEffect() {
        character.setDefense(character.getDefense()-calculateDefenseLost(), this);
    }

    private int calculateDefenseLost() {
        return 2 + (level * 2);
    }
}

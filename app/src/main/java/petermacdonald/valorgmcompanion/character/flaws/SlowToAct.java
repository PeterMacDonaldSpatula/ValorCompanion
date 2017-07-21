package petermacdonald.valorgmcompanion.character.flaws;

import petermacdonald.valorgmcompanion.character.ValorCharacter;
import petermacdonald.valorgmcompanion.character.enums.FlawType;
import petermacdonald.valorgmcompanion.character.enums.LevelingSpeed;

/**
 * Created by peter on 2017-07-04.
 */

public class SlowToAct extends Flaw {
    ValorCharacter character;
    public SlowToAct(ValorCharacter character) {
        super("Slow to Act", FlawType.FLAW, LevelingSpeed.FIXED, 1, 0, false, false);
        this.character = character;
    }

    @Override
    public String getDescription() {
        return "-2 to Initiative Rolls";
    }

    @Override
    public void applyPassiveEffect() {
        character.setInitiative(character.getInitiative()-2, this);
    }
}

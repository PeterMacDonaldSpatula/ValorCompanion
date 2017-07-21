package petermacdonald.valorgmcompanion.character.flaws;

import petermacdonald.valorgmcompanion.character.enums.FlawType;
import petermacdonald.valorgmcompanion.character.enums.LevelingSpeed;

/**
 * This class is the Despair flaw, 4 SP, fixed
 */

public class Despair extends Flaw {
    public Despair() {
        super("Despair", FlawType.FLAW, LevelingSpeed.FIXED, 4, 0, false, false);
    }

    @Override
    public String getDescription() {
        return "The first time in a scene that an ally is reduced to 0 Health, lose 2 Valor.";
    }
}

package petermacdonald.valorgmcompanion.character.flaws;

import petermacdonald.valorgmcompanion.character.enums.FlawType;
import petermacdonald.valorgmcompanion.character.enums.LevelingSpeed;

/**
 * This class models the Compulsion flaw. It has a +4 value and fixed leveling.
 */

public class Compulsion extends Flaw {
    public Compulsion() {
        super("Compulsion", FlawType.FLAW, LevelingSpeed.FIXED, 4, 0, false, false);
    }

    @Override
    public String getDescription() {
        return "On the second round of combat, and every two rounds thereafter, you must spend your support action to perform a compulsive activity, or else lose 1 Valor.";
    }
}

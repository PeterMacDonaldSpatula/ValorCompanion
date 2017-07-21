package petermacdonald.valorgmcompanion.character.flaws;

import petermacdonald.valorgmcompanion.character.enums.FlawType;
import petermacdonald.valorgmcompanion.character.enums.LevelingSpeed;

/**
 * Created by peter on 2017-07-02.
 */

public class Berserker extends Flaw {

    public Berserker() {
        super("Berserker", FlawType.FLAW, LevelingSpeed.FIXED, 5, 0, false, false);
    }

    @Override
    public String getDescription() {
        return "When at critical health, you enter a berserker state.";
    }
}

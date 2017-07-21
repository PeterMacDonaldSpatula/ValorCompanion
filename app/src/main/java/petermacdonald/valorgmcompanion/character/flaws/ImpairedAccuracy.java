package petermacdonald.valorgmcompanion.character.flaws;

import petermacdonald.valorgmcompanion.character.enums.FlawType;
import petermacdonald.valorgmcompanion.character.enums.LevelingSpeed;

/**
 * Created by peter on 2017-07-04.
 */

public class ImpairedAccuracy extends Flaw {
    public ImpairedAccuracy() {
        super("Impaired Accuracy", FlawType.WEAKEN_FLAW, LevelingSpeed.FIXED, 4, 0, false, false);
    }

    @Override
    public String getDescription() {
        return "-1 to Attack Rolls.";
    }
}

package petermacdonald.valorgmcompanion.character.flaws;

import petermacdonald.valorgmcompanion.character.enums.FlawType;
import petermacdonald.valorgmcompanion.character.enums.LevelingSpeed;

/**
 * Created by peter on 2017-07-04.
 */

public class Violent extends Flaw {
    public Violent() {
        super("Violent", FlawType.FLAW, LevelingSpeed.FIXED, 3, 0, false, false);
    }

    @Override
    public String getDescription() {
        return "-2 Valor if you could attack someone on a turn and choose not to.";
    }
}

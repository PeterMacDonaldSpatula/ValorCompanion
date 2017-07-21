package petermacdonald.valorgmcompanion.character.flaws;

import petermacdonald.valorgmcompanion.character.enums.FlawType;
import petermacdonald.valorgmcompanion.character.enums.LevelingSpeed;

/**
 * Created by peter on 2017-07-04.
 */

public class SlowHealing extends Flaw {
    public SlowHealing() {
        super("Slow Healing", FlawType.FLAW, LevelingSpeed.FIXED, 2, 0, false, false);
    }

    @Override
    public String getDescription() {
        return "No Health Recovery in the first non-combat Scene following each combat Scene.";
    }
}

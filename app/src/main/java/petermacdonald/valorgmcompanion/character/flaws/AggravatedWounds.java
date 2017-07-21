package petermacdonald.valorgmcompanion.character.flaws;

import petermacdonald.valorgmcompanion.character.enums.FlawType;
import petermacdonald.valorgmcompanion.character.enums.LevelingSpeed;

/**
 * Created by peter on 2017-07-02.
 */

public class AggravatedWounds extends Flaw {

    public AggravatedWounds() {
        super("Aggravated Wounds", FlawType.FLAW, LevelingSpeed.FIXED, 2, 0, false, false);
    }

    @Override
    public String getDescription() {
        return "Healing techniques are 1/2 as effective on you.";
    }
}

package petermacdonald.valorgmcompanion.character.flaws;

import petermacdonald.valorgmcompanion.character.enums.FlawType;
import petermacdonald.valorgmcompanion.character.enums.LevelingSpeed;

/**
 * Created by peter on 2017-07-04.
 */

public class WeakAura extends Flaw {
    public WeakAura() {
        super("Weak Aura", FlawType.FLAW, LevelingSpeed.FIXED, 3, 0, false, false);
    }

    @Override
    public String getDescription() {
        return "-1 to Defense Rolls against Aura attacks";
    }
}

package petermacdonald.valorgmcompanion.character.flaws;

import petermacdonald.valorgmcompanion.character.enums.FlawType;
import petermacdonald.valorgmcompanion.character.enums.LevelingSpeed;

/**
 * Created by peter on 2017-07-02.
 */

public class NonProficient extends Flaw {
    public NonProficient(String subtitle) {
        super("Non-Proficient", FlawType.FLAW, LevelingSpeed.FIXED, 1, 0, true, true);
        this.setSubtitle(subtitle);
    }

    @Override
    public String getDescription() {
        return null;
    }
}

package petermacdonald.valorgmcompanion.character.flaws;

import petermacdonald.valorgmcompanion.character.enums.FlawType;
import petermacdonald.valorgmcompanion.character.enums.LevelingSpeed;

/**
 * Created by peter on 2017-07-04.
 */

public class WeakWilled extends Flaw {
    public WeakWilled() {
        super("Weak Willed", FlawType.FLAW, LevelingSpeed.SLOW, 4, 3, false, false);
    }

    @Override
    public String getDescription() {
        return "-" + level + " starting Valor in each scene.";
    }
}

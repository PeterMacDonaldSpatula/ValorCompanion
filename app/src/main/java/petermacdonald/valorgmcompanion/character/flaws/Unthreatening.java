package petermacdonald.valorgmcompanion.character.flaws;

import petermacdonald.valorgmcompanion.character.enums.FlawType;
import petermacdonald.valorgmcompanion.character.enums.LevelingSpeed;

/**
 * Created by peter on 2017-07-04.
 */

public class Unthreatening extends Flaw {
    public Unthreatening() {
        super("Unthreatening", FlawType.FLAW, LevelingSpeed.FIXED, 3, 0, false, false);
    }

    @Override
    public String getDescription() {
        return "Enemies can move normally through your Zone of Control.";
    }
}

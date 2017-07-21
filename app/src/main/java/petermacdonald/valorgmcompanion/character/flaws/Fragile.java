package petermacdonald.valorgmcompanion.character.flaws;

import petermacdonald.valorgmcompanion.character.ValorCharacter;
import petermacdonald.valorgmcompanion.character.enums.FlawType;
import petermacdonald.valorgmcompanion.character.enums.LevelingSpeed;

/**
 * Created by peter on 2017-07-04.
 */

public class Fragile extends Flaw {
    ValorCharacter character;

    public Fragile(ValorCharacter character) {
        super("Fragile", FlawType.FLAW, LevelingSpeed.FAST, 3, 2, false, false);
        this.character = character;
    }

    @Override
    public String getDescription() {
        return "-" + calculateHealthLost() + " Health";
    }

    @Override
    public void applyPassiveEffect() {
        character.setHealth(character.getHealth()-calculateHealthLost(), this);
    }

    private int calculateHealthLost() {
        return 15 + (level*15);
    }
}

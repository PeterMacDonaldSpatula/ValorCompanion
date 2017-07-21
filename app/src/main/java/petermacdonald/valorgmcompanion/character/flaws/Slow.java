package petermacdonald.valorgmcompanion.character.flaws;

import petermacdonald.valorgmcompanion.character.ValorCharacter;
import petermacdonald.valorgmcompanion.character.enums.FlawType;
import petermacdonald.valorgmcompanion.character.enums.LevelingSpeed;

/**
 * Created by peter on 2017-07-04.
 */

public class Slow extends Flaw {
    ValorCharacter character;

    public Slow(ValorCharacter character) {
        super("Slow", FlawType.FLAW, LevelingSpeed.SLOW, 2, 1, false, false);
        this.character = character;
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public void applyPassiveEffect() {
        character.setSpeed(character.getSpeed()-level, this);
    }

    @Override
    public void setLevel(int level) {
        if (character.getSpeed()-level >= 1) {
            super.setLevel(level);
        } else {
            super.setLevel(character.getSpeed()-1);
        }
    }
}

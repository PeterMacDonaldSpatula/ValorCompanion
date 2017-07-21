package petermacdonald.valorgmcompanion.character.flaws;

import petermacdonald.valorgmcompanion.character.ValorCharacter;
import petermacdonald.valorgmcompanion.character.enums.FlawType;
import petermacdonald.valorgmcompanion.character.enums.LevelingSpeed;

/**
 * Created by peter on 2017-07-04.
 */

public class WeakPhysicalAttacker extends Flaw {
    ValorCharacter character;
    public WeakPhysicalAttacker(ValorCharacter character) {
        super("Weak Physical Attacker", FlawType.FLAW, LevelingSpeed.FAST, 3, 2, false, false);
        this.character = character;
    }

    @Override
    public String getDescription() {
        return "-" + calculateAttackLost() + " Strength and Agility Attack";
    }

    @Override
    public void applyPassiveEffect() {
        character.setStrengthAttack(character.getStrengthAttack()-calculateAttackLost(), this);
        character.setAgilityAttack(character.getAgilityAttack()-calculateAttackLost(), this);
    }

    private int calculateAttackLost() {
        return 3 + (3*level);
    }
}

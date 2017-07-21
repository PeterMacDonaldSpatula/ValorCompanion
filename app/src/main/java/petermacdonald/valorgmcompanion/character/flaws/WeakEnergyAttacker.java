package petermacdonald.valorgmcompanion.character.flaws;

import petermacdonald.valorgmcompanion.character.ValorCharacter;
import petermacdonald.valorgmcompanion.character.enums.FlawType;
import petermacdonald.valorgmcompanion.character.enums.LevelingSpeed;

/**
 * Created by peter on 2017-07-04.
 */

public class WeakEnergyAttacker extends Flaw {
    ValorCharacter character;

    /**
     *
     * @param character the character which this skill is attached to
     */
    public WeakEnergyAttacker(ValorCharacter character) {
        super("Weak Energy Attacker", FlawType.FLAW, LevelingSpeed.FAST, 3, 2, false, false);
        this.character = character;
    }

    @Override
    public String getDescription() {
        return "-" + calculateAttackLost() + " Spirit and Mind Attack.";
    }

    @Override
    public void applyPassiveEffect() {
        character.setSpiritAttack(character.getSpiritAttack()-calculateAttackLost(), this);
        character.setMindAttack(character.getMindAttack()-calculateAttackLost(), this);
    }

    private int calculateAttackLost() {
        return 3+(3*level);
    }
}

package petermacdonald.valorgmcompanion.character.techniques.cores;

import java.util.ArrayList;

import petermacdonald.valorgmcompanion.character.ValorCharacter;
import petermacdonald.valorgmcompanion.character.enums.CoreAttribute;
import petermacdonald.valorgmcompanion.character.enums.CoreType;
import petermacdonald.valorgmcompanion.character.techniques.limits.Limit;
import petermacdonald.valorgmcompanion.character.techniques.mods.Mod;
import petermacdonald.valorgmcompanion.character.techniques.Technique;

/**
 * This class represents Damage Cores for techniques. Ultimate Damage techs should use the UltimateDamageCore class instead.
 *
 * Eligible Attributes: Strength, Agility, Spirit, Mind
 */

public class Damage extends Core {

    //Must know the attribute to create the core. Can also create it at a given level
    public Damage(CoreAttribute attribute, int level) {
        super(CoreType.DAMAGE, "Damage", new ArrayList<CoreAttribute>(), attribute, level);
        this.eligibleAttributes.add(CoreAttribute.STRENGTH);
        this.eligibleAttributes.add(CoreAttribute.AGILITY);
        this.eligibleAttributes.add(CoreAttribute.SPIRIT);
        this.eligibleAttributes.add(CoreAttribute.MIND);
    }

    public Damage(CoreAttribute attribute) {
        super(CoreType.DAMAGE, "Damage", attribute, new ArrayList<CoreAttribute>());
        this.eligibleAttributes.add(CoreAttribute.STRENGTH);
        this.eligibleAttributes.add(CoreAttribute.AGILITY);
        this.eligibleAttributes.add(CoreAttribute.SPIRIT);
        this.eligibleAttributes.add(CoreAttribute.MIND);
    }

    @Override
    public int calculateBaseStaminaCost(Technique technique) {
        return technique.getLevel()+2;
    }

    /*
    Generates the description string for the technique and returns it. Calculates damage and roll bonus, and outputs it as a string along with a list of mods and limits.
    The descriptions are pretty primitive right now, to be improved later.

    The technique this is part of and the character this tech belongs to need to be passed in.
     */
    @Override
    public String generateDescription(Technique technique, ValorCharacter character) {
        int damage, rollBonus;
        String activeAttribute, damageType;

        if (technique.isSpecial()) {//If the technique has a Special Modifier, we need to use the Special Modifier damage calculation.
            damage = 12 + (4 * level);
            switch (attribute) {//We get our attack and roll stats depending on the attribute associated with the tech
                case STRENGTH:
                    damage += character.getHalfStrengthAttack();
                    activeAttribute = "Muscle";
                    rollBonus = character.getMuscle();
                    damageType = "physical";
                    break;
                case AGILITY:
                    damage += character.getHalfAgilityAttack();
                    activeAttribute = "Dexterity";
                    rollBonus = character.getDexterity();
                    damageType = "physical";
                    break;
                case SPIRIT:
                    damage += character.getHalfSpiritAttack();
                    activeAttribute = "Aura";
                    rollBonus = character.getAura();
                    damageType = "energy";
                    break;
                case MIND:
                    damage += character.getHalfMindAttack();
                    activeAttribute = "Intuition";
                    rollBonus = character.getIntuition();
                    damageType = "energy";
                    break;
                default://We should never see this, all Damage Cores should be one of the above attributes
                    activeAttribute = "ERROR";
                    rollBonus = 0;
                    damageType = "ERROR";
                    break;
            }
        } else {//If it doesn't have a Special Modifier, we use the standard damage calculation
            damage = 15 + (5 * level);
            switch (attribute) {//We get our attack and roll stats depending on the attribute associated with the tech
                case STRENGTH:
                    damage += character.getStrengthAttack();
                    activeAttribute = "Muscle";
                    rollBonus = character.getMuscle();
                    damageType = "physical";
                    break;
                case AGILITY:
                    damage += character.getAgilityAttack();
                    activeAttribute = "Dexterity";
                    rollBonus = character.getDexterity();
                    damageType = "physical";
                    break;
                case SPIRIT:
                    damage += character.getSpiritAttack();
                    activeAttribute = "Aura";
                    rollBonus = character.getAura();
                    damageType = "energy";
                    break;
                case MIND:
                    damage += character.getMindAttack();
                    activeAttribute = "Intuition";
                    rollBonus = character.getIntuition();
                    damageType = "energy";
                    break;
                default://We should never see this, all Damage Cores should be one of the above attributes
                    activeAttribute = "ERROR";
                    rollBonus = 0;
                    damageType = "ERROR";
                    break;
            }
        }

        //Now we generate the basic string. If there are no modifiers or limits, this will be everything there is.
        String description= "Roll " + activeAttribute + "(+" + rollBonus + "). On a hit, deal " + damage + " " + damageType + " damage.";

        //If there are modifiers, add their descriptions to the end of the description string.
        for(Mod mod:technique.getModifiers()) {
            description += " " + mod.getDescription(technique);
        }

        //If there are limits, add their descriptions to the end of the description string.
        for(Limit limit:technique.getLimits()) {
            description += " " + limit.getDescription(technique);
        }

        //Now that we've finished the string, we return it.
        return description;
    }
}

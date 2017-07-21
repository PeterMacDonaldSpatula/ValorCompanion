package petermacdonald.valorgmcompanion.character.techniques.cores;

import java.util.ArrayList;

import petermacdonald.valorgmcompanion.character.ValorCharacter;
import petermacdonald.valorgmcompanion.character.enums.CoreAttribute;
import petermacdonald.valorgmcompanion.character.enums.CoreType;
import petermacdonald.valorgmcompanion.character.techniques.limits.Limit;
import petermacdonald.valorgmcompanion.character.techniques.mods.Line;
import petermacdonald.valorgmcompanion.character.techniques.mods.Mod;
import petermacdonald.valorgmcompanion.character.techniques.mods.Ranged;
import petermacdonald.valorgmcompanion.character.techniques.Technique;

/**
 * This class is represents the Barrier Core - line variant. Barrier Cores which are blast-radius shaped are a separate class.
 */

public class BarrierLine extends Core {

    //Must know the attribute to create the core. Can also create it at a given level
    public BarrierLine(CoreAttribute attribute) {
        super(CoreType.BARRIER_LINE, "Barrier", attribute, new ArrayList<CoreAttribute>());
        this.eligibleAttributes.add(CoreAttribute.MIND);
        this.eligibleAttributes.add(CoreAttribute.SPIRIT);
    }

    public BarrierLine(CoreAttribute attribute, int level) {
        super(CoreType.BARRIER_LINE, "Barrier", new ArrayList<CoreAttribute>(), attribute, level);
        this.eligibleAttributes.add(CoreAttribute.MIND);
        this.eligibleAttributes.add(CoreAttribute.SPIRIT);
    }

    //Returns the base stamina cost, before any limits are applied
    @Override
    public int calculateBaseStaminaCost(Technique technique) {
        return technique.getLevel() + 1;
    }

    //Returns the description string for techniques with this core.
    @Override
    public String generateDescription(Technique technique, ValorCharacter character) {
        String activeAttribute;
        int rollBonus;
        int lineLength = getLineLength(technique);//How long the line is

        switch(attribute) {//Sets the active attribute and roll bonus for use in generating the effect string below.
            case SPIRIT: activeAttribute = "Aura";
                rollBonus = character.getAura();
                break;
            case MIND: activeAttribute = "Intuition";
                rollBonus = character.getIntuition();
                break;
            default: activeAttribute = "ERROR";
                rollBonus = 0;
                break;
        }

        //Generate the base effect string.
        String description = "Create a barrier of length " + getLineLength(technique) + " originating from a space within a range of " + getCreationRange(technique) + " spaces. Characters trying to move through this barrier must succeed at an opposed roll against your " + activeAttribute + " (+" + rollBonus + ") or else their movement ends. If a character tries to use a technique against a target which is across this barrier, they must succeed at an opposed roll between this technique's core power (" + level + ") and their own technique's core power or else their technique does not affect any spaces which are beyond the barrier. The barrier is destroyed regardless of whether these rolls succeed or fail.";

        //If there are modifiers, add their descriptions to the end of the description string.
        for(Mod mod:technique.getModifiers()) {
            if (!(mod instanceof Line || mod instanceof Ranged))//Line Attack and Ranged Technique mods have already been incorporated in the base description string, so they are excluded here.
            description += " " + mod.getDescription(technique);
        }

        //If there are limits, add their descriptions to the end of the description string.
        for(Limit limit:technique.getLimits()) {
            description += " " + limit.getDescription(technique);
        }

        //Now that we've finished the string, we return it.
        return description;
    }

    //This method returns how long of a line the barrier can be, based on how many levels of Line Attack it's got on it.
    //Used in generating the description string.
    private int getLineLength(Technique technique) {
        Line lineMod = technique.getLineMod();
        int length;
        switch(attribute) {
            case SPIRIT: length = 4;
                break;
            default: length = 3;
                break;
        }
        if (lineMod == null) {
            return length;
        } else {
            length += lineMod.getLevel()*3;
            return length;
        }
    }

    //Returns how far away the line can be created from (5 + range from Ranged mod)
    //Used in generating the description string.
    private int getCreationRange(Technique technique) {
        Ranged rangedMod = technique.getRangedMod();
        if (rangedMod==null) {
            return 5;
        } else {
            return 5 + rangedMod.getRange(technique);
        }
    }


}

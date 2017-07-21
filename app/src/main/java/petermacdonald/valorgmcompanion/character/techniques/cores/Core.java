package petermacdonald.valorgmcompanion.character.techniques.cores;

import java.util.List;

import petermacdonald.valorgmcompanion.character.ValorCharacter;
import petermacdonald.valorgmcompanion.character.enums.CoreAttribute;
import petermacdonald.valorgmcompanion.character.enums.CoreType;
import petermacdonald.valorgmcompanion.character.techniques.Technique;


/**
 * This is the abstract class representing Technique Cores. All technique cores should be subclasses of this class.
 */

public abstract class Core {
    final CoreType type; //What type of core it is. This value is set in the constructor and cannot be changed.
    final String name;//The name of the core as a string. This value is set in the constructor and cannot be changed.
    protected final List<CoreAttribute> eligibleAttributes;//What attributes can be associated with cores of this type? Although not set final - not a lot of point, since it wouldn't stop things being added to the list - this should never be changed after set in the constructor
    protected CoreAttribute attribute;//What attribute is associated with it?
    int level;//What level is the core?

    public Core(CoreType type, String name, CoreAttribute attribute, List<CoreAttribute> eligibleAttributes) {
        this.type = type;
        this.name = name;
        this.attribute = attribute;
        this.eligibleAttributes = eligibleAttributes;
        this.level = 1;
    }

    public Core(CoreType type, String name, List<CoreAttribute> eligibleAttributes, CoreAttribute attribute, int level) {
        this.type = type;
        this.name = name;
        this.eligibleAttributes = eligibleAttributes;
        this.attribute = attribute;
        this.level = level;
    }

    public CoreType getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public CoreAttribute getAttribute() {
        return attribute;
    }

    public void setAttribute(CoreAttribute attribute) {
        this.attribute = attribute;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    /*
        Calculates the base stamina cost before any limits
     */
    public abstract int calculateBaseStaminaCost(Technique technique);

    /*
        Generates the technique's description.
     */
    public abstract String generateDescription(Technique technique, ValorCharacter character);



}

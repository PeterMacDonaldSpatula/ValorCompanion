package petermacdonald.valorgmcompanion.character.enums;

/**
 * The list of all attributes which a core can be keyed to.
 */

public enum CoreAttribute {
    STRENGTH, AGILITY, SPIRIT, MIND, GUTS;

    @Override
    public String toString() {
        switch(this) {
            case STRENGTH: return "Strength";
            case AGILITY: return "Agility";
            case SPIRIT: return "Spirit";
            case MIND: return "Mind";
            case GUTS: return "Guts";
            default: throw new IllegalArgumentException();
        }
    }
}

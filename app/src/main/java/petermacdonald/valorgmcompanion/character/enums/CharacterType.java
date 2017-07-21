package petermacdonald.valorgmcompanion.character.enums;

/**
 * Created by peter on 2017-05-30.
 */

public enum CharacterType {
    FLUNKY, SOLDIER, SWARM, ELITE, MASTER;

    @Override
    public String toString() {
        switch(this) {
            case FLUNKY: return "Flunky";
            case SOLDIER: return "Soldier";
            case SWARM: return "Swarm";
            case ELITE: return "Elite";
            case MASTER: return "Master";
            default: throw new IllegalArgumentException();
        }
    }
}

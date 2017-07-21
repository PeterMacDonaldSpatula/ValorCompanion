package petermacdonald.valorgmcompanion.character.techniques.mods;

import java.util.ArrayList;
import java.util.List;

import petermacdonald.valorgmcompanion.character.enums.CoreType;
import petermacdonald.valorgmcompanion.character.enums.ModType;
import petermacdonald.valorgmcompanion.character.techniques.Technique;

/**
 * Created by peter on 2017-07-04.
 */

public class Sapping extends Mod {
    public Sapping() {
        super("Sapping Strike", 0, 0, true, ModType.SPECIAL, 1, new ArrayList<CoreType>());
        this.eligibleCores.add(CoreType.DAMAGE);
        this.eligibleCores.add(CoreType.ULTIMATE_ATTACK);
        this.level = 1;
    }

    @Override
    public String getDescription(Technique technique) {
        return "On a hit, the target takes an additional 1/3rd of the base damage after defense or resistance is applied on their turn for the next three turns.";
    }
}

package petermacdonald.valorgmcompanion.character.techniques.limits;

import java.util.ArrayList;
import java.util.List;

import petermacdonald.valorgmcompanion.character.CharacterComponent;
import petermacdonald.valorgmcompanion.character.enums.CoreType;
import petermacdonald.valorgmcompanion.character.techniques.Technique;

/**
 * Created by peter on 2017-07-04.
 */

public class Cooldown extends Limit {
    public Cooldown() {
        super("Cooldown", 2, false, 1, new ArrayList<CoreType>(), false, false);
        this.eligibleCores.add(CoreType.BARRIER_BLAST);
        this.eligibleCores.add(CoreType.BARRIER_LINE);
        this.eligibleCores.add(CoreType.BOOST);
        this.eligibleCores.add(CoreType.HEALING);
        this.eligibleCores.add(CoreType.DAMAGE);
        this.eligibleCores.add(CoreType.MIMIC);
        this.eligibleCores.add(CoreType.SUMMONING);
        this.eligibleCores.add(CoreType.WEAKEN);
        level = 1;
    }

    public Cooldown(int level) {
        super("Cooldown", 2, false, 1, new ArrayList<CoreType>(), false, false);
        this.eligibleCores.add(CoreType.BARRIER_BLAST);
        this.eligibleCores.add(CoreType.BARRIER_LINE);
        this.eligibleCores.add(CoreType.BOOST);
        this.eligibleCores.add(CoreType.HEALING);
        this.eligibleCores.add(CoreType.DAMAGE);
        this.eligibleCores.add(CoreType.MIMIC);
        this.eligibleCores.add(CoreType.SUMMONING);
        this.eligibleCores.add(CoreType.WEAKEN);
        this.level = level;
    }

    @Override
    public String getDescription(Technique technique) {
        return "After this technique is used, it goes on cooldown for " + level + " turns.";
    }
}

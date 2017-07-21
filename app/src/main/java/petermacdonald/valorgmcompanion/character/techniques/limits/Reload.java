package petermacdonald.valorgmcompanion.character.techniques.limits;

import java.util.ArrayList;
import java.util.List;

import petermacdonald.valorgmcompanion.character.enums.CoreType;
import petermacdonald.valorgmcompanion.character.techniques.Technique;

/**
 * Created by peter on 2017-07-04.
 */

public class Reload extends Limit {
    public Reload() {
        super("Reload Limit", 4, true, 1, new ArrayList<CoreType>(), false, false);
        this.eligibleCores.add(CoreType.BARRIER_BLAST);
        this.eligibleCores.add(CoreType.WEAKEN);
        this.eligibleCores.add(CoreType.BARRIER_LINE);
        this.eligibleCores.add(CoreType.DAMAGE);
        this.eligibleCores.add(CoreType.HEALING);
        this.eligibleCores.add(CoreType.BOOST);
        this.level = 1;
    }

    @Override
    public String getDescription(Technique technique) {
        return "You must spend a support action to reload this technique before it can be used again.";
    }
}

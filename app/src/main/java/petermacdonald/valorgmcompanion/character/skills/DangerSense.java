package petermacdonald.valorgmcompanion.character.skills;

import petermacdonald.valorgmcompanion.character.enums.LevelingSpeed;
import petermacdonald.valorgmcompanion.character.enums.SkillType;

/**
 * Created by peter on 2017-07-02.
 */

public class DangerSense extends Skill {
    public DangerSense() {
        super("Danger Sense", LevelingSpeed.FIXED, SkillType.SITUATIONAL, 1, 3, 0, false, false);
    }

    @Override
    public String getDescription() {
        return "You are immune to the effects of the Surprised status during an Ambush round.";
    }
}

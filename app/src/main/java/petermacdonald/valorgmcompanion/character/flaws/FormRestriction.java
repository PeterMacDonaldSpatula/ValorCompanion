package petermacdonald.valorgmcompanion.character.flaws;

import petermacdonald.valorgmcompanion.character.enums.FlawType;
import petermacdonald.valorgmcompanion.character.enums.LevelingSpeed;
import petermacdonald.valorgmcompanion.character.skills.Skill;
import petermacdonald.valorgmcompanion.character.techniques.Technique;

/**
 * This class models the flaw Form Restriction. It can be taken multiple time, and its subtitle is always based on the attached skill and transformation techniques.
 * Does not guard against inappropriate techniques being used here.
 */

public class FormRestriction extends Flaw {
    Skill attachedSkill;
    Technique transformation;

    public FormRestriction(Skill skill, Technique transformation) {
        super("Form Restriction", FlawType.FLAW, LevelingSpeed.FIXED, 2, 0, true, true);
        this.attachedSkill = skill;
        this.transformation = transformation;
        this.setSubtitle("");
    }

    @Override
    public String getDescription() {
        return "The skill " + attachedSkill.getName() + "is only available while the " + transformation.getName() + "transformation is active.";
    }

    @Override
    public int getValue() {
        if (attachedSkill.getCost() > 2) {
            return super.getValue();
        } else {
            return 1;
        }
    }

    @Override
    public void setSubtitle(String subtitle) {
        super.setSubtitle(attachedSkill.getName() + "in" + transformation.getName());
    }
}

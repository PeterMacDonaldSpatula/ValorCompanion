package petermacdonald.valorgmcompanion.character;

import org.junit.Before;
import org.junit.Test;

import petermacdonald.valorgmcompanion.character.enums.CharacterType;
import petermacdonald.valorgmcompanion.character.flaws.AggravatedWounds;
import petermacdonald.valorgmcompanion.character.flaws.Berserker;
import petermacdonald.valorgmcompanion.character.flaws.Compulsion;
import petermacdonald.valorgmcompanion.character.flaws.LackOfControl;
import petermacdonald.valorgmcompanion.character.flaws.MalevolentEntity;
import petermacdonald.valorgmcompanion.character.skills.DangerSense;
import petermacdonald.valorgmcompanion.character.skills.Tough;

import static org.junit.Assert.*;

/**
 * Created by peter on 2017-06-25.
 */
public class SkillsAndFlawsAddingAndRemovingTest {
    ValorCharacter flunky, soldier, swarm, elite, master;

    @Before
    public void setUp() throws Exception {
        flunky = new ValorCharacter(CharacterType.FLUNKY, 10, 17, 17, 2, 2, 14);
        soldier = new ValorCharacter(CharacterType.SOLDIER, 10, 17, 17, 2, 2, 14);
        swarm = new ValorCharacter(CharacterType.SWARM, 10, 17, 17, 2, 2, 14);
        elite = new ValorCharacter(CharacterType.ELITE, 10, 17, 17, 2, 2, 14);
        master = new ValorCharacter(CharacterType.MASTER, 10, 17, 17, 2, 2, 14);
    }

    @Test
    public void addSkill() throws Exception {
        assertEquals(1, flunky.getHealth());
        assertEquals(188, soldier.getHealth());
        assertEquals(375, swarm.getHealth());
        assertEquals(375, elite.getHealth());
        assertEquals(750, master.getHealth());

        flunky.addSkill(new Tough(flunky));
        soldier.addSkill(new Tough(soldier));
        swarm.addSkill(new Tough(swarm));
        elite.addSkill(new Tough(elite));
        master.addSkill(new Tough(master));

        flunky.addSkill(new DangerSense());
        soldier.addSkill(new DangerSense());
        swarm.addSkill(new DangerSense());
        elite.addSkill(new DangerSense());
        master.addSkill(new DangerSense());

        assertEquals(9, flunky.getUsedSP());
        assertEquals(9, soldier.getUsedSP());
        assertEquals(9, swarm.getUsedSP());
        assertEquals(9, elite.getUsedSP());
        assertEquals(9, master.getUsedSP());

        assertEquals(1, flunky.getHealth());
        assertEquals(203, soldier.getHealth());
        assertEquals(405, swarm.getHealth());
        assertEquals(405, swarm.getHealth());
        assertEquals(810, master.getHealth());

        flunky.removeSkill(new Tough(flunky));
        soldier.removeSkill(new Tough(soldier));
        swarm.removeSkill(new Tough(swarm));
        elite.removeSkill(new Tough(elite));
        master.removeSkill(new Tough(master));

        assertEquals(1, flunky.getHealth());
        assertEquals(188, soldier.getHealth());
        assertEquals(375, swarm.getHealth());
        assertEquals(375, elite.getHealth());
        assertEquals(750, master.getHealth());

        assertEquals(3, flunky.getUsedSP());
        assertEquals(3, soldier.getUsedSP());
        assertEquals(3, swarm.getUsedSP());
        assertEquals(3, elite.getUsedSP());
        assertEquals(3, master.getUsedSP());
    }

    @Test
    public void addFlaw() throws Exception {
        assertEquals(56, flunky.getStamina());
        assertEquals(56, soldier.getStamina());
        assertEquals(56, swarm.getStamina());
        assertEquals(56, elite.getStamina());
        assertEquals(112, master.getStamina());

        assertEquals(37, flunky.getSkillPoints());
        assertEquals(37, soldier.getSkillPoints());
        assertEquals(74, swarm.getSkillPoints());
        assertEquals(74, elite.getSkillPoints());
        assertEquals(88, master.getSkillPoints());

        flunky.addFlaw(new LackOfControl(flunky));
        soldier.addFlaw(new LackOfControl(soldier));
        swarm.addFlaw(new LackOfControl(swarm));
        elite.addFlaw(new LackOfControl(elite));
        master.addFlaw(new LackOfControl(master));

        flunky.addFlaw(new AggravatedWounds());
        soldier.addFlaw(new AggravatedWounds());
        swarm.addFlaw(new AggravatedWounds());
        elite.addFlaw(new AggravatedWounds());
        master.addFlaw(new AggravatedWounds());

        flunky.addFlaw(new Berserker());
        soldier.addFlaw(new Berserker());
        swarm.addFlaw(new Berserker());
        elite.addFlaw(new Berserker());
        master.addFlaw(new Berserker());

        flunky.addFlaw(new Compulsion());
        soldier.addFlaw(new Compulsion());
        swarm.addFlaw(new Compulsion());
        elite.addFlaw(new Compulsion());
        master.addFlaw(new Compulsion());

        flunky.addFlaw(new MalevolentEntity());
        soldier.addFlaw(new MalevolentEntity());
        swarm.addFlaw(new MalevolentEntity());
        elite.addFlaw(new MalevolentEntity());
        master.addFlaw(new MalevolentEntity());

        assertEquals(48, flunky.getStamina());
        assertEquals(48, soldier.getStamina());
        assertEquals(48, swarm.getStamina());
        assertEquals(48, elite.getStamina());
        assertEquals(96, master.getStamina());

        assertEquals(37+17, flunky.getSkillPoints());
        assertEquals(37+17, soldier.getSkillPoints());
        assertEquals(74+17, swarm.getSkillPoints());
        assertEquals(74+17, elite.getSkillPoints());
        assertEquals(88+17, master.getSkillPoints());

        flunky.removeFlaw(new LackOfControl(flunky));
        soldier.removeFlaw(new LackOfControl(soldier));
        swarm.removeFlaw(new LackOfControl(swarm));
        elite.removeFlaw(new LackOfControl(elite));
        master.removeFlaw(new LackOfControl(master));

        assertEquals(37+16, flunky.getSkillPoints());
        assertEquals(37+16, soldier.getSkillPoints());
        assertEquals(74+16, swarm.getSkillPoints());
        assertEquals(74+16, elite.getSkillPoints());
        assertEquals(88+16, master.getSkillPoints());

        assertEquals(56, flunky.getStamina());
        assertEquals(56, soldier.getStamina());
        assertEquals(56, swarm.getStamina());
        assertEquals(56, elite.getStamina());
        assertEquals(112, master.getStamina());
    }

}
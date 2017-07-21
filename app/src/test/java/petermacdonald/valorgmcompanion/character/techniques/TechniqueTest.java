package petermacdonald.valorgmcompanion.character.techniques;

import org.junit.Before;
import org.junit.Test;

import petermacdonald.valorgmcompanion.character.ValorCharacter;
import petermacdonald.valorgmcompanion.character.enums.CharacterType;
import petermacdonald.valorgmcompanion.character.enums.CoreAttribute;
import petermacdonald.valorgmcompanion.character.techniques.cores.BarrierLine;
import petermacdonald.valorgmcompanion.character.techniques.cores.Damage;
import petermacdonald.valorgmcompanion.character.techniques.limits.Cooldown;
import petermacdonald.valorgmcompanion.character.techniques.limits.Reload;
import petermacdonald.valorgmcompanion.character.techniques.mods.Line;
import petermacdonald.valorgmcompanion.character.techniques.mods.Ranged;
import petermacdonald.valorgmcompanion.character.techniques.mods.Sapping;

import static org.junit.Assert.*;

/**
 * Created by peter on 2017-07-04.
 */
public class TechniqueTest {
    ValorCharacter character;
    Technique technique;

    @Before
    public void setUp() throws Exception {
            character = new ValorCharacter(CharacterType.ELITE, 1, 8, 8, 1, 1, 7);
            technique = new Technique(character, new Damage(CoreAttribute.STRENGTH, 1));
            technique.addMod(new Ranged());
            technique.addLimit(new Cooldown());
            technique.addLimit(new Cooldown());
    }

    @Test
    public void addMod() throws Exception {
        assertEquals(2, technique.getStaminaCost());
        technique.addMod(new Line());
        System.out.println("Add the line in:");
        System.out.println(technique.getDescription());
        assertEquals(3, technique.getStaminaCost());
    }

    @Test
    public void addLimit() throws Exception {
        assertEquals(2, technique.getStaminaCost());
        technique.addLimit(new Reload());
        System.out.println("Add reload in:");
        System.out.println(technique.getDescription());
        assertEquals(0, technique.getStaminaCost());
    }

    @Test
    public void removeMod() throws Exception {
        assertEquals(2, technique.getStaminaCost());
        assertEquals(2, technique.getLevel());
        technique.removeMod(new Ranged());
        assertEquals(1, technique.getStaminaCost());
        assertEquals(1, technique.getLevel());
    }

    @Test
    public void removeLimit() throws Exception {
        assertEquals(2, technique.getStaminaCost());
        technique.removeLimit(new Cooldown());
        assertEquals(4, technique.getStaminaCost());
    }

    @Test
    public void setAttribute() throws Exception {
        System.out.println("Set to Agility:");
        technique.setAttribute(CoreAttribute.AGILITY);
        System.out.println(technique.getDescription());
    }

    @Test
    public void setCore() throws Exception {
        System.out.println("Set to BarrierLine:");
        technique.setCore(new BarrierLine(CoreAttribute.SPIRIT));
        System.out.println(technique.getDescription());
    }

    @Test
    public void isSpecial() throws Exception {
        assertEquals(false, technique.isSpecial());
        technique.addMod(new Sapping());
        assertEquals(true, technique.isSpecial());
        System.out.println("Set to Sapping:");
        System.out.println(technique.getDescription());

    }

    @Test
    public void getLineMod() throws Exception {
        Line lineMod = technique.getLineMod();
        assertEquals(null, lineMod);
        technique.addMod(new Line());
        lineMod = technique.getLineMod();
        assertNotEquals(null, lineMod);
        assertEquals(1, lineMod.getLevel());
    }

    @Test
    public void getRangedMod() throws Exception {
        Ranged rangedMod = technique.getRangedMod();
        assertNotEquals(null, rangedMod);
        assertEquals(1, rangedMod.getLevel());
        technique.removeMod(new Ranged());
        rangedMod = technique.getRangedMod();
        assertEquals(null, rangedMod);
    }
}
package petermacdonald.valorgmcompanion;

import org.junit.Before;
import org.junit.Test;

import petermacdonald.valorgmcompanion.character.ValorCharacter;
import petermacdonald.valorgmcompanion.character.enums.CharacterType;

import static org.junit.Assert.*;

/**
 * Created by peter on 2017-06-25.
 */
public class ValorCharacterTest {

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
    public void getSeason() throws Exception {
        assertEquals(4, flunky.getSeason());
        assertEquals(4, soldier.getSeason());
        assertEquals(4, swarm.getSeason());
        assertEquals(4, elite.getSeason());
        assertEquals(4, master.getSeason());
    }

    @Test
    public void getMuscle() throws Exception {
        assertEquals(10, flunky.getMuscle());
        assertEquals(10, soldier.getMuscle());
        assertEquals(11, swarm.getMuscle());
        assertEquals(11, elite.getMuscle());
        assertEquals(11, master.getMuscle());
    }

    @Test
    public void getDexterity() throws Exception {
        assertEquals(10, flunky.getDexterity());
        assertEquals(10, soldier.getDexterity());
        assertEquals(11, swarm.getDexterity());
        assertEquals(11, elite.getDexterity());
        assertEquals(11, master.getDexterity());
    }

    @Test
    public void getAura() throws Exception {
        assertEquals(23, flunky.getAura());
        assertEquals(23, soldier.getAura());
        assertEquals(24, swarm.getAura());
        assertEquals(24, elite.getAura());
        assertEquals(24, master.getAura());
    }

    @Test
    public void getIntuition() throws Exception {
        assertEquals(23, flunky.getIntuition());
        assertEquals(23, soldier.getIntuition());
        assertEquals(24, swarm.getIntuition());
        assertEquals(24, elite.getIntuition());
        assertEquals(24, master.getIntuition());
    }

    @Test
    public void getResolve() throws Exception {
        assertEquals(22, flunky.getResolve());
        assertEquals(22, soldier.getResolve());
        assertEquals(23, swarm.getResolve());
        assertEquals(23, elite.getResolve());
        assertEquals(23, master.getResolve());
    }

    @Test
    public void getSkillPoints() throws Exception {
        assertEquals(67, flunky.getSkillPoints());
        assertEquals(67, soldier.getSkillPoints());
        assertEquals(134, swarm.getSkillPoints());
        assertEquals(134, elite.getSkillPoints());
        assertEquals(158, master.getSkillPoints());
    }

    @Test
    public void getTechPoints() throws Exception {
        assertEquals(37, flunky.getTechPoints());
        assertEquals(64, soldier.getTechPoints());
        assertEquals(64, swarm.getTechPoints());
        assertEquals(118, elite.getTechPoints());
        assertEquals(139, master.getTechPoints());
    }

    @Test
    public void getStatPoints() throws Exception {
        assertEquals(82, flunky.getStatPoints());
        assertEquals(82, soldier.getStatPoints());
        assertEquals(82, swarm.getStatPoints());
        assertEquals(82, elite.getStatPoints());
        assertEquals(82, master.getStatPoints());
    }

    @Test
    public void getMaxTechLevel() throws Exception {
        assertEquals(23, flunky.getMaxTechLevel());
        assertEquals(23, soldier.getMaxTechLevel());
        assertEquals(23, swarm.getMaxTechLevel());
        assertEquals(23, elite.getMaxTechLevel());
        assertEquals(23, master.getMaxTechLevel());
    }

    @Test
    public void getMaxAttribute() throws Exception {
        assertEquals(27, flunky.getMaxAttribute());
        assertEquals(27, soldier.getMaxAttribute());
        assertEquals(27, swarm.getMaxAttribute());
        assertEquals(27, elite.getMaxAttribute());
        assertEquals(27, master.getMaxAttribute());
    }

    @Test
    public void getMaxFlaws() throws Exception {
        assertEquals(27, flunky.getMaxAttribute());
        assertEquals(27, soldier.getMaxAttribute());
        assertEquals(27, swarm.getMaxAttribute());
        assertEquals(27, elite.getMaxAttribute());
        assertEquals(27, master.getMaxAttribute());
    }

    @Test
    public void getStrengthAttack() throws Exception {
        assertEquals(21, flunky.getStrengthAttack());
        assertEquals(21, soldier.getStrengthAttack());
        assertEquals(21, swarm.getStrengthAttack());
        assertEquals(42, elite.getStrengthAttack());
        assertEquals(43, master.getStrengthAttack());
    }

    @Test
    public void getAgilityAttack() throws Exception {
        assertEquals(22, flunky.getAgilityAttack());
        assertEquals(22, soldier.getAgilityAttack());
        assertEquals(22, swarm.getAgilityAttack());
        assertEquals(44, elite.getAgilityAttack());
        assertEquals(46, master.getAgilityAttack());
    }

    @Test
    public void getSpiritAttack() throws Exception {
        assertEquals(47, flunky.getSpiritAttack());
        assertEquals(47, soldier.getSpiritAttack());
        assertEquals(47, swarm.getSpiritAttack());
        assertEquals(94, elite.getSpiritAttack());
        assertEquals(121, master.getSpiritAttack());
    }

    @Test
    public void getMindAttack() throws Exception {
        assertEquals(47, flunky.getMindAttack());
        assertEquals(47, soldier.getMindAttack());
        assertEquals(47, swarm.getMindAttack());
        assertEquals(94, elite.getMindAttack());
        assertEquals(121, master.getMindAttack());
    }

    @Test
    public void getHalfStrengthAttack() throws Exception {
        assertEquals(11, flunky.getHalfStrengthAttack());
        assertEquals(11, soldier.getHalfStrengthAttack());
        assertEquals(11, swarm.getHalfStrengthAttack());
        assertEquals(21, elite.getHalfStrengthAttack());
        assertEquals(22, master.getHalfStrengthAttack());
    }

    @Test
    public void getHalfAgilityAttack() throws Exception {
        assertEquals(11, flunky.getHalfAgilityAttack());
        assertEquals(11, soldier.getHalfAgilityAttack());
        assertEquals(11, swarm.getHalfAgilityAttack());
        assertEquals(22, elite.getHalfAgilityAttack());
        assertEquals(23, master.getHalfAgilityAttack());
    }

    @Test
    public void getHalfSpiritAttack() throws Exception {
        assertEquals(24, flunky.getHalfSpiritAttack());
        assertEquals(24, soldier.getHalfSpiritAttack());
        assertEquals(24, swarm.getHalfSpiritAttack());
        assertEquals(47, elite.getHalfSpiritAttack());
        assertEquals(61, master.getHalfSpiritAttack());
    }

    @Test
    public void getHalfMindAttack() throws Exception {
        assertEquals(24, flunky.getHalfMindAttack());
        assertEquals(24, soldier.getHalfMindAttack());
        assertEquals(24, swarm.getHalfMindAttack());
        assertEquals(47, elite.getHalfMindAttack());
        assertEquals(61, master.getHalfMindAttack());
    }

    @Test
    public void setLevel() throws Exception {
        flunky.setLevel(21);
        soldier.setLevel(21);
        swarm.setLevel(21);
        elite.setLevel(21);
        master.setLevel(21);

        assertEquals(5, flunky.getSeason());
        assertEquals(5, soldier.getSeason());
        assertEquals(5, swarm.getSeason());
        assertEquals(5, elite.getSeason());
        assertEquals(5, master.getSeason());
    }

    @Test
    public void getHealth() throws Exception {
        assertEquals(1, flunky.getHealth());
        assertEquals(253, soldier.getHealth());
        assertEquals(505, swarm.getHealth());
        assertEquals(505, elite.getHealth());
        assertEquals(1010, master.getHealth());
    }

    @Test
    public void getStamina() throws Exception {
        assertEquals(196, flunky.getStamina());
        assertEquals(196, soldier.getStamina());
        assertEquals(196, swarm.getStamina());
        assertEquals(196, elite.getStamina());
        assertEquals(392, master.getStamina());
    }

    @Test
    public void getDefense() throws Exception {
        assertEquals(66, flunky.getDefense());
        assertEquals(66, soldier.getDefense());
        assertEquals(66, swarm.getDefense());
        assertEquals(66, elite.getDefense());
        assertEquals(66, master.getDefense());
    }

    @Test
    public void getResistance() throws Exception {
        assertEquals(94, flunky.getResistance());
        assertEquals(94, soldier.getResistance());
        assertEquals(94, swarm.getResistance());
        assertEquals(94, elite.getResistance());
        assertEquals(94, master.getResistance());
    }

    @Test
    public void getSpeed() throws Exception {
        assertEquals(3, flunky.getSpeed());
        assertEquals(3, soldier.getSpeed());
        assertEquals(3, swarm.getSpeed());
        assertEquals(3, elite.getSpeed());
        assertEquals(3, master.getSpeed());
    }

    @Test
    public void getHealthIncrement() throws Exception {
        assertEquals(1, flunky.getHealthIncrement());
        assertEquals(51, soldier.getHealthIncrement());
        assertEquals(101, swarm.getHealthIncrement());
        assertEquals(101, elite.getHealthIncrement());
        assertEquals(202, master.getHealthIncrement());
    }

    @Test
    public void getStaminaIncrement() throws Exception {
        assertEquals(40, flunky.getStaminaIncrement());
        assertEquals(40, soldier.getStaminaIncrement());
        assertEquals(40, swarm.getStaminaIncrement());
        assertEquals(40, elite.getStaminaIncrement());
        assertEquals(79, master.getStaminaIncrement());
    }

    @Test
    public void getCriticalHealth() throws Exception {
        assertEquals(2, flunky.getCriticalHealth());
        assertEquals(102, soldier.getCriticalHealth());
        assertEquals(202, swarm.getCriticalHealth());
        assertEquals(202, elite.getCriticalHealth());
        assertEquals(404, master.getCriticalHealth());
    }

    @Test
    public void getDamageIncrement() throws Exception {
        assertEquals(13, flunky.getDamageIncrement());
        assertEquals(13, soldier.getDamageIncrement());
        assertEquals(25, swarm.getDamageIncrement());
        assertEquals(25, elite.getDamageIncrement());
        assertEquals(25, master.getDamageIncrement());
    }

    @Test
    public void getInitiative() throws Exception {
        assertEquals(10, flunky.getInitiative());
        assertEquals(10, soldier.getInitiative());
        assertEquals(11, swarm.getInitiative());
        assertEquals(11, elite.getInitiative());
        assertEquals(11, master.getInitiative());
    }

    @Test
    public void calculateUltTP() throws Exception {
        assertEquals(0, flunky.getUltTechPoints());
        assertEquals(0, soldier.getUltTechPoints());
        assertEquals(0, swarm.getUltTechPoints());
        assertEquals(62, elite.getUltTechPoints());
        assertEquals(62, master.getUltTechPoints());
    }
}
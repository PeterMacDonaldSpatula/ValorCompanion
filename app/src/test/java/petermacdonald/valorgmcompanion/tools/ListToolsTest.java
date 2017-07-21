package petermacdonald.valorgmcompanion.tools;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import petermacdonald.valorgmcompanion.character.ValorCharacter;
import petermacdonald.valorgmcompanion.character.flaws.AggravatedWounds;
import petermacdonald.valorgmcompanion.character.flaws.Berserker;
import petermacdonald.valorgmcompanion.character.flaws.Compulsion;
import petermacdonald.valorgmcompanion.character.flaws.Flaw;
import petermacdonald.valorgmcompanion.character.flaws.LackOfControl;
import petermacdonald.valorgmcompanion.character.flaws.NonProficient;
import petermacdonald.valorgmcompanion.character.skills.Tough;

import static org.junit.Assert.*;

/**
 * Created by peter on 2017-07-02.
 */
public class ListToolsTest {
    List<Flaw> list;

    @Before
    public void setUp() throws Exception {
        list = new ArrayList<Flaw>();
        list.add(new AggravatedWounds());
        list.add(new NonProficient("Athletics"));
        list.add(new NonProficient("Negotiation"));
        list.add(new Berserker());
        list.add(new Compulsion());
        list.add(new Compulsion());
        list.add(new NonProficient("James"));
    }

    @Test
    public void getPositionInList() throws Exception {
        assertEquals(1, ListTools.getPositionInList(new AggravatedWounds(), list).length);
        assertEquals(1, ListTools.getPositionInList(new Berserker(), list).length);
        assertEquals(2, ListTools.getPositionInList(new Compulsion(), list).length);
        assertEquals(3, ListTools.getPositionInList(new NonProficient(""), list).length);

        int[] indices = ListTools.getPositionInList(new NonProficient(""), list);
        assertNotEquals(null, indices);
        for (int i=0; i<indices.length;i++) {
            assertEquals(true, list.get(indices[i]) instanceof NonProficient);
        }
    }

    @Test
    public void addToList() throws Exception {
        ListTools.addToList(new AggravatedWounds(), list);
        assertEquals(7, list.size());

        ListTools.addToList(new NonProficient("Jackass"), list);
        assertEquals(8, list.size());

        ListTools.addToList(new LackOfControl(new ValorCharacter()), list);
        assertEquals(9, list.size());

        ListTools.addToList(new Tough(new ValorCharacter()), list);
        assertEquals(9, list.size());
    }

    @Test
    public void removeFromList() throws Exception {
        ListTools.removeFromList(new AggravatedWounds(), list);
        assertEquals(6, list.size());

        ListTools.removeFromList(new NonProficient("Derp"), list);
        assertEquals(6, list.size());

        int[] indices = ListTools.getPositionInList(new NonProficient("Test"), list);
        ListTools.removeFromList(list.get(indices[0]), list);
        assertEquals(5, list.size());

        ListTools.removeFromList(new LackOfControl(new ValorCharacter()), list);
        assertEquals(5, list.size());

        ListTools.removeFromList(new Compulsion(), list);
        assertEquals(3, list.size());
    }

}
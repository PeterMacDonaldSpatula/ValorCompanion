package petermacdonald.valorgmcompanion.tools;

import java.util.List;

import petermacdonald.valorgmcompanion.character.CharacterComponent;

/**
 * This class contains static methods for handling the various lists (Skills, flaws, limits, etc.) in this app.
 */

public final class ListTools {
    /*
        This static method takes in a character component and a list, and searches the list for an object of the same class as the object. If it finds it, it returns an array of ints containing the indices of the objects.
        Otherwise, returns null.
        Used for finding Skills, Flaws, Mods and Limits in their respective lists, and/or checking if they exist in the list.
     */
    public static int[] getPositionInList(CharacterComponent component, List list) {
        int total=0;
        for (Object i: list) {
            if (component.getClass().equals(i.getClass())) {
                total++;
            }
        }
        if (total==0) {
            return null;
        } else {
            int[] indices = new int[total];
            for (Object i: list) {
                if (component.getClass().equals(i.getClass())) {
                    indices[total-1] = list.indexOf(i);
                    total--;
                }
            }
            return indices;
        }
    }

    /*
        This static method takes in a character component and a list. If the component can have multiple instances of itself, it is simply added to the list.
        Otherwise, the method checks if an object of the same class as the object already exists in the list. If it doesn't, the object is added to the list.
        If an object of the same class does exist, no action is taken.
        This method CAN add objects to lists fo the wrong type, but this will cause errors at other points in operation.
     */
    public static void addToList(CharacterComponent component, List list) {
        if (component.isMultiplesAllowed()) {
            list.add(component);
        } else {
            if (getPositionInList(component, list) == null) {
                list.add(component);
            }
        }
    }


    /*
        This static method takes in a character component and a list. If the component allows multiples, we remove the specific component passed in.
         Otherwise, it removes all objects in the list which are of the same class as the object. If no such objects exist in the list, no action is taken.
     */
    public static void removeFromList(CharacterComponent component, List list) {
        boolean[] removalIndices = new boolean[list.size()];

        if (component.isMultiplesAllowed()) {
            list.remove(component);
        } else {

            for (boolean index : removalIndices) {
                index = false;
            }

            for (Object existing : list) {
                if (component.getClass().equals(existing.getClass())) {
                    removalIndices[list.indexOf(existing)] = true;
                }
            }

            for (int i = removalIndices.length - 1; i >= 0; i--) {
                if (removalIndices[i]) {
                    list.remove(i);
                }
            }
        }
    }
}

package petermacdonald.valorgmcompanion.tools;

/**
 * This class contains static methods for common calculations needed for Valor, such as Dividing something by half and rounding up.
 */

public final class ValorMath {

    /*
        This method takes in an integer and returns its half, rounded up if necessary.
     */
    public static int halfRoundUp(int input) {
        if (input % 2 == 0) {
            return input/2;
        } else {
            return 1+(input/2);
        }
    }

    /*
        Calculates increment. You pass in the HP or ST pool total size, and it returns the increment, rounded appropriately.
     */
    public static int calculateIncrement(int total) {
        int temp = total/5;
        if (total%5 != 0) {
            temp += 1;
        }
        return temp;
    }
}

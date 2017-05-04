/**
 * Programmmer: Quan Truong
 * Professor: Dr. Zerangue
 * Class: CSC110AB
 * Date: April 13, 2017
 * <p>
 * This program returns the last index of a parameter in an array, and also gets the median number that occurs
 * in an array.
 */

import java.util.Arrays;

public class Lab13 {
    public static void main(String[] args) {
    }
    /**
     * Returns the last index in which a parameter appears in an array.
     * @param array The array to be searched.
     * @param parameter The parameter to be found in an array.
     * @return Integer. The last index in which a parameter appears.
     */
    public static int lastIndexOf(int[] array, int parameter) {
        // default value for not found is -1
        int lastIndex = -1;
        for (int count = array.length - 1; count >= 0; count--) {
            if (array[count] == parameter) {
                lastIndex = count;
            }
        }
        return lastIndex;
    }

    /**
     * Returns the middle number in an odd array.
     * @param array Integer Array. The integer array to be searched for a median number.
     * @return The median number in an array.
     */
    public static int median(int[] array) {
        int divideBy2 = array.length / 2;
        for (int i = array.length; i > 1; i--) {
            for (int count = 0; count < array.length - 1; count++) {
                int temp, temp1;
                if (array[count] > array[count + 1]) {
                    temp = array[count + 1];
                    temp1 = array[count];
                    array[count] = temp;
                    array[count + 1] = temp1;
                }
            }
        }
        return array[divideBy2];
    }
}

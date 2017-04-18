import java.util.Arrays;

/**
 * Programmer: Quan Truong
 * Class: CSC110AB
 * Professor: Dr. Zerangue
 * Assignment: Lab14
 * <p>
 * This program devowel's a word, creates a two dimensional array from a one dimensional array,
 * and gets the union from two integer arrays.
 */
public class Lab14 {

    public static void main(String[] args) {
    }

    //Creates a two dimensional array from a one dimensional array
    public static int[][] toTwoDim(int[] array, int rows, int columns) {
        int[][] newArray = new int[rows][columns];

        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                newArray[row][column] = array[column];
            }
        }
        return newArray;
    }

    // Devowels a string
    public static String devowel(String sentence) {

        for (int index = 0; index < sentence.length(); index++) {
            if (sentence.charAt(index) == 'a') {
                sentence = sentence.replace("a", "");
            } else if (sentence.charAt(index) == 'e') {
                sentence = sentence.replace("e", "");
            } else if (sentence.charAt(index) == 'i') {
                sentence = sentence.replace("i", "");
            } else if (sentence.charAt(index) == 'o') {
                sentence = sentence.replace("o", "");
            } else if (sentence.charAt(index) == 'u') {
                sentence = sentence.replace("u", "");
            }
        }
        return sentence;
    }

    //Returns the union of two arrays
    public static int[] unionArrays(int[]... arrays) {
        int bothLengths = 0;
        int counter = 0;

        for (int[] array : arrays) {
            bothLengths += array.length;
        }
        int[] accumulator = new int[bothLengths];

        for (int[] array : arrays) {
            for (int element : array) {
                if (!isDuplicated(accumulator, counter, element)) {
                    accumulator[counter++] = element;
                }
            }
        }

        int[] result = new int[counter];
        for (int i = 0; i < counter; i++) result[i] = accumulator[i];

        return result;
    }

    //Checls whether an element is duplicated
    public static boolean isDuplicated(int[] array, int counter, int value) {
        for (int i = 0; i < counter; i++) if (array[i] == value) return true;
        return false;
    }
}

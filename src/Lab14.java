import java.util.Arrays;

/**
 * Programmer: Quan Truong
 * Class: CSC110AB
 * Professor: Dr. Zerangue
 * Assignment: Lab14
 * <p>
 * This program devowel's a word, creates a two dimensional array from a one dimensional array, and gets the union from two integer arrays.
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

    // Removes duplicates in an array
    public static int[] removeDuplicates(int[] array) {
        int j = 0;
        int i = 1;

        //return if the array length is less than 2
        if (array.length < 2) {
            return array;
        }

        while (i < array.length) {

            if (array[i] == array[j]) {
                i++;
            } else {
                array[++j] = array[i++];
            }

        }
        int[] output = new int[j + 1];
        for (int k = 0; k < output.length; k++) {
            output[k] = array[k];
        }
        return output;
    }

    // Devowel a string
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

    //Returns a one dimensional array that is the union of two integer arrays
    public static int[] union(int[] arr1, int[] arr2) {
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        // length of both arrays combined
        int[] intersection = new int[arr1.length + arr2.length];

        //counters for first and second array
        int index = 0, index2 = 0;

        // Until one of the loops is exhausted, assign any value that equals each other to the result array
        while (index < arr1.length && index2 < arr2.length) {
            if (arr1[index] < arr2[index2]) {
                index++;
            } else if (arr2[index2] < arr1[index]) {
                index2++;
            } else {
                intersection[index] = arr2[index2];
                index2++;
                index++;
            }
        }

        //Sort the result array, remove duplicates, and return the result
        Arrays.sort(intersection);

        return intersection;
    }

}

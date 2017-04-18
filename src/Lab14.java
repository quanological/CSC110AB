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

        int[] inta = {1, 2, 3, 4, 8};
        int[] intb = {4, 5, 7, 6, 9};
//        System.out.println(Arrays.deepToString(toTwoDim(inta, 3, 4)));

        System.out.println(Arrays.toString(union(inta, intb)));
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
    public static int[] union(int[] arr1, int[] arr2) {

        Arrays.sort(arr1);
        System.out.println(Arrays.toString(arr1));
        Arrays.sort(arr2);
        System.out.println(Arrays.toString(arr2));
        int[] result = new int[arr1.length + arr2.length];

        int m = arr1.length;
        int n = arr2.length;

        int i = 0;
        int j = 0;
        int count = 0;
        while (i < m && j < n) {
            if (arr1[i] < arr2[j]) {
                result[i] = arr1[i];
                i++;


                count++;
            } else if (arr2[j] < arr1[i]) {
                result[i] = arr2[j];
                //changed arr2 to i instead of j
                count++;
                j++;
                i++;
                //left here without incrementing i
            } else {

                result[i] = arr1[i];
                j++;
                count++;

            }
        }


            while (i < m) {
                result[i] = arr1[i];
                i++;
                count++;
            }

        while (j < n) {
                result[i] = arr2[j];
                j++;
                i++;
            count++;
            }

        System.out.println("Count: " + count);

        System.out.println("Result: " + Arrays.toString(result));


        int[] newResult = new int[count];

        for (int ok = 0; ok < count; ok++) {
            newResult[ok] = result[ok];
        }

        return newResult;

    }
}

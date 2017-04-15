import java.util.Arrays;
import java.util.*;

public class Exam2 {

    public static void main(String[] args) {

        /* BLOCKED OUT WHILE I TEST TOTWODIM STRING VERSION

        int[] array = {2, 3, 4, 5};

        //Takes a one dimensional array, and returns a two-dimensional array with a specified number of
        //rows and columns, and fills that new two-dimensional array with the values from the one dimensional array
        System.out.println(Arrays.deepToString(toTwoDim(array, 5, 4)));

        //grabs value from two-dimensional array
        int[][] crazyArray = toTwoDim(array,2, 4);
        int randValue = crazyArray[1][1];

        System.out.println(randValue);
        reverse(array);
        String sumSentence = "abcedfghi";
        System.out.println(devowel(sumSentence));

        // Convert one dimensional String array to two dimensional char array
        String[] stringArray = {"dot", "computer", "horizon", "force"};
        System.out.println(Arrays.deepToString(toTwoDim(stringArray)));

        int[] arrayOfNums = {1,2,3,4,5};
        System.out.println(Arrays.toString(sums(arrayOfNums)));


        //Convert a binary number to decimal form
        String binaryDigits = "0100";

        System.out.println(binToDec(binaryDigits));

         // Increase method
        int[] array = {2,4,5,6,8};
        increase(array);

        */

        String string1 = "okokok";
        String string2 = "okokok";

        System.out.println(isAnagram(string1, string2));

        int[] arrayOfNums1 = {2, 3, 4, 5, 6, 7, 1, 2, 3, 4};
        int[] arrayOfNums2 = {2, 3, 4, 5, 6, 7, 1, 1, 3, 4};

        intersection(arrayOfNums1, arrayOfNums2);

    }

    public static void reverse(int[] array) {
        for (int j = 0; j < array.length / 2; j++) {
            int temp;

//            int temp = array[array.length - j -1 ];
            temp = array[j];

            array[j] = array[array.length - j - 1];


            array[array.length - j - 1] = temp;


            System.out.println(Arrays.toString(array));
        }
    }

    /**
     * Replaces all vowels in a String with an empty character, consequently "devoweling" the String.
     *
     * @param sentence String. String object to be "devoweled".
     * @return String. The String object after is has been "devoweled".
     */
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

    public static int[][] toTwoDim(int[] array, int rows, int columns) {
        int[][] newArray = new int[rows][columns];

        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                newArray[row][column] = array[column];
            }
        }
        return newArray;
    }

    /**
     * Converts a one dimensional String array to a two dimensional char array.
     *
     * @param array String[]. One dimensional string array.
     * @return Char[][]. array paramater converted to a two dimensional char array.
     */
    public static char[][] toTwoDim(String[] array) {

        char[][] newArray = new char[array.length - 1][];

        for (int index = 0; index < array.length - 1; index++) {
            int indexLength = array[index].length(); //must declare new array lengths here
            newArray[index] = new char[indexLength];
            for (int colCount = 0; colCount < array[index].length(); colCount++) {
                newArray[index][colCount] = array[index].charAt(colCount);
            }
        }

        return newArray;
    }

    public static int[] sums(int[] array) {
        int sums[] = new int[2];
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                sums[0] += array[i];
            } else if (array[i] % 2 != 0) {
                sums[1] += array[i];
            }
        }
        //values[0] = SUM OF ALL EVEN NUMBERS
        //values[1] = SUM OF ALL ODD VALUES
        return sums;
    }

    public static int binToDec(String binaryNums) {
        int result = Integer.parseInt(binaryNums, 2);
        return result;
    }

    public static void increase(int[] array) {

        int sum = 0;
        int average;
        int amtOfIndicesInArray = array.length;
        for (int index = 0; index < array.length; index++) {
            sum += array[index];
        }
        average = sum / amtOfIndicesInArray;

        for (int count = 0; count < array.length; count++) {
            array[count] += average;
        }

        System.out.println(Arrays.toString(array));
    }

    public static boolean isAnagram(String param1, String param2) {

        char[] word1 = param1.toCharArray();
        char[] word2 = param2.toCharArray();

        Arrays.sort(word1);
        Arrays.sort(word2);

        boolean sameLength = (param1.length() == param2.length());

        return sameLength && Arrays.equals(word1, word2);


    }

    public static void intersection(int[] arr1, int[] arr2) {


//        boolean sameLength = (arr1.length == arr2.length);
//
//        int index2 = 0;
//
//        while (index2 != arr1.length - 1) {
//            for (index2 = 0; index2 < arr1.length; index2++) {
//                int index1 = 0;
//                if (arr1[index1] == arr2[index2]) {
//                    System.out.println("true");
//                } else {
//                    System.out.println("false");
//                }
//                index1++;
//            }
//        }
//    }

        // array for numbers that are found in both arr1 and arr2
        int[] similarNumsFound = new int[arr1.length];
        int simIndex = 0;

        //outer for loop seems redundant
        for (int index1 = 0; index1 < arr1.length; index1++) {
            System.out.println(index1 + ": ");
            for (int index2 = 0; index2 < arr1.length; index2++) {

                if (arr1[index1] == arr2[index2]) {
                    System.out.println("true");

                    // assigns values that are exact into an array
                    similarNumsFound[simIndex] = arr1[index1];
                    simIndex++;


                } else {
                    System.out.println("false");
                }
                index1++;
            }
            System.out.println();
        }

        System.out.println(Arrays.toString(similarNumsFound));

//        //attempting to delete duplicates from set, but do not know how
//        for (int i = 0; i < similarNumsFound.length; i++) {
//
//
//        }
    }


}
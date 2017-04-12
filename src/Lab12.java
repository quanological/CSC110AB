/**
 * Programmer: Quan Truong
 * Assignment: Lab12
 * Due Date: April 10th, 2017
 * Professor: Dr. Zerangue
 * Class: CSC110AB Mon-Thurs 12:00 PM - 12:50 PM
 * <p>
 * This program calculates standard deviation, gets the minimum gap between any set of numbers
 * in an array, tells you if a sequence of numbers is found in another array, and adds all numbers
 * within a two dimensional matrix together.
 */

import java.util.Arrays;

public class Lab12 {

    public static void main(String[] args) {

        // Get standard deviation of a number
        double[] nums = {1, -2, 4, -4, 9, -6, 16, -8, 25, -10};
        System.out.println("Standard deviation: " + stdev(nums));

        // Get the minimum gap between any adjacent numbers in an array
        int[] minGapNumbers = {1, 2, 7, 19, 24, 16, 32, 37, 34};
        System.out.println("minGap: " + minGap(minGapNumbers));

        // Returns true if the values of the second parameter, which is an array, is found within the first parameter, which is an array
        int[] containsNums = {2, 7, 19};
        System.out.println("contains(minGapNumbers, containsNums): " + contains(minGapNumbers, containsNums));

        int[][] matrixNums =
                {
                        {4, 8, 626, 901, 472},
                        {42, 94, 81, 710, 8177},
                        {72, 900, 1250, 780, 7422},
                        {9000, 7264, 4562, 8152, 92}
                };

        //Matrix addition
        System.out.println("Matrix addition: ");
        System.out.println(Arrays.deepToString(matrixAdd(matrixNums, matrixNums)));


    }

    /**
     * Adds every value inside a two dimensional matrix and stores it in a new array.
     * @param grid1 Integer Array. The first two dimensional array whose values are to be summed.
     * @param grid2 Integer Array. The second two dimensional array whose values are to be summed.
     * @return Two-dimensional Integer array. Array with every element of grid1 and grid2 added together.
     */
    public static int[][] matrixAdd(int[][] grid1, int[][] grid2) {

        int c[][] = new int[grid1.length][grid1[0].length];

        for (int row = 0; row < grid1.length; row++) {
            for (int column = 0; column < grid1[row].length; column++) {
                c[row][column] += (grid1[row][column] + grid2[row][column]);
            }
        }
        return c;
    }

    /**
     * Returns true if the sequence of numbers found in a2 is found in a1.
     * @param a1 int[]. Integer array whose values will be searched to see if a2 is inside of it.
     * @param a2 int[]. Integer array whose values will be matched to a1.
     * @return Boolean. True if the sequence of numbers is found inside a1, otherwise false.
     */
    public static boolean contains(int[] a1, int[] a2) {
        for (int i = 0; i < a1.length; i++) {
            int j = 0;
            while (j < a2.length && i + j < a1.length && a1[i + j] == a2[j])
                j++;
            if (j == a2.length)
                return true;
        }
        return false;
    }

    /**
     * Calculates the standard deviation of an array of double numbers.
     * @param array Double array. Array of numbers whose standard deviation will be found.
     * @return double. Standard deviation of the numbers in array.
     */
    public static double stdev(double[] array) {
        double mean = mean(array);
        double squaredSums = 0;

        for (int index = 0; index < array.length; index++) {
            squaredSums += Math.pow(array[index] - mean, 2);
        }
        return Math.sqrt(squaredSums / (array.length - 1));
    }

    /**
     * Calculate the mean of an array.
     * @param array Integer array. List of numbers whose mean is to be calculated
     * @return double. Mean of array.
     */
    public static double mean(double[] array) {

        double total = 0;
        double arrayLength = array.length;

        for (int i = 0; i < arrayLength; i++) {
            total += array[i];
        }
        return total / arrayLength;
    }

    /**
     * Returns the minimum gap, recorded as an integer value, between any set of values in a given array.
     * @param numbers Integer array. Numbers to be processed.
     * @return The minimum gap between any two numbers in an array.
     */
    public static int minGap(int[] numbers) {
        int gap = Math.abs(numbers[1] - numbers[0]);

        for (int i = 2; i < numbers.length; i++) {
            int absDiff = Math.abs(numbers[i] - numbers[i - 1]);

            if (gap > absDiff) {
                gap = absDiff;
            }
        }
        return gap;
    }
}

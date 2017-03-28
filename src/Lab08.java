/**
 * Programmer: Quan Truong
 * Date: March 23, 2017
 * Class: CSC110AB Mon-Thurs 12:00-12:50 PM
 * Professor: Dr. Zerangue
 * Assignment: Lab08
 * <p>
 * This program prints a random number of 'x' characters until a condition is met. This program also prints a random number of lines between 5 and 20,
 * and on those lines will be a random character. This program also prints the range of a given number.
 */

import java.util.Random;

public class Lab08 {

    public static Random rand = new Random();
    public static int max = 21;
    public static int low = 5;
    public static int genRandom;

    public static void main(String[] args) {
        System.out.println();

        System.out.println("PrintX method: ");
        randomX();

        System.out.println();

        System.out.println("Generate Random Char Method: ");
        generateRandomChar();

        System.out.println();

        System.out.println("Digit Range is: ");
        System.out.println(digitRange(402));
    }


    // prints a random number of 'x' characters (between 5 and 20)
    // until a line prints 16 or more characters
    public static void randomX() {
        do {
            genRandom = rand.nextInt((max - low)) + 5;
            for (int i = 0; i < genRandom; i++) {
                System.out.print('x');

            }
            System.out.println();
        } while (genRandom <= 16);
    }

    /**
     * Generate random char per each line, on a random number of lines
     */
    public static void generateRandomChar() {

        //generates a number between 97 and 122
        int ranToChar = rand.nextInt(26) + 97;

        char fromRand = (char) ranToChar;

        int numberOfLines = rand.nextInt(11 - 5) + 5;

        int upTo80Random = rand.nextInt(81);

        for (int i = 1; i <= numberOfLines; i++) {
            for (int x = 1; x <= upTo80Random; x++) {

                System.out.print((char) ranToChar);
            }
            upTo80Random = rand.nextInt(81);
            ranToChar = rand.nextInt(26 - 0) + 97;
            System.out.println();
        }
    }

    /**
     * Take the highest digit from the parameter and subtract it from the lowest, then add one.
     *
     * @param num The number parameter, integer.
     * @return The highest digit from the parameter and subtract it from the lowest, then add one.
     */
    public static int digitRange(int num) {
        num = Math.abs(num);
        int max = num % 10;
        int min = num % 10;
        num /= 10;

        while (num > 0) {
            int digit = num % 10;

            if (digit > max) {
                max = digit;
            } else if (digit < min) {
                min = digit;
            }
            num /= 10;
        }
        return max - min + 1;
    }
}

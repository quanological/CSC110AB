/**
 * Programmer: Quan Truong
 * Assignment: Lab09
 * Date: March 27, 2017
 * Professor: Dr. Zerangue
 * Class: CSC110AB 12:00 - 12:50 PM
 *
 * A recursive number guessing game. The user inputs numbers until it matches a computer generated
 * number within a given range.
 */
/**
 * Programmer: Quan Truong
 * Assignment: Lab09
 * Date: March 27, 2017
 * Professor: Dr. Zerangue
 * Class: CSC110AB 12:00 - 12:50 PM
 *
 * A recursive number guessing game. The user inputs numbers until it matches a computer generated
 * number within a given range.
 */

import java.util.*;

public class Lab09 {

    public static int successfulGuessCounter = 0;
    public static int outOfRangeCounter = 0;
    public static final int MAX_GUESS = 100;

    public static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int userValue, computerValue;

        // Ask user for input
        System.out.println("I am thinking of a number between 1 and 100.");
        System.out.println("Type your guess: ");
        userValue = in.nextInt();

        // Generate random number
        Random rand = new Random();
        computerValue = rand.nextInt(MAX_GUESS) + 1;

        // Check whether user input is equal to the computer generated number
        isEqual(userValue, computerValue);

        // Print number of tries to screen
        System.out.println("You got it right! It took you " + successfulGuessCounter + " tries.");
        System.out.println("You had " + outOfRangeCounter + " out of range tries.");
    }

    /**
     * Checks whether the user's input is equivalent to the computer generated number.
     * @param userValue Integer. User's input.
     * @param computerValue Integer. Random number that is generated from 1 to MAX_GUESS.
     */
    public static void isEqual(int userValue, int computerValue) {

        int lowValue = 1;
        int newMax = 100;

        while (userValue != computerValue) {
            int newUser = 0;

            if (userValue > computerValue && userValue < MAX_GUESS) {

                newUser = userValue;
                newMax = newUser - 1;
                System.out.println("Too high! Enter another number between " + (lowValue) + " and " + (newMax));
                userValue = in.nextInt();
                successfulGuessCounter++;

            } else if (userValue < computerValue) {
                lowValue = userValue;
                System.out.println("Too low! Enter a number between " + (userValue + 1) + " and " + (newMax));
                userValue = in.nextInt();
                successfulGuessCounter++;

            } else if (userValue > computerValue && userValue > MAX_GUESS) {
                System.out.print("Your guess is out of range. Try again: ");
                userValue = in.nextInt();
                outOfRangeCounter++;
            }
        }
    }
}

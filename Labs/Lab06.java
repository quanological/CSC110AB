package Labs;

/**
 * Programmer: Quan Truong
 * Assignment: Lab06
 * Date: February 22, 2017
 * 
 * This program calculates and prints the power of 2 up to a specified power, which is specified
 * by the user.
 * 
 * This program also prints a string in a vertical format, the string is provided by the 
 * user. 
 */
import java.util.Scanner;

public class Lab06 {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);

		// ask user to input number of times to power 2 and print
		System.out.print("Enter the number of times to multiply 2 by itself: ");
		int numberOfTimes = keyboard.nextInt();
		keyboard.nextLine();
		System.out.println(calculatePowerOf2(numberOfTimes));

		// ask user to input a string then print it vertically
		System.out.println("Enter a string object to be printed vertically: ");
		String userInput = keyboard.nextLine();
		System.out.println(vertical(userInput));
		
		//close scanner 
		keyboard.close();

	}

	//calculates the power of 2 up to a specified power
	public static int calculatePowerOf2(int max) {
		int power = 1;

		for (int i = 0; i < max; i++) {
			power *= 2;
		}

		return power;
	}

	//returns a string in a vertical format
	public static String vertical(String sentence) {
		String verticalString = "";
		for (int i = 0; i < sentence.length(); i++) {
			verticalString = verticalString + sentence.charAt(i) + "\n";
		}
		return verticalString;

	}
}

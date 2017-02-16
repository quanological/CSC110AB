package Labs;

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

	public static int calculatePowerOf2(int max) {
		int result = 2;

		for (int i = 1; i <= max; i++) {
			result *= i;

		}

		return result;
	}

	public static String vertical(String sentence) {
		String s = "";
		for (int i = 0; i < sentence.length(); i++) {
			s = s + sentence.charAt(i) + "\n";
		}
		return s;

	}
}

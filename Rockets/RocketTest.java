package Rockets;

/*
 * Prints a rocket to console. 
 * 
 * Programmer: Quan Truong					Class: CSC110AB M-Th 12:12:50 AM
 * Due Date: February 23, 2017
 * 
 */

public class RocketTest {
	final static int SIZE = 16;

	public static void main(String[] args) {

	//Draws a rocket
		drawCone();
		drawLine();
		drawUpperArrows();
		drawLowerArrows();
		drawLine();
		drawUpperArrows();
		drawLowerArrows();
		drawLine();
		drawCone();
	}

	public static void drawCone() {

		int width = SIZE * 2 - 1;

		// columns
		for (int line = width; line >= 1; line--) {

			// spaces
			for (int space = 1; space <= line; space++) {
				System.out.print(" ");
			}

			// fslash
			for (int fslash = line; fslash <= width; fslash++) {
				System.out.print("/");
			}

			// stars
			for (int stars = 1; stars <= 2; stars++) {
				System.out.print("*");
			}

			// bslash
			for (int bslash = line; bslash <= width; bslash++) {
				System.out.print("\\");
			}

			// spaces
			for (int space = 1; space <= line; space++) {
				System.out.print(" ");
			}

			// print new line
			System.out.print("\n");

		}


	}

	public static void drawLine() {

		int width = (SIZE * 4);

		System.out.print("+");

		// odd is =
		// even is *
		for (int line = 1; line <= width; line++) {
			if (line % 2 == 1) {
				System.out.print("=");
			} else if (line % 1 == 0) {
				System.out.print("*");
			}
		}

		System.out.print("+");
		System.out.println();

	}

	public static void drawUpperArrows() {
		// amount of columns is proportional to size
		for (int column = SIZE; column >= 1; column--) {

			// append the |
			System.out.print("|");

			// amount of dots begins at 2 and ends when it hits the current
			// column
			// column decrements in value so the number of dots will decrease
			// begins at 2 in order to align with SIZE number of columns
			for (int dots = 2; dots <= column; dots++) {
				System.out.print(".");
			}

			// amount of slashes begins at column (4), and tested against
			// constant 4
			// column decrements so slash will decrease in value
			// then slash will count upwards to SIZE
			for (int slashes = column; slashes <= SIZE; slashes++) {
				System.out.print("/\\");
			}

			// amount of dots can be achieved by taking the initial dots for
			// loop
			// and multiplying test value by 2 and subtracting 1
			for (int dots = 2; dots <= ((column * 2) - 1); dots++) {
				System.out.print(".");
			}

			// same slash loop as the initial slash loop
			for (int slashes = column; slashes <= SIZE; slashes++) {
				System.out.print("/\\");
			}

			// same dot loop as the initial dot loop
			for (int dots = 2; dots <= column; dots++) {
				System.out.print(".");
			}

			System.out.print("|");

			System.out.print("\n");
		}

	}

	public static void drawLowerArrows() {

		String result = "";
		// amount of columns is proportional to size
		for (int column = 1; column <= SIZE; column++) {

			// append the |
			System.out.print("|");

			// amount of dots begins at 2 and ends when it hits the current
			// column
			// column decrements in value so the number of dots will decrease
			// begins at 2 in order to align with SIZE number of columns
			for (int dots = 2; dots <= column; dots++) {
				System.out.print(".");
			}

			// amount of slashes begins at column (4), and tested against
			// constant 4
			// column decrements so slash will decrease in value
			// then slash will count upwards to SIZE
			for (int slashes = column; slashes <= SIZE; slashes++) {
				System.out.print("\\/");
			}

			// amount of dots can be achieved by taking the initial dots for
			// loop
			// and multiplying test value by 2 and subtracting 1
			for (int dots = 2; dots <= ((column * 2) - 1); dots++) {
				System.out.print(".");
			}

			// same slash loop as the initial slash loop
			for (int slashes = column; slashes <= SIZE; slashes++) {
				System.out.print("\\/");
			}

			// same dot loop as the initial dot loop
			for (int dots = 2; dots <= column; dots++) {
				System.out.print(".");
			}

			System.out.print("|");
			System.out.println();

		}

	}

}

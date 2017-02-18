package Rockets;

/*
 * Working on building a rocket to send to outer space. 
 * 
 * But on a serious note, the drawLowerArrows method is achieved by flipping the column parameters from UpperArrows.
 * 
 * @author qmtru
 */

public class RocketTest {
	final static int SIZE = 4;

	public static void main(String[] args) {

		// Alternating print and println because drawCone completes with a new
		// line
		// and next part does not
		System.out.print(drawCone());
		System.out.println(drawLine());
		System.out.print(drawUpperArrows());
		System.out.print(drawLowerArrows());
		System.out.println(drawLine());
		System.out.print(drawUpperArrows());
		System.out.print(drawLowerArrows());
		System.out.println(drawLine());
		System.out.println(drawCone());
	}

	public static String drawCone() {

		int width = SIZE * 2 - 1;
		String result = "";

		// columns
		for (int line = width; line >= 1; line--) {

			// spaces
			for (int space = 1; space <= line; space++) {
				result += " ";
			}

			// fslash
			for (int fslash = line; fslash <= width; fslash++) {
				result += "/";
			}

			// stars
			for (int stars = 1; stars <= 2; stars++) {
				result += "*";
			}

			// bslash
			for (int bslash = line; bslash <= width; bslash++) {
				result += "\\";
			}

			// spaces
			for (int space = 1; space <= line; space++) {
				result += " ";
			}

			// print new line
			result += "\n";

		}

		return result;

	}

	public static String drawLine() {

		int width = (SIZE * 4);
		String result = "";

		result += "+";

		// odd is =
		// even is *
		for (int line = 1; line <= width; line++) {
			if (line % 2 == 1) {
				result += "=";
			} else if (line % 1 == 0) {
				result += "*";
			}
		}

		result += "+";
		return result;

	}

	public static String drawUpperArrows() {
		String result = "";

		// amount of columns is proportional to size
		for (int column = SIZE; column >= 1; column--) {

			// append the |
			result += "|";

			// amount of dots begins at 2 and ends when it hits the current
			// column
			// column decrements in value so the number of dots will decrease
			// begins at 2 in order to align with SIZE number of columns
			for (int dots = 2; dots <= column; dots++) {
				result += ".";
			}

			// amount of slashes begins at column (4), and tested against
			// constant 4
			// column decrements so slash will decrease in value
			// then slash will count upwards to SIZE
			for (int slashes = column; slashes <= SIZE; slashes++) {
				result += "/\\";
			}

			// amount of dots can be achieved by taking the initial dots for
			// loop
			// and multiplying test value by 2 and subtracting 1
			for (int dots = 2; dots <= ((column * 2) - 1); dots++) {
				result += ".";
			}

			// same slash loop as the initial slash loop
			for (int slashes = column; slashes <= SIZE; slashes++) {
				result += "/\\";
			}

			// same dot loop as the initial dot loop
			for (int dots = 2; dots <= column; dots++) {
				result += ".";
			}

			result += "|";

			result += "\n";
		}

		return result;
	}

	public static String drawLowerArrows() {

		String result = "";
		// amount of columns is proportional to size
		for (int column = 1; column <= SIZE; column++) {

			// append the |
			result += "|";

			// amount of dots begins at 2 and ends when it hits the current
			// column
			// column decrements in value so the number of dots will decrease
			// begins at 2 in order to align with SIZE number of columns
			for (int dots = 2; dots <= column; dots++) {
				result += ".";
			}

			// amount of slashes begins at column (4), and tested against
			// constant 4
			// column decrements so slash will decrease in value
			// then slash will count upwards to SIZE
			for (int slashes = column; slashes <= SIZE; slashes++) {
				result += "\\/";
			}

			// amount of dots can be achieved by taking the initial dots for
			// loop
			// and multiplying test value by 2 and subtracting 1
			for (int dots = 2; dots <= ((column * 2) - 1); dots++) {
				result += ".";
			}

			// same slash loop as the initial slash loop
			for (int slashes = column; slashes <= SIZE; slashes++) {
				result += "\\/";
			}

			// same dot loop as the initial dot loop
			for (int dots = 2; dots <= column; dots++) {
				result += ".";
			}

			result += "|";
			result += "\n";

		}
		return result;
	}

}

package src;

/**
 * Create a scalable dollar figure drawing.
 * 
 * Use a constant.

 *
 */

public class ScalableDollarFigure {

	final public static int SIZE = 12;

	public static void main(String[] args) {
		// prints a diagram
		dollarFigure();
	}

	public static void dollarFigure() {
		// prints 7 columns
		for (int line = 1; line <= SIZE; line++) {

			// prints the outside stars
			for (int star = 0; star < (line * 2 - 2); star++) {
				System.out.print("*");
			}

			// prints the first set of dollar signs
			for (int dollarSigns = 0; dollarSigns < (SIZE - line) + 1; dollarSigns++) {
				System.out.print("$");
			}

			// prints the middle stars
			for (int stars = 0; stars < (SIZE * 2) + (-2 * line) + 2; stars++) {
				System.out.print("*");
			}

			// prints the second set of dollar signs
			for (int dollarSigns = 0; dollarSigns < (SIZE - line) + 1; dollarSigns++) {
				System.out.print("$");
			}

			// prints the 2nd set of stars
			for (int star = 0; star < (line * 2 - 2); star++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}

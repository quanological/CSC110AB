package src;

/**
 * Programmer: Quan Truong CSC110AB <M-Th 12 - 12:50 P.M.> Assignment: Lab05
 * Due: Feb. 14, 2014 (3 years late)
 * 
 * This program prints a "complex diagram" with a constant height of 7.
 */
public class Lab05 {

	public static void main(String[] args) {

		// prints the non-scalable version of the dollar figure
		DollarFigure();
		
		// print the scalable version of the dollar figure diagram
		dollarFigure2();
	}

	// prints the diagram
	public static void DollarFigure() {

		// prints 7 columns
		for (int height = 1; height <= 7; height++) {

			// prints the outside stars
			for (int star = 0; star < (height * 2 - 2); star++) {
				System.out.print("*");
			}

			// prints the first set of dollar signs
			for (int dollarSigns = 0; dollarSigns < (8 - height); dollarSigns++) {
				System.out.print("$");
			}

			// prints the middle stars
			for (int stars = 0; stars < (16 + (-2 * height)); stars++) {
				System.out.print("*");
			}

			// prints the second set of dollar signs
			for (int dollarSigns = 0; dollarSigns < (8 - height); dollarSigns++) {
				System.out.print("$");
			}

			// prints the 2nd set of stars
			for (int star = 0; star < (height * 2 - 2); star++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	final public static int HEIGHT = 12;

	public static void dollarFigure2() {
		// prints 7 columns
		for (int line = 1; line <= HEIGHT; line++) {

			// prints the outside stars
			for (int star = 0; star < (line * 2 - 2); star++) {
				System.out.print("*");
			}

			// prints the first set of dollar signs
			for (int dollarSigns = 0; dollarSigns < (HEIGHT - line) + 1; dollarSigns++) {
				System.out.print("$");
			}

			// prints the middle stars
			for (int stars = 0; stars < (HEIGHT * 2) + (-2 * line) + 2; stars++) {
				System.out.print("*");
			}

			// prints the second set of dollar signs
			for (int dollarSigns = 0; dollarSigns < (HEIGHT - line) + 1; dollarSigns++) {
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

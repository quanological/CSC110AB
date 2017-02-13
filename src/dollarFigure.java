package src;

/**
 * Programmer: Quan Truong
 * 
 * This program prints a a complex diagram.
 */
public class dollarFigure {

	public static void main(String[] args) {
		// prints a diagram
		dollarFigureNAME();
	}

	public static void dollarFigureNAME() {
		// prints 7 columns
		for (int line = 1; line <= 7; line++) {

			// prints the outside stars
			for (int star = 0; star < (line * 2 - 2); star++) {
				System.out.print("*");
			}

			// prints the first set of dollar signs
			for (int dollarSigns = 0; dollarSigns < (8 - line); dollarSigns++) {
				System.out.print("$");
			}

			// prints the middle stars
			for (int stars = 0; stars < (16 + (-2 * line)); stars++) {
				System.out.print("*");
			}

			// prints the second set of dollar signs
			for (int dollarSigns = 0; dollarSigns < (8 - line); dollarSigns++) {
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

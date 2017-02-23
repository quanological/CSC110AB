package ProgrammingProjects;

/**
 * 
 * Programmer: Quan Truong Due Date: Feb. 23, 2017
 * 
 * This program prints out a man climbing stairs.
 *
 */

public class DrawStairs1 {

	final static int STEPS = 4;

	public static void main(String[] args) {

		// for loop for the amount of steps
		// creates 17 spaces -- correct
		for (int step = 1; step <= STEPS; step++) {

			//head
			for (int spaces = 0; spaces < (step - STEPS) * (-5); spaces++) {
				System.out.print(" ");
			}

			System.out.print( "  o  ******" );

			// 2nd set of spaces
			// decrement spaces by 5
			for (int spaces = (step - 1) * 5; spaces >= 1; spaces--) {
				System.out.print( " " );
			}
			System.out.print("* \n");

			// upperbody
			for (int upperBody = 0; upperBody < (step - STEPS) * (-5); upperBody++) {
				System.out.print( " " );
			}
			System.out.print(" /|\\ *     ");

			// spaces after upperbody and asterisk
			for (int i = 5 * (step - 1); i >= 1; i--) {
				System.out.print( " " );
			}
			System.out.print( "* \n" );

			// legs
			for (int legs = 0; legs < (step - STEPS) * (-5); legs++) {
				System.out.print( " " );
			}

			// asterisk after legs
			System.out.print( " / \\ *     " );

			// spaces after legs and asterisk
			for (int spaces = (step - 1) * 5; spaces >= 1; spaces--) {
				System.out.print( " ");
			}
			System.out.print( "* \n" );
		}

		// bottom stars
		for (int bottomLength = 0; bottomLength <= (5 * STEPS) + 6; bottomLength++) {
			System.out.print( "*" );
		}
	}

}
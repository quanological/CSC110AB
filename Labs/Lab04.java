package Labs;

/**
 * Programmer: Quan Truong					CSC110AB <12:00 PM to 12:50 PM>
 * Assignment: Lab04						Due: Feb. 8, 2017
 * 
 * Prints the numbers 50 to 1 in decreasing order, prints the first 12 squares, and prints the first 12 Fibonacci numbers.
 * 
 */

public class Lab04 {

	public static void main(String[] args) {
		System.out.println("Print 50 to 1 in decreasing order: ");
		doExercise1();
		System.out.println();
		
		System.out.println("Print first 10 squares: ");
		doExercise2();
		System.out.println();
		
		System.out.println("Print the first 12 Fibonacci numbers");
		doExercise3();
	}
	
	// print the numbers 50 to 1 in decreasing order
	public static void doExercise1() {
		for (int i = 50; i >= 1; i--){
			System.out.print(i + " ");
		}
		System.out.println();
	}

	// print first 12 squares without using multiplication
	public static void doExercise2() {
		
		// init square and previous value of x
		int square = 0;
		int previousX = 0;
		
		// calculate and print the squares
		for (int x = 1; x <= 12; x++) {
			square = (square + x + previousX);
			
			System.out.print(square + " ");
			previousX = x;
		}
		System.out.println();
	}
	
	// prints the first 12 Fibonacci numbers
	public static void doExercise3() {
		int fibonacci, previousFibonacci, temp;
		System.out.print("1 ");
		
		fibonacci = 1; 
		previousFibonacci = 0;
		
		for (int i = 2; i <= 12; i++) {
			temp = fibonacci;
			fibonacci += previousFibonacci;
			previousFibonacci = temp;
			System.out.print(fibonacci + " ");
			
		}
		
	}
}

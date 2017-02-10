package Chp3;

public class mathMax {

	public static void main(String[] args) {
		int x = 2;
		String word = "sadly";
		
		System.out.println(twice(twice(twice(x))));
		
		System.out.println("\"" + word + "\"");
		
		String.length("CRAZY!\n\\\t\\\\\\\\\\n. . . .\\ \\\r\007'\\'\"TOOMUCH!");
	}
	
	public static int twice(int a) {
		return 2*a;
		
	}
	
	
	// Compare the populations of four different places
	public static void comparePopulations() {
		
		int population1 = 24;
		int population2 = 30;
		int population3 = 10;
		int population4 = 62;
		
		
		int result = Math.max(Math.max(Math.max(population1, population2),population3),population4);
		
		System.out.println(result);

		
	}

}

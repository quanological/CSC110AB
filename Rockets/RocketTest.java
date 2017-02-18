package Rockets;


public class RocketTest {
	final static int SIZE = 4;
	public static void main(String[] args) {
		
		/*
		System.out.println(drawCone());
		*/
		System.out.print(drawLine());
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
				result +=  "\\";
			}
	
			// spaces
			for (int space = 1; space <= line; space++) {
				result += " ";
			}
			
			//print new line
			result += "\n";
			
		}
		
		return result;

		
	}
	
	public static String drawLine() {
		
		int width = (SIZE*4);
		String result = "";
		
		
		
		
		result += "+";
		
		//odd is =
		//even is *
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
	
	
}

// Homework 2
// Part B
package Labs;

public class drawRocketGit 
{
	// Set the overall size of the Rocket
	static int size = 4;
			
	public static void main(String[] args) {
		cone();
		line();
		up();
		down();
		line();
		down();
		up();
		line();
		cone();
	}
	
	// The nose and tail
	public static void cone() {
		String result = "";
		int width = (size*2)-1;
		
		for (int line=width; line>=1; line--) {
			
			for (int k=1; k<=line; k++) {
				result +=" ";
			}

			for (int k=line; k<=width; k++) {
				result += ("/");
			}
			result +="**";
			
			for (int k=line; k<=width; k++) {
				result += ("\\");
			}
			result +="\n";
		}
		System.out.print(result);
	}
	
	// The upward pointing arrows of the middle
	public static void up() {
		String result = "";
		
		for (int line=size; line>=1; line--) {
			result += "|";
			for (int k=2; k<=line; k++) {
				result +=".";
			}

			for (int k=line; k<=size; k++) {
				result += ("/\\");
			}
			
			for (int k=2; k<=line; k++) {
				result +=".";
			}
			
			for (int k=2; k<=line; k++) {
				result +=".";
			}

			for (int k=line; k<=size; k++) {
				result += ("/\\");
			}
			
			for (int k=2; k<=line; k++) {
				result +=".";
			}
			result += "|";
			result +="\n";
		}
		System.out.print(result);
	}
	
	// The lines in between
	public static void line() {
		int width = size*4;
		
		System.out.print("+");
		for (int column=1; column<=width; column++) {

			if ((column % 2) == 0) {
				System.out.print("*");
			}
			else {
				System.out.print("=");
			}
		}
		System.out.print("+");
		System.out.print("\n");
	}
	
	// The downward pointing arrows of the middle
	public static void down() {
		String result = "";
		
		for (int line=1; line<=size; line++) {
			result += "|";
			for (int k=2; k<=line; k++) {
				result +=".";
			}

			for (int k=line; k<=size; k++) {
				result += ("\\/");
			}
			
			for (int k=2; k<=line; k++) {
				result +=".";
			}
			
			for (int k=2; k<=line; k++) {
				result +=".";
			}

			for (int k=line; k<=size; k++) {
				result += ("\\/");
			}
			
			for (int k=2; k<=line; k++) {
				result +=".";
			}
			result += "|";
			result +="\n";
		}
		System.out.print(result);
	}
}
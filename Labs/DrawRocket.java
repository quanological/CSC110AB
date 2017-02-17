package Labs;

public class DrawRocket {

	final static int SIZE = 4;

	public static void main(String[] args) {
		drawTop();
		drawLine();
	}

	// Draw the top of the rocket
	public static void drawTop() {
		String cone = "";
		int width = (SIZE*2)-1;

		for (int line = width; line >= 1; line--) {

			// print the spaces
			for (int spaces = 1; spaces <= line; spaces++) {
				cone += " ";

			}

			// print the forward slashes
			for (int slashes = line; slashes <= width; slashes++) {
				cone += "/";
			}
			
			cone += "**";

			/*
			 * // print the forward slashes for (int slashes = width; slashes <=
			 * width; slashes++) { cone += "/"; }
			 * 
			 * cone += "**";
			 * 
			 * // print the backslashes for (int slashes = 0; slashes < line;
			 * slashes++) { cone += "\\"; }
			 */
			cone += "\n";

		}
		System.out.println(cone);
	}

	public static void drawLine() {
		System.out.println("+=*=*=*=*+");
	}

}

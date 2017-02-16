package Labs;

public class DrawRocket {

	public static void main(String[] args) {
		
		
		//Draw the top of the rocket 
		for (int line = 1; line <= 3; line ++) {
			
			//print spaces
			for (int spaces = 1; spaces <= 3; spaces++){
				for (int i = 2; i >= spaces; i--){
					System.out.print(" ");	
					System.out.print("ok");
				}
			
			
			//print backslashes 
			for (int backslash = 3; backslash >= 0; backslash-- )
			{
				System.out.print("/");
			}
			
			
			System.out.println();
			
			
		}

	}

}

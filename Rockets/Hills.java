package Rockets;
/**
 * Use this code for the hills inside the box in rocket
 * @author qmtru
 *
 */
public class Hills {

	public static void main(String[] args) {
	int size = 4;
	
	for (int i = 1; i <= size*4; i++) {
		if ( i % 2 == 1) {
			System.out.print("/");
			
		} else if (i % 1 == 0){
			System.out.print("\\");
		}
	}
	}

}

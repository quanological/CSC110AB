package Chp3;

public class exercise20567 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		dashedLine(5);

	}
	
	public static void dashedLine(int n) {
		if (n <= 0) {
			return;
		} else {
			for (int i = 1; i <= n; i++) {
			System.out.print("-");	
			}
			System.out.println();
			
		}
	}

}

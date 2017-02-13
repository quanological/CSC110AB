package study;

public class AsteriskTriangle {

	public static void main(String[] args) {
		
		
		// creates the height of the asterisk triangle
		int n = 5;
		for (int i = 1; i <= n ; i++) {
			
			//uses the i as condition to print asterisks 
			//*
			//**
			//***
			//****
			for (int j = 1; j <= i; j ++) {
				System.out.print("*");
			}
			
			
			System.out.println();
			
			
		}
	}

}

package HW;
import java.util.*;



public class StringTokenizer1 {

	public static void main(String[] args) {
		//By default StringTokenizer breaks String on Space
		String str = "I am a sample string with a lot of spaces";
		
		// Create the String Tokenizer
		StringTokenizer defaultTokenizer = new StringTokenizer(str);
		System.out.println("Total number of tokens found: " + defaultTokenizer.countTokens());
		
		while (defaultTokenizer.hasMoreTokens()) { 
			System.out.println(defaultTokenizer.nextToken());
		}
		System.out.println("Total number of tokens found: " + defaultTokenizer.countTokens());

		
		
		//Default String Tokenizer on Spaces
		
		String str1 = "I am a string with a lot of different spaces";
		
		// String tokenizer name: defaultTokenizer
		StringTokenizer defaultTokenizer1 = new StringTokenizer(str1);

		// Print number of tokens found
		System.out.println("Total number of tokens found: " + defaultTokenizer1.countTokens());
		
		while (defaultTokenizer1.hasMoreTokens()) {
			System.out.println(defaultTokenizer1.nextToken());
		}
		
		
		
		//Create a tokenizer for a random sentence
		
		
		String sillyString = "My name is Boba Fett and I love piano";
		
		StringTokenizer bobaFettTokenizer = new StringTokenizer(sillyString);
		
		System.out.println("Number of tokens found: " + bobaFettTokenizer.countTokens());
		
		while (bobaFettTokenizer.hasMoreTokens()) {
			System.out.println(bobaFettTokenizer.nextToken());
		}
		
		//Print number of tokens left
		
		System.out.println(bobaFettTokenizer.countTokens());
		
	}

}

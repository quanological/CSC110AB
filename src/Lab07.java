package src;

public class Lab07 {

	public static void main(String[] args) {

		System.out.println(sumSome(5, 18, 3));

		System.out.println(isBalanced("aeioubdfgh"));

	}

	public static int sumSome(int range1, int range2, int divisor) {

		int sum = 0;
		for (int begin = range1; begin <= range2; begin++) {
			if (begin % divisor == 0) {
				sum += begin;
			}

		}
		return sum;
	}


	
	public static boolean isBalanced(String upperCaseCheck) {

		String upperCaseupperCaseCheck = upperCaseCheck.toUpperCase();
		int vowel, consonant;
		vowel = 0;
		consonant = 0;

		// loop through the string and count number of vowels
		for (int i = 0; i < upperCaseupperCaseCheck.length(); i++) {
			if ((upperCaseCheck.charAt(i) == 'a') || (upperCaseCheck.charAt(i) == 'e')
					|| (upperCaseCheck.charAt(i) == 'i')
					|| (upperCaseCheck.charAt(i) == 'o' || (upperCaseCheck.charAt(i) == 'u'))) {
				vowel += 1;
			}
		}

		// check for consonants
		for (int i = 0; i < upperCaseCheck.length(); i++) {
			if ((upperCaseCheck.toUpperCase().charAt(i) == 'B') || (upperCaseCheck.toUpperCase().charAt(i) == 'C')
					|| (upperCaseCheck.toUpperCase().charAt(i) == 'D')
					|| (upperCaseCheck.toUpperCase().charAt(i) == 'F')
					|| (upperCaseCheck.toUpperCase().charAt(i) == 'G')
					|| (upperCaseCheck.toUpperCase().charAt(i) == 'H')
					|| (upperCaseCheck.toUpperCase().charAt(i) == 'J')
					|| (upperCaseCheck.toUpperCase().charAt(i) == 'K')
					|| (upperCaseCheck.toUpperCase().charAt(i) == 'L')
					|| (upperCaseCheck.toUpperCase().charAt(i) == 'M')
					|| (upperCaseCheck.toUpperCase().charAt(i) == 'N')
					|| (upperCaseCheck.toUpperCase().charAt(i) == 'P')
					|| (upperCaseCheck.toUpperCase().charAt(i) == 'Q')
					|| (upperCaseCheck.toUpperCase().charAt(i) == 'R')
					|| (upperCaseCheck.toUpperCase().charAt(i) == 'S')
					|| (upperCaseCheck.toUpperCase().charAt(i) == 'T')
					|| (upperCaseCheck.toUpperCase().charAt(i) == 'V')
					|| (upperCaseCheck.toUpperCase().charAt(i) == 'X')
					|| (upperCaseCheck.toUpperCase().charAt(i) == 'Z')) {
				consonant += 1;
			}
		}

		return (vowel == consonant);

	}
	
	public static String merge (String a, String b) {
		
		
	}

}

package src;

public class Test {

	public static void main(String[] args) {
		int cents = 51;
		countQuarters(cents);
		
		
		System.out.println(everyOtherChar("abcdefg"));
		
		System.out.println(merge("ace", "bdf"));
		
		System.out.println(intDiv(6, 2));
		
	}
	
	public static int intDiv(int a, int b) {
		int count = 0;
		for (int i = a; i >= b; i-=b ) {
			count += 1;
		}
		
		return count;
	}
	
	public static int countQuarters(int cents) {
		
		return cents / 25;
		
	}
	
	public static String everyOtherChar(String s) {
		String evenString ="";
		for (int i = 0; i <s.length(); i++) {
			if (i % 2 == 0) {
				evenString += s.charAt(i);
			}
		}
		
		return evenString;
	}
	
	public static String merge(String a, String b) {
		String newString = "";
		for (int i = 0; i <a.length(); i++) {
			if (i % 2 == 0) {
				newString += a.charAt(i);
				newString += b.charAt(i);
			} else {
				newString += a.charAt(i);
				newString += b.charAt(i);
			}
		}
		
		return newString;
	}

}

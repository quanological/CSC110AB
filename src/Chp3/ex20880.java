package Chp3;

public class ex20880 {

	public static void main(String[] a) {
		String sentence="Now is the time.";
		String firstWord;
		String newSentence;
	
		//get the first word
firstWord = sentence.substring(0, sentence.indexOf(" "));
		
System.out.println(sentence.replaceFirst(" ", firstWord));


		newSentence = firstWord + sentence;


	}
	
	
	
	/*	public static void main(String[] args) {
		
		String sentence = "is googly-eyed";
		
		String trimFirstWord = "Smith is weird";
		
		String firstWord = trimFirstWord.substring(0,trimFirstWord.indexOf(" "));
		
		String newSentence = firstWord + sentence;
		
		System.out.println(newSentence);
		
		
		
		
		
		

	}*/

}

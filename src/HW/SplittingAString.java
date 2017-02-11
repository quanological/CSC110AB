package HW;

public class SplittingAString {

	public static void main(String[] args) {
		
		String sentence;
		
		//create a String array to store the split tokens
		String[] temp;
		
		sentence = "Broccoli is delicious";
		
		//split the string by " " 
		temp = sentence.split(" ");
		
		System.out.println(temp[1]);
	}

}

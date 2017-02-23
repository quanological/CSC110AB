package ProgrammingProjects;

/**
 * 
 * Programmer: Quan Truong
 * Due Date: Feb. 23, 2017
 * 
 * This program prints out a man climbing stairs.
 *
 */

public class DrawStairs{
	
	final static int STEPS = 8;  
	 
	   public static void main(String[] args){
		   
		   //Prints a bunch of men on a set of stairs, the height of which will be the final constant STEPS
		   //which is declared at the class level
		   System.out.println(drawStairs());
	   }
	   
	   public static String drawStairs() {
		   
		   String manClimbingStairs = "";
		   
		   //for loop for the amount of steps
		      for(int step = 1;step <= STEPS;step++){
		      
		         // Draw Head  ///////////////////////
		         for(int spaces = 0; spaces < (step-STEPS)*(-5);spaces++) {       
		        	 manClimbingStairs += " ";                            
		         }                                 
		      
		         manClimbingStairs += "  o  ******";                       
		         
		         
		         //2nd set of spaces
		         for(int spaces = (step-1)*5;spaces >= 1;spaces--) {            
		        	 manClimbingStairs += " ";                             
		         }
		         manClimbingStairs += "* \n";
		         
		         
		         
		         //upperbody
		         for(int upperBody = 0;upperBody < (step-STEPS)*(-5);upperBody++){         
		            manClimbingStairs += " ";
		         }                 
		         manClimbingStairs += (" /|\\ *     ");
		         
		         //spaces after upperbody and asterisk
		         for(int i = 5*(step-1);i >= 1;i--){              
		            manClimbingStairs += " ";
		         }
		         manClimbingStairs += "* \n";
		        
		         //legs
		         for(int legs = 0;legs < (step-STEPS)*(-5);legs++) {       
		            manClimbingStairs += " ";
		         }                  
		         
		         //asterisk after legs
		         manClimbingStairs += " / \\ *     ";
		         
		         //spaces after legs and asterisk
		         for(int spaces = (step-1)*5;spaces >= 1;spaces--) {             
		            manClimbingStairs += " ";                       
		         }
		         manClimbingStairs += "* \n";
		      }
		      
		      //bottom stars
		      for(int bottomLength = 0; bottomLength <= (5*STEPS)+6;bottomLength++){   
		         manClimbingStairs += "*";
		      }
		      
		   
		   
		return manClimbingStairs;
	}

}

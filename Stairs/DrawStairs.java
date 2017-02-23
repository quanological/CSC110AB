package Stairs;

public class DrawStairs {
		 
		   public static void main(String[] args){
		                     
		      int steps = 10;     
		           
		      for(int currentStep = 1;currentStep <= steps;currentStep++){
		      
		         // Draw Head  ///////////////////////
		         for(int i = 0;i < -5*(currentStep-steps);i++){        // Format - Leading spaces
		            System.out.print(" ");                             // (This step # - total step #) * negative average asterisk length. Needed a decrementing expression.
		         }                                                           
		         System.out.print("  o  ******");                       
		         
		         for(int i = 5*(currentStep-1);i >= 1;i--){             // Format - Spacing between asterisks
		            System.out.print(" ");                              // (currentStep-1) allows line 1(or 0) to place no spaces
		         }
		         System.out.println("*");
		         // End Head ////////////////////////
		         
		         
		         // Draw Torso ///////////////////////////
		         for(int i = 0;i < -5*(currentStep-steps);i++){         // Format - Leading spaces
		            System.out.print(" ");
		         }                 
		         System.out.print(" /|\\ *     ");
		         for(int i = 5*(currentStep-1);i >= 1;i--){              // Format - Spacing between asterisks
		            System.out.print(" ");
		         }
		         System.out.println("*");
		         // End Torso ////////////////////
		         
		         
		         // Draw legs //////////////////////
		         for(int i = 0;i < -5*(currentStep-steps);i++){        // Format - Leading spaces
		            System.out.print(" ");
		         }                  
		         System.out.print(" / \\ *     ");
		         
		         for(int i = 5*(currentStep-1);i >= 1;i--){              // Format - Spacing between asterisks
		            System.out.print(" ");                       
		         }
		         System.out.println("*");
		         // End Legs ////////////////////
		      }
		      
		      for(int bottomLength = 1; bottomLength <= (5*steps)+6;bottomLength++){   // Print bottom line
		         System.out.print("*");
		      }
		      System.out.println("*");
		   }
		 
		 }

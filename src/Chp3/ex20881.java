/**
 * John F. Kennedy
 * 
 * Print the initials
 * 
 * 
 */

package Chp3;

public class ex20881 {

	public static void main(String[] args) {

		String given, middle, family;

		given = "John";

		middle = "Fitzgerald";

		family = "Kennedy";

		System.out.println(given.substring(0, 1) + "." + middle.substring(0, 1) + "." + family.substring(0, 1));
	}
}

import java.util.*;
import java.io.File;
import java.util.Scanner;
import java.io.PrintStream;
import java.io.FileNotFoundException;

/**
 * This program strips a file of any tags that resemble HTML tags.
 * <p>
 * Programmer: Quan Truong
 * Assignment: Lab11
 * Professor: Dr. Zerangue
 * Class: CSC110AB 12:00 - 12:50 PM
 * Date: April 6th, 2017
 */
public class Lab11 {

    public static void main(String[] args) throws FileNotFoundException {

        File html = new File("/Users/qmtruong92/CSC110AB/src/other.html");
        Scanner line = new Scanner(html);
        stripHtmlTags(line);

    }

    // Strips a Scanner object of any tags that resemble HTML tags.
    public static void stripHtmlTags(Scanner input) {
        while (input.hasNextLine()) {
            String line = input.nextLine();

            while (line.contains("<") || line.contains(">")) {
                int index1 = line.indexOf("<");
                int index2 = line.indexOf(">");
                if (index1 == 0) {
                    line = line.substring(index2 + 1);
                } else {
                    line = line.substring(0, index1) + line.substring(index2 + 1);
                }
            }

            System.out.println(line);
        }
    }
}

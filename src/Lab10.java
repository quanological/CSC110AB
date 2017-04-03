/**
 * Programmer: Quan Truong
 * Assignment: Lab10
 * Due Date: April 3rd, 2017
 * Professor: Dr. Zerangue
 * Class: CSC110AB 12:00 - 12:50 PM
 *
 * This program replaces certain characters of words, and then wraps those words in parentheses.
 */

import java.io.*;
import java.util.*;

public class Lab10 {

    public static void main(String[] args) throws FileNotFoundException {
        PrintStream ps = new PrintStream("/Users/qmtruong92/Desktop/newWords.txt");
        File file = new File("/Users/qmtruong92/CSC110AB/src/words.txt");
        Scanner in = new Scanner(file);

        leetSpeak(in, ps);
    }

    /**
     * Reads a file and changes certain characters in it according to the conditions below,
     * and then wraps the word in parentheses, then writes the new text to a new file.
     *
     * @param in  Scanner. Location of text retrieval.
     * @param out PrintStream. Destination of where output is to be written.
     */
    public static void leetSpeak(Scanner in, PrintStream out) {
        // Executes if the Scanner has another line
        while (in.hasNextLine()) {
            String currentLine = in.nextLine();
            Scanner fromFile = new Scanner(currentLine);
            // Replace text in each word as long as there are tokens
            while (fromFile.hasNext()) {

                String word = fromFile.next();

                if (word.contains("o")) {
                    word = word.replace("o", "0");
                }
                if (word.contains("l")) {
                    word = word.replace('l', '1');
                }
                if (word.contains("e")) {
                    word = word.replace('e', '3');
                }
                if (word.contains("a")) {
                    word = word.replace('a', '4');
                }
                if (word.contains("t")) {
                    word = word.replace('t', '7');
                }
                if (word.contains("s")) {
                    word = word.replace('s', 'z');
                }
                // last letter
                if (word.charAt(word.length() - 1) == 's') {
                    word = word.substring(0, word.length() - 1) + "Z";
                }
                out.print("(" + word + ")" + " ");
            }
            out.println();
        }
    }
}

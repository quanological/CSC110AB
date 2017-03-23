import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;

import java.util.Random;


public class Lab08 {
    //These variables are declared as constants so that I can use the genRandom variable as a test in a do while loop
    public static Random rand = new Random();
    public static int max = 21;
    public static int low = 5;
    public static int genRandom;

    public static void main(String[] args) {
        System.out.println(maxDigit(68437));
//        System.out.println("PrintX method: ");
//        printX();
//        System.out.println("Generate Random Char Method: ");
//        generateRandomChar();
//
//

        System.out.println(digitRange(402));
    }


    //Logic is okay
    public static void printX() {
//        System.out.print("Number of x's should be = " + genRandom);
//        System.out.println();
//        do {
//            genRandom = rand.nextInt((max - low)) + 5;
//            for (int i = 0; i < genRandom; i++) {
//                System.out.print('x');
//
//            }
//            System.out.println();
//        } while (genRandom != 5);
    }

    public static void generateRandomChar() {

        //generates a number between 97 and 122
        int ranToChar = rand.nextInt(28 - 0) + 97;
        System.out.println("The ranToChar is generated as: " + ranToChar);

        char fromRand = (char) ranToChar;

        System.out.println("fromRand is generated as: " + fromRand);

        int numberOfLines = rand.nextInt(11 - 5) + 5;

        System.out.println("The number of lines to be generated is: " + numberOfLines);


        int upTo80Random = rand.nextInt(81 - 0);

        System.out.println("UpTo80Random is " + upTo80Random);

        for (int i = 1; i <= numberOfLines; i++) {
            for (int x = 1; x <= upTo80Random; x++) {

                System.out.print((char) ranToChar);
            }
            upTo80Random = rand.nextInt(81 - 0);
            ranToChar = rand.nextInt(28 - 0) + 97;
            System.out.println();
        }
    }

    public static int maxDigit(int parameter) {

        //ensures that negative numbers are converted to absolute value so that we may find lowest number
        parameter = Math.abs(parameter);

        if (parameter > 0) {
            int isolatedDigit = parameter % 10;
            int max = maxDigit(parameter / 10);
            return Math.max(isolatedDigit, max);

        } else {
            return 1;
        }

    }

    public static int digitRange(int num) {
        num = Math.abs(num);
        int max = num % 10;
        int min = num % 10;
        num /= 10;

        while (num > 0) {
            int digit = num % 10;

            if (digit > max) {
                max = digit;
            } else if (digit < min) {
                min = digit;
            }

            num /= 10;
        }

        return max - min + 1;
    }


}

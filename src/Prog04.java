/**
 * Programmer: Quan Truong
 * Assignment: Program 04
 * Date: April 26, 2017
 * Class: CSC110AB MTWTh 12:00-12:50 PM
 * <p>
 * Write to a file an assortment of names that are processed in a way that is specified by the user.
 */

import java.io.*;
import java.util.*;


public class Prog04 {

    //Row height of names.txt
    public static final int LENGTH = 4429;
    public static final int COLUMNS = 11;
    public static final String[] NAMES = new String[LENGTH];
    public static final int[][] NUMS = new int[LENGTH][COLUMNS]; //11 is number of columns
    //Filenames
    private static final String FILENAME = "/Users/qmtruong92/CSC110AB/src/names.txt";
    public static int fileCreationCount = 0;
    //Keyboard Scanner
    public static Scanner kb = new Scanner(System.in);


    public static void main(String[] args) throws FileNotFoundException, ArrayIndexOutOfBoundsException, NumberFormatException {
        File fr = new File(FILENAME);
        Scanner file = new Scanner(fr);
        readFile(file, NAMES, NUMS);
        introduction();
        chooseOption();
    }

    //Introduction text for the program
    public static void introduction() {
        System.out.println("This program allows you to use a file of names and their popularity ranks  \nover 11 decades to create new files based on user input:");
        System.out.println("1 - Names by increasing length");
        System.out.println("2 - All names in a chosen decade with better ranks than a chosen name");
        System.out.println("3 - Top N (chosen) names for a chosen decade");
        System.out.println("4 - Get names that begin with a letter");

        System.out.println();
    }

    //Menu selections for the application
    public static void menuSelections() {
        System.out.println("Choose a way to create the new file");
        System.out.println("1 - Have names ordered by increasing in length");
        System.out.println("2 - Names better than a given name");
        System.out.println("3 - Top N names for a given decade");
        System.out.println("4 - Names that begin with a given letter");
        System.out.println("5 - Exit program");
        System.out.println();
    }

    // Used to choose an option, and then execute one of the five commands.
    public static void chooseOption() throws FileNotFoundException {
        int option;
        boolean done = false;

        do {
            menuSelections();
            System.out.println("Enter a number between, 1-5: ");
            option = kb.nextInt();
            switch (option) {
                case 1:
                    increaseLength(NUMS, NAMES);
                    fileCreationCount++;
                    break;
                case 2:
                    namesBetterThanAName();
                    fileCreationCount++;
                    break;
                case 3:
                    topNames();
                    fileCreationCount++;
                    break;
                case 4:
                    getNameByLetter();
                    fileCreationCount++;
                    break;
                case 5:
                    done = true;
                    System.out.println("Application terminating. Created " + fileCreationCount + " files for user on this run.");
                    break;
                default:
                    System.out.print("Please enter a valid input: ");
                    option = kb.nextInt();
            }
        } while (!done);
    }

    //Prints name that are better than a specified name to a file
    public static void namesBetterThanAName() throws FileNotFoundException {

        String name;
        boolean nameValid = false;
        do {
            System.out.print("Enter a name: ");
            name = kb.next();

            //Name must be composed of letters
            if (name.matches("[a-zA-Z]+")) {
            }

            //If name is found loop
            for (int i = 0; i < NAMES.length; i++) {
                if (name.toUpperCase().equals(NAMES[i].toUpperCase())) {
                    nameValid = true;
                }
            }
        } while (!nameValid);
        //Choose a decade
        int decade = chooseDecade();


        String fileName = "NamesBetterThan" + name + "ForDecade_" + (decade + 1) + ".txt";

        //Write to the file
        PrintStream writeToFile = new PrintStream("/Users/qmtruong92/CSC110AB/src/" + fileName);

        //Used for the last print statement
        int numberCount = 0;
        int count[] = new int[NAMES.length];

        writeToFile.print("Names more popular than " + name + " (rank: " +
                getRanking(getNameIndex(name, NAMES), decade));
        writeToFile.print(") in decade, " + getDecadeString(decade + 1));
        writeToFile.println();
        writeToFile.println();

        //Write name and rank to file
        for (int i = 0; i < NAMES.length - 1; i++) {
            if (NUMS[i][decade] < 94 && NUMS[i][decade] != 0) {
                count[i]++;
                writeToFile.println("\t" + NAMES[i] + " (rank: " + NUMS[i][decade] + ")");
                numberCount++;
            }
        }

        //Print total number of names more popular than Debra
        writeToFile.print("Found " + numberCount + " names more popular than Debra in decade, ");
        writeToFile.println(getDecadeString(decade + 1));

        System.out.println(numberCount + " names written to file: NamesBetterThan" + name + "ForDecade_" + (decade + 1) + ".txt");
        System.out.println();
    }


    //Get a string for a given decade
    public static String getDecadeString(int decade) {
        String returnString = null;
        switch (decade) {
            case 1:
                returnString = "1900-1909";
                break;
            case 2:
                returnString = "1910-1919";
                break;
            case 3:
                returnString = "1920-1929";
                break;
            case 4:
                returnString = "1930-1939";
                break;
            case 5:
                returnString = "1940-1949";
                break;
            case 6:
                returnString = "1950-1959";
                break;
            case 7:
                returnString = "1960-1969";
                break;
            case 8:
                returnString = "1970-1979";
                break;
            case 9:
                returnString = "1980-1989";
                break;
            case 10:
                returnString = "1990-1999";
                break;
            case 11:
                returnString = "2000-2005";
                break;
        }
        return returnString;
    }

    //Prints a list of names based on the first letter
    public static void getNameByLetter() throws FileNotFoundException {

        String input;
        boolean nameValid = false;

        //Perform this action while the user input is not a letter
        do {
            System.out.println("Enter a letter: ");
            input = kb.next().toUpperCase();
            nameValid = input.matches("[a-zA-Z]+") && input.length() == 1;
        } while (!nameValid);

        File filename = new File("GetNamesByLetter" + input.toUpperCase() + ".txt");
        PrintStream writeToFile = new PrintStream(filename);

        char letter = input.charAt(0);

        //Write names that begin with the given letter to file
        String[] namess = new String[NAMES.length];
        int numberOfNamesPrinted = 0;
        for (int i = 0; i < NAMES.length; i++) {
            if (NAMES[i].charAt(0) == letter) {
                namess[i] = NAMES[i];
                writeToFile.println(namess[i] + " ");
                numberOfNamesPrinted++;
            }
        }

        //Tell user amount of names printed to file
        System.out.println(numberOfNamesPrinted + " were printed to " + filename);
        System.out.println();
    }

    /**
     * Prints the top names in a chosen decade to a file
     *
     * @throws FileNotFoundException
     */
    public static void topNames() throws FileNotFoundException {

        boolean topNameValid;
        int topNames;

        System.out.println("Choose your decade: ");
        int decade = chooseDecade();
        //Ensure that name is within 1000
        do {
            System.out.println("How many top names to find:  ");
            topNames = kb.nextInt();

            if (topNames < 1000 && topNames > 0) {
                topNameValid = true;
            } else
                topNameValid = false;
        } while (!topNameValid);

        int count = 0; //count numbers that aren't 0

        //initialize to 5000 and then reduce size
        int counter[] = new int[5000];
        int rankingArray[] = new int[5000];

        //Get the indices of elements that have a bigger ranking than user input
        for (int i = 0; i < NUMS.length; i++) {
            if (NUMS[i][decade] < (topNames + 1) && NUMS[i][decade] != 0) {
                count++;
                counter[i] = i;
                rankingArray[i] = NUMS[i][decade];
            }
        }

        //sort the counter and ranking array
        bubbleIntSort(counter);
        bubbleIntSort(rankingArray);

        //Create a new array that is going to be resized to the proper size
        int[] indexArray = new int[count];

        //Fill array with while counter is not over count
        indexArray = resizeAndFillArrayWithCorrectSize(indexArray, counter, count);

        //sort the indexArray
        bubbleIntSort(indexArray);

        //sort the indexArray based on rankings
        bubbleIntSortCompareRankings(indexArray, decade);

        PrintStream writeToFile = new PrintStream(new File("Top_Names_In_Decade"));
        String filename = "Top_" + topNames + "_Names_Decade_" + (decade + 1) + ".txt";
        writeToFile = new PrintStream(filename);

        //Print the resulting indexArray to a file
        printArrayToFile(writeToFile, indexArray, decade, topNames);

        writeToFile.print("\n" +
                "Found " + count + " names in top " + topNames + " in decade, ");
        writeToFile.print(getDecadeString(decade + 1) + ": ");
        writeToFile.println();

//        System.out.println("How many top names to find: " + topNames);
        System.out.println(count + " names written to file: Top_" + topNames + "_Names_Decade_" + decade + ".txt");

    }


    //Print an array to a file with the specified String formatting
    public static void printArrayToFile(PrintStream writeToFile, int[] indexArray, int decade, int topNumber) {

        writeToFile.print("Top " + topNumber + " (" + indexArray.length + ") names in decade, " + getDecadeString(decade + 1));
        writeToFile.print(": \n");
        writeToFile.println();

        for (int each = 0; each < indexArray.length; each++) {
            writeToFile.println("\t" + getName(indexArray[each]) + " (rank: " + getRanking(indexArray[each], decade) + ")");
        }

    }

    //Resizes and fills and array with the correct size
    public static int[] resizeAndFillArrayWithCorrectSize(int[] indexArray, int[] counter, int count) {
        int z = 0;
        while (z < count - 1) {
            for (int index = counter.length - 1; index > 5000 - 1 - count; index--) {
                if (counter[index] != 0) {
                    indexArray[z] = counter[index];
                    z++;
                }
            }
        }
        return indexArray;
    }

    //Bubble sort an array based on rankings
    public static void bubbleIntSortCompareRankings(int[] indexArray, int decade) {

        boolean swapped = false;

        for (int index : indexArray) {
            do {
                swapped = false;

                for (int i = 0; i < indexArray.length - 1; i++) {
                    if (getRanking(indexArray[i], decade) > getRanking(indexArray[i + 1], decade)) {
//                    if (getName(indexArray[i]).charAt(0) > getName(indexArray[i + 1]).charAt(0)) {
                        swapInt(indexArray, i, i + 1);
                        swapped = true;
                    }
                }
            } while (swapped);
        }
    }


    //Returns a name by searching through the NAMES[] constant
    public static String getName(int index) {
        return NAMES[index];
    }


    //Choose the decade
    public static int chooseDecade() {
        System.out.println("1 - 1900-1909\n" +
                "2 - 1910-1919\n" +
                "3 - 1920-1929\n" +
                "4 - 1930-1939\n" +
                "5 - 1940-1949\n" +
                "6 - 1950-1959\n" +
                "7 - 1960-1969\n" +
                "8 - 1970-1979\n" +
                "9 - 1980-1989\n" +
                "10 - 1990-1999\n" +
                "11 - 2000-2005");

        int chooseOption;
        do {
            System.out.print("Enter a number, 1-11: ");
            chooseOption = kb.nextInt();
        } while (chooseOption < 0 || chooseOption > 11);


        switch (chooseOption) {
            case 1:
                chooseOption = 0;
                break;
            case 2:
                chooseOption = 1;
                break;
            case 3:
                chooseOption = 2;
                break;
            case 4:
                chooseOption = 3;
                break;
            case 5:
                chooseOption = 4;
                break;
            case 6:
                chooseOption = 5;
                break;
            case 7:
                chooseOption = 6;
                break;
            case 8:
                chooseOption = 7;
                break;
            case 9:
                chooseOption = 8;
                break;
            case 10:
                chooseOption = 9;
                break;
            case 11:
                chooseOption = 10;
                break;
        }
        return chooseOption;
    }

    //Returns name by increasing length along with array of rankings
    public static void increaseLength(int[][]
                                              nums, String[] names) throws FileNotFoundException {

        PrintStream writeToFile = new PrintStream(new File("src/ByNameLength.txt"));

        int maxLength = 0;
        int i;
        int nameCount[] = new int[11];
        for (i = 0; i < names.length; i++) {
            if (names[i].length() > maxLength) {
                maxLength = names[i].length();
            }

            if (names[i].length() == 1) {
                nameCount[0]++;
            } else if (names[i].length() == 2) {
                nameCount[1]++;
            } else if (names[i].length() == 3) {
                nameCount[2]++;
            } else if (names[i].length() == 4) {
                nameCount[3]++;
            } else if (names[i].length() == 5) {
                nameCount[4]++;
            } else if (names[i].length() == 6) {
                nameCount[5]++;
            } else if (names[i].length() == 7) {
                nameCount[6]++;
            } else if (names[i].length() == 8) {
                nameCount[7]++;
            } else if (names[i].length() == 9) {
                nameCount[8]++;
            } else if (names[i].length() == 10) {
                nameCount[9]++;
            } else if (names[i].length() == 11) {
                nameCount[10]++;
            }
        }

        for (int k = 1; k <= maxLength; k++) {
            for (i = 0; i < names.length; i++) {
                if (names[i].length() == k) {

                    writeToFile.print(names[i] + " ");
                    for (int j = 0; j < maxLength; j++) {
                        writeToFile.print(nums[i][j] + " ");
                    }
                    writeToFile.println();
                }
            }
        }

        for (int index = 0; index < nameCount.length; index++) {
            System.out.println("Wrote " + nameCount[index] + " of length " + (index + 1));
        }

        System.out.println(LENGTH + " names written to file: ByNameLength.txt");
        System.out.println();

    }

    //Get the index of a name
    public static int getNameIndex(String targetName, String[] array) {
        int indexFoundAt = -1;
        for (int i = 0; i < array.length; i++) {
            if (targetName.equalsIgnoreCase(array[i])) {
                indexFoundAt = i;
            }
        }

        return indexFoundAt;
    }


    //Sort an integer array
    public static void bubbleIntSort(int[] nums) {
        boolean swapped = false;

        do {
            swapped = false;
            for (int i = 0; i < nums.length - 1; i++) {

                if (nums[i] > nums[i + 1]) {
                    swapInt(nums, i, i + 1);
                    swapped = true;
                }
            }
        } while (swapped);
    }


    //Swaps two integer elements in an array
    public static void swapInt(int[] nums, int index0, int indexPlusOne) {
        int temp = nums[index0];

        nums[index0] = nums[indexPlusOne];
        nums[indexPlusOne] = temp;
    }

    //Reads the file and stores the names into a String array and the numbers into a 2d array
    public static void readFile(Scanner file, String[] names, int[][] nums) throws NumberFormatException {

        int nameCount = 0; //gets count of file
        int row = 0;
        int col = 0;
        int index;

        //line parts index
        int numIndex = 1;

        while (file.hasNextLine()) {
            while (nameCount < LENGTH) {

                String line = file.nextLine();

                String[] lineParts = line.split(" ");

                index = 0;
                names[nameCount] = lineParts[index];
                nameCount++;

                while (numIndex < 12 & col < COLUMNS) {
                    //start the numIndex at 1
                    nums[row][col] = Integer.parseInt(lineParts[numIndex]);
                    numIndex++;
                    col++;
                }
                row++;
                col = 0;

                //reset lineparts index
                numIndex = 1;
            }
        }
    }

    //Returns the ranking for a nunber in a given decade
    public static int getRanking(int nameInNumberArr, int decade) {
        return NUMS[nameInNumberArr][decade];
    }

}

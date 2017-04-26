/**
 * This is a test file.
 * TODO:
 * 1) Finish chooseOption method
 * <p>
 * SORT BY RANKS
 * a) Implement a sorting algorithm to list ranking from least to greatest (try using bubble sort)
 * b)
 * <p>
 * <p>
 * Questions: Is using the println() method on PrintStream the correct way to write to a file?
 */

import java.io.*;
import java.util.*;


public class Program4 {

    public static final int LENGTH = 4429;
    public static final String[] NAMES = new String[LENGTH];
    public static final int[][] NUMS = new int[LENGTH][11];
    private static final String FILENAME = "/Users/qmtruong92/CSC110AB/src/names.txt";
    //names array
    private static final String BYNAMESLENGTH = "/Users/qmtruong92/CSC110AB/src/ByNamesLength.txt";
    public static Scanner kb = new Scanner(System.in);


    public static void main(String[] args) throws FileNotFoundException, ArrayIndexOutOfBoundsException, NumberFormatException {
        int option;
        File fr = new File(FILENAME);
        Scanner file = new Scanner(fr);

        readFile(file, NAMES, NUMS);


        topNames();
    }

    /**
     * @param option User selected option
     */

    // Used to choose an option, and then execute one of the five commands.
    public static void chooseOption(int option) throws FileNotFoundException {
        switch (option) {
            case 1:
                getNamesByLength(); // Can't simply call getNamesByLength here, because then it won't know// which names array I am referring to, or where to output the file.
                break;
            case 2:
                namesBetterThanAName();
                break;
//            case 2: sortNamesByLength(numArray, decade, name);
//                break;
            default:
                System.out.println("This is the default");
                break;
        }
    }

    public static void namesBetterThanAName() throws FileNotFoundException {
        System.out.println("Enter a name: ");
        String name = kb.next();
        int decade = chooseDecade();
        kb.close();
        //Get the name
        int nameIndex = getNameIndex(name);
//        String name = NAMES[nameIndex];

        String fileName = "NamesBetterThan" + name + "ForDecade_" + decade + ".txt";

        PrintStream writeToFile = new PrintStream("/Users/qmtruong92/CSC110AB/src/" + fileName);

        System.out.println("The requested name is " + name + " and is at index #" + nameIndex);
        int rankForGivenName = NUMS[nameIndex][decade];
        System.out.println("The rank for " + name + " in " + decade + " is: " + rankForGivenName);
//        System.out.print("Enter a name: ");
//        String name = kb.next();
//        int nameIndex = getNameIndex(NAMES, name);
//
//        for (int i = 0; i < nameIndex; i++) {
//            System.out.println(NAMES[i]);
//        }

        int count[] = new int[NAMES.length];
        for (int i = 0; i < NAMES.length - 1; i++) {
            if (NUMS[i][decade] < 94 && NUMS[i][decade] != 0) {
                count[i]++;
                writeToFile.println(NAMES[i] + " (rank: " + NUMS[i][decade] + ")");
            }
        }


//        for (int j = 0; j < 94; j++) {
//
//            if (count[j] > 0) {
//                System.out.println(NAMES[count[j]]);
//            }
//        }
    }

    public static void topNames() {

        System.out.println("Enter a number for top names: ");
        int topNames = kb.nextInt();
        System.out.println("Enter a decade: ");
        int decade = chooseDecade();


        int count = 0;
        int counter[] = new int[5000];
        int rankingArray[] = new int[5000];

        //Get the indices of elements
        //and rankings
        for (int i = 0; i < NUMS.length - 1; i++) {
            if (NUMS[i][decade] < topNames + 1 && NUMS[i][decade] != 0) {
                System.out.println(NUMS[i][decade]);
                count++;
                System.out.println("The name for the current iteration is: " + NAMES[i]);
                System.out.println("The rank for the current iteration is: " + NUMS[i][decade]);
                System.out.println("Total number of names found better than input: " + count);
//                counter[i] = NUMS[i][decade];
                counter[i] = i;
                rankingArray[i] = NUMS[i][decade];
            }

        }


        bubbleIntSort(counter);
        bubbleIntSort(rankingArray);

        System.out.println("RANK ARRAY: ");
        System.out.println(Arrays.toString(rankingArray));
        int[] indexArray = new int[count];

//        System.out.println("Indices of counter[]: ");
//        for (int number: counter)
//            System.out.println(number);

        int[] filledRankingArray = new int[count];
        //CREATE AN ARRAY WITH THE VALUES THAT WERE FILLED IN COUNTER
        int z = 0;
        while (z < count) {
            for (int index = counter.length - 1; index > 5000 - 1 - count; index--) {
                if (counter[index] != 0) {
                    indexArray[z] = counter[index];
//                    System.out.println(indexArray[z]);
                    filledRankingArray[z] = rankingArray[index];
                    z++;

                }

            }
            //HI DR ZERANGUE
        }


//        for (int number : newArray) {
//            System.out.println(number);
//        }

        //PRINT THE BUBBLE SORTED ARRAY
        //THIS IS USED TO PRINT THE NAMES ONLY
//        System.out.println("Starting the bubble sort array: ");
//        for (int number : indexArray) {
////            System.out.println(getName(number));
//            System.out.println("Index is: " + number +"\n"
//            + "Name is: " + getName(number));
//            System.out.println("Ranking is: " + getRanking(number, decade));
//            System.out.println();
//        }

        //CREATE A NEW ARRAY THAT IS LENGTH OF ALL ELEMENTS THAT ARENT 0
//        bubbleIntSort(filledRankingArray);

        for (int num : filledRankingArray)
            System.out.println(num);

        bubbleIntSort(indexArray);
        boolean swapped = false;
        for (int index : indexArray) {

            do {
                swapped = false;

                //calculate differences
                for (int i = 0; i < filledRankingArray.length - 1; i++) {
                    if (getRanking(indexArray[i], decade) > getRanking(indexArray[i + 1], decade)) {
//                    if (getName(indexArray[i]).charAt(0) > getName(indexArray[i + 1]).charAt(0)) {
                        swapInt(indexArray, i, i + 1);
                        swapped = true;

                    }

                }

            } while (swapped);

//            System.out.println(Arrays.toString(indexArray));
//            System.out.println(getName(index) + " " + getRanking(index, decade));
        }

        for (int each = 0; each < indexArray.length - 1; each++) {
            System.out.println(getName(indexArray[each]) + " (rank: " + getRanking(indexArray[each], decade) + ")");

        }


        System.out.println(Arrays.toString(indexArray));


    }

    public static String getName(int index) {
        return NAMES[index];
    }


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

        int chooseOption = kb.nextInt();

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


    //Returns the names organized length as well as alphabetically
    public static void getNamesByLength() throws FileNotFoundException {

        PrintStream printToByNamesLength = new PrintStream(BYNAMESLENGTH);
        bubbleSort(NAMES);

        for (String name : NAMES) {
            printToByNamesLength.println(name);
        }
    }

    public static int getNameIndex(String targetName) {
        int targetFoundAt = -1;
        for (int i = 0; i < NAMES.length; i++) {
            if (targetName.equalsIgnoreCase(NAMES[i])) {
                targetFoundAt = i;
            }
        }

        return targetFoundAt;
    }


    public static void mergeSort(String[] names) {

        int divArrayInHalf = names.length / 2;
        String[] firstHalf = new String[divArrayInHalf];
        String[] secondHalf = new String[divArrayInHalf];

        for (int i = 0; i < names.length / 2; i++) {
            firstHalf[i] = names[i];
            System.out.println(firstHalf[i]);
        }


    }

    public static void swapy(String[] names, int precedingIndex, int nextIndex) {
        String temp = names[precedingIndex];
        names[precedingIndex] = names[nextIndex];
        names[nextIndex] = temp;

    }

    public static void bubbzSort(String[] arr) {

        boolean swap = false;

        //do while
        do {
            swap = false;

            for (int i = 0; i < arr.length - 1; i++) {

                if (arr[i].length() > arr[i + 1].length()) {
                    swapy(arr, i, i + 1);
                    swap = true;
                }
            }
        } while (swap);
    }

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

    // Mutates the original array
    public static void bubbleSort(String[] arr) {
        boolean swapped = false;
        do {
            swapped = false;
            for (int i = 0; i < arr.length - 1; i += 1) {


                if (arr[i].length() > arr[i + 1].length()) {
                    swap(arr, i, i + 1);
                    swapped = true;
                }

                // or else move to next loop


            }
        } while (swapped);
    }

    // Mutates the original array
    public static void swap(String[] arr, int index0, int index1) {
        String temp = arr[index0];
        arr[index0] = arr[index1];
        arr[index1] = temp;
    }

    public static void swapInt(int[] nums, int index0, int indexPlusOne) {
        int temp = nums[index0];

        nums[index0] = nums[indexPlusOne];
        nums[indexPlusOne] = temp;
    }

    public static void readFile(Scanner file, String[] names, int[][] nums) throws NumberFormatException {

        int nameCount = 0;
        int row = 0;
        int col = 0;
        int index = 0;
        int numIndex = 1;


        while (file.hasNextLine()) {


            while (nameCount < LENGTH) {

                String line = file.nextLine();

                String[] lineParts = line.split(" ");

                //get the first part of the string, everytime
                index = 0;
                names[nameCount] = lineParts[index];
                //but count up the name, so that it stores right
                nameCount++;


                //while there are still parts left in the line.. get number
                // dont exceed number of columns initialized
                while (numIndex < 12 & col < 11) {
                    //start the numIndex at 1
                    nums[row][col] = Integer.parseInt(lineParts[numIndex]);
                    numIndex++;
                    col++;
                }
                row++;
                col = 0;
                numIndex = 1;
            }


        }


    }

    public static void introduction() {
        System.out.println("This program allows you to use a file of names and their popularity ranks  over 11 decades to create new files based on user input:");
        System.out.println("1 - Names by increasing length");
        System.out.println("2 - All names in a chosen decade with better ranks than a chosen name");
        System.out.println("3 - Top N (chosen) names for a chosen decade");
        System.out.println("4 - A file created using programmer-chosen criteria");

        System.out.println();
    }

    public static int getRanking(int nameInNumberArr, int decade) {

        return NUMS[nameInNumberArr][decade];


    }


//    public static int chooseOption(Scanner keyboard) {
//        int choice = 0;
//
//        System.out.println("Choose a way to create the new file:");
//        System.out.println("1 - Have names ordered by increasing in length");
//        System.out.println("2 - Names better than a given name");
//        System.out.println("3 - Top N names for a given decade");
//        System.out.println("4 - <programmer's criteria>");
//        System.out.println("5 - Exit program");
//
//        System.out.print("Enter a number, 1-5: ");
//        keyboard.nextInt();
//
//        switch (chouice) {
//            case 1: namesOrderedIncreasingLength();
//                break;
//            case 2: namesBetterThanAGivenName();
//                break;
//            case 3:
//                break;
//            case 4:
//                break;
//            case 5:
//                break;
//        }
//        return choice;
//    }


    //Displays a 2d array in the console, one line per row.
    static void printMatrix(int[][] grid, String[] names) {


        for (int r = 0; r < grid.length; r++) {
            System.out.print(names[r] + "[" + r + "]" + " ");

            for (int c = 0; c < grid[r].length; c++)
                System.out.print(grid[r][c] + " ");
            System.out.println();
        }
    }


    public static String[] populateNamesArray(String[] oneLongAssArray) {


        //STORE NAMES INTO AN ARRAY
        String[] names = new String[(oneLongAssArray.length / 12)]; //number of names

        int longArrIndex = 0;
        for (int k = 0; k < names.length; k++) {
            names[k] = oneLongAssArray[longArrIndex];
            longArrIndex += 12;
        }

        return names;
    }

    public static int[][] populateYears(String[] oneLongAssArray, int lineCount) {

        int decades = oneLongAssArray.length / 11;
        int[][] nums = new int[lineCount][11];


        int count = 0;
        for (int row = 0; row < lineCount; row++) {

            count = 1 + row;

            if (count % 12 != 0) {
                for (int col = 0; col < oneLongAssArray.length / 11; col++) {
                    if (count < 1236) {
                        nums[row][col] = Integer.parseInt(oneLongAssArray[count]);
                        // count cannot be a multiple of 12

                        //if count is a multiple of 12, increment by 1
//                    System.out.println(nums[row][col]);
                        count += 12;
                    }
                }

            }


        }
        return nums;
    }


    public static int[][] populateYearsModify(String[] oneLongAssArray, int lineCount) throws ArrayIndexOutOfBoundsException {

        int decades = 11;
        int[][] nums = new int[lineCount][decades];


        int count = 1;
        for (int name = 0; name < lineCount; name++) {


            if (count % 12 != 0) {

                for (int decade = 0; decade < decades; decade++) {
                    if (count < 1236) {
                        nums[name][decade] = Integer.parseInt(oneLongAssArray[count]);
                        count++;
                    }
                }
                count++;

            }


        }
        return nums;
    }

//    }


    // VERIFY THAT EACH 12TH MULTIPLE IN ONELONGASSARRAY IS THE CORRECT DATA NEEDED FOR 1900-1910 ARRAY.. THEN UNCOMMENT THE FOLLOWING CODE
//    public static int[][] populateIntArray1900(String[] oneLongAssArray) {
//
//        int[][] yearsAndScore = new int[oneLongAssArray.length/12][12];
//
//        int k = 0;
//
//        for (int i = 1; i < oneLongAssArray.length; i+=12) {
//            yearsAndScore[k][i] = Integer.parseInt(oneLongAssArray[i]);
//            k++;
//        }
//
//        return yearsAndScore;
//
//
//    }


    public static int countLinesInFile(Scanner file) {
        int lineCount = 0;
        while (file.hasNextLine()) {

            //Prints line of data
            String data = file.nextLine();
//            System.out.println(data);

            lineCount++;

            //            parsedData = nextLine.nextLine().split(" ");

            //Tokenize the line
            //            System.out.println(Arrays.toString(parsedData));


        }

        return lineCount;
    }

}

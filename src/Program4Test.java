/**
 * This is a test file.
 * TODO:
 */

import java.io.*;
import java.util.Arrays;
import java.util.*;


public class Program4Test {

    private static final String FILENAME = "/Users/qmtruong92/CSC110AB/names1.txt";

//    PrintStream out = new PrintStream(new FileOutputStream("/Users/qmtruong92/CSC110AB/namesOutput.txt"));
//
//    public Program4Test() throws FileNotFoundException {
//    }

    public static void main(String[] args) throws FileNotFoundException {

        int lineCount;
        //Read in the file
        File fr = new File(FILENAME);

        Scanner fileScan = new Scanner(fr);

        // Count number of Lines in the file
        lineCount = countLinesInFile(fileScan);


        //RESET THE SCANNER
        fileScan.close();
        fileScan = null;
        fileScan = new Scanner(fr);

        //ONE DIMENSIONAL ARRAY FOR ALL THE INTEGER
        String[] oneLongAssArray = new String[lineCount * 12];

        // STORE EVERY ELEMENT INTO ONE ARRAY
        for (int i = 0; i < oneLongAssArray.length; i++) {
            oneLongAssArray[i] = fileScan.next();
        }


        //POPULATE THE NAMES ARRAY -- DONE
        String[] names = populateNamesArray(oneLongAssArray);
//        System.out.println("Names: ");
//        System.out.println(Arrays.toString(names));

        //POPULATE THE INTEGER ARRAY FOR 1900-1910
//        int[][] nums = populateYears(oneLongAssArray, lineCount);

        int[][] nums = populateYearsModify(oneLongAssArray, lineCount);

        printMatrix(nums, names);

        System.out.println("Aleah[89][10] " + nums[89][10]);




//        //Print the ranking for name "A" (row 0) and for 1900-1910 (index 0)
//        System.out.println("nums[0][1] = " + nums[0][0]);
//
//        //Print ranking for name "A" (row 0) and for 1910-1920 (index 2)
//        System.out.println("nums[0][2] = " + nums[0][2]);
//
//        System.out.println("num[1][2] = " + nums[1][2]);
//
//        System.out.println("nums[2][2] = " + nums[2][2]);

    }

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

    public static int[][] populateYears(String[] oneLongAssArray, int lineCount) throws ArrayIndexOutOfBoundsException {

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

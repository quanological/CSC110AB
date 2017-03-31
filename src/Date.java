import java.util.Scanner;

/**
 * This program receives an input from the user and prints a statement to the console if correct, otherwise it will
 * print an error message to the console.
 *
 * Programmer: Quan Truong
 * Assignment: Programming Assignment 2 (Date.java)
 * Date: March 21, 2017
 * Professor: Dr. Zerangue
 * Class: CSC110AB Mon-Fri 12:00-12:50 PM
 */

public class Date {

    final static int JAN = 1;
    final static int FEB = 2;
    final static int MAR = 3;
    final static int APR = 4;
    final static int MAY = 5;
    final static int JUN = 6;
    final static int JUL = 7;
    final static int AUG = 8;
    final static int SEP = 9;
    final static int OCT = 10;
    final static int NOV = 11;
    final static int DEC = 12;


    // Create scanner for the program
    public static Scanner kb = new Scanner(System.in);


    public static void main(String[] args) {
        String date;

        // receive user input
        System.out.print("Enter a date in the three number format, m/d/year: ");
        date = kb.nextLine();

        if (isValid(parseDay(date), parseMonth(date), parseYear(date))) {
            System.out.println(getMonthName(parseMonth(date)) + " " + parseDay(date) + ", " + parseYear(date) + " is a valid date and is day number " + getDayNumber(parseDay(date), parseMonth(date)) + " in " + parseYear(date));

        }


        //TODO PRINT HERE WITH IF STATEMENT
    }

    /**
     * Converts an integer month into an appropriate 3 letter abbreviation for printing
     *
     * @param month Integer. User input month.
     * @return String. Formatted 3 letter abbreviation of corresponding month integer.
     */

    public static String getMonthName(int month) {
        String monthString = null;

        switch (month) {

            //these should be switched to the actual constant names up top, so JAN, FEB, MAR, APR
            case JAN:
                monthString = "Jan";
                break;
            case FEB:
                monthString = "Feb";
                break;
            case MAR:
                monthString = "Mar";
                break;
            case APR:
                monthString = "Apr";
                break;
            case MAY:
                monthString = "May";
                break;
            case JUN:
                monthString = "Jun";
                break;
            case JUL:
                monthString = "Jul";
                break;
            case AUG:
                monthString = "Aug";
                break;
            case SEP:
                monthString = "Sep";
                break;
            case OCT:
                monthString = "Oct";
                break;
            case NOV:
                monthString = "Nov";
                break;
            case DEC:
                monthString = "Dec";
                break;

        }
        return monthString;
    }

    /**
     * Returns the month from user input as Integer data type.
     *
     * @param date String. User input for the date.
     * @return The first numbers before the '/' in the user input.
     */
    public static int parseMonth(String date) {

        String splitMonth = date.substring(0, date.indexOf('/'));
        return Integer.parseInt(splitMonth);
    }

    /**
     * Substrings the day from the date from user input and parses it into an Integer data type.
     *
     * @param date String. User's input for the date.
     * @return Integer. The second substring before the 2nd '/' in the user input as an Integer.
     */
    public static int parseDay(String date) {
        String splitDay = date.substring(date.indexOf('/') + 1, date.indexOf('/', date.indexOf('/') + 1));
        int day = Integer.parseInt(splitDay);
        return day;
    }

    /**
     * Returns the year from user input as Integer data type.
     *
     * @param date String. User input as a String data type.
     * @return Integer. The year input by user.
     */
    public static int parseYear(String date) {
        String parsedYear;
        int divider = date.indexOf('/');
        int subString = date.indexOf('/', divider + 1);
        parsedYear = date.substring(subString + 1);
        return Integer.parseInt(parsedYear);
    }

    /**
     * Checks whether a given year is a leap year, using an algorithm that is derived from Wikipedia.
     *
     * @param year Integer. Year to be checked whether it is a leap year.
     * @return Boolean. True if it is a leap year, false if not a leap year.
     */
    public static boolean isLeapYear(int year) {
        if (year % 4 != 0) {
            return false;
        } else if (year % 400 == 0) {
            return true;
        } else if (year % 100 == 0) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Checks whether the date that the user inputs is valid.
     *
     * @param day   Integer. Day of the month.
     * @param month Integer. Month of the year.
     * @param year  Integer. Year of the century.
     * @return Boolean. True if the date the user inputted is valid, false if invalid.
     */
    public static boolean isValid(int day, int month, int year) {


        int maxDays = maxDays(month);

        boolean monthValid = (month >= JAN) && (DEC >= month);

        boolean yearValid = (1 <= year) && (year <= 3000);


        //if day number is 29, and not a leap year, return false
        if (!isLeapYear(year) && (day == 29) && (month == 2)) {
            System.out.println(
                    "Invalid day number for February for given year.");
        } else if (!yearValid) {
            System.err.println("Invalid year.");
        } else if (!dayValid(day, month, year)) {
            System.err.println("Invalid day number for month.");
        } else if (!monthValid) {
            System.err.println("The month you entered is invald.");
        } else {

            return true;
        }

        return false;
    }

    /**
     * Compute the numerical day.
     *
     * @param day       Integer. The day of the month
     * @param month     Integer. The month of the year.
     * @return Integer. The day number in a given year
     */
    public static int getDayNumber(int day, int month) {
        int dayNumber = 0;
        for (int monthCount = 1; monthCount < month; monthCount++) {
            dayNumber += maxDays(monthCount);
        }

        dayNumber += day;
        return dayNumber;
    }

    /**
     * Convert a month number to the number of days in the given month number.
     * <p>
     * Example: monthNumber = 1 will be converted to 31, since there is 31 days in the month
     * of Janaury.
     *
     * @param userMonth Integer. Month number.
     * @return Integer. Number of days in the given month number
     */
    public static int maxDays(int userMonth) {
        int maxDays;
        switch (userMonth) {
            case 2:
                // max days for february
                maxDays = 28;
                break;
            // max days for april, june, september, and november
            case 4:
            case 6:
            case 9:
            case 11:
                maxDays = 30;
                break;
            // max days for january, march, may, july, august, october, and december
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                maxDays = 31;
                break;
            default:
                maxDays = 0;
                break;
        }

        return maxDays;
    }

    /**
     * Checks whether a day is valid.
     *
     * @param day  Integer. The day from user input.
     * @param year Integer. The user input's year.
     * @return
     */
    public static boolean dayValid(int day, int month, int year) {
        int oneDayForLeapYear = 1;

        if (isLeapYear(year)) {
            return (day >= 1 && day <= (maxDays(month) + oneDayForLeapYear));
        } else {
            return (day >= 1 && day <= maxDays(month));
        }
    }

    public static boolean monthValid(int month) {
        return (month >= JAN) && (DEC >= month);
    }

    public static boolean yearValid(int year) {
        return (1 <= year) && (year <= 3000);
    }
}
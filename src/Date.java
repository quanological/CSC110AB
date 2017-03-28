package src;

import java.util.Scanner;

/**
 * This program parses the user input for the current date and prints the date
 * if it is valid.
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

        // Should the print statements be inside the isValid method or in main?
        System.out.println(isValid(parseDay(date), parseMonth(date), parseYear(date)));
    }

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
     * Returns the day from user input as Integer data type.
     *
     * @param date String. User input for the date.
     * @return The second substring before the 2nd '/' in the user input.
     */
    public static int parseDay(String date) {

        // Substring the day from the user input
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
     * Checks whether a year is a leap year.
     *
     * @param year Integer. Year to be checked whether it is a leap year.
     * @return Boolean. True if it is a leap year, false if not a leap year.
     */
    public static boolean isLeapYear(int year) {
        return ((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0);
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

        boolean dayValid = (day > 0) && (day < maxDays);

        boolean monthValid = (month >= JAN) && (DEC >= month);

        boolean yearValid = (1 <= year) && (year <= 3000);

        // check if the year is leap
        // began with error.. moved on downwards towards the valid test
        if (isLeapYear(year) && (day == 29) && (month == 2)) {
            System.out.println(
                    "The day you have entered is only capable of existing on a leap year. Please insert the " +
                            "correct date. ");
        } else if (!dayValid) {
            System.err.println("The day you have entered for the given month is invalid");
        } else if (!yearValid) {
            System.err.println("The year you entered is invalid. Please enter a year between 1 and 3000. ");
        } else if (!monthValid) {
            System.err.println("The month you entered is invald.");
        } else {
            System.out.println(getMonthName(month) + " " + day + ", " + year + " is a valid date and is day number "
                    + getDayNumber(day, month, year) + " in " + year);
            return true;
        }

        return false;
    }

    /**
     * Compute the day in a given year.
     *
     * @param day       Integer. The day of the month
     * @param userMonth Integer. The month of the year
     * @param year      Integer. The year of the date
     * @return Integer. The day number in a given year
     */
    public static int getDayNumber(int day, int userMonth, int year) {
        int dayNumber = 0;
        for (int month = 1; month < userMonth; month++) {
            dayNumber += maxDays(month);
        }

        dayNumber += day;

        if (isLeapYear(year)) {
            dayNumber += 1;
        }
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
}

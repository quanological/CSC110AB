package src;

import java.util.Scanner;

/**
 * This program parses the user input for the current date and prints the date
 * if it is valid.
 * 
 * Programmer: Quan Truong Assignment: Programming Assignment 2
 *
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

		int month, day, year;
		String date;

		// user input
		System.out.print("Enter a date in the three number format, m/d/year: ");
		date = kb.nextLine();

		System.out.println(isValid(parseDay(date), parseMonth(date), parseYear(date)));

	}

	public static String getMonthName(int month) {
		String monthString = null;

		switch (month) {

		case 1:
			monthString = "Jan";
			break;
		case 2:
			monthString = "Feb";
			break;
		case 3:
			monthString = "Mar";
			break;
		case 4:
			monthString = "Apr";
			break;
		case 5:
			monthString = "May";
			break;
		case 6:
			monthString = "Jun";
			break;
		case 7:
			monthString = "Jul";
			break;
		case 8:
			monthString = "Aug";
			break;
		case 9:
			monthString = "Sep";
			break;
		case 10:
			monthString = "Oct";
			break;
		case 11:
			monthString = "Nov";
			break;
		case 12:
			monthString = "Dec";
			break;

		}

		return monthString;

	}

	/**
	 * Returns the first substring of the user input.
	 * 
	 * @param date
	 *            The user input for the date.
	 * @return The first numbers before the '/' in the user input.
	 */
	public static int parseMonth(String date) {

		String splitMonth = date.substring(0, date.indexOf('/'));
		return Integer.parseInt(splitMonth);
	}

	/**
	 * Returns the second substring of the user input.
	 * 
	 * @param date
	 *            User input for the date.
	 * @return The second substring before the 2nd '/' in the user input.
	 */
	public static int parseDay(String date) {

		// returns parsed day
		String splitDay = date.substring(date.indexOf('/') + 1, date.indexOf('/', date.indexOf('/') + 1));

		int day = Integer.parseInt(splitDay);

		return day;

	}

	/**
	 * Returns the third substring of the user input.
	 * 
	 * @param date
	 *            User input for the date.
	 * @return The third substring before the 3rd '/' in the user input.
	 */
	public static int parseYear(String date) {
		String parsedYear;

		int i = date.indexOf('/');

		int subString = date.indexOf('/', i + 1);

		parsedYear = date.substring(subString + 1);

		return Integer.parseInt(parsedYear);

		/*
		 * String splitYear = date.substring( ( date.indexOf('/' + 1,
		 * date.indexOf('/') + 1 ) ));= return Integer.parseInt(splitYear);
		 * 
		 */
	}

	/**
	 * Checks for leap year
	 * 
	 * @param year
	 * @return
	 */
	public static boolean isLeapYear(int year) {
		return ((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0);
	}

	/**
	 * Checks whether the date is valid.
	 * 
	 * @param day
	 *            Day of the month.
	 * @param month
	 *            Month of the year.
	 * @param year
	 *            Year of the century.
	 * @return
	 */
	public static boolean isValid(int day, int month, int year) {

		// used to check if the day number input is within a valid range
		int maxDays;
		switch (month) {

		// max days for february
		case 2:
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

		boolean dayValid = (day > 0) && (day <= maxDays);

		boolean monthValid = (month >= JAN) && (DEC >= month);

		boolean yearValid = (1 <= year) && (year <= 3000);

		// check if the year is leap
		// began with error.. moved on downwards towards the valid test
		if (isLeapYear(year) && (day == 29) && (month == 2)) {
			System.out.println(
					"The day you have entered is only capable of existing on a leap year. Please insert the correct date. ");
		} else if (!dayValid) {
			System.err.println("The day you have entered for the given month is invalid");
		} else if (!yearValid) {
			System.err.println("The year you entered is invalid. Please enter a year between 1 and 3000. ");
		} else if (!monthValid) {
			System.err.println("The month you entered is invald.");
		} else {
			System.out.println(getMonthName(month) + " " + day + ", " + year + " is a valid date and is day number "
					+ " in " + year);
			return true;
		}

		return false;
	}

	public static int getDayNumber(int day, int month, int year) {

		int dayNumber = 0;

		// count the preceding months before the one given
		// add days
		// if leap year, add 1 to total number of days

		if (!isLeapYear(year)) {
			dayNumber = (JAN + FEB + MAR + APR + MAY + JUN + JUL + AUG + SEP + OCT + NOV + DEC) / day;

		}

		return dayNumber;
	}
}

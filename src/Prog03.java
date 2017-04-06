/**
 * Programmer: Quan Truong
 * Date: April 4th, 2017
 * Class: CSC110AB M-Th 12:00 - 12:50 PM
 * Professor: Dr. Zerangue
 * <p>
 * This program tells a user whether they are eligible for a loan or not.
 */

import java.util.Scanner;

public class Prog03 {

    //ages
    public static final int AGE_EIGHTEEN = 18;
    public static final int AGE_TWENTY_FIVE = 25;
    public static final int AGE_SIXTY_FIVE = 65;

    //salaries
    public static final int FIFTEEN_THOUSAND_DOLLAR_SALARY = 15000;
    public static final int SEVENTY_FIVE_THOUSAND_DOLLAR_SALARY = 75000;
    public static final double RATE = .067;
    public static final int MONTHS_IN_YEAR = 12;
    public static final int MONTH = 84;
    public static final double PRINCIPAL = 12000.00;
    //payment logic
    public static final double PAYMENT = (((RATE / MONTHS_IN_YEAR) * (Math.pow(1 + (RATE / MONTHS_IN_YEAR), MONTH))) /
            (Math.pow(1 + (RATE / MONTHS_IN_YEAR), MONTH) - 1)) * PRINCIPAL;
    public static final int PERCENTAGE_MODIFIER = 100;

    //credit scores
    public static final int CREDIT_SCORE_600 = 600;
    public static final int CREDIT_SCORE_650 = 650;
    public static final int CREDIT_SCORE_750 = 750;
    public static final int CREDIT_SCORE_800 = 800;


    public static Scanner kb = new Scanner(System.in);

    public static void main(String[] args) {

        String stringyName, studentStatus;
        int age, salary, creditScore;

        System.out.println("This is the loan information app.");
        System.out.println("You will be prompted to enter various data and the app");
        System.out.println("Will decide whether you get a loan, and if so");
        System.out.println("how much, how long, and what rate. Your monthly payment will also be shown.");


        do {

            System.out.print("Please enter your first name: ");
            stringyName = kb.next();

            //initial check for quit
            if (stringyName.equalsIgnoreCase("quit")) {
                System.out.println("Thanks for using the loan info app!");
                return;
            }

            age = retrieveAge();

            // age 18 to 25 bracket
            if (age >= AGE_EIGHTEEN && age < AGE_TWENTY_FIVE) {
                System.out.print("Are you a student? (Y or N): ");
                studentStatus = kb.next();
                studentOrNot(studentStatus, stringyName);
            } else if (age >= AGE_TWENTY_FIVE && age <= AGE_SIXTY_FIVE) { //25 to 65 bracket
                salary = retrieveSalary();
                //DONE
                if (salary < FIFTEEN_THOUSAND_DOLLAR_SALARY) {
                    System.out.println(stringyName + ", sorry, but we cannot approve your loan.");
                    System.out.println();
                    System.out.println();
                } else if (salary >= FIFTEEN_THOUSAND_DOLLAR_SALARY && salary < SEVENTY_FIVE_THOUSAND_DOLLAR_SALARY) {
                    creditScore = retrieveCreditScore();
                    if (creditScore < CREDIT_SCORE_750) {
                        System.out.println(stringyName + ", sorry, but we cannot approve your loan.");
                        System.out.println();
                        System.out.println();
                    } else if (creditScore >= CREDIT_SCORE_750) {
                        printSuccessfulApplication(stringyName);
                    }

                } else if (salary >= SEVENTY_FIVE_THOUSAND_DOLLAR_SALARY) {

                    creditScore = retrieveCreditScore();

                    if (creditScore < CREDIT_SCORE_600) {
                        System.out.println(stringyName + ", sorry, but we cannot approve your loan.");
                        System.out.println();
                        System.out.println();
                    } else if (creditScore >= CREDIT_SCORE_600) {
                        printSuccessfulApplication(stringyName);
                    }
                }
            } else if (age > AGE_SIXTY_FIVE) { // over 65 bracket
                creditScore = retrieveCreditScore();

                if (creditScore < CREDIT_SCORE_650) {
                    System.out.println(stringyName + ", sorry, but we cannot approve your loan.");
                    System.out.println();
                    System.out.println();
                } else if (creditScore >= CREDIT_SCORE_650 && creditScore < CREDIT_SCORE_800) {
                    printSuccessfulApplication(stringyName);
                } else {
                    printSuccessfulApplication(stringyName);
                }
            } else {
                age = retrieveAge();
            }

        } while (!stringyName.equalsIgnoreCase("quit"));
        System.out.println();
        System.out.println();
    }

    /**
     * Prints to console that the application is successful.
     *
     * @param name String. Name of the user.
     */
    public static void printSuccessfulApplication(String name) {
        System.out.print(name);
        System.out.printf(", we are happy to approve your loan for $%.2f at a rate of %.2f%%",
                PRINCIPAL, RATE * PERCENTAGE_MODIFIER);
        System.out.println();
        System.out.printf("You will need to make 96 payments of $%.2f each.", PAYMENT);
        System.out.println();
        System.out.println();

    }

    /**
     * Retrieve's the user's credit score.
     *
     * @return Integer. Returns the credit score after it has been validated.
     */
    public static int retrieveCreditScore() {
        int creditScore;
        String stringyCreditScore = "";

        System.out.println("What is your credit score?");


        do {

            do {
                System.out.println("Enter the right credit score ");
                System.out.print("Please enter the right credit score: ");
                stringyCreditScore = kb.next();
            } while (!isAllDigits(stringyCreditScore));
            creditScore = Integer.parseInt(stringyCreditScore);
        } while ((creditScore < 350) || (creditScore > 850));

//        do {
//
//            while (!isAllDigits(stringyCreditScore)) {
//                System.err.print("Enter the right credit score");
//                System.out.println("Please enter the right credit score: ");
//                stringyCreditScore = kb.next();
//            }
//            creditScore = Integer.parseInt(stringyCreditScore);
//        } while (!isAllDigits(stringyCreditScore));

        return creditScore;
    }

    /**
     * Ensures that the user's input for salary is all digits, and within the values
     * 18 and 99.
     *
     * @return boolean. True if the user's input is valid.
     */
    public static int retrieveSalary() {
        int salary;
        String stringySalary = "";

        System.out.println("What is your salary?");


        do {

            do {
                System.out.println("Enter an integer in the range 0 to 100000: ");
                System.out.print("Enter your yearly income in whole dollars: ");
                stringySalary = kb.next();

                if (!isAllDigits(stringySalary)) {
                    System.out.println("Your input must be digits only.");
                }
            } while (!isAllDigits(stringySalary));
            salary = Integer.parseInt(stringySalary);
        } while ((salary < 0) || (salary > 100000));

        return salary;
    }

    /**
     * Checks whether a user is a student or not, and prints to console whether
     * the person is approved for a loan based on their answer.
     *
     * @param studentStatus String. First letter of the user's input.
     * @param name          String. Name of the user.
     */
    public static void studentOrNot(String studentStatus, String name) {
        char studentStatusSingleChar = (char) studentStatus.charAt(0);

        // payment logic
        double rate = .1150;
        double monthsInYear = 12;

        int months = 36;

        double principal = 5000.00;

        int multiplyBy100ToDisplayPercent = 100;

        int intMonths = 36; //try using intMonths after calculating with double months

        double payment = (((rate / monthsInYear) * (Math.pow(1 + (rate / monthsInYear), months))) /
                (Math.pow(1 + (rate / monthsInYear), months) - 1)) * principal;

        do {
            if ((studentStatusSingleChar == 'Y') || (studentStatusSingleChar == 'y')) {
                System.out.printf(name + ", we are happy to approve your" +
                        " loan for $%.2f at a rate of %.2f", principal, rate * multiplyBy100ToDisplayPercent);
                System.out.print("%");
                System.out.println();
                System.out.printf("You will need to make " + months + " payments of $%.2f each.", payment);
                break;
            } else if ((studentStatusSingleChar == 'n') || (studentStatusSingleChar == 'n')) {
                System.out.println(name + ", sorry, but we cannot approve your loan.");
                break;
            } else {
                System.out.print("Enter only ONE character - Are you a student? (Y or N): ");
                studentStatus = kb.next();
            }
        } while ((studentStatus != "Y") || (studentStatus != "N") || (studentStatus != "Y") || (studentStatus != "N"));
    }

    /**
     * Retrieve the age of the user.
     *
     * @return True if the user age is all digits and between the values of 18 and 99, inclusive.
     */
    public static int retrieveAge() {

        int age;
        String stringyAge = "";

        do {

            do {
                System.out.println("Enter an integer in the range 18 to 99: ");
                System.out.print("Enter your age: ");
                stringyAge = kb.next();

                if (!isAllDigits(stringyAge)) {
                    System.out.println("Your input must be digits only.");
                }
            } while (!isAllDigits(stringyAge));
            age = Integer.parseInt(stringyAge);
        } while ((age < 18) || (age > 99));
        return age;
    }

    /**
     * Checks whether every char in a String is a number, and whether it is less than the length 6.
     *
     * @param input
     * @return
     */
    public static boolean isAllDigits(String input) {
        return (input.matches("[0-9]+") && input.length() <= 6);
    }
}
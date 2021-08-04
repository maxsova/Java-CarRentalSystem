/*
 * Console based program that will allow a customer to make a partial booking
 * of a vehicle through a car hire company.
 * Max Sova CSE1OFX Assessment 3
 */
package carrentalsystem;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 * This class manages user selections of the car be hired, and the dates they
 * would like to hire
 *
 * @author Max Sova CSE1OFX Assessment 3
 */
public class CarAndBookingDates {
    //Scanner keyboard = new Scanner(System.in);//Initialyse scanner.

    int year;
    int month;
    int day;
    public int carSelection;

    // Constructor to initialyse instance variables
    public CarAndBookingDates() {
        this.year = 0;
        this.month = 0;
        this.day = 0;
    }

    /**
     * Prompts user for entry of a Car ID number based on the records available.
     *
     * @param carsAvailable
     * @return carSelection
     */
    public int carSelection(int carsAvailable) {
        Scanner keyboard = new Scanner(System.in);//Initialyse scanner.
        String input = "";
        System.out.println("Total " + carsAvailable + " cars available.");
        System.out.println("Select the car number from the car list: ");

        while (!keyboard.hasNextInt()) {//Check if the input is integer.
            input = keyboard.next();
            System.out.printf("\"%s\" is not a valid number.Try again."
                    + "\n", input);//Print error message.
        }
        carSelection = keyboard.nextInt();//Receive scanner input.
        while (carSelection < 1 || carSelection > carsAvailable) {
            System.out.println("Invalid car selection, try again: ");
            carSelection = keyboard.nextInt();//Receive scanner input.   
            // validation loop if input is invalid.
        }

        //System.out.println(carSelection);
        return carSelection;
    }

    /**
     * Method collates the date inputs and returns as a LocalDate format.
     *
     * @return LocalDate localDate
     */
    public LocalDate getCarBookingDateFull() {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("d/M/yyyy");

        LocalDate localDate;

        promptForYear();
        promptForMonth();
        promptForDay();

        String date = day + "/" + month + "/" + year;
        //System.out.println(date);
        localDate = LocalDate.parse(date, dateFormatter);
        //  System.out.println(localDate);

        return localDate;
    }

    /**
     * User prompt for year of date. Input validation.
     *
     * @return year
     */
    public int promptForYear() {
        Scanner keyboard = new Scanner(System.in);//Initialyse scanner.
        String input = "";
        year = -1;
        do {// Start validation loop.
            // Prompt for keyboard input.
            System.out.println("Please enter the year - for example '2021': ");

            while (!keyboard.hasNextInt()) {//Check if the input is integer.
                input = keyboard.next();
                System.out.printf("\"%s\" is not a valid year.Try again."
                        + "\n", input);//Print error message.
            }
            input = keyboard.next();//Receive scanner string input.
            if (validateYear(input)) {//Validating year
                year = Integer.parseInt(input);//If true, convert to integer
            }

            //restart validation loop if input is invalid.
        } while (year == -1);//End of iteration
        return year;
    }

    /**
     * User prompt for month of date.Input validation.
     *
     * @return month
     */
    public int promptForMonth() {
        Scanner keyboard = new Scanner(System.in);//Initialyse scanner.
        String input = "";
        month = -1;
        do {// Start validation loop.
            // Prompt for keyboard input.
            System.out.println("Please enter the month number "
                    + "- for example '6': ");

            while (!keyboard.hasNextInt()) {//Check if the input is integer.
                input = keyboard.next();
                System.out.printf("\"%s\" is not a valid month number."
                        + "Try again." + "\n", input);//Print error message.
            }
            input = keyboard.next();//Receive scanner string input.
            if (validateMonth(input)) {//Validating month
                month = Integer.parseInt(input);//If true, convert to integer
            }

            //restart validation loop if input is invalid.
        } while (month == -1);//End of iteration
        return month;
    }

    /**
     * User prompt for day of date.Input validation.
     *
     * @return day
     */
    public int promptForDay() {
        Scanner keyboard = new Scanner(System.in);//Initialyse scanner.
        String input = "";
        day = -1;
        do {// Start validation loop.
            // Prompt for keyboard input.
            System.out.println("Please enter the day number -"
                    + "for example '21': ");

            while (!keyboard.hasNextInt()) {//Check if the input is integer.
                input = keyboard.next();
                System.out.printf("\"%s\" is not a valid day number."
                        + "Try again." + "\n", input);//Print error message.
            }
            input = keyboard.next();//Receive scanner string input.
            if (validateDay(input)) {//Validating year
                day = Integer.parseInt(input);//If true, convert to integer
            }

            //restart validation loop if input is invalid.
        } while (day == -1);//End of iteration

        return day;
    }

    /**
     * Validates a string containing a year. String is parsed as integer. Method
     * returns True if the integer is within 2020-2029 bracket.
     *
     * @param year String
     */
    private boolean validateYear(String year) {
        boolean isValid = false;
        int testValue = Integer.parseInt(year);
        if (testValue > 2019 && testValue < 2030) {
            isValid = true;
        }

        return isValid;
    }

    /**
     * Validates a string containing a month. String is parsed as integer.
     * Method returns True if the integer is within 1-12 bracket.
     *
     * @param month String
     */
    private boolean validateMonth(String month) {
        boolean isValid = false;
        int testValue = Integer.parseInt(month);
        if (testValue > 0 && testValue < 13) {
            isValid = true;

        }
        return isValid;
    }

    /**
     * Validates a string containing a day number. String is parsed as integer.
     * Max date is calculated based on currently selected month number and year.
     * Method returns True if the integer is within 1-28/29/30/31 bracket.
     *
     * @param day String
     */
    private boolean validateDay(String day) {
        boolean isValid = false;
        int numberOfDays;
        int testValue = Integer.parseInt(day);
        switch (month) {//Determine max day number.
            case 1:
            case 3:
            case 5:
            case 7:
            case 9:
            case 10:
            case 12:
                numberOfDays = 31;
                break;
            case 2:
                if (year % 4 == 0) {//Checking for leap year.
                    numberOfDays = 29;
                } else {
                    numberOfDays = 28;
                }
                break;
            default:
                numberOfDays = 30;
                break;
        }

        if (testValue > 0 && testValue < (numberOfDays + 1)) {
            isValid = true;

        }
        return isValid;
    }
}

/*
 * Console based program that will allow a customer to make a partial booking
 * of a vehicle through a car hire company.
 * Max Sova CSE1OFX Assessment 3
 */
package carrentalsystem;

import java.time.LocalDate;
import java.util.Scanner;

/**
 * This is the overall entry point for the program with the following functions:
 * Controlling access to the main menu, customer details and car booking info.
 * Main method invokes methods stored in other classes and captures key values.
 * Key values are passed as parameters to other instantiated objects.
 *
 * @author Max Sova CSE1OFX Assessment 3
 */
public class CarRentalTester {

    private MenuDisplay menu;
    private Customer customer;
    private CarBooking carBooking;
    private CarAndBookingDates carAndBookingDates;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //Declare local variables
        String customerName;
        String customerEmail;
        String customerAddress;

        //Print list of cars
        MenuDisplay menu = new MenuDisplay();

        //Calculate number of cars in the list
        int carsAvailable = menu.displayCarList();

        //Present user with choice of either makig a booking (1) or exiting (2)
        int option = menu.getSelection();

        //Start booking iteration
        do {
            if (option == 1) {//evaluate if user chooses to make boking

                //Receive and format start of hire date
                CarAndBookingDates cb1 = new CarAndBookingDates();
                //Receive and save selected car number
                int carSelection = cb1.carSelection(carsAvailable);
                System.out.print("\n\tEnter booking start date.\n");

                LocalDate startDate = cb1.getCarBookingDateFull();
                LocalDate endDate;//Declare endDate for validation

                do {//Enter hire end date, iterate if invalid
                    //Receive and format end of hire date
                    CarAndBookingDates cb2 = new CarAndBookingDates();
                    System.out.println("\n\tEnter booking end date.");
                    endDate = cb2.getCarBookingDateFull();

                    //Check if end date is greater than start date
                    if (endDate.compareTo(startDate) < 1) {//invalid option
                        System.out.println("End date is not greater than start"
                                + " day! Please re-enter.");
                    }

                } while (endDate.compareTo(startDate) < 1);//End of validation

                Scanner keyboard = new Scanner(System.in);//Initialyse scanner

                //Receive customer detais as local variabes    
                System.out.print("\n\tYour name: ");
                customerName = keyboard.nextLine();

                System.out.print("\tYour email: ");
                customerEmail = keyboard.nextLine();

                System.out.print("\tYour residential address: ");
                customerAddress = keyboard.nextLine();

                //Pass customer details as parameters to Customer
                Customer cm = new Customer(customerName, customerEmail,
                        customerAddress);

                //Pass dates and car number as parameters to CarBooking
                CarBooking carBooking = new CarBooking(startDate,
                        endDate, carSelection);

                PrintBookingDetails printSummary = new PrintBookingDetails();
                printSummary.printBookingDetails(carBooking, cm);

                //Present user an option of booking or exiting
                option = menu.getSelection();
            } else {//exit booking if user selects 2

                break;
            }
        } while (!(option == 2));//Exit bookng iteration when option 2 selected
        //Exit the system.
        System.exit(0);

    }

}

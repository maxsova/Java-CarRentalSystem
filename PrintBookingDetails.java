/*
 * Console based program that will allow a customer to make a partial booking
 * of a vehicle through a car hire company.
 * Max Sova CSE1OFX Assessment 3
 */
package carrentalsystem;

/**
 * This class displays details of a finalized booking to the user.
 *
 * @author Max Sova CSE1OFX Assessment 3
 */
public class PrintBookingDetails {

    //PrintBookingDetails constructor
    public void printBookingDetails(CarBooking carBooking, Customer customer) {

        //Access Car information
        Car car = carBooking.getCar();

        //Print summary
        for (int i = 0; i < 90; i++) {
            System.out.print("-");
        }
        System.out.println("\n\tThanks for your booking "
                + customer.getCustomerName());
        System.out.println("\tEmail                          "
                + customer.getCustomerEmail());
        System.out.println("\tAddress:                       "
                + customer.getCustomerAddress());

        System.out.print("\t................................................");

        System.out.println("\n\n\tBooking confirmed\n");
        System.out.println("\tHere is your booking summary");

        System.out.print("\t................................................");

        System.out.println("\n\tCar selected                   "
                + car.getCarType());
        System.out.println("\tStartDate:                     "
                + carBooking.getStartDate());
        System.out.println("\tEnd Date:                      "
                + carBooking.getEndDate());
        System.out.println("\tNumber of days booked:         "
                + carBooking.getTotalDays());
        System.out.println("\tCar rate per day:              "
                + carBooking.getNewRate());

        System.out.print("\t________________________________________________");

        System.out.println("\n\tTotal cost                     "
                + carBooking.getCost());

        for (int i = 0; i < 90; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

}

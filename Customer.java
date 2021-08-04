/*
 * Console based program that will allow a customer to make a partial booking
 * of a vehicle through a car hire company.
 * Max Sova CSE1OFX Assessment 3
 */
package carrentalsystem;

/**
 * This class manages the details of the customer looking to hire a car.
 *
 * @author Max Sova CSE1OFX Assessment 3
 */
public class Customer {

    //Instance variables
    private String customerName;
    private String customerEmail;
    private String customerAddress;

    //Customer constructor
    public Customer(String customerName, String customerEmail,
            String customerAddress) {
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.customerAddress = customerAddress;
    }

    //Accessor methods:
    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }
}
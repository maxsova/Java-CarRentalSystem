/*
 * Console based program that will allow a customer to make a partial booking
 * of a vehicle through a car hire company.
 * Max Sova CSE1OFX Assessment 3
 */
package carrentalsystem;

/**
 * This class holds information related to individual cars for hire.
 *
 * @author Max Sova CSE1OFX Assessment 3
 */
public class Car {

    //Instance variables
    protected double carRate;//Base cost of hiring
    protected String carName;//Type of car
    protected String carType;//Model of the car, introduced for integrity of Car

    //Car constructor
    public Car(double carRate, String carName, String carType) {
        this.carRate = carRate;
        this.carName = carName;
        this.carType = carType;
    }

    //Accessor methods
    public double getCarRate() {
        return carRate;
    }

    public String getCarName() {
        return carName;
    }

    public String getCarType() {
        return carType;
    }

}
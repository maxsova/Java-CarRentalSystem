/*
 * Console based program that will allow a customer to make a partial booking
 * of a vehicle through a car hire company.
 * Max Sova CSE1OFX Assessment 3
 */
package carrentalsystem;

import java.time.LocalDate;
import java.io.BufferedReader;
import java.io.FileReader;
import static java.time.temporal.ChronoUnit.DAYS;
import java.util.ArrayList;

/**
 * This class does all the work of calculating duration and cost of the hire of
 * a car.
 *
 * @author Max Sova CSE1OFX Assessment 3
 */
public class CarBooking {

    //Declare instance variables.
    private LocalDate startDate;//formatted start of hire date
    private LocalDate endDate;//formatted end of hire date
    private int carNumber;//identification number of car selected by user
    private long totalDays;//total days of hire
    private double newRate;//updated numerical value of hire rate
    private double cost;//calculated total cost of hire
    private Car car;//instance of Car
    private String carType;//Model of the car, introduced for integrity of Car

    //Declare input file name as constant.
    private static final String CARLIST = "CarList.csv";

    //Initialyze variables
    public CarBooking(LocalDate startDate, LocalDate endDate, int carNumber) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.carNumber = carNumber - 1;

        makeBooking();//call method below
    }

    /**
     * The method reads the CSV file, implement them with the try/catch
     * mechanism and print an error message and exit when caught. Car number
     * selected would be required to retrieve the details and store them in an
     * array.
     */
    public void makeBooking() {

        //Link to CarList.csv 
        String carList = MenuDisplay.getCARLIST();

        //Instantiate file reader
        ArrayList<String[]> carRecord = new ArrayList<String[]>();

        try (BufferedReader br = new BufferedReader(new FileReader(carList))) {
            String line;
            //Iterate through car list
            while ((line = br.readLine()) != null) {
                //Add car records to array 
                String[] values = line.split(",");
                carRecord.add(values);
            }
            br.close();
        } catch (Exception e) {//try/catch file not found exception
            System.out.println("Source file cannot be opened.");
            System.exit(2);//exiting if file not found

        }

        //Assign values from array carRecord to corresponding variables
        this.carType = carRecord.get(carNumber)[1];
        String carName = carRecord.get(carNumber)[4];
        String baseRate = carRecord.get(carNumber)[5];

        //Parse car hire rate string as double
        this.newRate = Double.parseDouble(baseRate);

        //Conditionally allocate hire rate from either Car or PremiumCar 
        if (carName.equals("Premium")) {//rate from PremiumCar
            this.car = new PremiumCar(this.newRate, carName, carType);
        } else {//rate from Car
            this.car = new Car(this.newRate, carName, carType);
        }

        //Update car information
        this.newRate = car.getCarRate();
        this.carType = car.getCarType();

        //Call methods below
        calculateTotalDays();
        calculateCost(this.newRate, totalDays);

    }

    /**
     * Calculates the difference in days between the start date and the end date
     *
     */
    public void calculateTotalDays() {
        // Allocate value to totalDays
        this.totalDays = DAYS.between(startDate, endDate)+1;
    }

    /**
     * Sets the cost of a booking based on the rate by the number of days
     *
     */
    public void calculateCost(double newRate, long totalDays) {
        //Allocate calculated value to cost
        this.cost = newRate * totalDays;
    }

    //Accessor methods
    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public int getCarNumber() {
        return carNumber;
    }

    public long getTotalDays() {
        return totalDays;
    }

    public double getNewRate() {
        return newRate;
    }

    public double getCost() {
        return cost;
    }

    public String getCarType() {
        return carType;
    }

    public Car getCar() {
        return car;
    }

}
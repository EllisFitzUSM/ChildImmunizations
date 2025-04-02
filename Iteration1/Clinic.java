/*
 * Clinic.java
 * @author: Abdirahman Mohamed
 * @version: April 1, 2025
 * Basic Clinic class that has little functionality at this point.
 * This class will be used to manage the clinic's operations..
 */

public class Clinic {
    // -------------------------------
    // Fields for storing clinic details
    // -------------------------------
    private String name;                // The name of the clinic
    private String address;             // The physical address of the clinic
    private int numberOfDoctors;        // The number of doctors working at the clinic

    // -------------------------------
    // Constructors
    // -------------------------------

    /**
     * Default constructor.
     * Initializes the clinic with default values.
     */
    public Clinic() {
        this.name = "Default Clinic";        // Set a default name for the clinic
        this.address = "Unknown Address";     // Set a default address
        this.numberOfDoctors = 0;             // Default number of doctors is 0
    }

    /**
     * Parameterized constructor.
     * Initializes the clinic with the provided name, address, and number of doctors.
     *
     * @param name             The name of the clinic.
     * @param address          The address of the clinic.
     * @param numberOfDoctors  The number of doctors working at the clinic.
     */
    public Clinic(String name, String address, int numberOfDoctors) {
        this.name = name;
        this.address = address;
        this.numberOfDoctors = numberOfDoctors;
    }

    // -------------------------------
    // Getter and Setter Methods
    // -------------------------------

    /**
     * Gets the clinic's name.
     *
     * @return The name of the clinic.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the clinic's name.
     *
     * @param name The new name of the clinic.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the clinic's address.
     *
     * @return The address of the clinic.
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the clinic's address.
     *
     * @param address The new address of the clinic.
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Gets the number of doctors at the clinic.
     *
     * @return The number of doctors.
     */
    public int getNumberOfDoctors() {
        return numberOfDoctors;
    }

    /**
     * Sets the number of doctors at the clinic.
     *
     * @param numberOfDoctors The new number of doctors.
     */
    public void setNumberOfDoctors(int numberOfDoctors) {
        this.numberOfDoctors = numberOfDoctors;
    }

    // -------------------------------
    // Overridden Methods
    // -------------------------------

    /**
     * Provides a string representation of the Clinic object.
     * This method helps in printing and logging the details of the clinic.
     *
     * @return A formatted string with clinic details.
     */
    @Override
    public String toString() {
        return "Clinic [Name: " + name 
                + ", Address: " + address 
                + ", Number of Doctors: " + numberOfDoctors + "]";
    }

    // -------------------------------
    // Main Method for Testing
    // -------------------------------

    /**
     * Main method to test the basic functionality of the Clinic class.
     * Demonstrates creating a Clinic instance and printing its details.
     *
     * @param args Command line arguments (not used here).
     */
    public static void main(String[] args) {
        // Create a Clinic instance using the parameterized constructor
        Clinic clinic = new Clinic("City Clinic", "123 Main Street", 5);
        
        // Print out the clinic details using the overridden toString method
        System.out.println(clinic);
    }
}

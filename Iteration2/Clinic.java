/**
* Clinic.java
* Basic Clinic class that has little functionality at this point.
* This class will be used to manage the clinic's operations.
*
* @author Abdirahman Mohamed
* April 1, 2025
*/

import java.util.ArrayList;

public class Clinic {
    private String name;                // The name of the clinic
    private String address;             // The physical address of the clinic
    private ArrayList<Vaccine> immunizations = new ArrayList<>();  // List to store immunization records (NEED TO CHANGE TO A VISIT CLASS EVENTUALLY)
    private ArrayList<Patient> patients = new ArrayList<>();       // List to store patient records

    /**
    * Default constructor.
    * Initializes the clinic with default values.
    */
    public Clinic() {
        this.name = "Default Clinic";        // Set a default name for the clinic
        this.address = "Unknown Address";     // Set a default address
    }

    /**
    * Parameterized constructor.
    * Initializes the clinic with the provided name and address.
    *
    * @param name The name of the clinic.
    * @param address The address of the clinic.
    */
    public Clinic(String name, String address) {
        this.name = name;
        this.address = address;
        this.immunizations = new ArrayList<>();
        this.patients = new ArrayList<>();
    }

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
    * Adds a patient to the list.
    *
    * @param patient The patient to be added.
    * @return true when completed.
    */
    public boolean addPatient(Patient patient){
        this.patients.add(patient);
        return true;
    }

    /**
    * Provides a string representation of the Clinic object.
    * This method helps in printing and logging the details of the clinic.
    *
    * @return A formatted string with clinic details.
    */
    @Override
    public String toString() {
        return "Clinic [Name: " + name 
                + ", Address: " + address + "]";
    }

    /**
    * Records a new immunization in the clinic.
    *
    * @param immunization The Immunization record to add.
    */
    public void recordImmunization(Vaccine immunization) { // NEEDS TO BE VISIT
        immunizations.add(immunization);
    }

    /**
    * Returns a report of all immunizations recorded in the clinic.
    * The report is a formatted string listing each immunization record.
    *
    * @return A string report of immunizations.
    */
    public String getReport() {
        StringBuilder report = new StringBuilder();
        report.append("Clinic Immunization Report for ").append(name).append(":\n");
    
        if (immunizations.isEmpty()) {
            report.append("No immunizations recorded.\n");
        } else {
            for (Vaccine imm : immunizations) {
                report.append(imm.toString()).append("\n");
            }
        }
        return report.toString();
    }

    /**
    * Main method to test the basic functionality of the Clinic class.
    * Demonstrates creating a Clinic instance and printing its details.
    *
    * @param args Command line arguments (not used here).
    */
    public static void main(String[] args) {
        // Create a Clinic instance using the parameterized constructor
        Clinic clinic = new Clinic("City Clinic", "123 Main Street");
        
        // Print out the clinic details using the overridden toString method
        System.out.println(clinic);
    }
}

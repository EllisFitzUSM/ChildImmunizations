/*
 * Vaccine.java
 * Represents a simple vaccine class with basic attributes and methods.
 * This class will be used to hold data for each vaccine.
 *
 * @author Milo Keys
 * April 14, 2025
 */

import java.util.ArrayList;

public class Vaccine {
    int ID;
    String name;
    String brand;
    int dosage;
    int numOfDosage;
    int Interval; //in days
    int MinAge;
    String adminMode;
    String adminLocation;
    ArrayList<String> diseasesTreated;

    /**
     * Constructs a Vaccine instance.
     *
     * @param ID the ID for the Vaccine
     * @param name name of the Vaccine
     * @param brand brand of the Vaccine
     * @param dosage the dosage amount
     * @param numOfDosage the number of dosages
     * @param Interval the interval between Vaccinations (in days)
     * @param MinAge the minimum age that the Vaccine can be administered
     * @param adminMode how is the Vaccine injected
     * @param adminLocation where the Vaccine is injected
     * @param diseasesTreated what diseases does the Vaccine treat
     */
    public Vaccine(int ID, String name, String brand, int dosage, int numOfDosage, int Interval,
                   int MinAge, String adminMode, String adminLocation, ArrayList<String> diseasesTreated) {
        this.ID = ID;
        this.name = name;
        this.brand = brand;
        this.dosage = dosage;
        this.numOfDosage = numOfDosage;
        this.Interval = Interval;
        this.MinAge = MinAge;
        this.adminMode = adminMode;
        this.adminLocation = adminLocation;
        this.diseasesTreated = diseasesTreated;
    }
}

/*
 * Vaccine.java
 * @author:Milo Keys
 * @version:
 * Represents a simple vaccine class with basic attributes and methods.
 * This class will be used to hold data for each vaccine.
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
     * 
     * @param ID the ID for Vaccine
     * @param name name of Vaccine
     * @param brand brand of Vaccine
     * @param dosage dosage amount
     * @param numOfDosage how many dosage
     * @param Interval the interval between Vaccinations
     * @param MinAge the minuman age that the Vaccine can be administrated
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
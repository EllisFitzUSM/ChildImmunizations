import java.util.ArrayList;

/**
 * Vaccine class extending Dosable
 *
 * @author Milo Keys & Ellis Fitzgerald
 * @version April 17th, 2025
 */
public class Vaccine extends Dosable {
    int ID;
    String name;
    String brand;
    int dosageML;
    int numOfDosage;
    int Interval; //in days
    int MinAge;
    String adminMode;
    String adminLocation;
    ArrayList<String> diseasesTreated;

    /**
     * Constructs a vaccine
     *
     * @param ID the ID for Vaccine
     * @param name name of Vaccine
     * @param brand brand of Vaccine
     * @param dosageML dosage amount in milliliters
     * @param numOfDosage how many dosage
     * @param Interval the interval between Vaccinations
     * @param MinAge the minuman age that the Vaccine can be administrated
     * @param adminMode how is the Vaccine injected
     * @param adminLocation where the Vaccine is injected
     * @param diseasesTreated what diseases does the Vaccine treat
     */
    public Vaccine(int ID, String name, String brand, int dosageML, int numOfDosage, int Interval,
                   int MinAge, String adminMode, String adminLocation, ArrayList<String> diseasesTreated) {
        this.ID = ID;
        this.name = name;
        this.brand = brand;
        this.dosageML = dosageML;
        this.numOfDosage = numOfDosage;
        this.Interval = Interval;
        this.MinAge = MinAge;
        this.adminMode = adminMode;
        this.adminLocation = adminLocation;
        this.diseasesTreated = diseasesTreated;
    }

    /**
     * Gets the vaccines dosage in milliliters.
     *
     * @return Dosage in Milliliters.
     */
    public int getDosageML() {
        return dosageML;
    }
}
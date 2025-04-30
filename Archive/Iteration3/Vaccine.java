import java.util.ArrayList;

/**
 * Vaccine class extending Dosable
 *
 * @author Milo Keys, Ellis Fitzgerald, & Gabrielle Akers
 * @version April 25, 2025
 */
public class Vaccine extends Dosable {
    int ID;
    String name;
    String brand;
    double dosageML;
    int numOfDosage;
    int interval; //in days
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
    public Vaccine(int ID, String name, String brand, double dosageML, int numOfDosage, int Interval,
                   int MinAge, String adminMode, String adminLocation, ArrayList<String> diseasesTreated, double minWeightKG) {
        this.ID = ID;
        this.name = name;
        this.brand = brand;
        this.dosageML = dosageML;
        this.numOfDosage = numOfDosage;
        this.interval = Interval;
        super.minAge = MinAge;
        this.adminMode = adminMode;
        this.adminLocation = adminLocation;
        this.diseasesTreated = diseasesTreated;
        this.minWeightKG = minWeightKG;
    }

    /**
     * Gets the vaccines dosage in milliliters.
     *
     * @return Dosage in Milliliters.
     */
    public double getDosageML() {
        return dosageML;
    }

    /**
    *Gets the number of doses
    *
    *@return numOfDosage
    */
    public int getNumOfDosage(){
        return numOfDosage;
    }

    /**
    *Gets interval between vaccines
    *
    *@return length of time there should be between vaccines
    */
    public int getInterval(){
        return interval;
    }

    /**
    *Gets the vaccine ID
    *
    *@return ID
    */
    public int getID(){
        return ID;
    }

    /**
    *Gets the vaccine name
    *
    *@return name
    */
    public String getName(){
        return name;
    }

    /**
    *Gets the vaccine brand
    *
    *@return brand
    */
    public String getBrand(){
        return brand;
    }
  
    /**
    *Gets the list of diseases that the vaccine treats
    *
    *@return diseasesTreated
    */
    public ArrayList<String> getDiseasesTreated(){
        return diseasesTreated;
    }

    /**
     * Returns a comprehensive string representation of the Vaccine object,
     * including both vaccine-specific information and relevant dosage information
     * from the parent Dosable class.
     * 
     * @return a string representation of the Vaccine object
     */
    @Override
    public String toString() {
        return "Vaccine{" +
            "ID=" + ID +
            ", name='" + name + '\'' +
            ", brand='" + brand + '\'' +
            ", dosageML=" + dosageML +
            ", numOfDosage=" + numOfDosage +
            ", interval=" + interval +
            ", " + super.toString() + // Includes Dosable information
            ", adminMode='" + adminMode + '\'' +
            ", adminLocation='" + adminLocation + '\'' +
            ", diseasesTreated=" + diseasesTreated +
            '}';
    }
}

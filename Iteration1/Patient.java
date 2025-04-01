/**
 * Patient Class for Immunizations
 * @author Ellis Fitzgerald
 * @version March 31st, 2025
 */
public class Patient {
    private String ID;
    private String name;
    private LocalDate dateOfBirth;
    private double weightKG;
    private String address;
    private String mothersName;

    /**
     * Constructs a Patient Instance
     * @param ID The unique and ideally universal identifier for this patient.
     * @param name The name this patient goes by
     * @param dateOfBirth The date this patient was born.
     * @param address The address this patient resides
     * @param mothersName The name of this patients mother
     */
    public Patient(String ID, String name, Date dateOfBirth, String address, String mothersName) {
        this.ID = ID;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.mothersName = mothersName;
    }

    /**
     * Get the patients weight
     * @return Weight in kilograms
     */
    public double getWeightKG() {
        return weightKG;
    }

    /**
     * Changes the weight for the patient
     * @param weightKG The amount of weight in kilograms to set the patient to.
     */
    public void setWeightKG(double weightKG) {
        this.weightKG = weightKG;
    }

    /**
     * Get the patients unique and ideally universal identifer
     * @return The String representing their ID
     */
    public String getID() {
        return ID;
    }

    /**
     * Get the patients name
     * @return The String representing their name
     */
    public String getName() {
        return name;
    }
}
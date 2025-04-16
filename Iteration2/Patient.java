/**
 * Patient.java
 * Patient Class for Immunizations
 *
 * @author Ellis Fitzgerald
 * March 31st, 2025
 */

import java.time.LocalDate;

public class Patient {
    private String ID;
    private String name;
    private LocalDate dateOfBirth;
    private double weightKG;
    private String address;
    private String mothersName;

    /**
     * Constructs a Patient Instance
     *
     * @param ID The unique and ideally universal identifier for this patient.
     * @param name The name this patient goes by
     * @param dateOfBirth The date this patient was born.
     * @param address The address this patient resides at
     * @param mothersName The name of this patient's mother
     */
    public Patient(String ID, String name, LocalDate dateOfBirth, String address, String mothersName) {
        this.ID = ID;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.mothersName = mothersName;
    }

    /**
     * Get the patient's weight
     *
     * @return Weight in kilograms
     */
    public double getWeightKG() {
        return weightKG;
    }

    /**
     * Sets the weight for the patient
     *
     * @param weightKG The amount of weight in kilograms to set the patient to.
     */
    public void setWeightKG(double weightKG) {
        this.weightKG = weightKG;
    }

    /**
     * Get the patient's unique and ideally universal identifier
     *
     * @return The String representing their ID
     */
    public String getID() {
        return ID;
    }

    /**
     * Get the patient's name
     *
     * @return The String representing their name
     */
    public String getName() {
        return name;
    }

    /**
     * Get the patient's DOB (Date of Birth)
     *
     * @return Java LocalDate
     */
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Get the patient's address
     *
     * @return String representing address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Get the patient's mother's name
     *
     * @return String representing the mother's name
     */
    public String getMothersName() {
        return mothersName;
    }
}

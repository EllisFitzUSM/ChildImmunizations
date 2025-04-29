import java.util.Date;
import java.util.List;

/**
 * ImmunizationPatient.java
 * Adds a weight data member to keep track of the patients weight in order to allow dosables.
 * ! Subject to change.
 *
 * @author Ellis Fitzgerald
 * @version April 17th, 2025
 */
public class ImmunizationPatient extends Patient {
    private double weightKG;

    /**
     * Creates an Immunization Patient
     *
     * @param patientId                     Patient ID
     * @param dateOfBirth                   DOB of Patient
     * @param name                          Name of Patient
     * @param outPatientNumber              Patient out Number
     * @param healthInsuranceNumber         Health Insurance Number
     * @param nationalIdentificationNumber  National ID
     * @param address                       Patient Residential address
     * @param sex                           Sex of patient
     * @param age                           Age of patient
     * @param motherId                      Patient mother ID
     * @param records                       Medical records
     * @param weightKG                      Patient most recent weight in kilograms
     */
    ImmunizationPatient(String patientId, Date dateOfBirth, String name, String outPatientNumber,
                        String healthInsuranceNumber, String nationalIdentificationNumber,
                        String address, String sex, int age, String motherId, List<Record> records, double weightKG) {
        super(patientId, dateOfBirth, name, outPatientNumber,
                healthInsuranceNumber, nationalIdentificationNumber,
                address, sex, age, motherId, records);
        this.weightKG = weightKG;
    }

    /**
     * Gets the weight of the patient
     *
     * @return Weight of patient in kilograms
     */
    public double getWeightKG() {
        return weightKG;
    }

    /**
     * Sets the weight of the patient in kilograms
     *
     * @param weightKG The amount of weight in kilograms to set the patient to.
     */
    public void setWeightKG(double weightKG) {
        this.weightKG = weightKG;
    }
}

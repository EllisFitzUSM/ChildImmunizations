import java.util.Date;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

/**
 * ImmunizationPatient.java
 * Adds a weight data member to keep track of the patients weight and number of doses they have received
 * ! Subject to change.
 *
 * @author Ellis Fitzgerald & Gabrielle Akers
 * @version April 25, 2025
 */
public class ImmunizationPatient extends Patient {
    private double weightKG;
    private Map <Vaccine, Integer> vaccineDoses = new HashMap<>();

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
    
    /**
     * Gets the number of doses a patient has received
     *
     * @return doseNum
     */
    public int getDoseNum(Vaccine vaccine) {
    	return vaccineDoses.get(vaccine);
    }
    
    /**
     * Adds vaccine and corresponding dose number to hash map
     *
     *@param vaccine		name of the vaccine
     *@param doseNum		number of doses patient has had of vaccine
     */
    public void addVaccineDoses(Vaccine vaccine) {
    	//initialize vaccine in list with dose number of 0
    	if(!vaccineDoses.containsKey(vaccine)) {
    		vaccineDoses.put(vaccine, 0);
    	}
    	else {
    		vaccineDoses.put(vaccine, getDoseNum(vaccine) + 1);
    	}
    }
}
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

/**
 * Visit.java
 * Visit class used by clinics when a patient comes in for a service.
 *
 * @author Ellis Fitzgerald & Gabrielle Akers
 * @version April 25, 2025
 */
public class Visit extends Dosable{
    private ImmunizationPatient patient;
    private LocalDate visitDate;
    private ArrayList<Vaccine> dosesAdministered;
    private Map<Vaccine, Integer> vaccineDoses = patient.getVaccineDoses();
    
    /**
     * Adds vaccine doses to the patient if the vaccine is eligible to be administered.
     * Iterates through the available vaccine doses, checks if each vaccine can be
     * given to the patient using {@code isDosable}, and if so, adds the dose to the patient
     * and records it in the dosesAdministered
     */
    public void addDoses() {  	
    	for(Vaccine vaccine : vaccineDoses.keySet()) {
    		if(isDosable(patient, vaccine)) {
    			patient.addVaccineDoses(vaccine);
    			dosesAdministered.add(vaccine);
    		}
    	}
    }
    
    /**
     * Returns the list of vaccine doses that have been administered to the patient.
     *
     * @return an ArrayList of Vaccine objects that have been administered
     */
    public ArrayList<Vaccine> getDosesAdministered(){
    	return dosesAdministered;
    }
}
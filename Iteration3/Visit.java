import java.util.Map;
import java.util.ArrayList;
import java.util.Date;

/**
 * Visit.java
 * Visit class used by clinics when a patient comes in for a service.
 *
 * @author Ellis Fitzgerald & Gabrielle Akers
 * @version April 25, 2025
 */
public class Visit extends Dosable{
    private ImmunizationPatient patient;
    private Date visitDate;
    private ArrayList<Vaccine> dosesAdministered;
    private Map<Vaccine, Integer> vaccineDoses; //this seems like a memory leak waiting to happen
    private String remarks;
    
    /**
     * Constructs a Visit instance with the specified patient and visit date.
     * Initializes the dosesAdministered list and sets the vaccineDoses from the patient.
     *
     * @param patient the ImmunizationPatient associated with this visit
     * @param visitDate the date of the visit
     */
    public Visit(ImmunizationPatient patient, Date visitDate) {
        this.patient = patient;
        this.visitDate = visitDate;
        this.dosesAdministered = new ArrayList<>();
        this.vaccineDoses = patient.getVaccineDoses();
    }
        /**
     * Constructs a Visit instance with the specified patient and visit date.
     * Initializes the dosesAdministered list and sets the vaccineDoses from the patient.
     *
     * @param patient the ImmunizationPatient associated with this visit
     * @param visitDate the date of the visit
     * @param remarks the remarks about a patient
     */
    public Visit(ImmunizationPatient patient, Date visitDate, String remarks) {
        this.patient = patient;
        this.visitDate = visitDate;
        this.dosesAdministered = new ArrayList<>();
        this.vaccineDoses = patient.getVaccineDoses();
        this.remarks = remarks;
    }


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
     * Adds vaccine doses to the patient if the vaccine is eligible to be administered.
     * Iterates through the available vaccine doses, checks if each vaccine can be
     * given to the patient using {@code isDosable}, and if so, adds the dose to the patient
     * and records it in the dosesAdministered
     */
    public void AdminsterDose(Vaccine vaccine) {  	
        patient.addVaccineDoses(vaccine);
        dosesAdministered.add(vaccine);
    }
    /**
     * Returns the list of vaccine doses that have been administered to the patient.
     *
     * @return an ArrayList of Vaccine objects that have been administered
     */
    public ArrayList<Vaccine> getDosesAdministered(){
    	return dosesAdministered;
    }

    /**
     * Gets the patient associated with this visit.
     *
     * @return the ImmunizationPatient object
     */
    public ImmunizationPatient getPatient() {
        return patient;
    }

    /**
     * Sets the patient associated with this visit.
     *
     * @param patient the ImmunizationPatient to set
     */
    public void setPatient(ImmunizationPatient patient) {
        this.patient = patient;
    }

    /**
     * Gets the date of this visit.
     *
     * @return the LocalDate representing the visit date
     */
    public Date getVisitDate() {
        return visitDate;
    }

    /**
     * Sets the date of this visit.
     *
     * @param visitDate the LocalDate to set as the visit date
     */
    public void setVisitDate(Date visitDate) {
        this.visitDate = visitDate;
    }

    /**
     * Gets the remarks of this visit.
     *
     * @return the remarks
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * Sets the remarks of this visit.
     *
     * @param remarks the remarks tobe set
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    /**
     * Gets the map of vaccine doses associated with this visit.
     *
     * @return the Map of Vaccine to Integer representing vaccine doses
     */
    public Map<Vaccine, Integer> getVaccineDoses() {
        return vaccineDoses;
    }
}
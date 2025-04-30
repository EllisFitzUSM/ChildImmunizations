import java.util.List;
import java.util.Date;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * The Model component of the Clinic MVC architecture.
 * Responsible for maintaining clinic data and business logic.
 * 
 * @author Milo Keys cc DeepSeek
 * @version April 28, 2025
 */
class ClinicModel {
    private String name;
    private String address;
    private ArrayList<ImmunizationPatient> patients;
    private ArrayList<Return> monthlyReturns;
    private ArrayList<Visit> visits;

    /**
     * Constructs a new ClinicModel with specified name and address.
     * 
     * @param name The name of the clinic
     * @param address The physical address of the clinic
     */
    public ClinicModel(String name, String address) {
        this.name = name;
        this.address = address;
        this.patients = new ArrayList<>();
        this.visits = new ArrayList<>();
        this.monthlyReturns = new ArrayList<>();
    }

    /**
     * Gets the clinic name.
     * 
     * @return The name of the clinic
     */
    public String getName() { return name; }

    /**
     * Sets the clinic name.
     * 
     * @param name The new name for the clinic
     */
    public void setName(String name) { this.name = name; }

    /**
     * Gets the clinic address.
     * 
     * @return The address of the clinic
     */
    public String getAddress() { return address; }

    /**
     * Sets the clinic address.
     * 
     * @param address The new address for the clinic
     */
    public void setAddress(String address) { this.address = address; }

    /**
     * Gets the list of patients.
     * 
     * @return List of Patient objects
     */
    public ArrayList<ImmunizationPatient> getPatients() { return patients; }

    /**
     * Gets the list of monthly returns.
     * 
     * @return List of Return objects
     */
    public ArrayList<Return> getMonthlyReturns() { return monthlyReturns; }

    /**
     * Gets the list of visits.
     * 
     * @return List of Visit objects
     */
    public ArrayList<Visit> getVisits() { return visits; }

    /**
     * Adds a patient to the clinic's records.
     * 
     * @param patient The patient to add
     * @return true if patient was added successfully
     */
    public boolean addPatient(ImmunizationPatient patient) {
        return patients.add(patient);
    }

    /**
     * Adds a patient to the clinic's records.
     * 
     * @param visit The visit to add
     */
    public boolean removePatient(ImmunizationPatient patient) {
        return patients.remove(patient);
    }

    /**
     * Adds a visit to the clinic's records.
     * 
     * @param visit The visit to add
     */
    public void addVisit(Visit visit) {
        visits.add(visit);
    }

    /**
     * Adds a monthly return to the clinic's records.
     * 
     * @param r The return to add
     * @return true if return was added successfully
     */
    public boolean addMonthlyReturn(Return r) {
        return monthlyReturns.add(r);
    }

    /**
     * Finds a Patient by their patientID
     * 
     * @param ID the ID of the patient
     * @return returns the Patient null if not found
     */
    public ImmunizationPatient getPatientByPatientID(String ID) {
        return patients
            .stream().
            filter(patient -> patient.getPatientId().equals(ID)).
            findFirst().
            orElse(null);
    }

    /**
     * Finds a Patient by their patientID
     * 
     * @param ID the ID of the patient
     * @return returns the Patient null if not found
     */
    public List<Visit> getVisitByDate(Date date, DateFormat dateFor) {
        return visits
            .stream()
            .filter(visit -> dateFor.format(visit.getVisitDate()).equals(dateFor.format(date)))
            .collect(Collectors.toList());
    }
}
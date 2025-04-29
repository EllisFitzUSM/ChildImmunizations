import java.util.Date;

/**
 * Represents a medical clinic using the MVC architecture pattern.
 * This class serves as the facade for the MVC components.
 * 
 * @author Abdirahman Mohamed, Milo Keys cc DeepSeek
 * @version April 1, 2025
 */
public class Clinic {
    private ClinicModel model;
    private ClinicView view;
    private ClinicController controller;

    /**
     * Constructs a new Clinic with default values.
     */
    public Clinic() {
        this("Default Clinic", "Unknown Address");
    }

    /**
     * Constructs a new Clinic with specified name and address.
     * 
     * @param name The name of the clinic
     * @param address The physical address of the clinic
     */
    public Clinic(String name, String address) {
        this.model = new ClinicModel(name, address);
        this.view = new ClinicView();
        this.controller = new ClinicController(model, view);
    }

    /**
     * Gets the clinic name.
     * 
     * @return The name of the clinic
     */
    public String getName() { return model.getName(); }

    /**
     * Sets the clinic name.
     * 
     * @param name The new name for the clinic
     */
    public void setName(String name) { controller.updateClinicDetails(name, model.getAddress()); }

    /**
     * Gets the clinic address.
     * 
     * @return The address of the clinic
     */
    public String getAddress() { return model.getAddress(); }

    /**
     * Sets the clinic address.
     * 
     * @param address The new address for the clinic
     */
    public void setAddress(String address) { controller.updateClinicDetails(model.getName(), address); }

    /**
     * Adds a patient to the clinic's records.
     * 
     * @param patient The patient to add
     * @return true if patient was added successfully
     */
    public boolean addPatient(ImmunizationPatient patient) { 
        controller.addNewPatient(patient); 
        return true; 
    }

    /**
     * Adds a visit to the clinic's records.
     * 
     * @param visit The visit to add
     */
    public void addVisit(Visit visit) { controller.recordNewVisit(visit); }

    /**
     * Adds a monthly return to the clinic's records.
     * 
     * @param r The return to add
     * @return true if return was added successfully
     */
    public boolean addMonthlyReturn(Return r) { 
        controller.addNewMonthlyReturn(r); 
        return true; 
    }

    /**
     * Generates an immunization report.
     * 
     * @return An empty string (report is displayed through controller)
     */
    public String getImmunizationReport() { 
        controller.generateImmunizationReport(); 
        return ""; 
    }

    /**
     * Generates a monthly report.
     * 
     * @return An empty string (report is displayed through controller)
     */
    public String makeMonthlyReport() { 
        controller.generateMonthlyReport(); 
        return ""; 
    }

    /**
     * Returns a string representation of the Clinic.
     * 
     * @return String representation of the Clinic
     */
    @Override
    public String toString() {
        return String.format("Clinic [Name: %s, Address: %s]", model.getName(), model.getAddress());
    }

    /**
     * Main method to demonstrate Clinic functionality.
     * 
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        // Create a Clinic instance
        Clinic clinic = new Clinic("City Clinic", "123 Main Street");
        
        // Demonstrate operations
        clinic.getImmunizationReport();
        
        // Create and add a sample monthly return
        Return april = new Return(
            "City Clinic", "Metro Zone", "Central Region", "April 2025",
            500, 480, 4.0,
            10, 1, 25,
            18, 7
        );
        clinic.addMonthlyReturn(april);
        
        // Generate reports
        clinic.makeMonthlyReport();
        ImmunizationPatient testPatient = new ImmunizationPatient("1", new Date(), "lilly",
         "opnum", "hinum", "ninum", "address", "f", 101, "1", null, 3.25);

        System.out.println(testPatient.getVaccineDoses());
        clinic.addPatient(testPatient);

        var testVisit = new Visit(testPatient, new Date());
        var testVaccine1 = new Vaccine(123, "COVID", "PHILL", 100, 5, 90, 12, "intramuscular", "arm", null);
        var testVaccine2 = new Vaccine(5, "Flu", "PHILL", 100, 5, 90, 12, "intramuscular", "leg", null);
        testVisit.AdminsterDose(testVaccine1);
        testVisit.AdminsterDose(testVaccine2);

        clinic.addVisit(testVisit);
        // Show clinic details
        System.out.println(clinic);
        clinic.view.show();
    }
}
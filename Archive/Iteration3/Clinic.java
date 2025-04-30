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
        ImmunizationPatient testPatient1 = new ImmunizationPatient("1", new Date(), "Lilly",
         "opnum", "hinum", "ninum", "address", "Female", 101, "0", null, 64.12);
        ImmunizationPatient testPatient2 = new ImmunizationPatient("13", new Date(), "Aurora",
         "1283568", "12398758", "123956", "address", "Female", 50, "1", null, 40.29);
        ImmunizationPatient testPatient3 = new ImmunizationPatient("40", new Date(), "Zeb",
         "1245123", "61236", "2157258", "address", "Male", 30, "1", null, 50.23);

        System.out.println(testPatient1.getVaccineDoses());
        clinic.addPatient(testPatient1);
        clinic.addPatient(testPatient2);
        clinic.addPatient(testPatient3);

        var testVisit = new Visit(testPatient1, new Date());
        var testVaccine1 = new Vaccine(14, "COVID", "PHILL", 100, 5, 90, 12, "intramuscular", "arm", null);
        var testVaccine2 = new Vaccine(5, "Flu", "PHILL", 100, 5, 90, 12, "intramuscular", "leg", null);
        testVisit.AdminsterDose(testVaccine1);
        testVisit.AdminsterDose(testVaccine2);

        clinic.addVisit(testVisit);
        clinic.addVisit(new Visit(testPatient1, new Date(), "good check up"));
        clinic.addVisit(new Visit(testPatient2, new Date(), "I hear the gang of four is good reading this time of year"));
        clinic.addVisit(new Visit(testPatient3, new Date()));


        // Show clinic details
        System.out.println(clinic);
        clinic.view.show();
    }
}
/*
 * Clinic.java
 * Basic Clinic class that has little functionality at this point.
 * This class will be used to manage the clinic's operations, including generating
 * sample register records and monthly return reports.
 *
 * @author Abdirahman Mohamed
 * April 1, 2025
 */

import java.util.ArrayList;
import java.time.LocalDate;

public class Clinic {
    private String name;                // The name of the clinic
    private String address;             // The physical address of the clinic
    private ArrayList<Vaccine> immunizations = new ArrayList<>();  // List to store immunization records
    private ArrayList<Patient> patients = new ArrayList<>();       // List to store patient records
    private ArrayList<Return> monthlyReturns = new ArrayList<>();  // List to store monthly return records

    /**
     * Default constructor.
     */
    public Clinic() {
        this.name = "Default Clinic";
        this.address = "Unknown Address";
    }

    /**
     * Parameterized constructor.
     */
    public Clinic(String name, String address) {
        this.name = name;
        this.address = address;
    }

    // Getter and setter methods omitted for brevity...

    /**
     * Creates and returns a sample Register record for demonstration.
     * @return A sample Register instance.
     */
    public Register makeRegister() {
        // Sample data for the register record
        return new Register(
            LocalDate.of(2025, 4, 15), 100,
            "John Matworth", "Alice Matworth", 1,
            "1328 SW 21st St Blue Springs, Missouri, 64015",
            LocalDate.of(2020, 1, 20),
            LocalDate.of(2019, 8, 9), 'M', 55.51
        );
    }

    /**
     * Provides a string representation of the Clinic.
     */
    @Override
    public String toString() {
        return "Clinic [Name: " + name + ", Address: " + address + "]";
    }

    /**
     * Returns a report of all immunizations.
     */
    public String getImmunizationReport() {
        StringBuilder report = new StringBuilder();
        report.append("Clinic Immunization Report for ").append(name).append("\n");
        if (immunizations.isEmpty()) {
            report.append("No immunizations recorded.\n");
        } else {
            for (Vaccine imm : immunizations) {
                report.append(imm).append("\n");
            }
        }
        return report.toString();
    }

    /**
     * Adds a monthly return record.
     */
    public boolean addMonthlyReturn(Return r) {
        return monthlyReturns.add(r);
    }

    /**
     * Generates a formatted monthly return report.
     */
    public String makeMonthlyReport() {
        StringBuilder sb = new StringBuilder();
        sb.append("Monthly Return Report for ").append(name)
          .append(" (").append(address).append(")\n");
        sb.append("================================================\n");
        if (monthlyReturns.isEmpty()) {
            sb.append("No monthly returns recorded.\n");
        } else {
            for (Return r : monthlyReturns) {
                sb.append(r).append("\n");
                sb.append("------------------------------------------------\n");
            }
        }
        return sb.toString();
    }

    /**
     * Main method to demonstrate functionality.
     */
    public static void main(String[] args) {
        Clinic clinic = new Clinic("City Clinic", "123 Main Street");

        // Demonstrate Register creation
        Register reg = clinic.makeRegister();
        System.out.println("Sample Register Record:");
        System.out.println(reg);

        // Demonstrate immunization report (empty)
        System.out.println(clinic.getImmunizationReport());

        // Create and add a sample monthly return
        Return april = new Return(
            "City Clinic", "Metro Zone", "Central Region", "April 2025",
            500, 480, 4.0,
            10, 1, 25,
            18, 7
        );
        clinic.addMonthlyReturn(april);

        // Demonstrate monthly return report
        System.out.println(clinic.makeMonthlyReport());
    }
}

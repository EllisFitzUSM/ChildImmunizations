import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Optional;

import javax.swing.JOptionPane;

/**
 * The Controller component of the Clinic MVC architecture.
 * Manages the flow of data between Model and View.
 * 
 * @author Milo Keys cc DeepSeek
 * @version April 28, 2025
 */
class ClinicController {
    private ClinicModel model;
    private ClinicView view;

    /**
     * Constructs a new ClinicController with specified model and view.
     * 
     * @param model The ClinicModel to use
     * @param view The ClinicView to use
     */
    public ClinicController(ClinicModel model, ClinicView view) {
        this.model = model;
        this.view = view;

        CreateButtonListener();
    }

    /**
     * Creates the ActionListeners required for buttons,
     */
    private void CreateButtonListener() {
        view.addAddPatientButtonListener((ActionListener) new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    addNewPatient(view.showAddPatientDialog());
                }
            }
        );

        view.addDeletePatientButtonListener((ActionListener) new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
                String selectedPatientID = view.getSelectedPatientId();
                //one liner to find the first patient that matchs the ID
                ImmunizationPatient PatientToBeRemoved = model.getPatients()
                    .stream().
                    filter(patient -> patient.getPatientId().equals(selectedPatientID)).
                    findFirst().
                    orElse(null);

                int response = JOptionPane.showConfirmDialog(
                    null,
                    "Are you sure you want to delete patient:\n" +
                    "ID: " + PatientToBeRemoved.getPatientId() + "\n" +
                    "Name: " + PatientToBeRemoved.getName() + "?",
                    "Confirm Deletion",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE
                );
                if (response == JOptionPane.YES_OPTION)
                    removePatient(PatientToBeRemoved);
            }
        }
        );

        view.addSearchPatientButtonListener((ActionListener) new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (view.getSearchText() != null) {
                    ImmunizationPatient p = model.getPatients()
                        .stream()
                        .filter(patient -> patient.getPatientId().equals(view.getSearchText()))
                        .findFirst()
                        .orElse(null);
                    view.showSearchResult(p);
                }
            }
        }
        );
    }

    /**
     * Updates the clinic's details.
     * 
     * @param name The new name for the clinic
     * @param address The new address for the clinic
     */
    public void updateClinicDetails(String name, String address) {
        model.setName(name);
        model.setAddress(address);
        view.displayMessage("Clinic details updated successfully.");
    }

    /**
     * Adds a new patient to the clinic.
     * 
     * @param patient The patient to add
     */
    public void addNewPatient(ImmunizationPatient patient) {
        if (patient != null) {
            model.addPatient(patient);
            view.displayMessage("Patient added successfully.");
            view.updatePatientsTable(model.getPatients());
        } else {
            view.displayMessage("Failed to add patient.");
        }
    }

    /**
     * Adds a new patient to the clinic.
     * 
     * @param patient The patient to add
     */
    public void removePatient(ImmunizationPatient patient) {
        if (model.removePatient(patient)) {
            view.displayMessage("Patient removed successfully.");
            view.updatePatientsTable(model.getPatients());
        } else {
            view.displayMessage("Failed to removed patient.");
        }
    }

    /**
     * Records a new visit to the clinic.
     * 
     * @param visit The visit to record
     */
    public void recordNewVisit(Visit visit) {
        model.addVisit(visit);
        view.updateVisitsTable(model.getVisits());
        view.displayMessage("Visit recorded successfully.");
    }

    /**
     * Adds a new monthly return to the clinic's records.
     * 
     * @param r The return to add
     */
    public void addNewMonthlyReturn(Return r) {
        if (model.addMonthlyReturn(r)) {
            view.displayMessage("Monthly return added successfully.");
        } else {
            view.displayMessage("Failed to add monthly return.");
        }
    }

    /**
     * Generates and displays the immunization report.
     */
    public void generateImmunizationReport() {
        StringBuilder report = new StringBuilder();
        report.append("Clinic Immunization Report for ").append(model.getName()).append(":\n");
        report.append("No immunizations recorded.\n");
        view.displayImmunizationReport(report.toString());
    }

    /**
     * Generates and displays the monthly report.
     */
    public void generateMonthlyReport() {
        StringBuilder report = new StringBuilder();
        report.append("Monthly Return Report for ").append(model.getName())
              .append(" (").append(model.getAddress()).append(")\n");
        report.append("================================================\n");
        
        if (model.getMonthlyReturns().isEmpty()) {
            report.append("No monthly returns recorded.\n");
        } else {
            for (Return r : model.getMonthlyReturns()) {
                report.append(r).append("\n");
                report.append("------------------------------------------------\n");
            }
        }
        
        view.displayMonthlyReport(report.toString());
    }

    /**
     * Displays the clinic's details.
     */
    public void showClinicDetails() {
        view.displayClinicDetails(model.getName(), model.getAddress());
    }
}

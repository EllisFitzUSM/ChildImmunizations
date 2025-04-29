import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

/**
 * The Swing-based View component of the Clinic MVC architecture.
 * Responsible for displaying clinic information to the user through a GUI.
 * 
 * @author Milo Keys cc DeepSeek
 * @version April 28, 2025
 */
public class ClinicView {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);

    private JFrame frame;
    private JPanel mainPanel;
    private JTabbedPane tabbedPane;
    
    // Clinic Details Tab
    private JPanel clinicDetailsPanel;
    private JLabel nameLabel;
    private JLabel addressLabel;
    private JTextField nameField;
    private JTextField addressField;
    private JButton updateButton;
    
    // Patients Tab
    private JPanel patientsPanel;
    private JTable patientsTable;
    private JScrollPane patientsScrollPane;
    private JButton searchPatientButton;
    private JButton deletePatientButton;
    private JButton addPatientButton;
    private JPanel patientsButtonPanel;
    private JTextField searchField;

    // Visits Tab
    private JPanel visitsPanel;
    private JTable visitsTable;
    private JScrollPane visitsScrollPane;
    
    // Reports Tab
    private JPanel reportsPanel;
    private JTextArea reportTextArea;
    private JScrollPane reportScrollPane;
    private JButton immunizationReportButton;
    private JButton monthlyReportButton;

    /**
     * Constructs a new ClinicView and initializes the GUI components.
     */
    public ClinicView() {
        initializeGUI();
    }

    /**
     * Initializes the main GUI components including the frame, main panel, and tabs.
     */
    private void initializeGUI() {
        frame = new JFrame("Clinic Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        
        mainPanel = new JPanel(new BorderLayout());
        tabbedPane = new JTabbedPane();
        
        createClinicDetailsTab();
        createPatientsTab();
        createVisitsTab();
        createReportsTab();
        
        mainPanel.add(tabbedPane, BorderLayout.CENTER);
        frame.add(mainPanel);
    }

    /**
     * Creates the Clinic Details tab with fields for clinic name and address,
     * along with an update button.
     */
    private void createClinicDetailsTab() {
        clinicDetailsPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;
        
        // Name components
        gbc.gridx = 0;
        gbc.gridy = 0;
        nameLabel = new JLabel("Clinic Name:");
        clinicDetailsPanel.add(nameLabel, gbc);
        
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        nameField = new JTextField(20);
        clinicDetailsPanel.add(nameField, gbc);
        
        // Address components
        gbc.gridx = 0;
        gbc.gridy = 1;
        addressLabel = new JLabel("Clinic Address:");
        clinicDetailsPanel.add(addressLabel, gbc);
        
        gbc.gridx = 1;
        addressField = new JTextField(20);
        clinicDetailsPanel.add(addressField, gbc);
        
        // Update button
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        updateButton = new JButton("Update Clinic Details");
        clinicDetailsPanel.add(updateButton, gbc);
        
        tabbedPane.addTab("Clinic Details", clinicDetailsPanel);
    }

    /**
     * Creates the Patients tab with a table to display patient information.
     */
    private void createPatientsTab() {
        patientsPanel = new JPanel(new BorderLayout());
        
        // Create table model with sample columns
        String[] columns = {"ID", "National ID", "Name", "Address", "DOB", "Sex", "Weight(KG)"};
        DefaultTableModel model = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Make table cells non-editable
            }
        };
        patientsTable = new JTable(model);
        patientsTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        patientsScrollPane = new JScrollPane(patientsTable);
        patientsPanel.add(patientsScrollPane, BorderLayout.CENTER);
        
        // Create button panel for patient actions
        patientsButtonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        
        // Search components
        searchField = new JTextField(15);
        searchPatientButton = new JButton("Search");
        patientsButtonPanel.add(new JLabel("Search:"));
        patientsButtonPanel.add(searchField);
        patientsButtonPanel.add(searchPatientButton);
        
        // Action buttons
        addPatientButton = new JButton("Add Patient");
        deletePatientButton = new JButton("Delete Selected");
        
        patientsButtonPanel.add(addPatientButton);
        patientsButtonPanel.add(deletePatientButton);
        
        patientsPanel.add(patientsButtonPanel, BorderLayout.SOUTH);
        
        tabbedPane.addTab("Patients", patientsPanel);
    }

    /**
     * Creates the Visits tab with a table to display visit information.
     */
    private void createVisitsTab() {
        visitsPanel = new JPanel(new BorderLayout());
        
        // Create table model with sample columns
        String[] columns = {"Patient ID","Date of Visit", "Vaccines", "Remarks"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);
        visitsTable = new JTable(model);
        
        visitsScrollPane = new JScrollPane(visitsTable);
        visitsPanel.add(visitsScrollPane, BorderLayout.CENTER);
        
        tabbedPane.addTab("Visits", visitsPanel);
    }

    /**
     * Creates the Reports tab with a text area for report display and buttons
     * to generate different types of reports.
     */
    private void createReportsTab() {
        reportsPanel = new JPanel(new BorderLayout());
        
        // Report display area
        reportTextArea = new JTextArea();
        reportTextArea.setEditable(false);
        reportScrollPane = new JScrollPane(reportTextArea);
        reportsPanel.add(reportScrollPane, BorderLayout.CENTER);
        
        // Button panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        immunizationReportButton = new JButton("Generate Immunization Report");
        monthlyReportButton = new JButton("Generate Monthly Report");
        
        buttonPanel.add(immunizationReportButton);
        buttonPanel.add(monthlyReportButton);
        
        reportsPanel.add(buttonPanel, BorderLayout.SOUTH);
        
        tabbedPane.addTab("Reports", reportsPanel);
    }

    /**
     * Makes the main application window visible.
     */
    public void show() {
        frame.setVisible(true);
    }

    /**
     * Displays the clinic's basic details in the Clinic Details tab.
     * 
     * @param name The name of the clinic to display
     * @param address The address of the clinic to display
     */
    public void displayClinicDetails(String name, String address) {
        nameField.setText(name);
        addressField.setText(address);
    }

    /**
     * Displays the immunization report in the Reports tab and switches to that tab.
     * 
     * @param report The immunization report text to display
     */
    public void displayImmunizationReport(String report) {
        reportTextArea.setText(report);
        tabbedPane.setSelectedIndex(3); // Switch to reports tab
    }

    /**
     * Displays the monthly report in the Reports tab and switches to that tab.
     * 
     * @param report The monthly report text to display
     */
    public void displayMonthlyReport(String report) {
        reportTextArea.setText(report);
        tabbedPane.setSelectedIndex(3); // Switch to reports tab
    }

    /**
     * Displays a message dialog to the user.
     * 
     * @param message The message to display in the dialog
     */
    public void displayMessage(String message) {
        JOptionPane.showMessageDialog(frame, message);
    }

    /**
     * Adds an ActionListener to the Update Clinic Details button.
     * 
     * @param listener The ActionListener to add
     */
    public void addUpdateButtonListener(ActionListener listener) {
        updateButton.addActionListener(listener);
    }
    
    /**
     * Adds an ActionListener to the Generate Immunization Report button.
     * 
     * @param listener The ActionListener to add
     */
    public void addImmunizationReportButtonListener(ActionListener listener) {
        immunizationReportButton.addActionListener(listener);
    }
    
    /**
     * Adds an ActionListener to the Generate Monthly Report button.
     * 
     * @param listener The ActionListener to add
     */
    public void addMonthlyReportButtonListener(ActionListener listener) {
        monthlyReportButton.addActionListener(listener);
    }
    
    /**
     * Gets the clinic name entered in the Clinic Details tab.
     * 
     * @return The clinic name as a String
     */
    public String getClinicName() {
        return nameField.getText();
    }
    
    /**
     * Gets the clinic address entered in the Clinic Details tab.
     * 
     * @return The clinic address as a String
     */
    public String getClinicAddress() {
        return addressField.getText();
    }
    
    /**
     * Updates the Patients table with the provided list of patients.
     * 
     * @param patients An ArrayList of ImmunizationPatient objects to display in the table
     */
    public void updatePatientsTable(ArrayList<ImmunizationPatient> patients) {
        DefaultTableModel model = (DefaultTableModel) patientsTable.getModel();
        model.setRowCount(0); // Clear existing data
        
        for (ImmunizationPatient patient : patients) {
            Object[] row = {
                patient.getPatientId(),
                patient.getNationalIdentificationNumber(),
                patient.getName(),
                patient.getAddress(),
                dateFormat.format(patient.getDateOfBirth()),
                patient.getSex(),
                patient.getWeightKG(),
            };
            model.addRow(row);
        }
    }
    
    /**
     * Updates the Visits table with the provided list of visits.
     * 
     * @param visits An ArrayList of Visit objects to display in the table
     */
    public void updateVisitsTable(ArrayList<Visit> visits) {
        DefaultTableModel model = (DefaultTableModel) visitsTable.getModel();
        model.setRowCount(0); // Clear existing data
        
        for (Visit visit : visits) {
            Patient p = visit.getPatient();
            Object[] row = {
                p.getPatientId(),
                dateFormat.format(visit.getVisitDate()),
                visit.getDosesAdministered().stream()
                    .map(Vaccine::getName)
                    .collect(java.util.stream.Collectors.joining(", "))
            };
            model.addRow(row);
        }
    }

    /**
     * Adds an action listener to the search patient button.
     * PLACEHOLDER - Actual implementation should be done in controller
     * 
     * @param listener The action listener to add
     */
    public void addSearchPatientButtonListener(ActionListener listener) {
        searchPatientButton.addActionListener(listener);
    }
    
    /**
     * Adds an action listener to the delete patient button.
     * PLACEHOLDER - Actual implementation should be done in controller
     * 
     * @param listener The action listener to add
     */
    public void addDeletePatientButtonListener(ActionListener listener) {
        deletePatientButton.addActionListener(listener);
    }
    
    /**
     * Adds an action listener to the add patient button.
     * PLACEHOLDER - Actual implementation should be done in controller
     * 
     * @param listener The action listener to add
     */
    public void addAddPatientButtonListener(ActionListener listener) {
        addPatientButton.addActionListener(listener);
    }
    
    /**
     * Gets the search text from the search field.
     * PLACEHOLDER - Returns empty string, actual filtering should be done in controller
     * 
     * @return The current search text
     */
    public String getSearchText() {
        return searchField.getText();
    }
    
    /**
     * Gets the ID of the currently selected patient in the table.
     * PLACEHOLDER - Returns -1 if no selection, actual patient lookup should be done in controller
     * 
     * @return The selected patient ID, or -1 if no selection
     */
    public String getSelectedPatientId() {
        int selectedRow = patientsTable.getSelectedRow();
        if (selectedRow >= 0) {
            return (String) patientsTable.getValueAt(selectedRow, 0);
        }
        return null;
    }
    
    /**
     * Shows a dialog for adding a new patient with all required fields.
     * 
     * @return ImmunizationPatient object if created, null if canceled
     */
    public ImmunizationPatient showAddPatientDialog() {
    JPanel panel = new JPanel(new GridLayout(0, 2, 5, 5));
    
    // Create form fields
    JTextField idField = new JTextField();
    JTextField DOBField = new JTextField();
    JTextField nameField = new JTextField();
    JTextField outNumField = new JTextField();
    JTextField insuranceNumField = new JTextField();
    JTextField natIDField = new JTextField();
    JTextField addressField = new JTextField();
    JTextField sexField = new JTextField();
    JTextField ageField = new JTextField();
    JTextField motherIDField = new JTextField();
    JTextField weightField = new JTextField();

    
    // Add fields to panel with labels
    panel.add(new JLabel("Patient ID:"));
    panel.add(idField);
    panel.add(new JLabel("Date Of Birth:"));
    panel.add(DOBField);
    panel.add(new JLabel("Name:"));
    panel.add(nameField);
    panel.add(new JLabel("Out-Patient Number:"));
    panel.add(outNumField);
    panel.add(new JLabel("Health Insurance Number:"));
    panel.add(insuranceNumField);
    panel.add(new JLabel("National Identification Number:"));
    panel.add(natIDField);
    panel.add(new JLabel("Address:"));
    panel.add(addressField);
    panel.add(new JLabel("Sex:"));
    panel.add(sexField);
    panel.add(new JLabel("Age:"));
    panel.add(ageField);
    panel.add(new JLabel("Mother ID:"));
    panel.add(motherIDField);
    panel.add(new JLabel("Weight:"));
    panel.add(weightField);


    
    int result = JOptionPane.showConfirmDialog(
        frame,
        panel,
        "Add New Patient",
        JOptionPane.OK_CANCEL_OPTION,
        JOptionPane.PLAIN_MESSAGE
    );
    
    if (result == JOptionPane.OK_OPTION) {
        try {
            // Create and return new ImmunizationPatient
            return new ImmunizationPatient(
                idField.getText(),
                dateFormat.parse(DOBField.getText()),
                nameField.getText(),
                outNumField.getText(),
                insuranceNumField.getText(),
                natIDField.getText(),
                addressField.getText(), sexField.getText(), Integer.parseInt(ageField.getText()),
                motherIDField.getText(),
                null,
                Double.parseDouble(weightField.getText())
            );
        } catch (Exception e) {
            System.err.println(e);
            JOptionPane.showMessageDialog(
                frame,
                "Invalid number or date",
                "Input Error",
                JOptionPane.ERROR_MESSAGE
            );
            return null;
        }
    }
    return null;
}
    

    /**
     * Shows a search result for a single patient in a dialog.
     * 
     * @param patient The ImmunizationPatient object to display, or null if not found
     */
    public void showSearchResult(ImmunizationPatient patient) {
        if (patient == null) {
            JOptionPane.showMessageDialog(frame,
                "Patient not found",
                "Search Result",
                JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Create a panel to display patient details
        JPanel panel = new JPanel(new GridLayout(0, 2, 5, 5));
        
        // Add patient details to the panel
        panel.add(new JLabel("Patient ID:"));
        panel.add(new JLabel(patient.getPatientId()));
        
        panel.add(new JLabel("Name:"));
        panel.add(new JLabel(patient.getName()));
        
        panel.add(new JLabel("Date of Birth:"));
        panel.add(new JLabel(dateFormat.format(patient.getDateOfBirth())));
        
        panel.add(new JLabel("Age:"));
        panel.add(new JLabel(String.valueOf(patient.getAge())));
        
        panel.add(new JLabel("Gender:"));
        panel.add(new JLabel(patient.getSex()));
        
        panel.add(new JLabel("Address:"));
        panel.add(new JLabel(patient.getAddress()));
        
        panel.add(new JLabel("Weight (kg):"));
        panel.add(new JLabel(String.valueOf(patient.getWeightKG())));
        
        panel.add(new JLabel("National ID:"));
        panel.add(new JLabel(patient.getNationalIdentificationNumber()));
        
        panel.add(new JLabel("Health Insurance:"));
        panel.add(new JLabel(patient.getHealthInsuranceNumber()));
        
        panel.add(new JLabel("Out-Patient Number:"));
        panel.add(new JLabel(patient.getOutPatientNumber()));
        
        panel.add(new JLabel("Mother ID:"));
        panel.add(new JLabel(patient.getMotherId() != null ? patient.getMotherId() : "N/A"));

        JOptionPane.showMessageDialog(
            frame,
            panel,
            "Patient Found - " + patient.getName(),
            JOptionPane.INFORMATION_MESSAGE
        );
    }
}
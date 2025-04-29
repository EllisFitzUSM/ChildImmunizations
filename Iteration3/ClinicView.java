import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * The Swing-based View component of the Clinic MVC architecture.
 * Responsible for displaying clinic information to the user through a GUI.
 * 
 * @author Milo Keys cc DeepSeek
 * @version April 28, 2025
 */
public class ClinicView {
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

    public ClinicView() {
        initializeGUI();
    }

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

    private void createPatientsTab() {
        patientsPanel = new JPanel(new BorderLayout());
        
        // Create table model with sample columns
        String[] columns = {"ID", "Name", "Age", "Sex"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);
        patientsTable = new JTable(model);
        
        patientsScrollPane = new JScrollPane(patientsTable);
        patientsPanel.add(patientsScrollPane, BorderLayout.CENTER);
        
        tabbedPane.addTab("Patients", patientsPanel);
    }

    private void createVisitsTab() {
        visitsPanel = new JPanel(new BorderLayout());
        
        // Create table model with sample columns
        String[] columns = {"Visit ID", "Patient ID", "Vaccines"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);
        visitsTable = new JTable(model);
        
        visitsScrollPane = new JScrollPane(visitsTable);
        visitsPanel.add(visitsScrollPane, BorderLayout.CENTER);
        
        tabbedPane.addTab("Visits", visitsPanel);
    }

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

    public void show() {
        frame.setVisible(true);
    }

    /**
     * Displays the clinic's basic details.
     * 
     * @param name The name of the clinic
     * @param address The address of the clinic
     */
    public void displayClinicDetails(String name, String address) {
        nameField.setText(name);
        addressField.setText(address);
    }

    /**
     * Displays the immunization report.
     * 
     * @param report The immunization report to display
     */
    public void displayImmunizationReport(String report) {
        reportTextArea.setText(report);
        tabbedPane.setSelectedIndex(3); // Switch to reports tab
    }

    /**
     * Displays the monthly report.
     * 
     * @param report The monthly report to display
     */
    public void displayMonthlyReport(String report) {
        reportTextArea.setText(report);
        tabbedPane.setSelectedIndex(3); // Switch to reports tab
    }

    /**
     * Displays a general message to the user.
     * 
     * @param message The message to display
     */
    public void displayMessage(String message) {
        JOptionPane.showMessageDialog(frame, message);
    }

    // Methods to add action listeners
    public void addUpdateButtonListener(ActionListener listener) {
        updateButton.addActionListener(listener);
    }
    
    public void addImmunizationReportButtonListener(ActionListener listener) {
        immunizationReportButton.addActionListener(listener);
    }
    
    public void addMonthlyReportButtonListener(ActionListener listener) {
        monthlyReportButton.addActionListener(listener);
    }
    
    // Getters for form data
    public String getClinicName() {
        return nameField.getText();
    }
    
    public String getClinicAddress() {
        return addressField.getText();
    }
    
    // Methods to update tables
    public void updatePatientsTable(ArrayList<Patient> patients) {
        DefaultTableModel model = (DefaultTableModel) patientsTable.getModel();
        model.setRowCount(0); // Clear existing data
        
        for (Patient patient : patients) {
            Object[] row = {
                patient.getPatientId(),
                patient.getName(),
                patient.getAge(),
                patient.getSex(),
                //patient.getVaccineDoses()
            };
            model.addRow(row);
        }
    }
    
    public void updateVisitsTable(ArrayList<Visit> visits) {
        DefaultTableModel model = (DefaultTableModel) visitsTable.getModel();
        model.setRowCount(0); // Clear existing data
        
        for (Visit visit : visits) {
            Patient p = visit.getPatient();
            Object[] row = {
                //visit.getPatient(),
                p.getPatientId(),
                visit.getVisitDate(),
                //one line to collect and join as a string
                visit.getDosesAdministered().stream()
                .map(Object::toString)
                .collect(java.util.stream.Collectors.joining())
            };
            model.addRow(row);
        }
    }
}
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.List;
import java.util.Map;
import javax.swing.*;
import java.awt.*;

/**
 * The Swing-based View component of the Clinic MVC architecture.
 * Responsible for displaying clinic information to the user through a GUI.
 * 
 * @author Milo Keys cc DeepSeek
 * @version April 28, 2025
 */
public class ClinicView {
    public static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
    public ClinicController controller;

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
    private JButton searchVisitButton;
    private JButton deleteVisitButton;
    private JButton addVisitButton;
    private JTextField visitsSearchField;
    
    // Reports Tab
    private JPanel reportsPanel;
    private JTextArea reportTextArea;
    private JScrollPane reportScrollPane;
    private JButton immunizationReportButton;
    private JButton monthlyReportButton;

    // Vaccines Tab
    private JPanel vaccinesPanel;
    private JTable vaccinesTable;
    private JScrollPane vaccinesScrollPane;
    private JButton saveVaccinesButton;
    private JButton refreshVaccinesButton;
    private JButton restockVaccineButton;
    private JButton addVaccineButton;
    private JButton deleteVaccineButton;

    // Vitamins Tab
    private JPanel vitaminsPanel;
    private JTable vitaminsTable;
    private JScrollPane vitaminsScrollPane;
    private JButton saveVitaminsButton;
    private JButton refreshVitaminsButton;
    private JButton restockVitaminButton;
    private JButton addVitaminButton;
    private JButton deleteVitaminButton;

    // Add these maps to track stock data
    private Map<Integer, Integer> vaccineStock = new HashMap<>();
    private Map<Integer, Integer> vitaminStock = new HashMap<>();

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
        frame.setSize(1000, 600);
        
        mainPanel = new JPanel(new BorderLayout());
        tabbedPane = new JTabbedPane();
        
        createClinicDetailsTab();
        createPatientsTab();
        createVisitsTab();
        createReportsTab();
        createVaccinesTab();
        createVitaminsTab();
        
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
        String[] columns = {"Patient ID", "Date of Visit", "Vaccines", "Remarks"};
        DefaultTableModel model = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Make table cells non-editable
            }
        };
        visitsTable = new JTable(model);
        visitsTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        visitsScrollPane = new JScrollPane(visitsTable);
        visitsPanel.add(visitsScrollPane, BorderLayout.CENTER);
        
        // Create button panel for visit actions
        JPanel visitsButtonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        
        // Search components
        visitsSearchField = new JTextField(15);
        searchVisitButton = new JButton("Search Visit");
        visitsButtonPanel.add(new JLabel("Search:"));
        visitsButtonPanel.add(visitsSearchField);
        visitsButtonPanel.add(searchVisitButton);
        
        // Action buttons
        addVisitButton = new JButton("Add Visit");
        deleteVisitButton = new JButton("Delete Selected");
        
        visitsButtonPanel.add(addVisitButton);
        visitsButtonPanel.add(deleteVisitButton);
        
        visitsPanel.add(visitsButtonPanel, BorderLayout.SOUTH);
        
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
     * Creates the Vaccines tab with a table to display and edit vaccine stock information.
     */
    private void createVaccinesTab() {
        vaccinesPanel = new JPanel(new BorderLayout());

        // Create table model with columns
        String[] columns = {"ID", "Name", "Brand", "Dosage (ml)", "Stock"};
        DefaultTableModel model = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                // Only allow editing the stock column
                return column == 4;
            }

            @Override
            public Class<?> getColumnClass(int columnIndex) {
                if (columnIndex == 4) { // Stock column
                    return Integer.class;
                }
                return String.class;
            }
        };

        vaccinesTable = new JTable(model);
        vaccinesTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        vaccinesScrollPane = new JScrollPane(vaccinesTable);
        vaccinesPanel.add(vaccinesScrollPane, BorderLayout.CENTER);

        // Create button panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        refreshVaccinesButton = new JButton("Refresh");
        saveVaccinesButton = new JButton("Save Changes");
        restockVaccineButton = new JButton("Restock");
        addVaccineButton = new JButton("Add New Vaccine");
        deleteVaccineButton = new JButton("Delete Vaccine");

        buttonPanel.add(refreshVaccinesButton);
        buttonPanel.add(saveVaccinesButton);
        buttonPanel.add(restockVaccineButton);
        buttonPanel.add(addVaccineButton);
        buttonPanel.add(deleteVaccineButton);

        vaccinesPanel.add(buttonPanel, BorderLayout.SOUTH);

        tabbedPane.addTab("Vaccines", vaccinesPanel);

        // Add action listeners
        refreshVaccinesButton.addActionListener(e -> loadVaccinesData());
        saveVaccinesButton.addActionListener(e -> saveVaccinesData());
        restockVaccineButton.addActionListener(e -> showRestockVaccineDialog());
        addVaccineButton.addActionListener(e -> showAddVaccineDialog());
        deleteVaccineButton.addActionListener(e -> deleteSelectedVaccine());

        // Load initial data
        loadVaccinesData();
    }

    /**
     * Creates the Vitamins tab with a table to display and edit vitamin stock information.
     */
    private void createVitaminsTab() {
        vitaminsPanel = new JPanel(new BorderLayout());

        // Create table model with columns
        String[] columns = {"ID", "Name", "Brand", "Dosage (mg)", "Stock"};
        DefaultTableModel model = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                // Only allow editing the stock column
                return column == 4;
            }

            @Override
            public Class<?> getColumnClass(int columnIndex) {
                if (columnIndex == 4) { // Stock column
                    return Integer.class;
                }
                return String.class;
            }
        };

        vitaminsTable = new JTable(model);
        vitaminsTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        vitaminsScrollPane = new JScrollPane(vitaminsTable);
        vitaminsPanel.add(vitaminsScrollPane, BorderLayout.CENTER);

        // Create button panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        refreshVitaminsButton = new JButton("Refresh");
        saveVitaminsButton = new JButton("Save Changes");
        restockVitaminButton = new JButton("Restock");
        addVitaminButton = new JButton("Add New Vitamin");
        deleteVitaminButton = new JButton("Delete Vitamin");

        buttonPanel.add(refreshVitaminsButton);
        buttonPanel.add(saveVitaminsButton);
        buttonPanel.add(restockVitaminButton);
        buttonPanel.add(addVitaminButton);
        buttonPanel.add(deleteVitaminButton);

        vitaminsPanel.add(buttonPanel, BorderLayout.SOUTH);

        tabbedPane.addTab("Vitamins", vitaminsPanel);

        // Add action listeners
        refreshVitaminsButton.addActionListener(e -> loadVitaminsData());
        saveVitaminsButton.addActionListener(e -> saveVitaminsData());
        restockVitaminButton.addActionListener(e -> showRestockVitaminDialog());
        addVitaminButton.addActionListener(e -> showAddVitaminDialog());
        deleteVitaminButton.addActionListener(e -> deleteSelectedVitamin());

        // Load initial data
        loadVitaminsData();
    }

    /**
     * Shows a dialog to restock an existing vaccine
     */
    private void showRestockVaccineDialog() {
        JPanel panel = new JPanel(new GridLayout(0, 2, 5, 5));

        JTextField idField = new JTextField();
        JTextField amountField = new JTextField();

        panel.add(new JLabel("Vaccine ID:"));
        panel.add(idField);
        panel.add(new JLabel("Amount to Add:"));
        panel.add(amountField);

        int result = JOptionPane.showConfirmDialog(
                frame,
                panel,
                "Restock Vaccine",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE
        );

        if (result == JOptionPane.OK_OPTION) {
            try {
                int id = Integer.parseInt(idField.getText());
                int amount = Integer.parseInt(amountField.getText());

                // Find the vaccine in the table and update stock
                for (int row = 0; row < vaccinesTable.getRowCount(); row++) {
                    if ((int)vaccinesTable.getValueAt(row, 0) == id) {
                        int currentStock = (int)vaccinesTable.getValueAt(row, 4);
                        vaccinesTable.setValueAt(currentStock + amount, row, 4);
                        break;
                    }
                }
            } catch (NumberFormatException e) {
                displayMessage("Please enter valid numbers for ID and amount");
            }
        }
    }

    /**
     * Shows a dialog to add a completely new vaccine
     */
    private void showAddVaccineDialog() {
        class DuplicateException extends Exception {};
        JPanel panel = new JPanel(new GridLayout(0, 2, 5, 5));

        JTextField idField = new JTextField();
        JTextField nameField = new JTextField();
        JTextField brandField = new JTextField();
        JTextField dosageField = new JTextField();
        JTextField stockField = new JTextField();
        JTextField dosageCountField = new JTextField();
        JTextField intervalField = new JTextField();
        JTextField treatsField = new JTextField();

        panel.add(new JLabel("ID:"));
        panel.add(idField);
        panel.add(new JLabel("Name:"));
        panel.add(nameField);
        panel.add(new JLabel("Brand:"));
        panel.add(brandField);
        panel.add(new JLabel("Dosage (ml):"));
        panel.add(dosageField);
        panel.add(new JLabel("Initial Stock:"));
        panel.add(stockField);
        panel.add(new JLabel("Dosage Count:"));
        panel.add(dosageCountField);
        panel.add(new JLabel("Interval (days):"));
        panel.add(intervalField);
        panel.add(new JLabel("Treats (comma separated):"));
        panel.add(treatsField);

        int result = JOptionPane.showConfirmDialog(
                frame,
                panel,
                "Add New Vaccine",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE
        );

        if (result == JOptionPane.OK_OPTION) {
            try {
                // Create CSV line
                String newLine = String.join(",",
                        idField.getText(),
                        nameField.getText(),
                        brandField.getText(),
                        dosageField.getText(),
                        dosageCountField.getText(),
                        intervalField.getText(),
                        treatsField.getText(),
                        stockField.getText()
                );
                System.out.println(newLine);

//                if(true) {
//                    throw new DuplicateException();
//                }

                // Append to file'
                File vaccinesFile = new File(getClass().getClassLoader().getResource("vaccines.csv").getFile());
                try (FileWriter fw = new FileWriter(vaccinesFile, true)) {
                    fw.write("\n" + newLine);
                    fw.flush();
                    displayMessage("New vaccine added successfully");
                }

                // Refresh the table
                loadVaccinesData();

            } catch (IOException e) {
                displayMessage("Error saving new vaccine: " + e.getMessage());
//            } catch (DuplicateException e) {
//                displayMessage("Duplicate vaccine: " + e.getMessage());
            }
        }
    }

    /**
     * Shows a dialog to restock an existing vitamin
     */
    private void showRestockVitaminDialog() {
        JPanel panel = new JPanel(new GridLayout(0, 2, 5, 5));

        JTextField idField = new JTextField();
        JTextField amountField = new JTextField();

        panel.add(new JLabel("Vitamin ID:"));
        panel.add(idField);
        panel.add(new JLabel("Amount to Add:"));
        panel.add(amountField);

        int result = JOptionPane.showConfirmDialog(
                frame,
                panel,
                "Restock Vitamin",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE
        );

        if (result == JOptionPane.OK_OPTION) {
            try {
                int id = Integer.parseInt(idField.getText());
                int amount = Integer.parseInt(amountField.getText());

                // Find the vaccine in the table and update stock
                for (int row = 0; row < vaccinesTable.getRowCount(); row++) {
                    if ((int)vaccinesTable.getValueAt(row, 0) == id) {
                        int currentStock = (int)vaccinesTable.getValueAt(row, 4);
                        vaccinesTable.setValueAt(currentStock + amount, row, 4);
                        break;
                    }
                }
            } catch (NumberFormatException e) {
                displayMessage("Please enter valid numbers for ID and amount");
            }
        }
    }

    /**
     * Shows a dialog to add a completely new vitamin
     */
    private void showAddVitaminDialog() {
        class DuplicateException extends Exception {};
        JPanel panel = new JPanel(new GridLayout(0, 2, 5, 5));

        JTextField idField = new JTextField();
        JTextField nameField = new JTextField();
        JTextField brandField = new JTextField();
        JTextField dosageField = new JTextField();
        JTextField stockField = new JTextField();
        JTextField dosageCountField = new JTextField();
        JTextField intervalField = new JTextField();
        JTextField treatsField = new JTextField();

        panel.add(new JLabel("ID:"));
        panel.add(idField);
        panel.add(new JLabel("Name:"));
        panel.add(nameField);
        panel.add(new JLabel("Brand:"));
        panel.add(brandField);
        panel.add(new JLabel("Dosage (mG):"));
        panel.add(dosageField);
        panel.add(new JLabel("Initial Stock:"));
        panel.add(stockField);
        panel.add(new JLabel("Dosage Count:"));
        panel.add(dosageCountField);
        panel.add(new JLabel("Interval (days):"));
        panel.add(intervalField);
        panel.add(new JLabel("Treats (comma separated):"));
        panel.add(treatsField);

        int result = JOptionPane.showConfirmDialog(
                frame,
                panel,
                "Add New Vitamin",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE
        );

        if (result == JOptionPane.OK_OPTION) {
            try {
                // Create CSV line
                String newLine = String.join(",",
                        idField.getText(),
                        nameField.getText(),
                        brandField.getText(),
                        dosageField.getText(),
                        dosageCountField.getText(),
                        intervalField.getText(),
                        treatsField.getText(),
                        stockField.getText()
                );

//                if(true) {
//                    throw new DuplicateException();
//                }

                // Append to file
                File vitaminsFile = new File(getClass().getClassLoader().getResource("vitamins.csv").getFile());
                try (FileWriter fw = new FileWriter(vitaminsFile, true)) {
                    fw.write("\n" + newLine);
                    fw.flush();
                    displayMessage("New vitamin added successfully");
                }

                // Refresh the table
                loadVitaminsData();

            } catch (IOException e) {
                displayMessage("Error saving new vitamin: " + e.getMessage());
//            } catch(DuplicateException e) {
//                displayMessage("Duplicate vitamin: " + e.getMessage());
            }
        }
    }

    /**
     * Deletes the selected vaccine after confirmation
     */
    private void deleteSelectedVaccine() {
        int selectedRow = vaccinesTable.getSelectedRow();
        if (selectedRow >= 0) {
            int id = (int) vaccinesTable.getValueAt(selectedRow, 0);
            String name = (String) vaccinesTable.getValueAt(selectedRow, 1);

            int confirm = JOptionPane.showConfirmDialog(
                    frame,
                    "Are you sure you want to delete vaccine:\n" +
                            "ID: " + id + "\n" +
                            "Name: " + name + "?",
                    "Confirm Deletion",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE
            );

            if (confirm == JOptionPane.YES_OPTION) {
                // Remove from table
                ((DefaultTableModel)vaccinesTable.getModel()).removeRow(selectedRow);
                // Remove from stock map
                vaccineStock.remove(id);
                displayMessage("Vaccine deleted (remember to save changes)");
            }
        } else {
            displayMessage("Please select a vaccine to delete");
        }
    }

    /**
     * Deletes the selected vitamin after confirmation
     */
    private void deleteSelectedVitamin() {
        int selectedRow = vitaminsTable.getSelectedRow();
        if (selectedRow >= 0) {
            int id = (int) vitaminsTable.getValueAt(selectedRow, 0);
            String name = (String) vitaminsTable.getValueAt(selectedRow, 1);

            int confirm = JOptionPane.showConfirmDialog(
                    frame,
                    "Are you sure you want to delete vitamin:\n" +
                            "ID: " + id + "\n" +
                            "Name: " + name + "?",
                    "Confirm Deletion",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE
            );

            if (confirm == JOptionPane.YES_OPTION) {
                // Remove from table
                ((DefaultTableModel)vitaminsTable.getModel()).removeRow(selectedRow);
                // Remove from stock map
                vitaminStock.remove(id);
                displayMessage("Vitamin deleted (remember to save changes)");
            }
        } else {
            displayMessage("Please select a vitamin to delete");
        }
    }

    /**
     * Loads vaccine data from the vaccines.csv file and populates the table.
     */
    private void loadVaccinesData() {
        vaccineStock.clear();
        DefaultTableModel model = (DefaultTableModel) vaccinesTable.getModel();
        model.setRowCount(0);

        try (InputStream in = getClass().getClassLoader().getResourceAsStream("vaccines.csv");
            BufferedReader br = new BufferedReader(new InputStreamReader(in))) {
            // Skip header line
            br.readLine();

            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length >= 8) {
                    int id = Integer.parseInt(values[0].trim());
                    String name = values[1].trim();
                    String brand = values[2].trim();
                    double dosage = Double.parseDouble(values[3].trim());
                    int stock = Integer.parseInt(values[7].trim());

                    model.addRow(new Object[]{id, name, brand, dosage, stock});
                    vaccineStock.put(id, stock);
                }
            }
        } catch (IOException | NumberFormatException e) {
            displayMessage("Error loading vaccines data: " + e.getMessage());
        }
    }

    /**
     * Saves modified vaccine stock data back to the vaccines.csv file.
     */
    private void saveVaccinesData() {
//        try (InputStream in = getClass().getClassLoader().getResourceAsStream("vaccines.csv");
//             BufferedReader br = new BufferedReader(new InputStreamReader(in));
//             FileWriter fw = new FileWriter("vaccines.tmp")) {
//
//            // Write header
//            fw.write(br.readLine() + "\n");
//
//            String line;
//            while ((line = br.readLine()) != null) {
//                String[] values = line.split(",");
//                if (values.length >= 8) {
//                    int id = Integer.parseInt(values[0].trim());
//
//                    // Update stock value from table if changed
//                    for (int row = 0; row < vaccinesTable.getRowCount(); row++) {
//                        int tableId = (int) vaccinesTable.getValueAt(row, 0);
//                        if (tableId == id) {
//                            int newStock = (int) vaccinesTable.getValueAt(row, 4);
//                            if (newStock != vaccineStock.get(id)) {
//                                values[7] = String.valueOf(newStock);
//                                vaccineStock.put(id, newStock);
//                            }
//                            break;
//                        }
//                    }
//
//                    fw.write(String.join(",", values) + "\n");
//                }
//            }
//
//            // Replace original file with temp file
//            java.nio.file.Files.move(
//                    java.nio.file.Paths.get("vaccines.tmp"),
//                    java.nio.file.Paths.get("vaccines.csv"),
//                    java.nio.file.StandardCopyOption.REPLACE_EXISTING
//            );
//
//            displayMessage("Vaccine stock data saved successfully.");
//        } catch (IOException | NumberFormatException e) {
//            displayMessage("Error saving vaccines data: " + e.getMessage());
//        }
        try {
            // Read all existing data first (except stock values)
            Map<Integer, String[]> vaccineData = new HashMap<>();
            try (BufferedReader br = new BufferedReader(new FileReader("vaccines.csv"))) {
                String header = br.readLine(); // Save header
                String line;
                while ((line = br.readLine()) != null) {
                    String[] values = line.split(",");
                    if (values.length >= 8) {
                        int id = Integer.parseInt(values[0].trim());
                        vaccineData.put(id, values);
                    }
                }
            }

            // Write back all data with updated stock values
            try (FileWriter fw = new FileWriter("vaccines.csv")) {
                fw.write("id,name,brand,dosageml,dosage count,interval days,treats,stock\n");

                // Write existing entries with updated stock
                for (int row = 0; row < vaccinesTable.getRowCount(); row++) {
                    int id = (int) vaccinesTable.getValueAt(row, 0);
                    String name = (String) vaccinesTable.getValueAt(row, 1);
                    String brand = (String) vaccinesTable.getValueAt(row, 2);
                    String dosage = vaccinesTable.getValueAt(row, 3).toString();
                    int stock = (int) vaccinesTable.getValueAt(row, 4);

                    String[] originalData = vaccineData.get(id);
                    if (originalData != null) {
                        fw.write(String.format("%d,%s,%s,%s,%s,%s,%s,%d\n",
                                id, name, brand, dosage,
                                originalData[4], originalData[5], originalData[6],
                                stock));
                    } else {
                        // This is a new entry added via the table
                        fw.write(String.format("%d,%s,%s,%s,1,30,,%d\n",
                                id, name, brand, dosage, stock));
                    }
                }
            }

            displayMessage("Vaccine data saved successfully");
        } catch (IOException | NumberFormatException e) {
            displayMessage("Error saving vaccine data: " + e.getMessage());
        }
    }

    /**
     * Loads vitamin data from the vitamins.csv file and populates the table.
     */
    private void loadVitaminsData() {
        vitaminStock.clear();
        DefaultTableModel model = (DefaultTableModel) vitaminsTable.getModel();
        model.setRowCount(0);

        try (InputStream in = getClass().getClassLoader().getResourceAsStream("vitamins.csv");
             BufferedReader br = new BufferedReader(new InputStreamReader(in))) {
            // Skip header line
            br.readLine();

            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length >= 8) {
                    int id = Integer.parseInt(values[0].trim());
                    String name = values[1].trim();
                    String brand = values[2].trim();
                    double dosage = Double.parseDouble(values[3].trim());
                    int stock = Integer.parseInt(values[7].trim());

                    model.addRow(new Object[]{id, name, brand, dosage, stock});
                    vitaminStock.put(id, stock);
                }
            }
        } catch (IOException | NumberFormatException e) {
            displayMessage("Error loading vitamins data: " + e.getMessage());
        }
    }

    /**
     * Saves modified vitamin stock data back to the vitamins.csv file.
     */
    private void saveVitaminsData() {
        try (InputStream in = getClass().getClassLoader().getResourceAsStream("vitamins.csv");
             BufferedReader br = new BufferedReader(new InputStreamReader(in));
             FileWriter fw = new FileWriter("vitamins.tmp")) {

            // Write header
            fw.write(br.readLine() + "\n");

            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length >= 8) {
                    int id = Integer.parseInt(values[0].trim());

                    // Update stock value from table if changed
                    for (int row = 0; row < vitaminsTable.getRowCount(); row++) {
                        int tableId = (int) vitaminsTable.getValueAt(row, 0);
                        if (tableId == id) {
                            int newStock = (int) vitaminsTable.getValueAt(row, 4);
                            if (newStock != vitaminStock.get(id)) {
                                values[7] = String.valueOf(newStock);
                                vitaminStock.put(id, newStock);
                            }
                            break;
                        }
                    }

                    fw.write(String.join(",", values) + "\n");
                }
            }

            // Replace original file with temp file
            java.nio.file.Files.move(
                    java.nio.file.Paths.get("vitamins.tmp"),
                    java.nio.file.Paths.get("vitamins.csv"),
                    java.nio.file.StandardCopyOption.REPLACE_EXISTING
            );

            displayMessage("Vitamin stock data saved successfully.");
        } catch (IOException | NumberFormatException e) {
            displayMessage("Error saving vitamins data: " + e.getMessage());
        }
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
                    .collect(java.util.stream.Collectors.joining(", ")),
                visit.getRemarks()
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
     * 
     * @return The current search text
     */
    public String getSearchText() {
        return searchField.getText();
    }
    
    /**
     * Gets the ID of the currently selected patient in the table.
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

        /**
     * Adds an action listener to the search visit button.
     * 
     * @param listener The action listener to add
     */
    public void addSearchVisitButtonListener(ActionListener listener) {
        searchVisitButton.addActionListener(listener);
    }
    
    /**
     * Adds an action listener to the delete visit button.
     * 
     * @param listener The action listener to add
     */
    public void addDeleteVisitButtonListener(ActionListener listener) {
        deleteVisitButton.addActionListener(listener);
    }
    
    /**
     * Adds an action listener to the add visit button.
     * 
     * @param listener The action listener to add
     */
    public void addAddVisitButtonListener(ActionListener listener) {
        addVisitButton.addActionListener(listener);
    }
    
    /**
     * Gets the search text from the visits search field.
     * 
     * @return The current search text for visits
     */
    public String getVisitsSearchText() {
        return visitsSearchField.getText();
    }
    
    /**
     * Gets the index of the currently selected visit in the table.
     * 
     * @return The selected visit index, or -1 if no selection
     */
    public int getSelectedVisitIndex() {
        return visitsTable.getSelectedRow();
    }

    /**
     * Shows a dialog for adding a new visit with all required fields.
     *
     * @return Visit object if created, null if canceled
     */
    public Visit showAddVisitDialog() {
        JPanel panel = new JPanel(new GridLayout(0, 2, 5, 5));

        // Create form fields
        JTextField patientIdField = new JTextField();
        JTextField dateField = new JTextField();
        JTextField vaccinesField = new JTextField();
        JTextField remarksField = new JTextField();

        // Add fields to panel with labels
        panel.add(new JLabel("Patient ID:"));
        panel.add(patientIdField);
        panel.add(new JLabel("Date (dd/MM/yyyy):"));
        panel.add(dateField);
        panel.add(new JLabel("Vaccines (comma separated):"));
        panel.add(vaccinesField);
        panel.add(new JLabel("Remarks:"));
        panel.add(remarksField);

        int result = JOptionPane.showConfirmDialog(
            frame,
            panel,
            "Add New Visit",
            JOptionPane.OK_CANCEL_OPTION,
            JOptionPane.PLAIN_MESSAGE
        );

        if (result == JOptionPane.OK_OPTION) {
            try {
                ImmunizationPatient patient = controller.getPatientByPatientID(patientIdField.getText()); //breaking some rules here FYI
                return new Visit(patient, dateFormat.parse(dateField.getText()), remarksField.getText());
            } catch (Exception e) {
                System.err.println(e);
                JOptionPane.showMessageDialog(
                    frame,
                    "Invalid date format or input",
                    "Input Error",
                    JOptionPane.ERROR_MESSAGE
                );
                return null;
            }
        }
        return null;
    }

//    /**
//     * Shows a dialog for adding a new visit with weight input and available vaccines
//     *
//     * @return Visit object if created, null if canceled
//     */
//    public Visit showAddVisitDialog() {
//        JPanel panel = new JPanel(new GridLayout(0, 2, 5, 5));
//
//        // Create form fields
//        JTextField patientIdField = new JTextField();
//        JTextField dateField = new JTextField();
//        JTextField weightField = new JTextField();
//        JTextArea availableVaccinesArea = new JTextArea(5, 20);
//        availableVaccinesArea.setEditable(false);
//        JScrollPane vaccinesScrollPane = new JScrollPane(availableVaccinesArea);
//        JTextField remarksField = new JTextField();
//
//        // Add listener to update available vaccines when patient ID or weight changes
//        ActionListener updateVaccinesListener = e -> {
//            try {
//                ImmunizationPatient patient = controller.getPatientByPatientID(patientIdField.getText());
//                if (patient != null) {
//                    double weight = Double.parseDouble(weightField.getText());
//                    List<Vaccine> availableVaccines = getAvailableVaccinesForPatient(patient, weight);
//
//                    StringBuilder sb = new StringBuilder();
//                    for (Vaccine vaccine : availableVaccines) {
//                        sb.append(vaccine.getName())
//                                .append(" (Min Age: ").append(vaccine.getMinAge())
//                                .append(", Min Weight: ").append(vaccine.getMinWeightKG()).append(" kg)\n");
//                    }
//                    availableVaccinesArea.setText(sb.toString());
//                }
//            } catch (Exception ex) {
//                availableVaccinesArea.setText("");
//            }
//        };
//
//        patientIdField.addActionListener(updateVaccinesListener);
//        weightField.addActionListener(updateVaccinesListener);
//
//        // Add fields to panel with labels
//        panel.add(new JLabel("Patient ID:"));
//        panel.add(patientIdField);
//        panel.add(new JLabel("Date (dd/MM/yyyy):"));
//        panel.add(dateField);
//        panel.add(new JLabel("Current Weight (kg):"));
//        panel.add(weightField);
//        panel.add(new JLabel("Available Vaccines:"));
//        panel.add(vaccinesScrollPane);
//        panel.add(new JLabel("Vaccines to Administer (comma separated):"));
//        panel.add(new JLabel()); // Empty label for layout
//        panel.add(new JLabel("Remarks:"));
//        panel.add(remarksField);
//
//        int result = JOptionPane.showConfirmDialog(
//                frame,
//                panel,
//                "Add New Visit",
//                JOptionPane.OK_CANCEL_OPTION,
//                JOptionPane.PLAIN_MESSAGE
//        );
//
//        if (result == JOptionPane.OK_OPTION) {
//            try {
//                ImmunizationPatient patient = controller.getPatientByPatientID(patientIdField.getText());
//                double weight = Double.parseDouble(weightField.getText());
//                patient.setWeightKG(weight); // Update patient's weight
//
//                return new Visit(patient, dateFormat.parse(dateField.getText()), remarksField.getText());
//            } catch (Exception e) {
//                System.err.println(e);
//                JOptionPane.showMessageDialog(
//                        frame,
//                        "Invalid input format",
//                        "Input Error",
//                        JOptionPane.ERROR_MESSAGE
//                );
//                return null;
//            }
//        }
//        return null;
//    }

//    /**
//     * Gets available vaccines for a patient based on age and weight
//     *
//     * @param patient The patient
//     * @param currentWeightKG The patient's current weight in kg
//     * @return List of available vaccines
//     */
//    private List<Vaccine> getAvailableVaccinesForPatient(ImmunizationPatient patient, double currentWeightKG) {
//        List<Vaccine> availableVaccines = new ArrayList<>();
//
//        // Get patient's age in years
//        long ageInMillis = System.currentTimeMillis() - patient.getDateOfBirth().getTime();
//        int ageInYears = (int) (ageInMillis / (1000L * 60 * 60 * 24 * 365));
//
//        // Load vaccines from CSV
//        try (InputStream in = getClass().getClassLoader().getResourceAsStream("vaccines.csv");
//             BufferedReader br = new BufferedReader(new InputStreamReader(in))) {
//
//            // Skip header
//            br.readLine();
//
//            String line;
//            while ((line = br.readLine()) != null) {
//                String[] values = line.split(",");
//                if (values.length >= 10) {
//                    try {
//                        int minAge = Integer.parseInt(values[8].trim());
//                        double minWeightKG = Double.parseDouble(values[9].trim());
//
//                        // Check if patient meets age and weight requirements
//                        if (ageInYears >= minAge && currentWeightKG >= minWeightKG) {
//                            availableVaccines.add(new Vaccine(
//                                    Integer.parseInt(values[0].trim()),
//                                    values[1].trim(),
//                                    values[2].trim(),
//                                    Double.parseDouble(values[3].trim()),
//                                    Integer.parseInt(values[4].trim()),
//                                    Integer.parseInt(values[5].trim()),
//                                    minAge,
//                                    "injection", // Default admin mode
//                                    "arm",       // Default admin location
//                                    null,        // Diseases treated (would need parsing)
//                                    minWeightKG
//                            ));
//                        }
//                    } catch (NumberFormatException e) {
//                        // Skip malformed lines
//                    }
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return availableVaccines;
//    }
}
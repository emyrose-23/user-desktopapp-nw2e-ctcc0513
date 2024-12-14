package group05_concertseatreservation_finalrequirement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Group05_ConcertSeatReservationForm02_FinalRequirement extends JFrame implements ActionListener {
    private JTextField txtFullName, txtContactNumber, txtAddress, txtGmail, txtOther;
    private JComboBox<String> paymentOptions, seatTypeDropdown, dateDropdown;
    private JRadioButton maleRadioButton, femaleRadioButton;
    private JCheckBox diabetesCheckBox, hypertensionCheckBox, asthmaCheckBox, noneCheckBox;

    public Group05_ConcertSeatReservationForm02_FinalRequirement() {
        setTitle("Concert Seat Reservation Form");
        setSize(800, 700); // Increased size for better visibility
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Background Image Path
        String backgroundImagePath = "image/FORM02BACKGROUND.png"; // Update
                                                                   // with
                                                                   // the
                                                                   // correct
                                                                   // path

        // Layered Pane to handle the background and components
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(800, 800));

        // Background Panel
        BackgroundPanel backgroundPanel = new BackgroundPanel(backgroundImagePath);
        backgroundPanel.setBounds(0, 0, 800, 800);
        layeredPane.add(backgroundPanel, JLayeredPane.DEFAULT_LAYER);

        // Main Panel to hold all form components
        JPanel contentPane = new JPanel(new GridBagLayout());
        contentPane.setOpaque(false); // Make it transparent to show the background image
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;

        // Font for labels
        Font labelFont = new Font("Times New Roman", Font.BOLD, 12);

        // Add components
        gbc.gridx = 0;
        gbc.gridy = 0;

        JLabel lblDate = new JLabel("Select Date:");
        lblDate.setFont(labelFont);
        contentPane.add(lblDate, gbc);

        gbc.gridx = 1;
        String[] dates = { "July 1, 2024", "July 2, 2024", "July 3, 2024", "July 4, 2024", "July 5, 2024" };
        dateDropdown = new JComboBox<>(dates);
        contentPane.add(dateDropdown, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        JLabel lblFullName = new JLabel("Full Name:");
        lblFullName.setFont(labelFont);
        contentPane.add(lblFullName, gbc);

        gbc.gridx = 1;
        txtFullName = new JTextField(20);
        contentPane.add(txtFullName, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        JLabel lblContactNumber = new JLabel("Contact Number:");
        lblContactNumber.setFont(labelFont);
        contentPane.add(lblContactNumber, gbc);

        gbc.gridx = 1;
        txtContactNumber = new JTextField(20);
        contentPane.add(txtContactNumber, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        JLabel lblAddress = new JLabel("Address:");
        lblAddress.setFont(labelFont);
        contentPane.add(lblAddress, gbc);

        gbc.gridx = 1;
        txtAddress = new JTextField(20);
        contentPane.add(txtAddress, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        JLabel lblGmail = new JLabel("Gmail:");
        lblGmail.setFont(labelFont);
        contentPane.add(lblGmail, gbc);

        gbc.gridx = 1;
        txtGmail = new JTextField(20);
        contentPane.add(txtGmail, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        JLabel lblSex = new JLabel("Sex:");
        lblSex.setFont(labelFont);
        contentPane.add(lblSex, gbc);

        gbc.gridx = 1;
        JPanel sexPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        sexPanel.setOpaque(false);
        maleRadioButton = new JRadioButton("Male");
        femaleRadioButton = new JRadioButton("Female");
        ButtonGroup sexGroup = new ButtonGroup();
        sexGroup.add(maleRadioButton);
        sexGroup.add(femaleRadioButton);
        sexPanel.add(maleRadioButton);
        sexPanel.add(femaleRadioButton);
        contentPane.add(sexPanel, gbc);

        // Health Conditions
        gbc.gridx = 0;
        gbc.gridy++;
        JLabel lblHealthConditions = new JLabel("Health Conditions:");
        lblHealthConditions.setFont(labelFont);
        contentPane.add(lblHealthConditions, gbc);

        gbc.gridx = 1;
        JPanel healthPanel = new JPanel(new GridLayout(3, 2));
        healthPanel.setOpaque(false);
        diabetesCheckBox = new JCheckBox("Fever/Cough");
        hypertensionCheckBox = new JCheckBox("Hypertension");
        asthmaCheckBox = new JCheckBox("Asthma");
        noneCheckBox = new JCheckBox("None");
        txtOther = new JTextField(10);
        healthPanel.add(diabetesCheckBox);
        healthPanel.add(hypertensionCheckBox);
        healthPanel.add(asthmaCheckBox);
        healthPanel.add(noneCheckBox);
        healthPanel.add(new JLabel("Others:"));
        healthPanel.add(txtOther);
        contentPane.add(healthPanel, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        JLabel lblPayment = new JLabel("Payment Transaction:");
        lblPayment.setFont(labelFont);
        contentPane.add(lblPayment, gbc);

        gbc.gridx = 1;
        String[] paymentOptionsList = { "GCASH", "PAYPAL", "PAYMAYA", "MAYA", "CREDIT CARD", "VISA" };
        paymentOptions = new JComboBox<>(paymentOptionsList);
        contentPane.add(paymentOptions, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        JLabel lblSeatSelection = new JLabel("Seat Selection:");
        lblSeatSelection.setFont(labelFont);
        contentPane.add(lblSeatSelection, gbc);

        gbc.gridx = 1;
        String[] seatTypes = { "VIP - ₱7000.00", "Patron - ₱6000.00", "Lower Box - ₱4500.00", "Upper Box - ₱2500.00",
                "Gen Add - ₱1500.00" };
        seatTypeDropdown = new JComboBox<>(seatTypes);
        contentPane.add(seatTypeDropdown, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        JButton btnSubmit = new JButton("Next");
        btnSubmit.addActionListener(this);
        contentPane.add(btnSubmit, gbc);

        // Add the content pane to the layered pane
        contentPane.setBounds(0, 0, 800, 800);
        layeredPane.add(contentPane, JLayeredPane.PALETTE_LAYER); // Add components above the background

        // Set the layered pane as the content pane
        setContentPane(layeredPane);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Next")) {
            // Collect data and proceed to the next form
            String fullName = txtFullName.getText().trim();
            String address = txtAddress.getText().trim();
            String contactNumber = txtContactNumber.getText().trim();
            String gmail = txtGmail.getText().trim();
            String sex = maleRadioButton.isSelected() ? "Male" : femaleRadioButton.isSelected() ? "Female" : "";

            // Health conditions
            StringBuilder healthConditions = new StringBuilder();
            if (diabetesCheckBox.isSelected())
                healthConditions.append("Fever/Cough ");
            if (hypertensionCheckBox.isSelected())
                healthConditions.append("Hypertension ");
            if (asthmaCheckBox.isSelected())
                healthConditions.append("Asthma ");
            if (noneCheckBox.isSelected())
                healthConditions = new StringBuilder("None ");
            String otherConditions = txtOther.getText().trim();
            if (!otherConditions.isEmpty())
                healthConditions.append(otherConditions);

            String payment = (String) paymentOptions.getSelectedItem();
            String seatInfo = (String) seatTypeDropdown.getSelectedItem();
            String date = (String) dateDropdown.getSelectedItem();

            // Extract seatType from seatInfo
            String seatType = ""; // Initialize seatType
            if (seatInfo != null && !seatInfo.isEmpty()) {
                String[] parts = seatInfo.split(" - ");
                if (parts.length > 1) {
                    seatType = parts[0]; // Extract the seat type (VIP, Patron, etc.)
                }
            }

            if (fullName.isEmpty() || address.isEmpty() || contactNumber.isEmpty() || gmail.isEmpty() || sex.isEmpty()
                    || payment.isEmpty() || seatInfo.isEmpty() || date.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill in all required fields.", "Warning",
                        JOptionPane.WARNING_MESSAGE);
            } else {
                // Insert data into the database
                boolean isInserted = JDBCUtils.insertReservation(fullName, contactNumber, address, gmail, sex,
                        healthConditions.toString(), payment, date, seatType);

                if (isInserted) {
                    // Open the next form with the collected data
                    new Group05_ConcertSeatReservationForm04_FinalRequirement(fullName, contactNumber, address, gmail,
                            sex, healthConditions.toString(), payment, date).setVisible(true);
                    this.dispose(); // Close the current form
                } else {
                    JOptionPane.showMessageDialog(this, "Failed to store data in the database.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    // Custom Panel to Paint Background Image
    private class BackgroundPanel extends JPanel {
        private Image backgroundImage;

        public BackgroundPanel(String imagePath) {
            try {
                backgroundImage = ImageIO.read(new File(imagePath));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (backgroundImage != null) {
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            }
        }

        @Override
        public Dimension getPreferredSize() {
            return backgroundImage == null ? super.getPreferredSize()
                    : new Dimension(backgroundImage.getWidth(this), backgroundImage.getHeight(this));
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Group05_ConcertSeatReservationForm02_FinalRequirement();
            }
        });
    }
}
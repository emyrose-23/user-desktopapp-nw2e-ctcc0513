package group05_concertseatreservation_finalrequirement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Group05_ConcertSeatReservationForm04_FinalRequirement extends JFrame implements ActionListener {
    private JButton btnSubmit;
    private JRadioButton[] seatRadioButtons;
    private String fullName, contactNumber, address, gmail, sex, healthConditions, payment, date;
    private String[] seatCategories;

    // Constructor updated to remove "username" parameter
    public Group05_ConcertSeatReservationForm04_FinalRequirement(String fullName, String contactNumber, String address,
            String gmail, String sex, String healthConditions, String payment, String date) {
        this.fullName = fullName;
        this.contactNumber = contactNumber;
        this.address = address;
        this.gmail = gmail;
        this.sex = sex;
        this.healthConditions = healthConditions;
        this.payment = payment;
        this.date = date;

        setTitle("Seat Plan");
        setSize(1300, 700); // Adjusted frame size
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Load the background image
        ImageIcon backgroundImageIcon = new ImageIcon(
                "image/FORM04BACKGROUND.png");
        Image backgroundImage = backgroundImageIcon.getImage().getScaledInstance(1300, 700, Image.SCALE_SMOOTH);

        // Create a custom panel with the background image
        BackgroundPanel backgroundPanel = new BackgroundPanel(backgroundImage);
        backgroundPanel.setLayout(new BorderLayout());

        // Seat plan panel
        ImageIcon seatPlanIcon = new ImageIcon(
                "image/STAGE.png");
        Image seatPlanImage = seatPlanIcon.getImage().getScaledInstance(900, 420, Image.SCALE_SMOOTH); // Adjusted image
                                                                                                       // size
        JLabel seatPlanImageLabel = new JLabel(new ImageIcon(seatPlanImage));
        seatPlanImageLabel.setBounds(400, 100, 50, 480);
        backgroundPanel.add(seatPlanImageLabel, BorderLayout.CENTER);

        // Panel for radio buttons
        JPanel radioPanel = new JPanel(new GridBagLayout());
        radioPanel.setOpaque(false); // Make panel transparent to show background image
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        seatRadioButtons = new JRadioButton[52];
        seatCategories = new String[52];
        ButtonGroup seatGroup = new ButtonGroup();

        // VIP Section (Top Right)
        JLabel lblVIP = new JLabel("VIP");
        lblVIP.setFont(new Font("Verdana", Font.BOLD, 14));
        lblVIP.setForeground(Color.BLACK); // Set text color for better visibility
        gbc.gridx = 6; // Right position
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;
        radioPanel.add(lblVIP, gbc);

        gbc.gridy++;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.CENTER;

        for (int i = 0; i < 3; i++) {
            seatRadioButtons[i] = new JRadioButton("Seat " + (i + 1));
            seatRadioButtons[i].setOpaque(false); // Make radio button transparent
            seatRadioButtons[i].setForeground(Color.BLACK); // Set text color for better visibility
            seatGroup.add(seatRadioButtons[i]);
            radioPanel.add(seatRadioButtons[i], gbc);
            seatCategories[i] = "VIP"; // Assign category to each seat
            gbc.gridx++;
        }

        // Patron Section (Top Left)
        JLabel lblPatron = new JLabel("Patron");
        lblPatron.setFont(new Font("Verdana", Font.BOLD, 14));
        lblPatron.setForeground(Color.BLACK); // Set text color for better visibility
        gbc.gridx = 0; // Left position
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;
        radioPanel.add(lblPatron, gbc);

        gbc.gridy++;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.CENTER;

        for (int i = 3; i < 6; i++) {
            seatRadioButtons[i] = new JRadioButton("Seat " + (i + 1));
            seatRadioButtons[i].setOpaque(false); // Make radio button transparent
            seatRadioButtons[i].setForeground(Color.BLACK); // Set text color for better visibility
            seatGroup.add(seatRadioButtons[i]);
            radioPanel.add(seatRadioButtons[i], gbc);
            seatCategories[i] = "Patron"; // Assign category to each seat
            gbc.gridx++;
        }

        // Lower Box Section (Below VIP)
        JLabel lblLowerBox = new JLabel("Lower Box");
        lblLowerBox.setFont(new Font("Verdana", Font.BOLD, 14));
        lblLowerBox.setForeground(Color.BLACK); // Set text color for better visibility
        gbc.gridx = 6;
        gbc.gridy = 6;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;
        radioPanel.add(lblLowerBox, gbc);

        gbc.gridy++;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.CENTER;

        for (int i = 6; i < 20; i++) {
            seatRadioButtons[i] = new JRadioButton("Seat " + (i + 1));
            seatRadioButtons[i].setOpaque(false); // Make radio button transparent
            seatRadioButtons[i].setForeground(Color.BLACK); // Set text color for better visibility
            seatGroup.add(seatRadioButtons[i]);
            radioPanel.add(seatRadioButtons[i], gbc);
            seatCategories[i] = "Lower Box"; // Assign category to each seat
            gbc.gridx++;
            if (gbc.gridx % 5 == 1) { // Corrected for alignment under VIP
                gbc.gridx = 6;
                gbc.gridy++;
            }
        }

        // Upper Box Section (Below Patron)
        JLabel lblUpperBox = new JLabel("Upper Box");
        lblUpperBox.setFont(new Font("Verdana", Font.BOLD, 14));
        lblUpperBox.setForeground(Color.BLACK); // Set text color for better visibility
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;
        radioPanel.add(lblUpperBox, gbc);

        gbc.gridy++;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.CENTER;

        for (int i = 20; i < 36; i++) {
            seatRadioButtons[i] = new JRadioButton("Seat " + (i + 1));
            seatRadioButtons[i].setOpaque(false); // Make radio button transparent
            seatRadioButtons[i].setForeground(Color.BLACK); // Set text color for better visibility
            seatGroup.add(seatRadioButtons[i]);
            radioPanel.add(seatRadioButtons[i], gbc);
            seatCategories[i] = "Upper Box"; // Assign category to each seat
            gbc.gridx++;
            if (gbc.gridx % 5 == 0) {
                gbc.gridx = 0;
                gbc.gridy++;
            }
        }

        // Gen Add Section (Occupies the remaining space below Lower and Upper Box)
        JLabel lblGenAdd = new JLabel("Gen Add");
        lblGenAdd.setFont(new Font("Verdana", Font.BOLD, 14));
        lblGenAdd.setForeground(Color.BLACK); // Set text color for better visibility
        gbc.gridx = 0;
        gbc.gridy = gbc.gridy + 5; // Start after the last row of Upper Box
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;
        radioPanel.add(lblGenAdd, gbc);

        gbc.gridy++;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.CENTER;

        for (int i = 36; i < 52; i++) {
            seatRadioButtons[i] = new JRadioButton("Seat " + (i + 1));
            seatRadioButtons[i].setOpaque(false); // Make radio button transparent
            seatRadioButtons[i].setForeground(Color.BLACK); // Set text color for better visibility
            seatGroup.add(seatRadioButtons[i]);
            radioPanel.add(seatRadioButtons[i], gbc);
            seatCategories[i] = "Gen Add"; // Assign category to each seat
            gbc.gridx++;
            if (gbc.gridx % 5 == 0) {
                gbc.gridx = 0;
                gbc.gridy++;
            }
        }

        backgroundPanel.add(radioPanel, BorderLayout.NORTH); // Add radio panel to the background panel

        // Submit button panel
        btnSubmit = new JButton("Submit");
        btnSubmit.addActionListener(this);
        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnPanel.setOpaque(false); // Make panel transparent to show background image
        btnPanel.add(btnSubmit);
        backgroundPanel.add(btnPanel, BorderLayout.SOUTH); // Add button panel to the background panel

        setContentPane(backgroundPanel); // Set the custom panel as the content pane
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSubmit) {
            String selectedSeat = null;
            String selectedCategory = null;
            for (int i = 0; i < seatRadioButtons.length; i++) {
                if (seatRadioButtons[i].isSelected()) {
                    selectedSeat = seatRadioButtons[i].getText();
                    selectedCategory = seatCategories[i];
                    break;
                }
            }

            if (selectedSeat != null && selectedCategory != null) {
                String seatInfo = selectedCategory + " - " + selectedSeat;

                // Adjusted to remove "username" from the constructor
                new Group05_ConcertSeatReservationForm03_FinalRequirement(fullName, contactNumber, address, gmail, sex,
                        healthConditions, payment, seatInfo, date).setVisible(true);
                setVisible(false);
            } else {
                JOptionPane.showMessageDialog(this, "Please select a seat before submitting.");
            }
        }
    }

    // Custom panel to paint the background image
    private class BackgroundPanel extends JPanel {
        private Image backgroundImage;

        public BackgroundPanel(Image backgroundImage) {
            this.backgroundImage = backgroundImage;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Adjusted to remove "username" from the constructor
            new Group05_ConcertSeatReservationForm04_FinalRequirement("", "", "", "", "", "", "", "");
        });
    }
}
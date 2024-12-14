package group05_concertseatreservation_finalrequirement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Group05_ConcertSeatReservationForm03_FinalRequirement extends JFrame implements ActionListener {
    private JButton btnCancel, btnConfirm;

    // Updated constructor to remove the "username" parameter
    public Group05_ConcertSeatReservationForm03_FinalRequirement(String fullName, String contactNumber, String address,
            String gmail, String sex, String healthConditions, String payment, String seat, String date) {
        setTitle("Review Your Information");
        setSize(600, 400); // Adjusted size for better display
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Load the background image as a resource
        BackgroundPanel contentPane = new BackgroundPanel(
                "group05_concertseatreservation_finalrequirement\\image\\FORM03BACKGROUND.png");
        contentPane.setLayout(new BorderLayout());
        setContentPane(contentPane);

        // Create a JPanel with GridBagLayout for the center area
        JPanel centerPanel = new JPanel(new GridBagLayout());
        centerPanel.setOpaque(false); // Make the panel transparent

        // GridBagConstraints for labels alignment
        GridBagConstraints labelGbc = new GridBagConstraints();
        labelGbc.gridx = 0;
        labelGbc.gridy = 0;
        labelGbc.anchor = GridBagConstraints.WEST; // Align labels to the left
        labelGbc.insets = new Insets(5, 5, 5, 10); // Padding around labels

        // GridBagConstraints for values alignment
        GridBagConstraints valueGbc = new GridBagConstraints();
        valueGbc.gridx = 1;
        valueGbc.gridy = 0;
        valueGbc.anchor = GridBagConstraints.WEST; // Align values to the left
        valueGbc.insets = new Insets(5, 0, 5, 5); // Padding around values

        // Adding components to centerPanel
        addLabelAndValue(centerPanel, labelGbc, valueGbc, "THANK YOU FOR AVAILING!", "", 20, Font.BOLD);
        addLabelAndValue(centerPanel, labelGbc, valueGbc, "Date:", date, 14, Font.PLAIN);
        addLabelAndValue(centerPanel, labelGbc, valueGbc, "Full Name:", fullName, 14, Font.PLAIN);
        addLabelAndValue(centerPanel, labelGbc, valueGbc, "Contact Number:", contactNumber, 14, Font.PLAIN);
        addLabelAndValue(centerPanel, labelGbc, valueGbc, "Gmail:", gmail, 14, Font.PLAIN);
        addLabelAndValue(centerPanel, labelGbc, valueGbc, "Sex:", sex, 14, Font.PLAIN);
        addLabelAndValue(centerPanel, labelGbc, valueGbc, "Health Conditions:",
                healthConditions.isEmpty() ? "" : healthConditions, 14, Font.PLAIN);
        addLabelAndValue(centerPanel, labelGbc, valueGbc, "Payment Transaction:", payment, 14, Font.PLAIN);
        addLabelAndValue(centerPanel, labelGbc, valueGbc, "Seat Selection:", seat, 14, Font.PLAIN);

        contentPane.add(centerPanel, BorderLayout.CENTER);

        // Button panel at the bottom
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setOpaque(false); // Make the button panel transparent
        btnCancel = new JButton("Cancel");
        btnCancel.addActionListener(this);
        buttonPanel.add(btnCancel);
        btnConfirm = new JButton("Confirm");
        btnConfirm.addActionListener(this);
        buttonPanel.add(btnConfirm);
        contentPane.add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    // Method to add a label and its value to the centerPanel
    private void addLabelAndValue(JPanel panel, GridBagConstraints labelGbc, GridBagConstraints valueGbc,
            String labelText, String valueText, int fontSize, int fontStyle) {
        JLabel label = new JLabel(labelText);
        label.setFont(new Font("Times New Roman", fontStyle, fontSize));
        panel.add(label, labelGbc);

        if (!valueText.isEmpty()) {
            JLabel value = new JLabel(valueText);
            value.setFont(new Font("Times New Roman", Font.PLAIN, fontSize));
            panel.add(value, valueGbc);
        }

        // Increment both y positions for the next label and value pair
        labelGbc.gridy++;
        valueGbc.gridy++;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnCancel) {
            // Cancel button clicked
            dispose(); // Close the current form
            new Group05_ConcertSeatReservationForm02_FinalRequirement().setVisible(true); // Display Form2
        } else if (e.getSource() == btnConfirm) {
            // Confirm button clicked
            JOptionPane.showMessageDialog(this, "Thank you for registering!");
            dispose(); // Close the current form
        }
    }

    public static void main(String[] args) {
        // Updated main method to remove "username" parameter
        SwingUtilities.invokeLater(
                () -> new Group05_ConcertSeatReservationForm03_FinalRequirement("", "", "", "", "", "", "", "", "")
                        .setVisible(true));
    }

    private class BackgroundPanel extends JPanel {
        private Image backgroundImage;

        public BackgroundPanel(String imagePath) {
            try {
                // Load the image from the classpath
                backgroundImage = ImageIO.read(getClass()
                        .getResource("/resources/FORM03BACKGROUND.png"));
            } catch (IOException e) {
                System.err.println("Error loading image: " + e.getMessage());
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
    }
}

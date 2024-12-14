package group05_concertseatreservation_finalrequirement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Group05_ConcertSeatRegistrationForm extends JFrame implements ActionListener {
    private JLabel lblUsername, lblPassword;
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JButton btnRegister, btnCancel;

    public Group05_ConcertSeatRegistrationForm() {
        setTitle("Log In Form");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Background Panel
        BackgroundPanel bgPanel = new BackgroundPanel(
                "image/LOGIN.png");
        bgPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        // Labels and Text Fields
        lblUsername = new JLabel("Username:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        bgPanel.add(lblUsername, gbc);

        txtUsername = new JTextField(20);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        bgPanel.add(txtUsername, gbc);

        lblPassword = new JLabel("Password:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        bgPanel.add(lblPassword, gbc);

        txtPassword = new JPasswordField(20);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        bgPanel.add(txtPassword, gbc);

        // Button Panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnRegister = new JButton("Register");
        btnRegister.addActionListener(this);
        buttonPanel.add(btnRegister);

        btnCancel = new JButton("Cancel");
        btnCancel.addActionListener(this);
        buttonPanel.add(btnCancel);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        bgPanel.add(buttonPanel, gbc);

        add(bgPanel, BorderLayout.CENTER);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnRegister) {
            String username = txtUsername.getText().trim();
            String password = new String(txtPassword.getPassword()).trim();

            if (username.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter both username and password.", "Warning",
                        JOptionPane.WARNING_MESSAGE);
            } else {
                // Attempt to register user in database
                boolean registered = registerUser(username, password);

                if (registered) {
                    JOptionPane.showMessageDialog(this, "Registration successful!");
                    // Optionally, redirect to login form or perform other actions
                    dispose(); // Close registration form
                    // Open the next form (Group05_ConcertSeatReservationForm02_FinalRequirement)
                    new Group05_ConcertSeatReservationForm02_FinalRequirement().setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(this, "Registration failed. Please try again.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        } else if (e.getSource() == btnCancel) {
            dispose(); // Close the registration form
            // Optionally, redirect to login form or perform other actions
        }
    }

    private boolean registerUser(String username, String password) {
        // Use JDBCUtils to insert into database
        String sql = "INSERT INTO users (username, password) VALUES (?, ?)";
        try {
            PreparedStatement statement = JDBCUtils.getConnection().prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, password);
            int rowsInserted = statement.executeUpdate();
            statement.close();
            return rowsInserted > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Group05_ConcertSeatRegistrationForm::new);
    }
}

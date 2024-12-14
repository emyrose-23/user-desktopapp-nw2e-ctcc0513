package group05_concertseatreservation_finalrequirement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

public class JDBCUtils {

    // JDBC URL, username, and password of MySQL server
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/concert_seat_reservation";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
    }

    public static boolean insertReservation(String fullName, String contactNumber, String address, String gmail,
            String sex, String healthConditions, String payment, String date, String seat) {
        boolean inserted = false;
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = getConnection();
            // Convert date string to java.util.Date
            SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM d, yyyy");
            java.util.Date parsedDate = dateFormat.parse(date);

            // Convert java.util.Date to java.sql.Date
            java.sql.Date sqlDate = new java.sql.Date(parsedDate.getTime());

            String sql = "INSERT INTO reservations (full_name, contact_number, address, gmail, sex, health_conditions, payment, reservation_date, seat_type) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, fullName);
            stmt.setString(2, contactNumber);
            stmt.setString(3, address);
            stmt.setString(4, gmail);
            stmt.setString(5, sex);
            stmt.setString(6, healthConditions);
            stmt.setString(7, payment);
            stmt.setDate(8, sqlDate); // Use setDate for SQL date columns
            stmt.setString(9, seat);

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                inserted = true;
            } else {
                throw new SQLException("No rows affected, insertion failed.");
            }
        } catch (SQLException | ParseException e) {
            e.printStackTrace(); // For debugging, replace with proper logging
            JOptionPane.showMessageDialog(null, "Failed to store data in the database: " + e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return inserted;
    }
}

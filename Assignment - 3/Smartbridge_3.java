package practice;
import java.sql.*;
import java.util.Scanner;

public class Smartbridge_3 {
    public static void main(String[] args){
        try {
            // 1. Register the driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. Connection
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/beginner", "root", "alens");
            Statement stmt = conn.createStatement();

            // 3. Select query - Display entire table
            System.out.println("---- Original Table ----");
            ResultSet selectResult = stmt.executeQuery("SELECT * FROM employee");
            displayResultSet(selectResult);

            // 4. Update query - Update a row
            String updateQuery = "UPDATE employee SET city = 'New York City' WHERE emp_id = 3";
            int rowsUpdated = stmt.executeUpdate(updateQuery);
            System.out.println(rowsUpdated + " row(s) updated.");

            // 5. Select query - Display updated row
            System.out.println("---- Updated Row ----");
            ResultSet updatedRowResult = stmt.executeQuery("SELECT * FROM employee WHERE emp_id = 1");
            displayResultSet(updatedRowResult);

            // 6. Delete query - Delete a row
            String deleteQuery = "DELETE FROM employee WHERE emp_id = 2";
            int rowsDeleted = stmt.executeUpdate(deleteQuery);
            System.out.println(rowsDeleted + " row(s) deleted.");

            // 7. Insert query - Insert a new row
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the details for the new employee:");
            System.out.print("emp_id (Integer): ");
            int empId = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            System.out.print("emp_name (String): ");
            String empName = scanner.nextLine();
            System.out.print("address (String): ");
            String address = scanner.nextLine();
            System.out.print("city (String): ");
            String city = scanner.nextLine();
            System.out.print("postal_code (Integer): ");
            int postalCode = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            System.out.print("country (String): ");
            String country = scanner.nextLine();

            String insertQuery = "INSERT INTO employee (emp_id, emp_name, address, city, postal_code, country) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement insertStmt = conn.prepareStatement(insertQuery);
            insertStmt.setInt(1, empId);
            insertStmt.setString(2, empName);
            insertStmt.setString(3, address);
            insertStmt.setString(4, city);
            insertStmt.setInt(5, postalCode);
            insertStmt.setString(6, country);
            int rowsInserted = insertStmt.executeUpdate();
            System.out.println(rowsInserted + " row(s) inserted.");

            // 8. Select query - Display updated table
            System.out.println("---- Updated Table ----");
            ResultSet updatedTableResult = stmt.executeQuery("SELECT * FROM employee");
            displayResultSet(updatedTableResult);

            // 9. Close the resources
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Helper method to display the ResultSet as a table
    private static void displayResultSet(ResultSet rs) throws SQLException {
        ResultSetMetaData metaData = rs.getMetaData();
        int columnCount = metaData.getColumnCount();

        // Display header names
        for (int i = 1; i <= columnCount; i++) {
            String columnName = metaData.getColumnName(i);
            System.out.printf("%-15s", columnName);
        }
        System.out.println();

        // Display data rows
        while (rs.next()) {
            for (int i = 1; i <= columnCount; i++) {
                String columnValue = rs.getString(i);
                if (i == 3 || i == 4) {
                    System.out.printf("%-25s", columnValue);
                } else {
                    System.out.printf("%-15s", columnValue);
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}


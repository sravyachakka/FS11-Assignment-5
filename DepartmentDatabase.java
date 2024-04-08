import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DepartmentDatabase {
    public static void main(String[] args) {
        // 1. Register the MySQL driver
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver not found: " + e.getMessage());
            return;
        }

        // 2. Open a connection to the database
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/departments", "root", "password")) {
            // 3. Create a Statement object
            Statement stmt = conn.createStatement();

            // 4. Execute a SQL statement to create the 'department' table
            String sql = "CREATE TABLE IF NOT EXISTS department ("
                    + "id INT NOT NULL PRIMARY KEY,"
                    + "name VARCHAR(255) NOT NULL"
                    + ")";
            stmt.executeUpdate(sql);

            // 5. Insert a few Department objects into the 'department' table
            sql = "INSERT INTO department VALUES (1, 'IT'), (2, 'HR'), (3, 'Finance')";
            stmt.executeUpdate(sql);

            // 6. Clean up
            stmt.close();
        } catch (Exception e) {
            System.out.println("Error connecting to the database: " + e.getMessage());
        }
    }
}
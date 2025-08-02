import java.util.Scanner;
import java.sql.*;

public class Program_02 {
    public static void main(String[] args) {
        // Step 1: Declare outside try so we can use in finally
        Connection conn = null;

        try {
            // Step 2: Load the Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 3: Create Connection
            String url = "jdbc:mysql://localhost:3306/aditya_jdbc";
            String username = "root";
            String password = "admin";
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("✅ Connected to aditya_jdbc");

            // Step 4: Scanner for input
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter NAME: ");
            String name = sc.next();
            System.out.print("Enter AGE: ");
            int age = sc.nextInt();

            // Step 5: Prepare query (CORRECT KEYWORD: INSERT)
            String sql = "INSERT INTO students (name, age) VALUES (?, ?)";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, name);
            pst.setInt(2, age);

            // Step 6: Execute query
            int rows = pst.executeUpdate(); // executeUpdate() JDBC ka ek method hai jo INSERT, UPDATE, DELETE jaise queries ko run karta hai.
            if (rows > 0) {
                System.out.println("✅ Data inserted successfully!");
            } else {
                System.out.println("❌ Insert failed.");
            }

            sc.close(); // Close scanner

        } catch (Exception e) {
            e.printStackTrace(); // Error trace
        } finally {
            // Step 7: Close connection safely
            try {
                if (conn != null) {
                    conn.close();
                    System.out.println("🔌 Connection closed.");
                }
            } catch (SQLException e) {
                e.printStackTrace(); // Error trace
            }
        }
    }
}

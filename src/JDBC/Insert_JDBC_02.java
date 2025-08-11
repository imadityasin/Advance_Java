package JDBC;
import java.sql.*;
import java.util.Scanner;

public class Insert_JDBC_02 {
    public static void main(String[] args) {
        Connection conn=null;

        // Step 1: Load the Driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Connection Establishment
            String url = "jdbc:mysql://localhost:3306/wz3100"; // Change to your DB name
            String username = "root"; // Change to your DB username
            String password = "Adityahindustantimes@123"; // Change to your DB password

            conn = DriverManager.getConnection(url, username, password);

            // Step 3: Take input from user
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter Name : ");
            String name = sc.nextLine();

            System.out.print("Enter Mobile Number : ");
            String mobile = sc.nextLine();

            System.out.print("Enter Occupation : ");
            String occupation = sc.nextLine();

            System.out.print("Enter Age : ");
            int age = sc.nextInt();

            // Step 4: Write SQL insert query
            String query = "INSERT INTO UpperGroundFloor (name, mobile, occupation, age) VALUES (?, ?, ?, ?)";

            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, name);
            pst.setString(2, mobile);
            pst.setString(3, occupation);
            pst.setInt(4, age);

            int rows = pst.executeUpdate();
            if (rows > 0) {
                System.out.println("✅ Data inserted successfully!");
            } else {
                System.out.println("❌ Data insertion failed.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try{
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

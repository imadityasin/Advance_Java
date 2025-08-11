package JDBC;

import java.util.Scanner;
import java.sql.*;

public class Update_01 {
    public static void main(String[] args) {
        Connection conn = null;

        try {
            // Step 1: Load the Driver.
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Connection Establishment.
            String url = "jdbc:mysql://localhost:3306/WZ3100";
            String username = "root";
            String password = "Adityahindustantimes@123";

            conn = DriverManager.getConnection(url, username, password);

            // Step 3: Taking Values
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Mobile Number: ");
            String mobile = sc.nextLine();

            System.out.print("Enter Occupation: ");
            String occupation = sc.nextLine();

            System.out.print("Enter Age: ");
            int age = sc.nextInt();

            // Step 4: SQL Query
            String sql = "INSERT INTO UpperGroundFloor (name, mobile, occupation, age) VALUES (?, ?, ?, ?)";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, name);
            pst.setString(2, mobile);
            pst.setString(3, occupation);
            pst.setInt(4, age);

            int rows = pst.executeUpdate();

            if (rows > 0) {
                System.out.println("✅ Data Inserted Successfully");
            } else {
                System.out.println("❌ Data Not Inserted");
            }

            // UPDATE DATA
            System.out.println("Do you want to update data? Press 1 for Yes, 2 for No");
            int in = sc.nextInt();

            if (in == 1) {
                System.out.print("Enter the mobile number of the record to update: ");
                long updateMobile = sc.nextLong();
                sc.nextLine(); // consume newline

                System.out.println("What do you want to update?");
                System.out.println("1. Name");
                System.out.println("2. Mobile Number");
                System.out.println("3. Occupation");
                System.out.println("4. Age");
                System.out.print("Enter your choice: ");
                int cho = sc.nextInt();
                sc.nextLine(); // consume newline

                String updateQuery = "";
                PreparedStatement pst1;
                int updated = 0;

                switch (cho) {
                    case 1:
                        System.out.print("Enter the New Name: ");
                        String newName = sc.nextLine();
                        updateQuery = "UPDATE UpperGroundFloor SET name = ? WHERE mobile = ?";
                        pst1 = conn.prepareStatement(updateQuery);
                        pst1.setString(1, newName);
                        pst1.setLong(2, updateMobile);
                        updated = pst1.executeUpdate();
                        break;

                    case 2:
                        System.out.print("Enter the New Mobile Number: ");
                        long newMobile = sc.nextLong();
                        updateQuery = "UPDATE UpperGroundFloor SET mobile = ? WHERE mobile = ?";
                        pst1 = conn.prepareStatement(updateQuery);
                        pst1.setLong(1, newMobile);
                        pst1.setLong(2, updateMobile);
                        updated = pst1.executeUpdate();
                        break;

                    case 3:
                        System.out.print("Enter the New Occupation: ");
                        String newOcc = sc.nextLine();
                        updateQuery = "UPDATE UpperGroundFloor SET occupation = ? WHERE mobile = ?";
                        pst1 = conn.prepareStatement(updateQuery);
                        pst1.setString(1, newOcc);
                        pst1.setLong(2, updateMobile);
                        updated = pst1.executeUpdate();
                        break;

                    case 4:
                        System.out.print("Enter the New Age: ");
                        int newAge = sc.nextInt();
                        updateQuery = "UPDATE UpperGroundFloor SET age = ? WHERE mobile = ?";
                        pst1 = conn.prepareStatement(updateQuery);
                        pst1.setInt(1, newAge);
                        pst1.setLong(2, updateMobile);
                        updated = pst1.executeUpdate();
                        break;

                    default:
                        System.out.println("Invalid choice.");
                        break;
                }

                if (updated > 0) {
                    System.out.println("Data Updated Successfully");
                } else if (cho >= 1 && cho <= 4) {
                    System.out.println("Update Failed. Record may not exist.");
                }

            } else if (in == 2) {
                System.out.println("No update selected.");
            } else {
                System.out.println("Invalid input.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

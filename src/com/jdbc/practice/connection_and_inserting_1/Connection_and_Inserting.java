package com.jdbc.practice.connection_and_inserting_1;

import java.sql.*;
import java.util.Scanner;

public class Connection_and_Inserting {
    public static void main(String[] args) {
        Connection conn = null;

        try {
            // Step 1: Load the Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Connection Establishment
            String url = "jdbc:mysql://localhost:3306/practiceJDBC";
            String username = "root";
            String password = "admin";
            conn = DriverManager.getConnection(url, username, password);

            // Step 3: Taking input from user
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter Your Name: ");
            String name = sc.nextLine(); // Space wala name bhi chalega

            System.out.println("Enter Age: ");
            int age = sc.nextInt();

            System.out.println("Enter Mobile Number: ");
            long number = sc.nextLong();

            // Step 4: Write SQL Query
            String sql = "INSERT INTO insertJDBC (name, age, number) VALUES (?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setInt(2, age);
            ps.setLong(3, number);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Data Inserted Successfully");
            } else {
                System.out.println("Data Insertion Failed");
            }

            sc.close();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) { // Null check sahi kiya
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

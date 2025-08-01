

import java.util.Scanner;
import java.sql.*;

public class Program_02 {
    public static void main(String[] args) {
        try{
//            Step 1 : Load The Driver.
            Class.forName("com.mysql.cj.jdbc.Driver");

//            Step 2 : Create Connection
            String url = "jdbc:mysql://localhost:3306/aditya_jdbc";
            String username = "root";
            String password = "admin";

            Connection conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to aditya_jdbc");

//            Taking values and updating.
            Scanner sc =  new Scanner (System.in);
            System.out.println("Enter ID: ");
            int id=sc.nextInt();
            System.out.println("Enter NAME : ");
            String name=sc.next();
            System.out.println("Enter AGE : ");
            int age=sc.nextInt();

            String sql = "INSERTING INTO students (name, age) VALUES (?, ?)";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(name);

        } catch (Exception e) {
            e.printStackTrace(); // This will Show if error occurs then whats the error?.
        }
    }
}

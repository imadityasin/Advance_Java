
import java.util.Scanner;
import java.sql.*;

public class main {
    public static void main(String[] args) {
        try{
            // Step 1 : Load the Driver.
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2 : Create Connection.
            String url = "jdbc:mysql://localhost:3306/testdb";
            String username = "root";
            String password = "admin";

            Connection conn = DriverManager.getConnection(url, username, password);

            // Step 3 : Print Success Message.
            System.out.println("Connected successfully to the Database ! ");

            //Step 4 : Close the connection.
            conn.close();

        } catch (Exception e) {
            e.printStackTrace(); // Error Dikhao Connection fail hua hai toh kya problem aayi.
        }
    }
}

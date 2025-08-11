package JDBC;

import java.util.Scanner;
import java.sql.*;

public class Insert_JDBC {
    public static void main(String[] args) {
        Connection conn=null;

        try{
//            Step : 1 : Load Driver.
//            Aaj kal new JVM m automatically load ho jate hai.
            Class.forName("com.mysql.cj.jdbc.Driver");

//            Step : 2 : Create Connection.
            String url = "jdbc:mysql://localhost:3306/aditya_jdbc";
            String username = "root";
            String password = "Adityahindustantimes@123";

            conn=DriverManager.getConnection(url, username, password);

//            Step : 3 : Inserting Data.
            Scanner sc=new Scanner(System.in);

            System.out.println("Enter Name : ");
            String name=sc.nextLine();

            System.out.println("Enter Age : ");
            int age=sc.nextInt();

//            Step : 4 : SQL Query
            String sql="Insert into students (name, age) VALUES (?,?)";
            PreparedStatement pst=conn.prepareStatement(sql);
            pst.setString(1, name);
            pst.setInt(2, age);

            int rows=pst.executeUpdate();

            if(rows > 0) {
                System.out.println("Student Data Inserted Successfully ");
            } else {
                System.out.println("Student Data Insertion Failed ");
            }

//            Step : 5 :
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try{
//                Pehle check kar lo ki conn object bana bhi hai ya nahi,
//                tabhi conn.close() call karo.
                if (conn != null) {
                    conn.close();
                    System.out.println("Connection Closed");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}

package com.jdbc.practice.connection_program_1;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFile {
    public static void main(String[] args) {
        Connection conn=null;

        try{
//            Step 1: Load the Driver.
            Class.forName("com.mysql.cj.jdbc.Driver");

//            Step 2: Connection establish.
            String url="jdbc:mysql://localhost:3306/aditya_jdbc";
            String username="root";
            String password="admin";
            conn= DriverManager.getConnection(url ,username, password);

//            Step 3: Print
            System.out.println("Connection Establish Successful");

        } catch (Exception e){
            e.printStackTrace();
        } finally {
//            Close the connection prevent resources leaks
            try{
                if(conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

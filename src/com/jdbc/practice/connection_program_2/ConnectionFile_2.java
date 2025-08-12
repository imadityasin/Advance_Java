package com.jdbc.practice.connection_program_2;

import java.sql.Connection;

public class ConnectionFile_2 {
    public static void main(String[] args) {
        Connection conn=null;

        try{
//            Step 1: Load The Driver.
            Class.forName("com.mysql.cj.jdbc.Driver");

//            Step 2: Connection Establishment.
            String url="jdbc:mysql://localhost:3306/aditya_jdbc";
            String username="admin";
            String password="root";

//            Printing the message.
            System.out.println("Connection Establishment is Successful");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try{
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

package JDBC;

import java.util.Scanner;
import java.sql.*;

public class Select_JDBC_01 {
    public static void main(String[] args) {
        String url="com.mysql.cj.jdbc.Driver";
        String username="root";
        String password="admin";

        try {
            //        Load the Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

        } catch (Exception e ) {
            e.printStackTrace();
        }
    }
}

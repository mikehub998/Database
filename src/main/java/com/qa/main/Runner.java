package com.qa.main;

import com.qa.Domain.DatabaseConnection;
import com.qa.utility.DatabaseConfig;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Runner {
    public static void main(String[] args) {
        try {
            DatabaseConnection db =  new DatabaseConnection();
            db.updateDB(3, "bye");
            db.read();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
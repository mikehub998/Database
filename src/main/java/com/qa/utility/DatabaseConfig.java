package com.qa.utility;


public class DatabaseConfig {

    public static String USERNAME = "root";

    public static String PASSWORD = "root123!A";

    public final static String URL = "jdbc:mysql://" +
            "qa-rds.ctg5o8cgyv5v.eu-west-2.rds.amazonaws.com:3306/" +
            "mike_db?" +
            "useUnicode =true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
}

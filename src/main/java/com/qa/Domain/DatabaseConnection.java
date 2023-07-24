package com.qa.Domain;

import com.qa.utility.DatabaseConfig;

import javax.xml.crypto.Data;
import java.sql.*;

public class DatabaseConnection {

    private PreparedStatement ps;
    private ResultSet rs;
    private Connection con;
    public DatabaseConnection() throws SQLException {

        con = DriverManager.getConnection(DatabaseConfig.URL, DatabaseConfig.USERNAME, DatabaseConfig.PASSWORD);
    }
// create
    public void create(int id, String str) throws SQLException {
        String sql = "INSERT INTO mike_example_table(exampleID, exampleStr) VALUE (?,?)";
        ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        ps.setString(2, str);
        ps.execute();
        System.out.println("Created new example item..");

    }
// readAll
    public void read() throws SQLException {
        String sql = "SELECT * FROM mike_example_table";
        ps = con.prepareStatement(sql);
        rs = ps.executeQuery();
        if(!rs.next()) {
            System.out.println("No data found");
        }
        else {
            do {
                System.out.println(rs.getInt("exampleID") + rs.getString("exampleStr"));
            } while(rs.next());
        }
    }

//    read by id
    public void readIndividual(int id) throws SQLException {
        String sql = "SELECT * FROM mike_example_table where exampleID = ?";
        ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        rs = ps.executeQuery();
        if (rs.next()) {
            System.out.println("No data found");
        } else {
            do {
                System.out.println(rs.getInt("exampleID"));
            } while (rs.next());
        }
    }

//    update a database
    public boolean updateDB(int id, String str) throws SQLException {
        String sql = "UPDATE mike_example_table SET exampleStr =? WHERE exampleID = ?";
        ps = con.prepareStatement(sql);
        ps.setString(1, str);
        ps.setInt(2, id);
        ps.executeUpdate();
        System.out.println(String.format("Database updated at id: %d, with %s", id, str));
        return ps.execute();

    }

//    delete a database
    public boolean deleteDB(int id) throws SQLException {
        String sql = "DELETE FROM mike_example_table WHERE exampleID = ?";
        ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
        System.out.println("Database deleted");
        return ps.execute();
    }

//    closedown a database
    public void tearDown(int id) throws SQLException {
        con.close();
    }



}

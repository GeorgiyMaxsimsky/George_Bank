package GBDB;

import GBDB.Util.ConnectionManager;

import java.sql.Connection;
import java.sql.SQLException;


/**
 This class establishes a connection to the database using the Connection Manager.open() method
 */


public class GBDBRunner {


    public static void main(String[] args) throws SQLException {
        try (Connection connection = ConnectionManager.open()) {
            System.out.println(connection.getTransactionIsolation());
        }
    }


}

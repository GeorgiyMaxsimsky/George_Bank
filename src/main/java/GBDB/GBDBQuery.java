package GBDB;

import GBDB.Util.ConnectionManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;





/**
 this class is designed to execute sql queries
 */

public class GBDBQuery {


    static String sql = """
            create table client_passport(
            client_id  serial unique not null,
            p_serial varchar unique not null CHECK (length(p_serial)=4 ),
            p_number varchar unique not null CHECK (length(p_number)=6 ),
            client_first_name varchar (100),
            client_last_name varchar (100),
            client_surname varchar (100),
            birthdate date,
            registration varchar,
            former_passport_id int,
            
            
            CONSTRAINT FK_client_id FOREIGN KEY (client_id) REFERENCES client_account(client_id),
            CONSTRAINT PK_client_id PRIMARY KEY (client_id)
           ) 
            
            
            """;


    public static void main(String[] args) throws SQLException {
        try (Connection connection = ConnectionManager.open()) {

            Statement statement = connection.createStatement();
            System.out.println(connection.getTransactionIsolation());
            statement.execute(sql);
        }
    }
}

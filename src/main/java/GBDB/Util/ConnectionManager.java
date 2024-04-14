package GBDB.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    private static final String PASSWORD_KEY = "gbdb.password";
    private static final String USER_KEY = "gbdb.user";
    private static final String URL_KEY = "gbdb.url";

public static Connection open(){

    try {
        return DriverManager.getConnection(
        PropertiesUtil.get(URL_KEY),
         PropertiesUtil.get(USER_KEY),
         PropertiesUtil.get(PASSWORD_KEY)
        );
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }


}
    
    static {
        
        loadDriver();
        
    }

    private static void loadDriver() {

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }


}

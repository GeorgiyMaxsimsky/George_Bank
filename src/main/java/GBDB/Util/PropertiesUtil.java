package GBDB.Util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class PropertiesUtil {



    private static final Properties PROPERTIES= new Properties();

    public PropertiesUtil() {
    }




    static {

        loadProperties ();


    }
    public static String get(String key){
        return PROPERTIES.getProperty(key);


    }

    private static void loadProperties() {
        try (InputStream inputStream = PropertiesUtil.class.getClassLoader().getResourceAsStream("GBDB.properties")) {

            PROPERTIES.load(inputStream);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}

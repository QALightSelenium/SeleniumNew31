package libs;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/*
 *  That class provides static methods for getting values from Config and UI mapping files
 */
public class ConfigData {
    public static String cfgFile="src/config.properties";


    /**
     *  Return value from .properties file
     */
    public static String getValueFromFile(String key, String fileName) throws IOException {
        Properties p = new Properties();
        // Create stream for reading from file
        FileInputStream cfg = new FileInputStream(fileName);
        // Load Properties from input stream
        p.load(cfg);
        cfg.close();

        // Return value for the property
        return(p.getProperty(key));
    }


    public static String getCfgValue(String key) throws IOException {

        return(getValueFromFile(key, cfgFile));

    }
}

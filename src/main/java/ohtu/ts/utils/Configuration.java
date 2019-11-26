package ohtu.ts.utils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

/**
 * Provides global configuration for the app.
 * @author Joonas Häkkinen
 */
public class Configuration {
    // Path to configuration file:
    String path = "config.properties";
    // Configuration variables
    String dbFile;

    /**
     * Read the configuration file and load property values to this class.
     */
    public Configuration() {
        try (InputStream input = new FileInputStream("config.properties")) {
            Properties prop = new Properties();
            prop.load(input);

            // Load props to class variables.
            dbFile = prop.getProperty("dbFile");
        } catch (Exception e) {
            // The app must exit if config cannot be loaded!
            System.out.println("*** ERROR - Configuration file not found! Program will quit.");
            e.printStackTrace();
            System.exit(1);
        }
    }

    public String getDbFile() {
        return dbFile;
    }
}

package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Utility class to read configuration properties from config.properties file.
 */
public class ConfigReader {

    private static final Properties properties = new Properties();

    static {
        try (FileInputStream input = new FileInputStream("src/main/resources/config.properties")) {
            properties.load(input);
        } catch (IOException e) {
            System.err.println("Failed to load configuration file: " + e.getMessage());
            // Optionally: throw new RuntimeException("Configuration loading failed", e);
        }
    }

    /**
     * Returns the property value for the given key.
     */
    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}

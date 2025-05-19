package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties = new Properties();

    public static void load(String env) {
        try {
            FileInputStream fis = new FileInputStream("src/test/resources/config/config." + env + ".properties");
            properties.load(fis);
        } catch (IOException e) {
            throw new RuntimeException("Config file not found for env: " + env, e);
        }
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }
}

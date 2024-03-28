package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    static Properties properties;

    static {

        String dosyaYolu = "config.properties";

        try {
            FileInputStream fis = new FileInputStream(dosyaYolu);
            properties = new Properties();
            properties.load(fis);

        } catch (IOException e) {
            System.out.println("Properties file could not be read");
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}

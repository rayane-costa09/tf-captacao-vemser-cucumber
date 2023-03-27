package vemser.captacao.tests.utils;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;

public class Utils {
    private static final Properties userSystem = System.getProperties();

    public static String getUserOs() {
        return userSystem.getProperty("os.name");
    }

    public static String getUserOsLanguage() {
        return userSystem.getProperty("user.language");
    }

    public static String getUserPath() {
        return userSystem.getProperty("user.dir");
    }

    public static Properties getProperties() {

        Properties properties = new Properties();

        try {
            FileInputStream fileProperties = new FileInputStream("src/properties/config.properties");
            properties.load(fileProperties);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return properties;
    }

    public static int getRandomNumber(int bound) {
        return new Random().nextInt(bound);
    }
}

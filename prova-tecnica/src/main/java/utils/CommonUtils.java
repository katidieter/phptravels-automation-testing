package utils;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class CommonUtils {

    private CommonUtils() {

    }

    public static String getValueFromConfigFile(String property) {
        Properties properties;
        try {
            properties = new Properties();

            String env = null == System.getProperty("env") ? "dev" : System.getProperty("env");

            String fileSeparator = "/";
            ClassLoader classLoader = ClassLoader.getSystemClassLoader();
            properties.load(new FileReader(new File(classLoader.
                    getResource("conf" + fileSeparator + env + fileSeparator + "config.properties").getFile())));

            return properties.getProperty(property);
        } catch (IOException | NullPointerException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}

package ui.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {
    private static Properties prop = initProps();

    private static Properties initProps() {
        Properties prop = new Properties();
        InputStream input = null;

        try {
            input = PropertyReader.class.getClassLoader().getResourceAsStream("application.properties");
            prop.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return prop;
    }

    public static String getProperty(String name) {
        return prop.getProperty(name).trim();
    }
}

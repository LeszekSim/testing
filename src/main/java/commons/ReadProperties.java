package commons;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadProperties {

    public static String getValue(String key){

        Properties prop = new Properties();
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("src/main/resources/registerData.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            prop.load(fis);
        } catch (IOException e) {
            e.printStackTrace(); //tu nizej dac np unchecked wyjatek, gdyby
        }

        return prop.getProperty(key);
    }



}

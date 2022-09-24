package config;



import java.io.FileInputStream;
import java.util.Properties;

public class Config {

    /**
     * Method to initialize configuration.
     */

    public Properties initializeConfig() {
        Properties conf = new Properties();
        try (FileInputStream fis = new FileInputStream(
                System.getProperty("user.dir") + "/src/main/resources/config.properties")) {
            conf.load(fis);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return conf;
    }
}

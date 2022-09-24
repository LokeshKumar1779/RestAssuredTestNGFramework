package utils;

import java.io.File;
import java.util.Properties;

public class DataLoader {

    private final Properties properties;
    private static DataLoader dataLoader;

    public DataLoader() {
        properties = PropertyUtils.propertyLoader(System.getProperty("user.dir") + File.separator +"src/main/resources" + File.separator + "data.properties");
    }

    public static DataLoader getInstance(){
        if (dataLoader == null){
            dataLoader = new DataLoader();
        }
        return dataLoader;
    }

    public String getPlaylistId(){
        String prop = properties.getProperty("get_playlist_id");
        if (prop != null) return prop;
        else throw new RuntimeException("Property client_id is not specified in the config.properties file");
    }

    public String getUpdatePlaylistId(){
        String prop = properties.getProperty("update_playlist_id");
        if (prop != null) return prop;
        else throw new RuntimeException("Property client_id is not specified in the config.properties file");
    }
}
package utils;

import java.io.File;
import java.util.Properties;

public class ConfigLoader {

    private final Properties properties;
    private static ConfigLoader configLoader;

    public ConfigLoader() {
        properties = PropertyUtils.propertyLoader(System.getProperty("user.dir") + File.separator +"src/main/resources" + File.separator + "config.properties");
    }

    public static ConfigLoader getInstance(){
        if (configLoader == null){
            configLoader = new ConfigLoader();
        }
        return configLoader;
    }

    public String getClientId(){
        String prop = properties.getProperty("client_id");
        if (prop != null) return prop;
        else throw new RuntimeException("Property client_id is not specified in the config.properties file");
    }

    public String getGrantType(){
        String prop = properties.getProperty("grant_type");
        if (prop != null) return prop;
        else throw new RuntimeException("Property client_id is not specified in the config.properties file");
    }

    public String getRefreshToken(){
        String prop = properties.getProperty("refresh_token");
        if (prop != null) return prop;
        else throw new RuntimeException("Property client_id is not specified in the config.properties file");
    }

    public String getClientSecret(){
        String prop = properties.getProperty("client_secret");
        if (prop != null) return prop;
        else throw new RuntimeException("Property client_id is not specified in the config.properties file");
    }

    public String getUserId(){
        String prop = properties.getProperty("user_id");
        if (prop != null) return prop;
        else throw new RuntimeException("Property client_id is not specified in the config.properties file");
    }

    public String getPlaylistId(){
        String prop = properties.getProperty("playlist_id");
        if (prop != null) return prop;
        else throw new RuntimeException("Property client_id is not specified in the config.properties file");
    }




}
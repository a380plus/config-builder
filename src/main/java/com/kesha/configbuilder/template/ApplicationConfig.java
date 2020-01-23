package com.kesha.configbuilder.template;

import java.util.Properties;

public class ApplicationConfig extends AbstractConfig {

    private static Properties properties = loadResources("application.properties");

    public static String getServerPort() {
        return properties.getProperty("server.port");
    }

    public static String getServerPort(String defaultValue) {
        return properties.getProperty("server.port", defaultValue);
    }

}

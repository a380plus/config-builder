package com.kesha.configbuilder.confClass;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class InitConfig extends AbstractConfig{

private static Properties properties = loadRootConf("./conf/init.properties");

    public static String getMainClass(){
        return properties.getProperty("main.class");
    }

    public static String getMainClass(String defaultValue) {
        return properties.getProperty("main.class", defaultValue);
    }

}
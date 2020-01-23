package com.kesha.configbuilder.confClass;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class SystemConfig extends AbstractConfig{

private static Properties properties = loadRootConf("./conf/system.properties");

    public static String getIsOpenTest(){
        return properties.getProperty("is.open.test");
    }

    public static String getIsOpenTest(String defaultValue) {
        return properties.getProperty("is.open.test", defaultValue);
    }

    public static String getName(){
        return properties.getProperty("name");
    }

    public static String getName(String defaultValue) {
        return properties.getProperty("name", defaultValue);
    }

    public static String getAddress(){
        return properties.getProperty("address");
    }

    public static String getAddress(String defaultValue) {
        return properties.getProperty("address", defaultValue);
    }

}
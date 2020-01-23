package com.kesha.configbuilder.template;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AbstractConfig {

    public static Properties loadResources(String path) {
        Properties properties = new Properties();
        InputStream in = AbstractConfig.class.getClassLoader().getResourceAsStream(path);
        if (null == in) {
            return properties;
        }

        try {
            properties.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;

    }

    public static Properties loadRootConf(String path) {
        Properties properties = new Properties();
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(path));
            properties.load(bufferedReader);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return properties;
    }

}

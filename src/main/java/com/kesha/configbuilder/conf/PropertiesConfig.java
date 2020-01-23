package com.kesha.configbuilder.conf;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertiesConfig {


    private static Properties readProperty(String path) {
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

    public static void getProperties(String filepath, Map<String, Properties> propertiesMap) {
        try {
            File file = new File(filepath);
            if (!file.isDirectory()) {
                propertiesMap.put(file.getName(), readProperty(file.getPath()));

            } else if (file.isDirectory()) {
                String[] filelist = file.list();
                for (int i = 0; i < filelist.length; i++) {
                    File readfile = new File(filepath + File.separator + filelist[i]);
                    if (!readfile.isDirectory()) {
                        propertiesMap.put(readfile.getName(), readProperty(readfile.getPath()));
                    } else if (readfile.isDirectory()) {
                        getProperties(filepath + File.separator + filelist[i], propertiesMap);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Map<String, Properties> propertiesMap = new HashMap<String, Properties>();
        PropertiesConfig.getProperties("./cof", propertiesMap);
        System.out.println(propertiesMap);
        System.out.println(new File("./conf").exists());
    }
}

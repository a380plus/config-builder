package com.kesha.configbuilder.conf;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class TemplateConfig {

    public static String getAbstractConfigClass(String path) {

        File file = new File(path);
        BufferedReader bReader = null;
        StringBuilder content = new StringBuilder();
        try {
            bReader = new BufferedReader(new FileReader(file));
            String s = "";
            while ((s = bReader.readLine()) != null) {
                content.append(s + "\n");
            }
            bReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return content.toString();
    }

    public static void main(String[] args) {
        System.out.println(getAbstractConfigClass("../template/AbstractConfig.java"));
//        System.out.println(getAbstractConfigClass("PropertiesConfig.java"));
        System.out.println();
    }

}

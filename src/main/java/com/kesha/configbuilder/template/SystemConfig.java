package com.kesha.configbuilder.template;

import java.util.Properties;

public class SystemConfig extends AbstractConfig {

    private static Properties properties = loadRootConf("./conf/system.properties");

    public static String getIsOpenTest() {
        return properties.getProperty("is.open.test");
    }

    public static String getIsOpenTest(String defaultValue) {
        return properties.getProperty("is.open.test", defaultValue);
    }

    public static void main(String[] args) {
        System.out.println(getIsOpenTest("a"));
    }
}

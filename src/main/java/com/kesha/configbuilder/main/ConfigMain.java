package com.kesha.configbuilder.main;

import com.kesha.configbuilder.builder.ConfigBuilder;

public class ConfigMain {

    public static void main(String[] args) {
        boolean inResouresOrRoot = Boolean.parseBoolean(args[0]);
        String path = args[1];
        ConfigBuilder configBuilder = new ConfigBuilder();
        configBuilder.build(inResouresOrRoot, path);
    }
}

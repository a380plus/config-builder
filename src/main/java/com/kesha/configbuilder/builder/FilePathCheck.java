package com.kesha.configbuilder.builder;

import java.io.File;

public class FilePathCheck {



    public  FilePathCheck check(String path) {
        if(ConfigBuilderHelp.isEmpty(path) ||  !new File(path).exists()){
            throw new RuntimeException("Invalid path: " + path);
        }
        return new FilePathCheck();
    }

    public static void main(String[] args) {
        new FilePathCheck().check("./conf/t").check("./conf");
    }
}

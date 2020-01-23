package com.kesha.configbuilder.builder;

import java.io.File;

public class ConfigBuilderHelp {
    public static String getLoadContent(boolean inResourceOrRoot, String fileName, String path) {
        String content = "";
        if (inResourceOrRoot) {
            content = String.format("private static Properties properties = loadResources(\"%s\");", getResourcesPath(path, fileName));
        } else {
            content = String.format("private static Properties properties = loadRootConf(\"%s\");", getRootPath(path, fileName));
        }
        return content;
    }

    final static String slash = "\\";
    final static String back_slash = "/";

    public static String getResourcesPath(String path, String fileName) {
        if (null == path || "".equals(path)) {
            return fileName;
        }
        String fullPath = "";
        if (path.contains(slash)) {
            for (String s : path.split("\\\\")) {
                if (null != s && !"".equals(s)) {
                    fullPath +=  s+"/";
                }
            }
        } else if (path.contains(back_slash)) {
            for (String s : path.split(back_slash)) {
                if (null != s && !"".equals(s)) {
                    fullPath +=  s+"/";
                }
            }
        }
        return fullPath  + fileName;
    }

    final static String sep = File.separator;

    public static String getRootPath(String path, String fileName) {
        if (null == path || "".equals(path)) {
            return fileName;
        }
        String fullPath = ".";
        if (path.contains(slash)) {
            for (String s : path.split("\\\\")) {
                if (null != s && !"".equals(s)) {
                    fullPath += "/" + s;

                }
            }
        } else if (path.contains(back_slash)) {
            for (String s : path.split(back_slash)) {
                if (null != s && !"".equals(s)) {
                    fullPath += "/" + s;

                }
            }
        }
        return fullPath + "/" + fileName;
    }

    public static String getClassName(String fileName) {
        String name = fileName.split("\\.")[0];
        return getUppperLowerCase(name);
    }

    public static String getUppperLowerCase(String value) {
        if (null == value || "".equals(value)) {
            return value;
        }
        return value.substring(0, 1).toUpperCase() + value.substring(1, value.length()).toLowerCase();
    }

    public static String getKeyName(String key) {
        String keyName = "";
        if (key.contains(".")) {
            for (String s : key.split("\\.")) {
                keyName += getUppperLowerCase(s);
            }
        } else if (key.contains("_")) {
            for (String s : key.split("_")) {
                keyName += getUppperLowerCase(s);
            }
        } else if (key.contains("-")) {
            for (String s : key.split("-")) {
                keyName += getUppperLowerCase(s);
            }
        } else {
            keyName += getUppperLowerCase(key);
        }
        return keyName;
    }

    public static boolean isEmpty(String content){
        if(null==content||"".equals(content)){
            return true;
        }
        return false;
    }

    public static String getAbstractClass(){
        String abstractClass= "package com.xxx.xxx;\n" +
                "\n" +
                "import java.io.BufferedReader;\n" +
                "import java.io.FileReader;\n" +
                "import java.io.IOException;\n" +
                "import java.io.InputStream;\n" +
                "import java.util.Properties;\n" +
                "\n" +
                "public class AbstractConfig {\n" +
                "\n" +
                "    public static Properties loadResources(String path) {\n" +
                "        Properties properties = new Properties();\n" +
                "        InputStream in = AbstractConfig.class.getClassLoader().getResourceAsStream(path);\n" +
                "        try {\n" +
                "            properties.load(in);\n" +
                "        } catch (IOException e) {\n" +
                "            e.printStackTrace();\n" +
                "        }\n" +
                "        return properties;\n" +
                "\n" +
                "    }\n" +
                "\n" +
                "    public static Properties loadRootConf(String path) {\n" +
                "        Properties properties = new Properties();\n" +
                "        BufferedReader bufferedReader = null;\n" +
                "        try {\n" +
                "            bufferedReader = new BufferedReader(new FileReader(path));\n" +
                "            properties.load(bufferedReader);\n" +
                "        } catch (Exception e) {\n" +
                "            e.printStackTrace();\n" +
                "        }\n" +
                "        return properties;\n" +
                "    }\n" +
                "\n" +
                "}\n";
        return abstractClass;
    }

}

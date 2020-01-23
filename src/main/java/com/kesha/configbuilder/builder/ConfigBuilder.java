package com.kesha.configbuilder.builder;

import com.kesha.configbuilder.conf.PropertiesConfig;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ConfigBuilder {
    private final static String brbr = "\n\n";
    private final static String br = "\n";
    private static String packages = "package com.xxx.xxx;";
    private static String imports = "import java.io.BufferedReader;\n" +
            "import java.io.FileReader;\n" +
            "import java.io.IOException;\n" +
            "import java.io.InputStream;\n" +
            "import java.util.Properties;";
    private static String test_imports = "import org.junit.Assert;\n" +
            "import org.junit.Test;";

    public void build(boolean inResourceOrRoot, String path) {
        ConfigBuilder configBuilder = new ConfigBuilder();
        configBuilder.buildConfigClass("./conf-builder", inResourceOrRoot, path, "./conf-builder-output");
    }

    private void buildConfigClass(String propertiesPath, boolean inResourceOrRoot, String path, String outPutPath) {

        new FilePathCheck().check(propertiesPath);
        if (ConfigBuilderHelp.isEmpty(outPutPath)) {
            throw new RuntimeException("Invalid path: " + outPutPath);
        }

        Map<String, Properties> propertiesMap = new HashMap<>();
        PropertiesConfig.getProperties(propertiesPath, propertiesMap);


        for (Map.Entry<String, Properties> entry : propertiesMap.entrySet()) {

            StringBuilder configClass = new StringBuilder();
            StringBuilder configTestClass = new StringBuilder();
            String fileName = entry.getKey();
            Properties properties = entry.getValue();
            String className = ConfigBuilderHelp.getClassName(fileName) + "Config";
            String testClassName = ConfigBuilderHelp.getClassName(fileName) + "ConfigTest";

            configClass.append(packages).append(brbr)
                    .append(imports).append(brbr)
                    .append(String.format("public class %s extends AbstractConfig{", className)).append(brbr)
                    .append(ConfigBuilderHelp.getLoadContent(inResourceOrRoot, fileName, path)).append(brbr);

            configTestClass.append(packages).append(brbr)
                    .append(test_imports).append(brbr)
                    .append(String.format("public class %s{", testClassName)).append(brbr)
                    .append("    @Test").append(br)
                    .append("    public void getConfigTest() {").append(br);


            properties.forEach((k, v) -> {
                String methodName = String.format("get%s()", ConfigBuilderHelp.getKeyName(k.toString()));
                String defualMethod = String.format("get%s(\"default\")", ConfigBuilderHelp.getKeyName(k.toString()));


                configClass
                        .append(String.format("    public static String %s{", methodName)).append(br)
                        .append(String.format("        return properties.getProperty(\"%s\");", k.toString())).append(br)
                        .append("    }").append(brbr)
                        .append(String.format("    public static String get%s(String defaultValue) {", ConfigBuilderHelp.getKeyName(k.toString()))).append(br)
                        .append(String.format("        return properties.getProperty(\"%s\", defaultValue);", k.toString())).append(br)
                        .append("    }").append(brbr);

                configTestClass
                        .append(String.format("        System.out.println(%s.%s);", className, methodName)).append(br)
                        .append(String.format("        Assert.assertEquals(\"%s\", %s.%s);", v.toString(), className, methodName)).append(brbr);
//                        .append(String.format("        Assert.assertEquals(\"%s\", %s.%s);", v.toString(), className, methodName)).append(br)
//                        .append(String.format("        Assert.assertEquals(\"default\", %s.%s);", className, defualMethod)).append(brbr);

            });

            configClass.append("}");
            configTestClass.append("    }").append(brbr).append("}");

            WriteFile.write(outPutPath + "/conf/" + className + ".java", configClass.toString());
            WriteFile.write(outPutPath + "/configtest/" + testClassName + ".java", configTestClass.toString());
            WriteFile.write(outPutPath + "/abstract/AbstractConfig.java", ConfigBuilderHelp.getAbstractClass());
        }


    }







}

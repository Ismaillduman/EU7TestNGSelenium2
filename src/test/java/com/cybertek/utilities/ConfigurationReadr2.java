package com.cybertek.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReadr2 {

    private static Properties properties;
// static blocks it initiates every time i call the classname

    static {
        String path = "configutarionTwo.properties";
        try {
            FileInputStream file = new FileInputStream(path);
            properties.load(file);
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String get(String keyName){

        return properties.getProperty(keyName);
    }
}
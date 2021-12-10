package com.test;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Properties;
public class ConfProperties {
    protected static FileInputStream fileInputStream;
    protected static Properties PROPERTIES;
    static {
        try {   
            fileInputStream = new FileInputStream("src/main/resources/conf.properties");
            Reader reader = new InputStreamReader(fileInputStream, "UTF-8");
            PROPERTIES = new Properties();
            PROPERTIES.load(reader);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null)
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace(); } } }
    public static String get(String key) {
        return PROPERTIES.getProperty(key); } }

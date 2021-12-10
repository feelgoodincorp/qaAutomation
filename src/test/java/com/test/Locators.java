package com.test;
import java.io.FileReader;
import java.io.IOException;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.apache.commons.io.IOUtils;

public class Locators {
    //protected static FileInputStream fileInputStream;
    protected static FileReader reader;
    protected static String locator;
    protected static JsonObject jsonObject;
    static {
        try {
            //FileReader reader = new FileReader("src/main/resources/locators.json");
            reader = new FileReader("src/main/resources/locators.json");
            String json = IOUtils.toString(reader);
            jsonObject = new JsonParser().parse(json).getAsJsonObject();            
            locator = jsonObject.get("logoBtnClass").getAsString();
    
            // JsonArray arr = jsonObject.getAsJsonArray("posts");
            // for (int i = 0; i < arr.size(); i++) {
            //     String post_id = arr.get(i).getAsJsonObject().get("post_id").getAsString();
            //     System.out.println(post_id);
            // }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (reader != null)
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace(); } } }
    /**
     *          
     */
    public static String get(String key) {
        return jsonObject.get(key).getAsString();} 
}

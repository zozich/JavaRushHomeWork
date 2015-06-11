package com.javarush.test.level20.lesson02.task03;

import java.io.*;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* Знакомство с properties
В методе fillInPropertiesMap считайте имя файла с консоли и заполните карту properties данными из файла.
Про .properties почитать тут - http://ru.wikipedia.org/wiki/.properties
Реализуйте логику записи в файл и чтения из файла для карты properties.
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        solution.load(new FileInputStream("D:\\JavaProjects\\JavaRushHomeWork\\src\\JavaRushPlugin.properties"));
        for (Map.Entry<String, String> pair : properties.entrySet()) {
            System.out.println(pair.getKey() + ":" + pair.getValue());
        }
    }

    public void fillInPropertiesMap() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        InputStream inputStream = new FileInputStream(fileName);

        loadProperties(inputStream);
    }

    public void save(OutputStream outputStream) throws Exception {
        Properties pr = new Properties();
        for (Map.Entry pair:properties.entrySet()) {
            pr.put(pair.getKey(), pair.getValue());
        }
        pr.store(outputStream, "");
    }

    public void load(InputStream inputStream) throws Exception {
        properties.clear();
        loadProperties(inputStream);
    }

    private void loadProperties(InputStream inputStream) throws IOException {
        Properties pr = new Properties();
        pr.load(inputStream);
        inputStream.close();

        Enumeration enuKeys = pr.keys();
        while (enuKeys.hasMoreElements()) {
            String key = (String) enuKeys.nextElement();
            String value = pr.getProperty(key);
            properties.put(key, value);
        }
    }
}

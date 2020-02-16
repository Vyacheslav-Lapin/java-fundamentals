package com.epam.courses.java.fundamentals.collections.task2;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertyReader {

  private static Map<Object, Object> map = new HashMap<>();
  private static final String path = "C:\\Users\\Nikita\\IdeaProjects\\java-fundamentals\\" +
      "collections\\src\\main\\resources\\test.properties";

  public static void main(String[] args) throws IOException {
    PropertyReader propertyReader = new PropertyReader();
    propertyReader.read(path);
  }

  private void read(String path) throws IOException {
    try (InputStream inputStream = new FileInputStream(new File(path))) {
      Properties property = new Properties();
      property.load(inputStream);
      property.forEach((K, V) -> map.put(K, V));
      System.out.println(map.keySet() + " " + map.values());
    }
  }

}

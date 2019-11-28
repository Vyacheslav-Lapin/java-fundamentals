package com.epam.courses.java.fundamentals.threads.task2;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class SynchronizedReader {

  private static Map<Object, Object> map = new HashMap<>();
  private static final String PATH = "...";

  public static void main(String[] args) throws IOException {
    SynchronizedReader reader = new SynchronizedReader();
    reader.readFromPropertiesFile(PATH);
  }

  private void readFromPropertiesFile(String filePath) throws IOException {
    synchronized (this) {
      try (InputStream input = new FileInputStream(filePath)) {
        Properties properties = new Properties();
        properties.load(input);
        properties.forEach((k, v) -> map.put(k, v));
        System.out.println(map.keySet() + " " + map.values());
      }
    }
  }
}

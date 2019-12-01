package com.epam.courses.java.fundamentals.collections.task2;

// Если в map добавить значение с уже существующим ключом, то оно перезапишется

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class UniversalClass {

  Properties property;

  String filename;

  Map<String, String> map;

  public UniversalClass(String filename) {
    property = new Properties();
    this.filename = filename;
    map = new HashMap<>();
    readFile(filename);
  }

  private void readFile(String filename) {
    try (FileInputStream fis = new FileInputStream(filename)) {
      property.load(fis);
      for (String i : property.stringPropertyNames()) {
        map.put(i, property.getProperty(i));
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}

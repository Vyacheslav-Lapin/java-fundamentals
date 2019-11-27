package com.epam.courses.java.fundamentals.io.practice.task1;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class KeyworsDefiner {

  private String[] keywords =
      {
          "abstract", "assert", "boolean", "break", "byte", "case", "catch", "char", "class", "continue", "default", "do", "double", "else", "enum", "extends", "final",
          "finally", "float", "for", "if", "implements", "import", "instanceof", "int", "interface", "long", "native", "new", "package", "private", "protected",
          "public", "return", "short", "static", "strictfp", "super", "switch", "synchronized", "this", "throw", "throws", "transient", "try", "void", "volatile", "while"
      };

  private Map<String, Integer> words() {
    Map<String, Integer> map = new HashMap<>();
    String res = readFile();
    int count = 0;
    String[] a = res
        .replaceAll("\\(", " ")
        .replaceAll("\\.", " ")
        .split("\\s+");
    for (String s : keywords) {
      for (String s1 : a) {
        if (s1.equals(s)) {
          count++;
          map.put(s, count);
        }
      }
      count = 0;
    }
    return map;
  }

  public void define() {
    String path = "io/src/main/java/com/epam/courses/java/fundamentals/io/practice/task1/result";
    try (FileOutputStream fs = new FileOutputStream(path)) {
      for (Map.Entry<String, Integer> entry : words().entrySet()) {
        fs.write(entry.getKey().getBytes());
        fs.write(' ');
        fs.write(entry.getValue().toString().getBytes());
        fs.write("\n".getBytes());
      }
    } catch (IOException ex) {
      System.out.println(ex.getMessage());
    }

  }

  private String readFile() {
    String path = "io/src/main/java/com/epam/courses/java/fundamentals/io/practice/task1/text";
    String res = "";
    try (FileInputStream fs = new FileInputStream(path)) {
      byte[] buffer = new byte[fs.available()];
      fs.read(buffer, 0, buffer.length);
      res = new String(buffer);
    } catch (IOException ex) {
      System.out.println(ex.getMessage());
    }
    return res;
  }

}

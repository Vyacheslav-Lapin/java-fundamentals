package com.epam.courses.java.fundamentals.io.practice.task2;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class AnotherKeywordsDefiner {

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
    File res = new File("io/src/main/java/com/epam/courses/java/fundamentals/io/practice/task2/result");
    try {
      res.createNewFile();
    } catch (IOException e) {
      e.printStackTrace();
    }
    try (BufferedWriter bw = new BufferedWriter(new FileWriter(res))) {
      for (Map.Entry<String, Integer> entry : words().entrySet()) {
        bw.write(entry.getKey() + " " + entry.getValue() + "\n");
      }
    } catch (IOException ex) {
      System.out.println(ex.getMessage());
    }

  }

  private String readFile() {
    String path = "io/src/main/java/com/epam/courses/java/fundamentals/io/practice/task2/text";
    StringBuilder res = new StringBuilder();
    try (BufferedReader br = new BufferedReader(new FileReader(path))) {
      String s;
      while ((s = br.readLine()) != null){
        res.append(s + "\n");
      }
    } catch (IOException ex) {
      System.out.println(ex.getMessage());
    }
    return res.toString();
  }

}

package com.epam.courses.java.fundamentals.strings.practice.task3;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextParser {

  public boolean areSequenceImages() {
    Pattern pattern = Pattern.compile("\\([Р|p]ис\\.\\s\\d+\\sи\\s\\d+\\)");
    Matcher matcher = pattern.matcher(readFile());
    return matcher.find();
  }


  public String readFile() {
    StringBuilder result = new StringBuilder();
    String path = "strings/src/main/java/com/epam/courses/java/fundamentals/strings/practice/task3/article.html";
    try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path), "Cp1251"))) {
      String tmp;
      while ((tmp = br.readLine()) != null) {
        result.append(tmp);
      }
    } catch (IOException ex) {
      System.out.println(ex.getMessage());
    }
    return result.toString();
  }

}

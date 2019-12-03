package com.epam.courses.java.fundamentals.io.practice.task2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;

public class StreamProcessor {
  protected StringBuffer buffer = new StringBuffer();
  private final String[] keywords = {"abstract", "assert", "boolean",
      "break", "byte", "case", "catch", "char", "class", "const",
      "continue", "default", "do", "double", "else", "extends", "false",
      "final", "finally", "float", "for", "goto", "if", "implements",
      "import", "instanceof", "int", "interface", "long", "native",
      "new", "null", "package", "private", "protected", "public",
      "return", "short", "static", "strictfp", "super", "switch",
      "synchronized", "this", "throw", "throws", "transient", "true",
      "try", "void", "volatile", "while"};

  public void countKeywords(String path) {
    StringBuffer result = new StringBuffer();
    for (String i : keywords) {
      int tmp = buffer.indexOf(i);
      int count = 0;
      while (tmp != -1) {
        count++;
        tmp = buffer.indexOf(i, tmp + 1);
      }
      result.append(i)
          .append(" - ")
          .append(count)
          .append('\n');
    }
    System.out.println(result);
    writeToFile(path, result);
  }
  public boolean setFile(String path) {
    try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
      String s;
      while ((s = bufferedReader.readLine()) != null) {
        buffer.append(s);
      }
    } catch (FileNotFoundException e) {
      System.err.println("File not found");
    } catch (Exception e) {
      e.printStackTrace();
    }
    return true;
  }


  protected void writeToFile(String path, StringBuffer buffer) {
    try (FileWriter fileWriter = new FileWriter(path)) {
      fileWriter.write(buffer.toString());
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    StreamProcessor task2 = new StreamProcessor();
    task2.setFile("io/src/main/resources/Task21.java");
    task2.countKeywords("io/src/main/resources/text.text");
  }
}

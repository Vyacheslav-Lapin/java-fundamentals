package com.epam.courses.java.fundamentals.io.practice.task1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class ByteStreamProcessor {
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
    try (FileInputStream inputStream = new FileInputStream(path)) {
      int data = inputStream.read();
      while (data != -1) {
        buffer.append((char) data);
        data = inputStream.read();
      }
    } catch (FileNotFoundException e) {
      System.err.println("File not found.");
      return false;
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
    return true;
  }

  protected void writeToFile(String path, StringBuffer buffer) {
    try (FileOutputStream outputStream = new FileOutputStream(path)) {
      char[] arr = buffer.toString().toCharArray();
      for (char i : arr) {
        outputStream.write(i);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    ByteStreamProcessor task2 = new ByteStreamProcessor();
    task2.setFile("io/src/main/resources/Task21.java");
    task2.countKeywords("io/src/main/resources/text.txt");
  }
}

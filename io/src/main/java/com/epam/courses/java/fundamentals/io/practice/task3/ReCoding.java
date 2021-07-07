package com.epam.courses.java.fundamentals.IO.practice.task3;

import lombok.SneakyThrows;

import java.io.*;

/**
 * Дан файл, содержащий буквы текст на кириллице. Кодировка файла utf-8.
 * Прочитайте информацию из файла и перепишите ее в файл в кодировкой utf-16.
 */

public class ReCoding {

  static File source = new File("io/src/main/java/com/epam/courses/java/fundamentals/IO/practice/task3/UTF_8.txt");
  static File output = new File("io/src/main/java/com/epam/courses/java/fundamentals/IO/practice/task3/UTF_16.txt");

  @SneakyThrows
  public static void main(String[] args) {
    try (
        BufferedReader sourceReader = new BufferedReader(new InputStreamReader
            (new FileInputStream(source), "UTF-8"));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter
            (new FileOutputStream(output), "UTF-16"))) {

      StringBuilder source = new StringBuilder();
      String line;
      while ((line = sourceReader.readLine()) != null) {
        source.append(line).append("\n");
      }
      writer.write(source.toString().toCharArray());

    }
  }
}

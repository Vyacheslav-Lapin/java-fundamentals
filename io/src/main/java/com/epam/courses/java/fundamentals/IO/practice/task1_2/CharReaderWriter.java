package com.epam.courses.java.fundamentals.IO.practice.task1_2;

import java.io.*;

/**
 * Прочитайте файл, содержащий код на языке Java. Определите, какие ключевые слова языка Java это код содержит.
 * Выведите эти слова и их количество в другой файл. Используйте только символьные потоки ввода-вывода.
 */

public class CharReaderWriter implements StringParser {
  public static void main(String[] args) throws Exception {
    try (BufferedReader sourceReader = new BufferedReader(new FileReader(StringParser.source));
         BufferedReader templateReader = new BufferedReader(new FileReader(StringParser.templ));
         BufferedWriter writer = new BufferedWriter(new FileWriter(StringParser.output, false))){

      CharReaderWriter charRW = new CharReaderWriter();
      StringBuilder source = new StringBuilder();
      StringBuilder templ = new StringBuilder();
      String line;
      while ((line = sourceReader.readLine()) != null) {
        source.append(line).append("\n");
      }
      while ((line = templateReader.readLine()) != null) {
        templ.append(line).append("\n");
      }
      String result = charRW.parse(source.toString(), templ.toString());
      writer.write(result.toCharArray());
    }

  }
}

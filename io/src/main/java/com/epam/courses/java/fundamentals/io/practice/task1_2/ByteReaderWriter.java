package com.epam.courses.java.fundamentals.IO.practice.task1_2;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * Прочитайте файл, содержащий код на языке Java. Определите, какие ключевые слова языка Java это код содержит.
 * Выведите эти слова и их количество в другой файл. Используйте только байтовые потоки ввода-вывода.
 */

public class ByteReaderWriter implements StringParser{
  public static void main(String[] args) throws Exception {
    try (BufferedInputStream sourceReader = new BufferedInputStream(new FileInputStream(StringParser.source));
         BufferedInputStream templateReader = new BufferedInputStream(new FileInputStream(StringParser.templ));
         BufferedOutputStream writer = new BufferedOutputStream(new FileOutputStream(StringParser.output, false))){

      String result = new ByteReaderWriter().
          parse(new String(sourceReader.readAllBytes()), new String(templateReader.readAllBytes()));
      writer.write(result.getBytes());
    }

  }
}

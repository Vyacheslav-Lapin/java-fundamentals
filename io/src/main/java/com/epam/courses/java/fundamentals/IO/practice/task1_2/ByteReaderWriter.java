package com.epam.courses.java.fundamentals.IO.practice.task1_2;

import java.io.*;

/**
 * Прочитайте файл, содержащий код на языке Java. Определите, какие ключевые слова языка Java это код содержит.
 * Выведите эти слова и их количество в другой файл. Используйте только байтовые потоки ввода-вывода.
 */

public class ByteReaderWriter implements StringParser{
  public static void main(String[] args) throws Exception {
    try (BufferedInputStream sourceReader = new BufferedInputStream(new FileInputStream(StringParser.source));
         BufferedInputStream templateReader = new BufferedInputStream(new FileInputStream(StringParser.templ));
         BufferedOutputStream writer = new BufferedOutputStream(new FileOutputStream(StringParser.output, false))){

      ByteReaderWriter byteRW = new ByteReaderWriter();
      String result = byteRW.parse(new String(sourceReader.readAllBytes()), new String(templateReader.readAllBytes()));
      writer.write(result.getBytes());
    }

  }
}

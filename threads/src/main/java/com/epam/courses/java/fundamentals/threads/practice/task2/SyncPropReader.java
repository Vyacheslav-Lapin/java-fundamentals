package com.epam.courses.java.fundamentals.threads.practice.task2;

import io.vavr.CheckedConsumer;
import lombok.Cleanup;

import java.io.*;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

/**
 * Создать “универсальный” класс, позволяющий получить значение из любого properties-файла.
 * Физическое чтение файла должно происходить только один раз.
 * Учтите ситуацию, когда несколько потоков одновременно обращаются к одному и тому же файлу.
 * + из модуля Exeptions: Обработайте следующие исключительные ситуации: нет файла *.properties, нет ключа в properties-файле.
 */
public class SyncPropReader {
  Properties properties;

  SyncPropReader(String fileName) {
    var properties = new Properties();
    CheckedConsumer<InputStream> consumer = properties::load;
    String path = "/" + fileName + ".properties";
    try {
      File file = new File("src/main/resources" + path);
      @Cleanup FileChannel channel = new RandomAccessFile(file, "r").getChannel();
      FileLock lock = channel.lock();
      try {
        lock = channel.tryLock();
        @Cleanup var inputStream = SyncPropReader.class.getResourceAsStream(path);
        consumer.accept(inputStream);
      } catch (Throwable throwable) {
        throwable.printStackTrace();
      } finally {
        if (lock != null) lock.release();
      }
    } catch (FileNotFoundException f) {
      f.getMessage();
    } catch (IOException e) {
      e.printStackTrace();
    }
    this.properties = properties;
  }

  String getProperty(String propertyName) {
    try {
      if (!properties.containsKey(propertyName)) throw new PropertyNotFoundException("No such property found");
    } catch (PropertyNotFoundException e) {
      e.printStackTrace();
    }
    return properties.getProperty(propertyName);
  }

  public static void main(String[] args) {
    SyncPropReader reader = new SyncPropReader("db");
    List<String> keyset = reader.properties.keySet().stream().map(Object::toString).collect(Collectors.toList());
    for (String s : keyset) System.out.println(reader.getProperty(s));
  }
}

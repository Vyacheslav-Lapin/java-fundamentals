package com.epam.courses.java.fundamentals.oop.practice.task4;

import com.epam.courses.java.fundamentals.oop.practice.task4.Stationery.PapersNotes.PapersNotes;
import com.epam.courses.java.fundamentals.oop.practice.task4.Stationery.Stationery;
import lombok.SneakyThrows;
import lombok.experimental.NonFinal;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Разработайте иерархию канцелярских товаров. Создайте “набор новичка”, используя созданную иерархию.
 */

public class StationerySet {
  @NonFinal
  ArrayList<String> newbySet;

  public StationerySet() {
  }

  public static void main(String[] args) {
    String path = "oop/src/main/java/com/epam/courses/java/fundamentals/oop/practice/task4/Stationery";
    try (Stream<Path> walk = Files.walk(Paths.get(path))) {
      List<String> result = walk.map(Path::toString).filter(f -> f.endsWith(".java")).collect(Collectors.toList());
      for (String str : result) {
        String address1 = str.substring(str.lastIndexOf("src") + 14).
            replace("\\", ".");
        String address = address1.substring(0, address1.lastIndexOf("java") - 1);
        Class<?> newClass = ClassLoader.getSystemClassLoader().loadClass(address);
        if(newClass.getModifiers()!=1025) {
          Method method = newClass.getDeclaredMethod("getNewbySet", null);
          ArrayList<Object> list = (ArrayList<Object>) method.invoke(newClass);
          System.out.println(newClass.getName() + "\n" + list);
        }
      }
    }
    catch (Exception e){
      e.printStackTrace();
    }
  }
}

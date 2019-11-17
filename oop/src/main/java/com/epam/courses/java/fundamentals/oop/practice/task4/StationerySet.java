package com.epam.courses.java.fundamentals.oop.practice.task4;

import com.epam.courses.java.fundamentals.oop.practice.task4.Stationery.Stationery;
import lombok.experimental.NonFinal;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Разработайте иерархию канцелярских товаров. Создайте “набор новичка”, используя созданную иерархию.
 */

public class StationerySet {
  @NonFinal
  private ArrayList<ArrayList<Stationery>> newbySet;

  private StationerySet() {
    this.newbySet = new ArrayList<>();
    String path = "oop/src/main/java/com/epam/courses/java/fundamentals/oop/practice/task4/Stationery";
    try (Stream<Path> walk = Files.walk(Paths.get(path))) {
      List<String> result = walk.map(Path::toString).filter(f -> f.endsWith(".java")).
          collect(Collectors.toList());
      for (String str : result) {
        String address1 = str.substring(str.lastIndexOf("src") + 14).
            replace("\\", ".");
        String address = address1.substring(0, address1.lastIndexOf("java") - 1);
        Class<?> newClass = ClassLoader.getSystemClassLoader().loadClass(address);
        if(newClass.getModifiers()!=1025) {
          Method method = newClass.getDeclaredMethod("getNewbySet", null);
          ArrayList<Stationery> categoryList = (ArrayList<Stationery>) method.invoke(newClass);
          newbySet.add(categoryList);
        }
      }
    }
    catch (Exception e){
      e.printStackTrace();
    }
  }

  public ArrayList<Stationery> getFullNewbySet (){
    ArrayList<Stationery> result = new ArrayList<>();
    for(ArrayList<Stationery> arr: newbySet){
      for (Stationery stat : arr) result.add(stat);
    }
    return result;
  }

  public String printNewbySet(){
    StringBuilder s = new StringBuilder();
    for(ArrayList<Stationery> arr: newbySet){
      s.append(arr.get(0).getClass().getSimpleName()).
          append(": ").
          append(arr.size()).
          append(" items.\n");
      for (Stationery stat : arr) s.append(stat).append(",\n");
    }
    return s.toString();
  }

  public static void main(String[] args) {
    System.out.println(new StationerySet().printNewbySet());
  }
}

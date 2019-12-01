package com.epam.courses.java.fundamentals.exceptions.practice.task1;

import lombok.experimental.NonFinal;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Разработать приложение, позволяющее просматривать файлы и каталоги файловой системы, а также создавать и удалять текстовые файлы.
 * Для работы с текстовыми файлами необходимо реализовать функциональность записи (дозаписи) в файл.
 * Требуется определить исключения для каждого слоя приложения и корректно их обработать.
 */
public class FileManager {
  @NonFinal
  Path path;

  FileManager(String startPath) {
    this.path = Path.of(startPath);
    while (!this.path.toFile().exists()&&this.path.getParent()!=null){
      this.path = this.path.getParent();
    }
    if(this.path.getParent()==null) {
      if (!this.path.toFile().exists()) {
        try {
          throw new IllegalArgumentException();
        }catch (IllegalArgumentException e){
          System.out.println("Check initial path! Incorrect path entered: "+startPath);
          throw e;
        }
      }
    }
    System.out.println(this.path);
  }

  void upToRoot(int levels){
    if(levels<0 || levels>path.getNameCount()){
      System.out.println("Cannot move: illegal number of levels");
      levels = 0;
    }
    for (int i = 0; i < levels; i++){
      path = path.getParent();
    }
    System.out.println(path);
  }

  boolean levelUp(){
    if(this.path.getParent()!=null) {
      System.out.println(path = path.getParent());
      return true;
    } else System.out.println("Cannot move: root level is present");
    return false;
  }

  void goToDir(String dirName){
    StringBuilder s = new StringBuilder();
    s.append(path).append("\\").append(dirName);
    Path pathTest = Path.of(s.toString());
    if(!pathTest.toFile().exists()){
      try {
        throw new IllegalArgumentException();
      }catch (IllegalArgumentException e){
        System.out.println("Cannot access specified directory! Incorrect name entered: "+dirName);
        System.out.println("Available the following directories: ");
        getFilesList();
        throw e;
      }
    }
    path = Path.of(s.toString());
    System.out.println(path);
  }

  List <String> getFilesList(){
    List<String> allFiles = Arrays.stream(Objects.requireNonNull(path.toFile().list())).collect(Collectors.toList());
    allFiles.forEach(System.out::println);
    return allFiles;
  }

  boolean createNewFile(String fileName){
    String filePath = path+"\\"+fileName+".txt";
    File file = new File(filePath);
    boolean f = false;
    try {
      f = file.createNewFile();
      if(f)System.out.println("file created: "+fileName+".txt");
      else System.out.println("file with this name is already in folder");
    } catch (IOException e) {
      e.printStackTrace();
    }
    return f;
  }

  boolean deleteFile(String fileName){
    String filePath = path+"\\"+fileName+".txt";
    File file = new File(filePath);
    boolean f = file.delete();
    if(f)System.out.println("file deleted: "+fileName+".txt");
    else System.out.println("deletion failed: no such file in this folder");
    return f;
  }

  void writeToFile(String fileName, String text, boolean append){
    String filePath = path+"\\"+fileName+".txt";
    File file = new File(filePath);
    if (!file.exists()) {
      try {
        file.createNewFile();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, append))) {
      writer.write(text.toCharArray());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    FileManager manager = new FileManager("exceptions/src/main/java/com/epam/courses/java/fundamentals/exceptions/practice/task1/");
    //manager.upToRoot(3);
    //manager.levelUp();
    //manager.goToDir("task1");
    //manager.getFilesList();
    //manager.createNewFile("test");
    //manager.deleteFile("test");
  }

}

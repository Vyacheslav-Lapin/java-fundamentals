package com.epam.courses.java.fundamentals.strings.practice.task1;

import lombok.experimental.NonFinal;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Разработать приложение, позволяющее просматривать файлы и каталоги файловой системы, а также создавать и удалять текстовые файлы.
 * Для работы с текстовыми файлами необходимо реализовать функциональность записи (дозаписи) в файл.
 * Требуется определить исключения для каждого слоя приложения и корректно их обработать.
 */
public class FileManager {
  @NonFinal
  protected List<String> pathAsString;
  @NonFinal
  protected Path path;

  public FileManager(String startPath) {
    String[] path = startPath.split("/");
    this.pathAsString = new ArrayList<>();
    pathAsString.addAll(Arrays.asList(path));
    this.path = Path.of(startPath);
  }

  static void write (File file, String text, boolean append){
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, append))) {
      writer.write(text.toCharArray());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  void upToRoot(int levels){}

  void goToDir(String dirName){}

  List <String> getFilesList(){
    ArrayList<String> allFiles = new ArrayList<>();
    return allFiles;
  }

  void createNewFile(String fileName){}

  void deleteFile(String fileName){}

  void writeToFile(String fileName, String text, boolean append){}

  boolean pickFile(String fileName){
    return false;
  }

  public static void main(String[] args) {
    FileManager manager = new FileManager("exceptions/src/main/java/com/epam/courses/java/fundamentals/exceptions/practice/task1/");
    System.out.println(manager.path);

  }

}

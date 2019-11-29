package com.epam.courses.java.fundamentals.exeptions.practice.task1;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * Разработать приложение, позволяющее просматривать файлы и каталоги файловой системы, а также создавать и удалять текстовые файлы.
 * Для работы с текстовыми файлами необходимо реализовать функциональность записи (дозаписи) в файл.
 * Требуется определить исключения для каждого слоя приложения и корректно их обработать.
 */
public class FileManager {
  List<String> pathAsString;
  Path path;
  File file;

  public FileManager(String startPath) {
    String[] path = startPath.split("/");
    this.pathAsString = new ArrayList<String>();
    for(String s: path) pathAsString.add(s);
    this.path = Path.of(startPath);
    this.path.getFileName()
    this.file = new File();
  }

    /*try (
  BufferedInputStream sourceReader = new BufferedInputStream(new FileInputStream(StringParser.source));
  BufferedInputStream templateReader = new BufferedInputStream(new FileInputStream(StringParser.templ));
  BufferedOutputStream writer = new BufferedOutputStream(new FileOutputStream(StringParser.output, false))) {

    String result = new ByteReaderWriter().
        parse(new String(sourceReader.readAllBytes()), new String(templateReader.readAllBytes()));
    writer.write(result.getBytes());

    Path aaa = Path.of("io/src/main/java/com/epam/courses/java/fundamentals/IO/practice/task1_2/Pen.java");
    System.out.println(aaa.getFileName());
    System.out.println(aaa.getName(12));
    System.out.println(aaa.getNameCount());
  }*/

  void upToRoot(int levels){}

  void goToDir(String dirName){}

  void chooseFile(String fileName){}

  List <String> getFilesList(){}

  void createNewFile(String fileName){}

  void deleteFile(String fileName){}

  void deleteThisFile(){}

  void writeToFile(String fileName, String text, boolean append){}

  void writeToThisFile(String text, boolean append){}


}

package com.epam.courses.java.fundamentals.io.practice.task2;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JavaFileSymbolReader {

  private static long count;
  private static final List<String> keyWords = List.of("abstract", "assert", "boolean", "break", "byte",
      "case", "catch", "char", "class", "continue", "default", "do", "double", "else", "enum",
      "extends", "final", "finally", "float", "for", "goto", "if", "implements", "import",
      "instanceof", "int", "interface", "long", "native", "new", "package", "private", "protected",
      "public", "return", "short", "static", "strictfp", "super", "switch", "synchronized", "this",
      "throw", "throws", "transient", "try", "void", "volatile", "while");
  private static  List<String> keyWordsForOutput = new ArrayList<>();

  public static void main(String[] args) throws IOException {
    try {
      write();
    } catch (IOException e){
      System.out.println("Can't find or read file");
      e.printStackTrace();
    }
  }

  private static String[] readFile() throws IOException{
    File file = new File("C:\\Users\\Nikita\\IdeaProjects\\java-fundamentals" +
        "\\io\\src\\main\\java\\com\\epam\\courses\\java\\fundamentals\\io\\" +
        "practice\\task2\\example.txt");
    char[] arrayOfChar = new char[(int)file.length()];
    try(FileReader fileReader = new FileReader(file)){
      while ((fileReader.read()) != -1){
        fileReader.read(arrayOfChar);
      }
    }

    return new String(arrayOfChar).split("[\\s+{();]");
  }

  private static boolean isKeyWord(String word){
    return keyWords.contains(word);
  }

  private static void filter() throws IOException{
    String[] list = readFile();
    count = Arrays.stream(list).filter(JavaFileSymbolReader::isKeyWord).count();
    Arrays.stream(list).filter(JavaFileSymbolReader::isKeyWord).forEach(keyWordsForOutput::add);
  }

  private static void write() throws IOException {
    filter();
    File file = new File("C:\\Users\\Nikita\\IdeaProjects\\java-fundamentals" +
        "\\io\\src\\main\\java\\com\\epam\\courses\\java\\fundamentals\\io\\" +
        "practice\\task2\\result.txt");
    try(FileWriter fileWriter = new FileWriter(file)){
      fileWriter.write(String.valueOf(count) + " ");
      for (String str: keyWordsForOutput
           ) {
        fileWriter.write(str + " \n");
      }
    }
  }

}

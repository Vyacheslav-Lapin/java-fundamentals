package com.epam.courses.java.fundamentals.io.practice.task1;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JavaFileReader {
  private static long count;
  private static final List<String> keyWords = List.of("abstract", "assert", "boolean", "break", "byte",
      "case", "catch", "char", "class", "continue", "default", "do", "double", "else", "enum",
      "extends", "final", "finally", "float", "for", "goto", "if", "implements", "import",
      "instanceof", "int", "interface", "long", "native", "new", "package", "private", "protected",
      "public", "return", "short", "static", "strictfp", "super", "switch", "synchronized", "this",
      "throw", "throws", "transient", "try", "void", "volatile", "while");
  private static List<String> keyWordsForOutput = new ArrayList<>();

  public static void main(String[] args) throws IOException {
    try {
      write();
    } catch (IOException e){
      System.out.println("Can't find or open a file.");
      e.printStackTrace();
    }
  }

  public static String[] readFile() throws IOException{
    File file = new File("C:\\Users\\Nikita\\IdeaProjects\\" +
        "java-fundamentals\\io\\src\\main\\java\\com\\epam\\courses\\java\\fundamentals\\io\\" +
        "practice\\task1\\example.txt");
    try(InputStream inputStream = new FileInputStream(file);
    InputStreamReader inputStreamReader = new InputStreamReader(inputStream)){
      char[] arrayOfChar = new char[(int)file.length()];
      inputStreamReader.read(arrayOfChar);
      return new String(arrayOfChar).replaceAll("\\{","").replaceAll("}","").
          replaceAll("\\(","\n").split("[\\s+]");
    }
  }

  private static boolean isKeyWord(String word){
    return keyWords.contains(word);
  }

  private static List<String> filter() throws IOException{
    String[] list = readFile();
    count = Arrays.stream(list).filter(JavaFileReader::isKeyWord).count();
    Arrays.stream(list).filter(JavaFileReader::isKeyWord).forEach(keyWordsForOutput::add);
    return keyWordsForOutput;
  }

  private static void write() throws IOException{
    filter();
    File file = new File("C:\\Users\\Nikita\\IdeaProjects\\java-fundamentals" +
        "\\io\\src\\main\\java\\com\\epam\\courses\\java\\fundamentals\\io\\" +
        "practice\\task1\\result.txt");
    try(OutputStream outputStream = new FileOutputStream(file);
    OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream)){
      outputStreamWriter.write((int)count);
      for (String str:keyWordsForOutput
           ) {
        outputStreamWriter.write(str + " ");
      }
    }
  }

}

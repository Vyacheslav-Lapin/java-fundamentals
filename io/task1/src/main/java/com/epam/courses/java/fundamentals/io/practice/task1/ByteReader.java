package com.epam.courses.java.fundamentals.io.practice.task1;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ByteReader {

  private static long count;
  private static final List<String> keywords = List.of("abstract", "assert", "boolean", "break", "byte",
      "case", "catch", "char", "class", "continue", "default", "do", "double", "else", "enum",
      "extends", "final", "finally", "float", "for", "goto", "if", "implements", "import",
      "instanceof", "int", "interface", "long", "native", "new", "package", "private", "protected",
      "public", "return", "short", "static", "strictfp", "super", "switch", "synchronized", "this",
      "throw", "throws", "transient", "try", "void", "volatile", "while");
  private static List<String> keywordsToOutput = new ArrayList<>();


  public static String[] readFile() throws IOException {
    File file = new File("C:\\Users\\Алексей\\IdeaProjects\\input.txt");
    try (InputStream is = new FileInputStream(file);
        InputStreamReader isr = new InputStreamReader(is)) {
      char[] charArray = new char[(int) file.length()];
      isr.read(charArray);
      return new String(charArray).replaceAll("\\{", "")
          .replaceAll("}", "")
          .replaceAll("\\(", "\n")
          .split("[\\s+]");
    }
  }

  private static List<String> filter() throws IOException {
    String[] list = readFile();
    count = Arrays.stream(list).filter(ByteReader::isKeyword)
        .count();
    Arrays.stream(list).filter(ByteReader::isKeyword)
        .forEach(keywordsToOutput::add);
    return keywordsToOutput;
  }

  public static void main(String[] args) throws IOException {
    writeToFile();
  }

  private static void writeToFile() throws IOException {
    filter();
    File file = new File("C:\\Users\\Алексей\\IdeaProjects\\output.txt");
    try(OutputStream os = new FileOutputStream(file);
    OutputStreamWriter osw = new OutputStreamWriter(os)) {
      osw.write((int)count);
      for (String s : keywordsToOutput) {
        osw.write(s + ' ');
      }
    }
  }

  private static boolean isKeyword(String word) {
    return keywords.contains(word);
  }
}

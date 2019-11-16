package com.epam.courses.java.fundamentals.io.practice.task1;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SymbolReader {

  private static long count;
  private static final List<String> keywords = List.of("abstract", "assert", "boolean", "break", "byte",
      "case", "catch", "char", "class", "continue", "default", "do", "double", "else", "enum",
      "extends", "final", "finally", "float", "for", "goto", "if", "implements", "import",
      "instanceof", "int", "interface", "long", "native", "new", "package", "private", "protected",
      "public", "return", "short", "static", "strictfp", "super", "switch", "synchronized", "this",
      "throw", "throws", "transient", "try", "void", "volatile", "while");
  private static List<String> keywordsToOutput = new ArrayList<>();

  private static String[] readFile() throws IOException {
    File file  = new File("C:\\Users\\Алексей\\IdeaProjects\\input.txt");
    char[] chars = new char[(int) file.length()];
    try (FileReader fr = new FileReader(file)) {
      while ((fr.read()) != -1) {
        fr.read(chars);
      }
    }
    return new String(chars).split("[\\s+{();]");
  }

  private static void filter() throws IOException {
    String[] list = readFile();
    count = Arrays.stream(list)
        .filter(SymbolReader::isKeyword)
        .count();
    Arrays.stream(list)
        .filter(SymbolReader::isKeyword)
        .forEach(keywordsToOutput::add);
  }

  private static boolean isKeyword(String word) {
    return keywords.contains(word);
  }

  private static void writeFile() throws IOException {
    filter();
    File file = new File("C:\\Users\\Алексей\\IdeaProjects\\output.txt");
    try (FileWriter fw = new FileWriter(file)) {
      fw.write(String.valueOf(count) + " ");
      for (String s : keywordsToOutput) {
        fw.write(s + " \n");
      }
    }
  }

  public static void main(String[] args) throws IOException {
    writeFile();
  }
}

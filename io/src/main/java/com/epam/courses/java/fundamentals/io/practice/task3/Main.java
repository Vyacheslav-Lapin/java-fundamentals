package com.epam.courses.java.fundamentals.io.practice.task3;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Main {

  public static void main(String... ___) throws IOException {
    String source = "io/src/main/resources/Text.txt";
    String destination = "io/src/main/resources/ConvertedText.txt";

    var fileConverter = new FileConverter();
    fileConverter.readFromFile(source, StandardCharsets.UTF_8);
    fileConverter.writeToFile(fileConverter.getData().toString(), destination, StandardCharsets.UTF_16);
  }
}

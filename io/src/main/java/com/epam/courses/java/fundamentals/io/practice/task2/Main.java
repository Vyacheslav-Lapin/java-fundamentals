package com.epam.courses.java.fundamentals.io.practice.task2;

import java.io.IOException;

public class Main {

  public static void main(String[] args) throws IOException {
    String source = "io/src/main/resources/RegExpExample.java";
    String destination = "io/src/main/resources/Keywords.txt";

    var charStreamProcessor = new CharStreamProcessor();
    charStreamProcessor.readCharsFromFile(source); // 1
    charStreamProcessor.searchByKeyWords(charStreamProcessor.getData()); // 2
    charStreamProcessor.countKeyWords(charStreamProcessor.getProcessedData()); // 3
    charStreamProcessor.writeCharsToFile(destination, charStreamProcessor.getKeyWords()); // 4
  }
}

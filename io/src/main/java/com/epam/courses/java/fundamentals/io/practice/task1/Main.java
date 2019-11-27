package com.epam.courses.java.fundamentals.io.practice.task1;

import java.io.IOException;

public class Main {

  public static void main(String[] args) throws IOException {
    String source = "io/src/main/resources/RegExpExample.java";
    String destination = "io/src/main/resources/Keywords.txt";

    var byteStreamProcessor = new ByteStreamProcessor();
    byteStreamProcessor.readBytesFromFile(source); // 1
    byteStreamProcessor.searchByKeyWords(byteStreamProcessor.getData()); // 2
    byteStreamProcessor.countKeyWords(byteStreamProcessor.getProcessedData()); // 3
    byteStreamProcessor.writeBytesToFile(destination, byteStreamProcessor.getKeyWords()); // 4
  }
}

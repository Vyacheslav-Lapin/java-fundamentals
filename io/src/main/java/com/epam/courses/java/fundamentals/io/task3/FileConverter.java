package com.epam.courses.java.fundamentals.io.task3;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileConverter {
  static public void convert(Path fromFile,  Charset fromCharset, Path toFile, Charset toCharset) throws IOException {
    var content = Files.readString(fromFile, fromCharset);
    Files.writeString(toFile, content, toCharset);
  }
}

package com.epam.courses.java.fundamentals.io.practice.task3;

import java.io.*;

public class UtfChanger {


  public void convert() {
    String infile = "io/src/main/java/com/epam/courses/java/fundamentals/io/practice/task3/fileUTF8";
    File outfile = new File("io/src/main/java/com/epam/courses/java/fundamentals/io/practice/task3/fileUTF16");
    try {
      outfile.createNewFile();
    } catch (IOException e) {
      e.printStackTrace();
    }
    try (Reader in = new InputStreamReader(new FileInputStream(infile), "UTF-8");
         Writer out = new OutputStreamWriter(new FileOutputStream(outfile), "UTF-16")) {
      char buffer[] = new char[2048];
      int len;
      while ((len = in.read(buffer, 0, buffer.length)) != -1) {
        out.write(buffer, 0, len);
      }
    } catch (IOException ex) {
      System.out.println(ex.getMessage());
    }
  }
}

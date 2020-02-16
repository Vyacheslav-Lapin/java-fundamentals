package com.epam.courses.java.fundamentals.io.practice.task3;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Encoding {

  private File file = new File("C:\\Users\\Nikita\\IdeaProjects\\java-fundamentals" +
      "\\io\\src\\main\\java\\com\\epam\\courses\\java\\fundamentals\\io\\" +
      "practice\\task3\\text.txt");

  private void rewrite() throws IOException{
    char[] text = new char[(int)file.length()];
    try(Reader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "Cp1251"))){
      reader.read(text);
    }
    try (Writer writer = new BufferedWriter(new OutputStreamWriter(
        new FileOutputStream(file),
        StandardCharsets.UTF_16))){
      writer.write(text);
    }
  }
}

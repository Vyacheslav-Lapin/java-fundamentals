package com.epam.courses.java.fundamentals.io.practice.task3;

import lombok.Getter;
import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.nio.charset.Charset;

@Getter
public class FileConverter {

  private StringBuilder data = new StringBuilder();

  public String readFromFile(@NotNull String fileName, Charset encoding) throws IOException {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(
        new FileInputStream(fileName), encoding))) {
      String line;
      while ((line = br.readLine()) != null)
        data.append(line).append("\n");
    }

    return data.toString();
  }

  public void writeToFile(@NotNull String data, @NotNull String fileName, Charset encoding) throws IOException {
    try (BufferedOutputStream bs = new BufferedOutputStream(new FileOutputStream(fileName))) {
      bs.write(data.getBytes(encoding));
    }
  }
}

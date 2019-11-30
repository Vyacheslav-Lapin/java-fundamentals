package com.epam.courses.java.fundamentals.io.task3;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FileConverterTests {
  @Test
  void testConversionUtf8toUtf16() throws URISyntaxException, IOException {
    URL url = getClass().getResource("/utf-8.ru.txt");
    Path javaCodeFilePath = Paths.get(url.toURI());
    Path tmpPath = Paths.get("tmp/utf-16.ru.txt");
    tmpPath.toFile().getParentFile().mkdirs();
    FileConverter.convert(javaCodeFilePath, StandardCharsets.UTF_8, tmpPath, StandardCharsets.UTF_16);

    var contents = Files.readString(tmpPath, StandardCharsets.UTF_16);
    var firstWord = contents.split("\\s")[0];
    assertEquals(firstWord, "Многообра́зие");
  }
}

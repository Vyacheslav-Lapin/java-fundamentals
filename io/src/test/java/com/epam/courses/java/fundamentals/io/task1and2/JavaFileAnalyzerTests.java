package com.epam.courses.java.fundamentals.io.task1and2;

import org.junit.jupiter.api.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JavaFileAnalyzerTests {
  private String testJavaFileName = "/QuestionnaireApp.java";


  private void verifyAndWrite(Map<String, Long> keywords, String fileName) throws IOException {
    var keyWordsAsStringMap = keywords.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, e -> String.valueOf(e.getValue())));
    assertEquals(20, keywords.size());


    Properties properties = new Properties();
    properties.putAll(keyWordsAsStringMap);
    properties.store(new FileOutputStream(fileName + ".properties"), null);

  }

  //task 1
  @Test
  void keyWordsInFileBytesWay() throws URISyntaxException, IOException {
    URL url = getClass().getResource(testJavaFileName);
    Path javaCodeFilePath = Paths.get(url.toURI());
    var keyWords = JavaFileAnalyzer.findUsedKeyWordsBytesWay(javaCodeFilePath);
    verifyAndWrite(keyWords, "keywords_bytes_way");
  }

  //task 2
  @Test
  void keyWordsInFileCharsWay() throws URISyntaxException, IOException {
    URL url = getClass().getResource(testJavaFileName);
    Path javaCodeFilePath = Paths.get(url.toURI());
    var keyWords = JavaFileAnalyzer.findUsedKeyWordsCharWay(javaCodeFilePath);
    verifyAndWrite(keyWords, "keywords_chars_way");
  }

}

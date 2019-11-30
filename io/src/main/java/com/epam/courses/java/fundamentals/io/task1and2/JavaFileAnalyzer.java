package com.epam.courses.java.fundamentals.io.task1and2;


import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class JavaFileAnalyzer {


  public static Map<String, Long> findUsedKeyWordsBytesWay(Path javaCodeFilePath) throws IOException {
    byte[] bFile = Files.readAllBytes(javaCodeFilePath);
    var dataAsString = new String(bFile);

    return findUsedKeywordsOnString(dataAsString);
  }

  private static Map<String, Long> findUsedKeywordsOnString(String dataAsString) {
    var listOfWords = Pattern.compile("\\s|[{}();]").split(dataAsString);
    return Arrays.stream(listOfWords).
        filter(word -> JavaKeywords.keyWords.contains(word))
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

  }

  public static Map<String, Long> findUsedKeyWordsCharWay(Path javaCodeFilePath) throws IOException {
    var contents = Files.readString(javaCodeFilePath, Charset.defaultCharset());
    return findUsedKeywordsOnString(contents);
  }


}

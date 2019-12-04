package com.epam.courses.java.fundamentals.io.practice.task1;

import lombok.Getter;
import lombok.NonNull;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Getter
public class ByteStreamProcessor {

  private StringBuilder data;
  private List<String> processedData;
  private HashMap<String, Integer> keyWords;

  private Pattern pattern = Pattern.compile("abstract |continue |for |new |switch |assert |default |goto |" +
      "package |synchronized |boolean |do |if |private |this |break |double |implements |protected |" +
      "throw |byte |else |import |public |throws |case |enum |instanceof |return |transient |catch |" +
      "extends |int |short |try |char |final |interface |static |void |class |finally |long |strictfp |" +
      "volatile |const |float |native |super |while |var ");

  public ByteStreamProcessor() {
    this.data = new StringBuilder();
    this.processedData = new ArrayList<>();
    this.keyWords = new HashMap<>();
  }

  public String readBytesFromFile(@NonNull String source) throws IOException {
    try (FileInputStream inputStream = new FileInputStream(source)) {
      int value;
      while ((value = inputStream.read()) != -1) // The input value of −1 signifies the end of a file
        data.append((char) value);
    }

    return data.toString();
  }

  public void writeBytesToFile(@NonNull String destination, @NonNull String keyWords) throws IOException {
    try (FileOutputStream outputStream = new FileOutputStream(destination)) {
      outputStream.write(keyWords.getBytes());
    }
  }

  public List<String> searchByKeyWords(@NonNull StringBuilder data) {
    Matcher matcher = pattern.matcher(data);

    while (matcher.find())
      processedData.add(matcher.group(0));

    return processedData;
  }

  public String countKeyWords(@NonNull List<String> processedData) {
    for (int i = 0; i < processedData.size(); i++) {
      String keyWord = processedData.get(i);
      if (!keyWords.containsKey(keyWord))
        keyWords.put(keyWord, 1);
      else
        keyWords.put(keyWord, keyWords.get(keyWord) + 1);
    }

    return keyWords.toString();
  }

  public String getKeyWords() {
    return keyWords.toString();
  }

  public Integer getKeyWords(String key) {
    return keyWords.get(key);
  }
}

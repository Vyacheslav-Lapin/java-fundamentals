package com.epam.courses.java.fundamentals.oop.practice.logger;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CrazyLogger {
  private StringBuilder logStore = new StringBuilder();

  public void log(String entry){
    LocalDateTime date = LocalDateTime.now();
    logStore.append(date.format(DateTimeFormatter.ofPattern("dd-mm-YYYY : hh-mm: "))).append(entry).append("\n");
  }

  public List<String> search(String pattern) {
    Stream<String> entries = Arrays.stream(logStore.toString().split("\n"));
    List<String> list = entries.filter(entry -> entry.contains(pattern)).collect(Collectors.toList());
    list.forEach(System.out::println);
    return list;

  }
}

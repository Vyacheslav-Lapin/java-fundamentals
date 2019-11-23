package com.epam.courses.java.fundamentals.oop.practice.logger;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CrazyLogger {
  private StringBuilder logStore = new StringBuilder();

  public void log(String entry){
    DateFormat dateFormat = new SimpleDateFormat("dd-mm-YYYY : hh-mm: ");
    Date date = new Date();
    String dateString=dateFormat.format(date);
    logStore.append(dateString).append(entry).append("\n");
  }

  public List<String> search(String pattern) {
    Stream<String> entries = Arrays.stream(logStore.toString().split("\n"));
    return entries.filter(entry -> entry.contains(pattern)).collect(Collectors.toList());

  }
}

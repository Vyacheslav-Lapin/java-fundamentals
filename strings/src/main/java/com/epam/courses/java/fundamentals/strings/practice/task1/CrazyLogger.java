package com.epam.courses.java.fundamentals.strings.practice.task1;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CrazyLogger {

  private StringBuilder storage = new StringBuilder();
  private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-YYYY : hh-mm");


  public void log(String toLog){
    LocalDateTime dateTime = LocalDateTime.now();
    storage.append(dateTime.format(formatter) + " - " + toLog + ";");
  }

  public String search(String inf){
    String[] str = storage.toString().split(";");
    for (String s: str) {
      if(s.contains(inf))
        return s;
    }
    return "No found";
  }

}

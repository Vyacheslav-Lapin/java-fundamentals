package com.epam.courses.java.fundamentals.strings.practice.task1;

import org.jetbrains.annotations.NotNull;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CrazyLoger {

  private StringBuilder log;
  private DateTimeFormatter dateTimeFormatter;

  public CrazyLoger(){
    this.log = new StringBuilder();
    this.dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-YYYY : hh-mm-ss");
  }

  private String getCurrentTime(){
    return dateTimeFormatter.format(LocalDateTime.now());
  }

  public String getLog() {
    return log.toString();
  }

  public void addToLog(@NotNull String str){
    log.append(getCurrentTime()).append(" - ").append(str).append(";").append("\n");
  }

  public String search(@NotNull String str){
    String[] logArray = log.toString().split("\n");
    StringBuilder result = new StringBuilder();
    for(int i = 0; i < logArray.length; i++){
      if(logArray[i].equals(str))
        result.append(logArray[i]).append(" | ");
    }
    return result.toString();
  }
}

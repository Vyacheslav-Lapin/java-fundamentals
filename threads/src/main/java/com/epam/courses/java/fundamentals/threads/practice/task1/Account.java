package com.epam.courses.java.fundamentals.threads.practice.task1;

import lombok.Getter;
import lombok.experimental.NonFinal;

@Getter
public class Account {
  long accNumber;
  @NonFinal
  double value;
  StringBuilder log;

  public Account(long accNumber, double value) {
    this.accNumber = accNumber;
    this.value = value;
    this.log = new StringBuilder();
  }

  public void addToLog(String transaction){
    log.append(transaction);
  }

  public void setValue(double value) {
    this.value = value;
  }
}


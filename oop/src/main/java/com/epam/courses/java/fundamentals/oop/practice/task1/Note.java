package com.epam.courses.java.fundamentals.oop.practice.task1;

import lombok.Data;
import lombok.experimental.NonFinal;

public class Note {

  @NonFinal
  String title;

  @NonFinal
  String body;

  int id;

  public String getTitle() {
    return title;
  }

  public String getBody() {
    return body;
  }

  public int getId() {
    return id;
  }
}

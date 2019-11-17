package com.epam.courses.java.fundamentals.oop.practice.task1;

import lombok.Data;
import lombok.experimental.NonFinal;

public class Note {

  @NonFinal
  String title;

  @NonFinal
  String body;

  int id;

  public Note(int id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public String getBody() {
    return body;
  }

  public int getId() {
    return id;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setBody(String body) {
    this.body = body;
  }

  public void setId(int id) {
    this.id = id;
  }
}

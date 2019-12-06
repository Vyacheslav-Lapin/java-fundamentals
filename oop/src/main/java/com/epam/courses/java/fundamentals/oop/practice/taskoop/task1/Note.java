package com.epam.courses.java.fundamentals.oop.practice.taskoop.task1;

import lombok.Data;
import lombok.experimental.NonFinal;

@Data
public class Note {

  @NonFinal
  String title;

  @NonFinal
  String body;

  int id;
}

package com.epam.courses.java.fundamentals.jdbc.practice.task2;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldNameConstants;
import lombok.experimental.NonFinal;

@Getter
@ToString
@FieldNameConstants
@AllArgsConstructor
public class Book {

  Long id;

  String Author;

  String Title;
  @NonFinal
  String genre;
  @NonFinal
  int shelf_id;

  public Book(String author, String title, String genre, int shelf_id) {
    id = 0L;
    Author = author;
    Title = title;
    this.genre = genre;
    this.shelf_id = shelf_id;
  }
}

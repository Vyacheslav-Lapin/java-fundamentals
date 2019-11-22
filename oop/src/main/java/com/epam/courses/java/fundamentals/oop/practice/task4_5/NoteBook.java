package com.epam.courses.java.fundamentals.oop.practice.task4_5;

import lombok.Getter;

@Getter
public class NoteBook extends Stationery {

  private final NoteBookType noteBookType;

  public NoteBook(String name, int price, NoteBookType noteBookType) {
    super(name, price);
    this.noteBookType = noteBookType;
  }

  @Override
  public String toString() {
    return "NoteBook{" +
        "name=" + getName() +
        ", price=" + getPrice() +
        ", noteBookType=" + noteBookType +
        '}';
  }
}

package com.epam.courses.java.fundamentals.oop.practice.students;

import java.util.Objects;

public class IntMark implements Mark{
  private int mark;
  public IntMark(int mark) {
    this.mark = mark;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    IntMark intMark = (IntMark) o;
    return mark == intMark.mark;
  }

  @Override
  public int hashCode() {
    return Objects.hash(mark);
  }
}

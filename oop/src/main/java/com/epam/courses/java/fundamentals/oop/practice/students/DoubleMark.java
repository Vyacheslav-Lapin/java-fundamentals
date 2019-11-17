package com.epam.courses.java.fundamentals.oop.practice.students;

import java.util.Objects;

public class DoubleMark implements Mark{
  private double mark;
  public DoubleMark(double mark) {
    this.mark = mark;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    DoubleMark that = (DoubleMark) o;
    return Double.compare(that.mark, mark) == 0;
  }

  @Override
  public int hashCode() {
    return Objects.hash(mark);
  }
}

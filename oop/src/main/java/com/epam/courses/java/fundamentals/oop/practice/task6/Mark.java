package com.epam.courses.java.fundamentals.oop.practice.task6;

import java.util.Objects;

public class Mark<T> {
  private T mark;

  public Mark(T mark){
    this.mark = mark;
  }

  public T getMark() {
    return mark;
  }

  public void setMark(T mark) {
    this.mark = mark;
  }

  @Override
  public int hashCode() {
    return Objects.hash(mark);
  }

  @Override
  public boolean equals(Object obj) {
    if(this == obj)
      return true;
    if(obj == null || this.getClass() != obj. getClass())
      return false;
    Mark<T> mark = (Mark<T>)obj;
    return this.mark == mark.mark;
  }

  @Override
  public String toString() {
    return "Mark: " + mark;
  }
}

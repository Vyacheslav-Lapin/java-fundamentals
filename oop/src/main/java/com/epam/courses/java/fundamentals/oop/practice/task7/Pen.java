package com.epam.courses.java.fundamentals.oop.practice.task7;

import java.util.Objects;

public class Pen {
  private Color colorInk;
  private String mark;
  private String type;

  public Pen(Color colorInk, String mark, String type) {
    this.colorInk = colorInk;
    this.mark = mark;
    this.type = type;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Pen pen = (Pen) o;
    return colorInk == pen.colorInk &&
        Objects.equals(mark, pen.mark) &&
        Objects.equals(type, pen.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(colorInk, mark, type);
  }

  @Override
  public String toString() {
    return "Pen{" +
        "colorInk=" + colorInk +
        ", mark='" + mark + '\'' +
        ", type='" + type + '\'' +
        '}';
  }
}

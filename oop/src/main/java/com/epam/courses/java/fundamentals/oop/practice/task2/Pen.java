package com.epam.courses.java.fundamentals.oop.practice.task2;

import lombok.experimental.NonFinal;
import org.jetbrains.annotations.Contract;
import java.util.Objects;

/**
 * The Pen class with equals(), hashCode() and toString() implementation
 *
 * @author Irina Panova
 */
public class Pen {

  @NonFinal
  PenType penType;

  @NonFinal
  InkColor inkColor;

  public Pen(PenType penType, InkColor inkColor) {
    this.penType = penType;
    this.inkColor = inkColor;
  }

  public PenType getPenType() {
    return penType;
  }

  public void setPenType(PenType penType) {
    this.penType = penType;
  }

  public InkColor getInkColor() {
    return inkColor;
  }

  public void setInkColor(InkColor inkColor) {
    this.inkColor = inkColor;
  }

  @Override
  @Contract(value = "null -> false", pure = true)
  public boolean equals(Object obj) {
    if (this == obj) return true;

    if (obj == null || this.getClass() != obj.getClass()) return false;

    Pen pen = (Pen) obj;

    return (penType == pen.penType || (penType != null && penType.equals(pen.getPenType()))
        && (inkColor == pen.inkColor || (inkColor != null && inkColor.equals(pen.getInkColor()))));
  }

  @Override
  public int hashCode() {
    return Objects.hash(penType, inkColor);
  }

  @Override
  public String toString() {
    return "Pen{" +
        "penType=" + penType +
        ", inkColor=" + inkColor +
        '}';
  }
}

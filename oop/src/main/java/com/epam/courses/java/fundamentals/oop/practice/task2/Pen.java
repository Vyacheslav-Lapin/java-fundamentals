package com.epam.courses.java.fundamentals.oop.practice.task2;

import lombok.experimental.NonFinal;
import org.jetbrains.annotations.Contract;

import java.util.Objects;

public class Pen {

  String color;

  Type type;

  @NonFinal
  boolean isPremium;

  @NonFinal
  LineThickness thickness = LineThickness.UNKNOWN;

  @NonFinal
  CaseMaterial material = CaseMaterial.UNKNOWN;

  public Pen(String color, Type type) {
    this.color = color;
    this.type = type;
  }

  public void setPremium(boolean premium) {
    isPremium = premium;
  }

  public void setThickness(LineThickness thickness) {
    this.thickness = thickness;
  }

  public void setMaterial(CaseMaterial material) {
    this.material = material;
  }

  @Override
  public String toString() {
    return "Pen{" +
        "color='" + color + '\'' +
        ", type=" + type +
        ", isPremium=" + isPremium +
        ", thickness=" + thickness +
        ", material=" + material +
        '}';
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Pen pen = (Pen) o;
    return isPremium == pen.isPremium &&
        Objects.equals(color, pen.color) &&
        type == pen.type &&
        thickness == pen.thickness &&
        material == pen.material;
  }

  @Override
  public int hashCode() {
    return Objects.hash(color, type, isPremium, thickness, material);
  }
}

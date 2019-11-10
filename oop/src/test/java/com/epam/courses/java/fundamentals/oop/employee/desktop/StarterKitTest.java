package com.epam.courses.java.fundamentals.oop.employee.desktop;

import com.epam.courses.java.fundamentals.oop.practice.employee.desktop.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class StarterKitTest {
  Office of = new Office();

  @Test
  void CreateStarterKitTest() {
    //checking the presence of a pen and a notebook in the starter kit
    ArrayList<Stationery> starterKit = of.createStarterKit();
    boolean x = new BallPen() instanceof Pen;
    assertTrue(starterKit.stream().anyMatch(s -> s instanceof Pen));
    assertTrue(starterKit.stream().anyMatch(s -> s instanceof Notebook));

  }
}

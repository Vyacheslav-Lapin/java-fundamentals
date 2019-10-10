package com.epam.courses.java.fundamentals.oop.practice.task6;

import java.util.Arrays;

public class Main {
  public static void main(String[] args) {
    NotePad np = new NotePad();
    np.addNote("0", "0");
    np.addNote("1", "1");
    np.addNote("2", "2");
    np.addNote("3", "3");

    System.out.println(Arrays.toString(np.getNotes()));
    System.out.println("===================");
    np.removeNote(1);
    System.out.println(Arrays.toString(np.getNotes()));
    System.out.println("===================");
    np.removeNote(1);
    System.out.println(Arrays.toString(np.getNotes()));
    System.out.println("===================");
    np.editNote(2, "6", "6");
    System.out.println(Arrays.toString(np.getNotes()));

  }
}

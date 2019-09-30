package com.epam.courses.java.fundamentals.intro.practice.task5;

import java.util.Scanner;

public class CrossMatrixTestDrive {

  public static void main(String[] args) {
    System.out.print("Enter the size of the matrix: ");
    Scanner scan = new Scanner(System.in);
    try {
      int number = scan.nextInt();
      CrossMatrix cr = new CrossMatrix(number);
      System.out.println(cr);
    } catch (Exception e) {
      System.err.println(e);
    } finally {
      scan.close();
    }
  }

}

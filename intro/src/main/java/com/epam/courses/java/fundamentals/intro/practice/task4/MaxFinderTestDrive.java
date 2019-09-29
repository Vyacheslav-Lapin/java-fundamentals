package com.epam.courses.java.fundamentals.intro.practice.task4;

import java.util.Scanner;

public class MaxFinderTestDrive {

  public static void main(String[] args) {
    System.out.print("Enter the number of elements in array: ");
    Scanner scan = new Scanner(System.in);
    try {
      int number = scan.nextInt();
      System.out.println("Array of " + number + " elements is created");

      double[] arr1 = new double[number];
      initializeArray(arr1);
      printArray(arr1);

      MaxFinder mf = new MaxFinder(arr1);
      System.out.println("Maximum value: " + mf.getMaximum());
    } catch (Exception e) {
      System.err.println(e);
    } finally {
      scan.close();
    }
  }

  private static void initializeArray(double[] arr) {
    for (int i = 0; i < arr.length; i++) {
      double randNumber = Math.random() * 100;
      arr[i] = Math.round(randNumber);
    }
  }

  private static void printArray(double[] arr) {
    for (double elem : arr) {
      System.out.println(elem);
    }
  }
}

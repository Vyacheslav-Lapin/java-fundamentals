package com.epam.courses.java.fundamentals.intro.practice.task4;

import java.util.Scanner;

public class MaxFinderTestDrive {

  public static void main(String[] args) {
    System.out.print("Enter the number of elements in array: ");
    Scanner scan = new Scanner(System.in);
    try {
      int number = scan.nextInt();
      double[] arr1 = new double[number];
      System.out.println("Array of " + number + " elements is created");
      
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
  	double randNumber = 0.0;
  	
    for (int i = 0; i < arr.length; i++) {
      randNumber = Math.random() * 100;
      arr[i] = Math.round(randNumber);
    }
  }

  private static void printArray(double[] arr) {
    for (double elem : arr) {
      System.out.println(elem);
    }
  }
}

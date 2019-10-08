package com.epam.courses.java.fundamentals.intro.practice.task2;

import static java.lang.Math.pow;
import static java.lang.System.out;

import org.jetbrains.annotations.Contract;

import java.util.ArrayList;
import java.util.List;

public class MinFinder {

  private double e;

  @Contract(pure = true)
  private MinFinder(double e) {
    this.e = e;
  }

  public static double findMin(double e) {
    return new MinFinder(e).findMin();
  }

  @Contract(pure = true)
  private static double getA(int n) {
    return 1 / pow(n + 1, 2);
  }

  public static void main(String... __) {
    out.println("Минимальный индекс: " + findMin(0.1));
  }

  @Contract(pure = true)
  private boolean filter(double a) {
    return a < e;
  }

  private int findMin() {
    if(this.e >1) return 0;
    int n = 0;
    for (int i = 1; i < Integer.MAX_VALUE; i++){
      if (this.filter(getA(i))){
        n = i;
        break;
      }
      out.print(getA(i)+"\n");
    }
    return n;
  }
}

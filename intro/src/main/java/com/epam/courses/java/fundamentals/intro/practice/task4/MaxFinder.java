/* Реализация до fork'a
  import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        System.out.print("Введите размер массива(должен быть четным числом):");
        Scanner sc = new Scanner(System.in);
        try {
            int[] array = new int[sc.nextInt()];
            if (array.length % 2 == 0) {
                for (int i = 0; i < array.length; i++) {
                    System.out.print("Введите элемент массива №" + i + ":");
                    array[i] = sc.nextInt();
                }
                int[] arrayResult = new int[array.length / 2];
                for (int i = 0; i < arrayResult.length; i++) {
                    arrayResult[i] = array[i] + array[array.length - i - 1];
                    System.out.println(arrayResult[i]);
                }
                int max = arrayResult[0];
                for (int i:arrayResult) {
                    if (i > max) max = i;
                }
                System.out.println("Max of New Array: " + max);

            } else System.out.println("Ну говорили же тебе, вводи четное число...");
        } catch (Exception e) {
            System.out.println("Размер массива должен быть положительным и целочисленным числом. Элементы массива целочисленныи числами.");
        }
    }
}

 */
package com.epam.courses.java.fundamentals.intro.practice.task4;

/**
 * MaxFinder.
 */
public class MaxFinder {

  private double[] as;

  public MaxFinder(double... as) {
    this.as = as;
  }

  public double getMaximum() {
    double maxValue=as[0];
    for (int i=0;i<as.length-1;i++) {
      if (as[i]+as[i+1]>maxValue) maxValue=as[i]+as[i+1];
    }
    return maxValue;
  }
  public static void main(String[] args) {
    System.out.println(new MaxFinder(0.1,0.2,0.3,0.4,0.2,0.3,0.1).getMaximum());
  }
}

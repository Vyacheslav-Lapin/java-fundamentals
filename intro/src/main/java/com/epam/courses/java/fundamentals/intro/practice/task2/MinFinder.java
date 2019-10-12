/* Предыдущая реализация, по условиям дз предыдущей группы, без fork с GitHub.
import java.util.Scanner;

public class Task2 {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите количество элементов в массиве:");
        try {
            int elements = sc.nextInt();
            System.out.print("Введите значение эпсилон:");
            double epsilon = sc.nextDouble();
            if (epsilon<=0) throw new Exception();
            double[] elemArray = new double[elements];
            for (int i = 0; i < elemArray.length; i++) {
                elemArray[i] = 1.0 / ((i + 2) * (i + 2));    //в условиях задачи первый номер элемента 1
                System.out.println("Элемент №" + (i + 1) + ": " + elemArray[i]);
            }

            for (int i = 0; i < elemArray.length; i++) {
                if (elemArray[i] < epsilon) {
                    System.out.println("Номер первого элемента меньше эпсилон: " + (i + 1));
                    break;
                }
                if (i == elemArray.length - 1) System.out.println("Не найден элемент массива меньше эпсилон.");
            }
        } catch (Exception e) {
            System.out.println("Размер массива должен быть положительным и целочисленным. Эпсилон должна быть >0.");
        }

    }

}

*/
package com.epam.courses.java.fundamentals.intro.practice.task2;

import static java.lang.Math.pow;
import static java.lang.System.out;

import org.jetbrains.annotations.Contract;

public class MinFinder {

  private double e;

  @Contract(pure = true)
  private MinFinder(double e) {
    this.e = e;
  }

  public static int findMin(double e) {
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
    int i=1;
    do {
      out.println(getA(i));
    } while (!filter(getA(i++)));
    return i-1; //при запуске test выдает только два первые элементы массива, я счел что нужну вывести и третий
                // который как раз и является первым удовлетворяющим условию. Ниже реализация которая соотв. тесту.
 /*    while(!filter(getA(i))) {
      out.println(getA(i++));
    }
    return i; */
  }
}

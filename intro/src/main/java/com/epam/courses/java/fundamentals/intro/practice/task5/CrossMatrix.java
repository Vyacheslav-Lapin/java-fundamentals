/* Тоже самое, но чуть-чуть подругому.
  import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {
        System.out.print("Введите размер матрицы(целое положительное число):");
        Scanner sc = new Scanner(System.in);
        try {
            int arrayValue = sc.nextInt();
            int[][] matrix = new int[arrayValue][arrayValue];
            for (int i = 0; i < arrayValue; i++) {
                for (int k = 0; k < arrayValue; k++) {
                    if (i == k || (k == arrayValue - 1 - i)) matrix[i][k] = 1;
                    else matrix[i][k] = 0;
                    System.out.print(matrix[i][k] + " ");
                }
                System.out.println();
            }
        } catch (Exception e) {
            System.out.println("Размер должен быть положительны, целочиленным числом.");
        }
    }
}

 */
package com.epam.courses.java.fundamentals.intro.practice.task5;

public class CrossMatrix {

  private int size;

  public CrossMatrix(int size) {
    this.size = size;
  }

  public boolean get(int x, int y) {
    if ((x==y)||((y+x)==(size-1))) return true;
    return false;
  }

  @Override
  public String toString() {

    String result = "";

    for (int x = 0; x < size; x++) {
      for (int y = 0; y < size; y++)
        result += get(x, y) ? "1 " : "0 ";
      result += "\n";
    }
    return result;
  }
  public static void main(String[] args) {
    System.out.println(new CrossMatrix(6));
  }
}

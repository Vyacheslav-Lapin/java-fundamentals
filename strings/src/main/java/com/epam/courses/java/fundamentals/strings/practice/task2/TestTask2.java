package com.epam.courses.java.fundamentals.strings.practice.task2;

import org.checkerframework.framework.util.Heuristics;

import java.io.IOException;
import java.util.Scanner;

public class TestTask2 {
  public static void main(String[] args) throws IOException {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Choose you're language:\n1)RU\n2)EN\n3)default");
    int numberOfLocale = scanner.nextInt();
    Resource resource = new Resource(numberOfLocale);
    System.out.println(resource.getString("intro"));
    System.out.println(resource.getString("questions"));
    int numberOfAnswer = scanner.nextInt();
    resource.showAnswer(numberOfAnswer);
  }
}

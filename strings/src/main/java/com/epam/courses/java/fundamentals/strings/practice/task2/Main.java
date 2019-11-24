package com.epam.courses.java.fundamentals.strings.practice.task2;

import java.io.IOException;
import java.util.Scanner;

public class Main {

  private static Scanner scanner = new Scanner(System.in);

  public static void main(String... __) throws IOException {
    System.out.println("Choose your language:");
    System.out.println("1 - RU; \n2 - EN; \nother - by default.");
    int questionNumber = scanner.nextInt();
    var resourceManager = new ResourceManager(questionNumber);

    System.out.println(resourceManager.getString("proposal"));
    System.out.println(resourceManager.getString("question_list"));
    int answerNumber = scanner.nextInt();
    resourceManager.getAnswer(answerNumber);
  }
}

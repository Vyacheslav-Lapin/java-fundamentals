package com.epam.courses.java.fundamentals.strings.practice.task2;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class QuestionApp {
  public static void main(String[] args) {
    Locale current;
    ResourceBundle rb;
    System.out.print("Please choose your language ");
    System.out.print("en or ru: ");
    Scanner in = new Scanner(System.in);
    String choice = in.next();
    switch (choice) {
      case "en":
        current = new Locale("en", "Us");
        rb = ResourceBundle.getBundle("questions", current);
        break;
      case "ru":
        current = new Locale("ru", "RU");
        rb = ResourceBundle.getBundle("questions", current);
        break;
      default:
        System.out.println("We don't have your language. Default language is english");
        current = new Locale("en", "Us");
        rb = ResourceBundle.getBundle("questions", current);
    }
    System.out.println(rb.getString("message.greetings"));
    System.out.println(rb.getString("message.questions"));
    int question = in.nextInt();
    switch (question) {
      case 1:
        System.out.println(rb.getString("answer.first"));
        break;
      case 2:
        System.out.println(rb.getString("answer.second"));
        break;
      case 3:
        System.out.println(rb.getString("answer.third"));
        break;
      default:
        System.out.println("No such question");
    }
  }
}


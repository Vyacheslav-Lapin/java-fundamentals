package com.epam.courses.java.fundamentals.info.task2;

import lombok.experimental.NonFinal;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class QuestionnaireApp {
  @NonFinal
  private Locale locale = Locale.getDefault();
  private Scanner sc = new Scanner(System.in);

  public static void main(String... args) {
    new QuestionnaireApp().run();
  }

  private int numOfQuestions = 5;

  public void run() {
    chooseLocale();
    String lastAnswer = "";
    while (true) {
      printPrompt();
      lastAnswer = readLineFromStdin();
      if (lastAnswer.equals("q"))
        return;
      if (lastAnswer.equals("l")) {
        chooseLocale();
        continue;
      }
      if (!allowedAnswer(lastAnswer)) {
        printlnMsg("cant-recognize-option");
        continue;
      }


      printlnMsg("answer" + lastAnswer);
      System.out.println();
    }
  }

  private void printlnMsg(String msgKey) {
    System.out.println(getString(msgKey));
  }

  private void printMsg(String msgKey) {
    System.out.print(getString(msgKey));
  }

  private void printPrompt() {
    printMsg("questions-prompt");
    System.out.println("[1-" + numOfQuestions + "]:");
    for (int iQ = 1; iQ <= numOfQuestions; iQ++) {
      System.out.print(iQ + ". ");
      printlnMsg("question" + iQ);
    }
    System.out.println();
    printlnMsg("to-exit-press");
    printlnMsg("to-change-locale-press");

  }

  private boolean allowedAnswer(String answer) {
    if (answer.equals("q") || answer.equals("l"))
      return true;
    try {
      int answerAsInt = Integer.parseInt(answer);
      if (answerAsInt <= 0 || answerAsInt > numOfQuestions)
        return false;
    } catch (NumberFormatException ex) {
      return false;
    }
    return true;
  }

  private String getString(String msgKey) {
    ResourceBundle messages = ResourceBundle.getBundle("MessagesBundle", locale);

    return messages.getString(msgKey);
  }

  private String readLineFromStdin() {
    return sc.next();
  }

  private void chooseLocale() {
    printlnMsg("choose-locale");
    System.out.println(
        """
            1. English
            2. Русский
            """);

    String answer = readLineFromStdin();
    switch (answer) {
      case "1" -> locale = new Locale("en");
      case "2" -> locale = new Locale("ru");
      default -> {
        printlnMsg("cant-recognize-locale-answer");
        locale = Locale.getDefault();
      }

    }
  }

}

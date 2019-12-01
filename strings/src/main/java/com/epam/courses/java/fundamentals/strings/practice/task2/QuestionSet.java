package com.epam.courses.java.fundamentals.strings.practice.task2;

import lombok.SneakyThrows;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class QuestionSet implements Runnable {

  private static File rusFile = new File("strings/src/main/java/com/epam/courses/java/fundamentals/strings/practice/task2/FileRus.txt");
  private static File engFile = new File("strings/src/main/java/com/epam/courses/java/fundamentals/strings/practice/task2/FileEng.txt");
  private static File ansFile = new File("strings/src/main/java/com/epam/courses/java/fundamentals/strings/practice/task2/Answers.txt");
  private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

  Map<Integer, Question> questions;

  boolean isRussian = isLangRussian();

  QuestionSet() {
    this.questions = new HashMap<>();
    Map<String, Integer> questions = readFiles();
    for (String singleQues : questions.keySet()) {
      int endOfQuestionbody = singleQues.indexOf("\n", 3);
      int dotPosition = singleQues.indexOf(".", 1);
      int questionNumber = Integer.parseInt(singleQues.substring(1, dotPosition));
      String questionBody = singleQues.substring(dotPosition + 1, endOfQuestionbody);
      List<String> splittedAnswers = Arrays.asList(singleQues.substring(endOfQuestionbody + 1).split("\n"));
      this.questions.put(questionNumber,
          new Question(questionNumber, questionBody, splittedAnswers, questions.get(singleQues)));
    }
  }

  @SneakyThrows
  private Map<String, Integer> readFiles() {
    String[] splittedQuestions = readFile(isRussian ? rusFile : engFile, "&");
    String[] splittedAnswers = readFile(ansFile, "\n");
    HashMap<String, Integer> resultMap = new HashMap<>();
    for (int i = 0; i < splittedQuestions.length; i++) {
      int corr = Integer.parseInt(splittedAnswers[i].substring(splittedAnswers[i].indexOf(":") + 1));
      resultMap.put(splittedQuestions[i], corr);
    }
    return resultMap;
  }

  @SneakyThrows
  private String[] readFile(File file, String splitRegex) {
    try (BufferedReader sourceReader = new BufferedReader(new FileReader(file))) {
      StringBuilder source = new StringBuilder();
      String line;
      while ((line = sourceReader.readLine()) != null) {
        source.append(line).append("\n");
      }
      return source.toString().split(splitRegex);
    }
  }

  @SneakyThrows
  private boolean isLangRussian() {
    System.out.print("default language is english. Press 'Enter' to continue.\n" +
        "Язык по умолчанию английский. Введите 'rus' чтобы выбрать русский язык: ");
    String s = reader.readLine();
    return s.equalsIgnoreCase("rus");
  }

  private static int chooseNum(boolean isRussian) {
    System.out.println(isRussian ? "Введите номер вопроса: " : "Input question number: ");
    int result = 0;
    try {
      result = Integer.parseInt(reader.readLine());
    } catch (NumberFormatException | IOException exc) {
      System.out.println(isRussian ? "Неверный ввод!" : "Incorrect input!");
      chooseNum(isRussian);
    }
    return result;
  }

  @SneakyThrows
  @Override
  public void run() {
    int qNumber = chooseNum(isRussian);
    Question question = questions.get(qNumber);
    System.out.println(question + "\n");
    System.out.println(isRussian ? "Введите вариант ответа (1 буква):" : "Input letter of correct answer:");
    boolean isCorr = reader.readLine().substring(0, 1)
        .equalsIgnoreCase(question.answerSet.get(question.corrAnswer - 1).substring(0,1));
    System.out.println(isCorr ? "You right!" : "No!");
  }
}

package com.epam.courses.java.fundamentals.strings.practice.task2;

/**
 * Разработать приложение, позволяющее по выбору пользователя использовать русский или английский язык,
 * для отображения информации.  Приложение должно представлять собой перечень вопросов под номерами
 * (на английском или русском соответственно). Выбрав номер вопроса пользователь может узнать ответ на него.
 */
public class Main {
  public static void main(String[] args) {
    QuestionSet questionSet = new QuestionSet();
    questionSet.run();
  }
}

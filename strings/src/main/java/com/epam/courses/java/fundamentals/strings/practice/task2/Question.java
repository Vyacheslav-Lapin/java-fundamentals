package com.epam.courses.java.fundamentals.strings.practice.task2;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class Question {

  protected int number;

  protected String questionBody;

  protected List<String> answerSet;

  protected int corrAnswer;

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("\n").append(number).append(") ").append(questionBody);
    for (String str : answerSet) s.append("\n").append(str);
    return s.toString();
  }
}

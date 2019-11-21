package com.epam.courses.java.fundamentals.strings.practice.task2;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.NonFinal;

import java.util.List;

@AllArgsConstructor
public class Question {
  @NonFinal
  protected int number;
  @NonFinal
  protected String questionBody;
  @NonFinal
  protected List<String> answerSet;
  @NonFinal
  protected int corrAnswer;

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("\n").append(number).append(") ").append(questionBody);
    for (String str : answerSet) s.append("\n").append(str);
    return s.toString();
  }
}

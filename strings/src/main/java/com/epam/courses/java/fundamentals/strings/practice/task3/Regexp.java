package com.epam.courses.java.fundamentals.strings.practice.task3;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Необходимо определить в тексте статьи* (html-файл), ссылается ли автор на рисунки последовательно или нет,
 * а также выделить все предложения, в которых встречаются ссылки на рисунки.
 * Для разбора текста использовать регулярные выражения.
 */

public class Regexp {
  public static void main(String[] args) {
    ArrayList<String> allWords = new ArrayList<>();
    Pattern pattern = Pattern.compile("[a-z][A-Z]*");
    Matcher matcher = pattern.matcher(new String("aaa"));
    while (matcher.find()) {
      allWords.add(matcher.group());
    }
  }
}

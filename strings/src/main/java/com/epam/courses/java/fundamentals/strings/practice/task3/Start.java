package com.epam.courses.java.fundamentals.strings.practice.task3;

/**
 * Необходимо определить в тексте статьи* (html-файл), ссылается ли автор на рисунки последовательно или нет,
 * а также выделить все предложения, в которых встречаются ссылки на рисунки.
 * Для разбора текста использовать регулярные выражения.
 */

public class Start {
  public static void main(String[] args) {
    String path = "strings/src/main/java/com/epam/courses/java/fundamentals/strings/practice/task3/task.html";
    Regexp regexpnew = new Regexp(path, "Windows-1251");
    System.out.println(regexpnew.areRefsInOrder());
    System.out.println(regexpnew);
  }
}

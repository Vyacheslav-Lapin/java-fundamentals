package com.epam.courses.java.fundamentals.strings.practice.task2;

import lombok.experimental.NonFinal;
import org.jetbrains.annotations.NotNull;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class Resource {

  private final String resourceName = "res";

  @NonFinal
  private Locale locale;

  @NonFinal
  private ResourceBundle resourceBundle;

  public Resource(int numberOfLocale) throws MissingResourceException {
    setLocale(numberOfLocale);
    this.resourceBundle = ResourceBundle.getBundle(resourceName,locale);
  }

  public void setLocale(int numberOfLocale){
    switch (numberOfLocale) {
      case 1 -> locale = new Locale("ru", "RU");
      case 2 -> locale = new Locale("en", "US");
      default -> locale = Locale.getDefault();
    }
  }

  public Locale getLocale() {
    return locale;
  }

  public void showAnswer(int numberOfAnswer){
    switch (numberOfAnswer) {
      case 1 -> System.out.println(resourceBundle.getString("answer_one"));
      case 2 -> System.out.println(resourceBundle.getString("answer_two"));
      case 3 -> System.out.println(resourceBundle.getString("answer_three"));
      default -> System.out.println(resourceBundle.getString("answer_default"));
    }
  }

  public String getString(@NotNull String key){
    if(resourceBundle.containsKey(key))
      return resourceBundle.getString(key);
    else throw new RuntimeException();
  }

}

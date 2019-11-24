package com.epam.courses.java.fundamentals.strings.practice.task2;

import lombok.experimental.NonFinal;
import org.jetbrains.annotations.NotNull;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class ResourceManager {

  @NonFinal
  private Locale locale;

  @NonFinal
  private ResourceBundle resourceBundle;

  private final String resourceName = "prop";

  public ResourceManager(int number) throws MissingResourceException {
    setLocale(number);
    this.resourceBundle = ResourceBundle.getBundle(resourceName, locale);
  }

  public String getLocale() {
    return locale.toString();
  }

  public void setLocale(int number) {
    switch (number) {
      case 1:
        locale = new Locale("ru", "RU");
        break;

      case 2:
        locale = new Locale("en", "US");
        break;

      default:
        locale = Locale.getDefault();
    }
  }

  public String getString(@NotNull String key) {
    isKeyExists(key);
    return resourceBundle.getString(key);
  }

  private boolean isKeyExists(String key) {
    if (resourceBundle.containsKey(key))
      return true;
    else
      throw new RuntimeException("Key doesn't exist");
  }

  public void getAnswer(int number) {
    switch (number) {
      case 1:
        System.out.println(resourceBundle.getString("answer.1"));
        break;

      case 2:
        System.out.println(resourceBundle.getString("answer.2"));
        break;

      case 3:
        System.out.println(resourceBundle.getString("answer.3"));
        break;

      default:
        System.out.println(resourceBundle.getString("answer.default"));
        break;
    }
  }
}

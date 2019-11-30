package com.epam.courses.java.fundamentals.strings.practice.task1;

import org.jetbrains.annotations.NotNull;

public interface Logger {

  void addToLog(@NotNull String str);

  String getLog();

  String searchByString(@NotNull String str);
}

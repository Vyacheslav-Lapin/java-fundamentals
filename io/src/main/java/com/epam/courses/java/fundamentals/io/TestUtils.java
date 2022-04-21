package com.epam.courses.java.fundamentals.io;

import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;
import lombok.val;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

@UtilityClass
public class TestUtils {

  String LINE_SEPARATOR = System.lineSeparator();
  String TEST_RESOURCES_PATH = "./src/test/resources/";

  @NotNull
  @SneakyThrows
  @Contract("_ -> new")
  public String fromSystemOutPrint(@NotNull Runnable task) {
    return OutputStreamUtils.fromPrintStream(
        printStream -> {
          val realOut = System.out;
          System.setOut(printStream);
          task.run();
          System.setOut(realOut);
        }
    );
  }

  @NotNull
  public String fromSystemOutPrintln(@NotNull Runnable runnable) {
    String s = fromSystemOutPrint(runnable);
    return s.endsWith(LINE_SEPARATOR) ?
               s.substring(0, s.length() - LINE_SEPARATOR.length())
               : s;
  }

  @NotNull
  @Contract(pure = true)
  public String toTestResourceFilePath(@NotNull String fileName) {
    return TEST_RESOURCES_PATH + fileName;
  }
}

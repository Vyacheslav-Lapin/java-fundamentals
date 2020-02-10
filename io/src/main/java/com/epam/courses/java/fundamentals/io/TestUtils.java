package com.epam.courses.java.fundamentals.io;

import java.io.PrintStream;
import lombok.SneakyThrows;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public interface TestUtils {

  String LINE_SEPARATOR = System.lineSeparator();
  String TEST_RESOURCES_PATH = "./src/test/resources/";

  @NotNull
  @SneakyThrows
  @Contract("_ -> new")
  static String fromSystemOutPrint(@NotNull Runnable task) {
//    return
//        peek(ByteArrayOutputStream::new)
//          .map(PrintStream::new).closeable()
//            .peekObj(System.out)
//              .run(System::setOut)
//              .run(task)
//              .then(System::setOut)
//            .then()
//          .map(ByteArrayOutputStream::toByteArray)
//          .map(String::intern)
//          .get();

//    return new String(
//        peekFrom(
//            ByteArrayOutputStream::new,
//            baos -> peekAndClose(
//                map(baos, PrintStream::new),
//                printStream -> peek(
//                    System.out,
//                    __ -> System.setOut(printStream),
//                    __ -> task.run(),
//                    System::setOut)))
//            .toByteArray()
//    ).intern();

    //    return fromPrintStream(printStream ->

    //      peek(System.out,
    //          __ -> System.setOut(printStream),
    //          __ -> task.run(),
    //          System::setOut)

        return OutputStreamUtils.fromPrintStream(printStream -> {
          PrintStream realOut = System.out;
          System.setOut(printStream);
          task.run();
          System.setOut(realOut); }
        );
  }

  @NotNull
  static String fromSystemOutPrintln(@NotNull Runnable runnable) {
//    return ifMap(fromSystemOutPrint(runnable),
//        s -> s.endsWith(LINE_SEPARATOR),
//        s -> s.substring(0, s.length() - LINE_SEPARATOR.length()));

        String s = fromSystemOutPrint(runnable);
        return s.endsWith(LINE_SEPARATOR) ?
                   s.substring(0, s.length() - LINE_SEPARATOR.length()) :
                   s;
  }

  @NotNull
  @Contract(pure = true)
  static String toTestResourceFilePath(@NotNull String fileName) {
    return TEST_RESOURCES_PATH + fileName;
  }
}

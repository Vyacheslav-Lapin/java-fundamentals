package com.epam.courses.java.fundamentals.io;

import io.vavr.CheckedConsumer;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import lombok.Cleanup;
import lombok.val;
import org.jetbrains.annotations.NotNull;

public interface OutputStreamUtils {

  @NotNull
  static String fromPrintStream(@NotNull CheckedConsumer<PrintStream> printStreamConsumer) {
    val out = new ByteArrayOutputStream();
    @Cleanup val printStream = new PrintStream(out);
    printStreamConsumer.unchecked().accept(printStream);
    return out.toString().intern();
  }

}

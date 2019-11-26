package com.epam.courses.java.fundamentals.jdbc.cp;

import io.vavr.CheckedConsumer;
import io.vavr.CheckedFunction1;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import lombok.Cleanup;
import lombok.SneakyThrows;
import lombok.val;
import org.jetbrains.annotations.NotNull;

public interface InputStreamUtils {

  @SneakyThrows
  static <T> T mapFileInputStream(@NotNull String fileName,
                                  @NotNull CheckedFunction1<InputStream, T> fisMapper) {
    @Cleanup val inputStream = InputStreamUtils.class
        .getResourceAsStream("/" + fileName);
    return fisMapper.apply(inputStream);
  }


  static void withFileInputStream(@NotNull String fileName,
                                  @NotNull CheckedConsumer<InputStream> fisConsumer) {
    try {
    @Cleanup val inputStream = InputStreamUtils.class
        .getResourceAsStream("/" + fileName);

      fisConsumer.accept(inputStream);
    } catch (Throwable throwable) {
      throwable.printStackTrace();
    }
  }

  @SneakyThrows
  static Optional<String> getFileAsString(@NotNull String fileName) {
    val path = String.format("/%s", fileName);
    return Optional.ofNullable(InputStreamUtils.class.getResource(path))
        .map(URL::getFile)
        .map(Paths::get)
        .map(CheckedFunction1.<Path, String>narrow(Files::readString)
            .recover(throwable -> null));
  }
}

package com.epam.courses.java.fundamentals.io;

import io.vavr.CheckedConsumer;
import io.vavr.CheckedFunction1;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
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

  @SneakyThrows
  static void withFileInputStream(@NotNull String fileName,
                                  @NotNull CheckedConsumer<InputStream> fisConsumer) {
    @Cleanup val inputStream = InputStreamUtils.class.getResourceAsStream("/" + fileName);
    fisConsumer.accept(inputStream);
  }

  @SneakyThrows
  static String getFileAsString(@NotNull Path file) {
    @Cleanup Stream<String> stringStream = Files.lines(file);
    return stringStream.collect(Collectors.joining());
  }

  static Optional<Path> getPath(@NotNull String fileName) {
    final URL resource = InputStreamUtils.class.getResource("/" + fileName);
    return Optional.ofNullable(resource)
               .map(URL::getFile)
               .map(Paths::get);
  }

  @SneakyThrows
  static Optional<String> getFileAsString(String folder, String fileName) {
    return getPath(String.format("/%s/%s", folder, fileName))
               .map(InputStreamUtils::getFileAsString);
  }
}

package com.epam.courses.java.fundamentals.io;

import io.vavr.CheckedFunction1;
import io.vavr.CheckedConsumer;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import lombok.Cleanup;
import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;
import lombok.val;
import org.jetbrains.annotations.NotNull;

@UtilityClass
public class InputStreamUtils {

  @SneakyThrows
  public <T> T mapFileInputStream(@NotNull String fileName,
                                  @NotNull CheckedFunction1<InputStream, T> fisMapper) {
    @Cleanup val inputStream = InputStreamUtils.class
                                 .getResourceAsStream("/" + fileName);
    return fisMapper.apply(inputStream);
  }

  @SneakyThrows
  public void withFileInputStream(@NotNull String fileName,
                                  @NotNull CheckedConsumer<InputStream> fisConsumer) {
    @Cleanup val inputStream = InputStreamUtils.class
                                 .getResourceAsStream("/" + fileName);
    fisConsumer.accept(inputStream);
  }

  @SneakyThrows
  public Optional<String> getFileAsString(@NotNull String fileName) {
    val path = String.format("/%s", fileName);
    return Optional.ofNullable(InputStreamUtils.class.getResource(path))
             .map(URL::getFile)
             .map(Paths::get)
             .map(CheckedFunction1.<Path, String>narrow(Files::readString)
                    .recover(throwable -> null));
  }
}

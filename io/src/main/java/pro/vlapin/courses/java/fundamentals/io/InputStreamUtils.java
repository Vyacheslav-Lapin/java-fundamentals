package pro.vlapin.courses.java.fundamentals.io;

import io.vavr.CheckedConsumer;
import io.vavr.CheckedFunction1;
import io.vavr.Function1;
import lombok.Cleanup;
import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;
import lombok.val;
import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@UtilityClass
public class InputStreamUtils {

  public final Function<InputStream, String> INPUT_STREAM_TO_STRING =
      Function1.<InputStream, InputStreamReader>narrow(InputStreamReader::new)
          .andThen(BufferedReader::new)
          .andThen(BufferedReader::lines)
          .andThen(lines -> lines.collect(Collectors.joining("\n")));

  /**
   * As example - "jar:file:/Users/vyacheslavlapin/IdeaProjects/demo/lombok-demo/target/lombok-demo-0.0.1-SNAPSHOT-sources.jar!/META-INF/MANIFEST.MF"
   */
  @SneakyThrows
  public <T> T getJarFileMap(@NotNull String fileNameInJar,
                             @NotNull Function<InputStream, T> mapper) {
    @Cleanup val inputStream = URI.create(fileNameInJar).toURL().openStream();
    return mapper.apply(inputStream);
  }

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
    if (!fileName.startsWith("/"))
      fileName = "/" + fileName;
    @Cleanup val inputStream = InputStreamUtils.class.getResourceAsStream(fileName);
//    try (val inputStream = InputStreamUtils.class.getResourceAsStream(fileName)) {
      fisConsumer.accept(inputStream);
//    }
  }

  @SneakyThrows
  public String getFileAsString(@NotNull Path file) {
    @Cleanup Stream<String> stringStream = Files.lines(file);
    return stringStream.collect(Collectors.joining());
  }

  public Optional<Path> getPath(@NotNull String fileName) {
    if (!fileName.startsWith("/"))
      fileName = "/" + fileName;
    return Optional.ofNullable(InputStreamUtils.class.getResource(fileName))
               .map(URL::getFile)
               .map(Paths::get);
  }

  @SneakyThrows
  public Optional<String> getFileAsString(String folder, String fileName) {
    return getPath(String.format("%s/%s", folder, fileName))
               .map(InputStreamUtils::getFileAsString);
  }

  @SneakyThrows
  public Optional<String> getFileAsString(String fileName) {
    return getPath(String.format("/%s", fileName))
               .map(InputStreamUtils::getFileAsString);
  }
}

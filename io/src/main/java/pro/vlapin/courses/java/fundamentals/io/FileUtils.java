package pro.vlapin.courses.java.fundamentals.io;

import io.vavr.Function1;
import io.vavr.PartialFunction;
import java.io.FileNotFoundException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import lombok.SneakyThrows;
import lombok.experimental.ExtensionMethod;
import lombok.experimental.UtilityClass;
import lombok.val;
import org.jetbrains.annotations.NotNull;

@UtilityClass
@ExtensionMethod(Files.class)
public class FileUtils {

  private static final Function1<String, URL> GET_RESOURCE =
      Function1.of(FileUtils.class::getResource)
          .memoized();

  private static final PartialFunction<String, Path> FILE_NAME_TO_PATH =
      GET_RESOURCE
          .andThen(URL::getFile)
          .andThen(absoluteFilePath -> absoluteFilePath.length() > 2 && absoluteFilePath.charAt(2) == ':' ? absoluteFilePath.substring(1) : absoluteFilePath)
          .andThen(Paths::get)
          .partial(fileName -> GET_RESOURCE.apply(fileName) != null);

  @SneakyThrows
  public @NotNull Path getPath(@NotNull String fileName) {
    val path = fileName.charAt(0) == '/' ? fileName : String.format("/%s", fileName);
    return FILE_NAME_TO_PATH.lift()
        .apply(path)
        .getOrElseThrow(FileNotFoundException::new);
  }

  @SneakyThrows
  public String fileContent(String fileName) {
    return getPath(fileName).readString();
  }
}

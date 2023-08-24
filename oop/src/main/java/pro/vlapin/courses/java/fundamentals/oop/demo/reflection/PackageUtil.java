package pro.vlapin.courses.java.fundamentals.oop.demo.reflection;

import static io.vavr.API.$;
import static io.vavr.API.Case;
import static io.vavr.API.Match;
import static java.util.Spliterator.ORDERED;

import io.vavr.CheckedFunction1;
import io.vavr.Function1;
import io.vavr.Function2;
import java.io.File;
import java.net.URL;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Spliterators;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

@UtilityClass
public class PackageUtil {

  @SneakyThrows
  @Contract(pure = true)
  public @NotNull Stream<Class<?>> classes(@NotNull String packageName) {
    return classes(
        packageName,
        Function2.<String, File, Stream<Class<?>>>of(PackageUtil::classes)
            .apply(packageName));
  }

  @NotNull
  private Stream<Class<?>> classes(@NotNull String packageName,
                                   @NotNull Function1<File, Stream<Class<?>>> fileToClasses) {
    return CheckedFunction1.of(Thread.currentThread().getContextClassLoader()::getResources)
               .unchecked()
               .andThen(Enumeration::asIterator)
               .andThen(urlIterator -> Spliterators.spliteratorUnknownSize(urlIterator, ORDERED))
               .andThen(urlSpliterator -> StreamSupport.stream(urlSpliterator, false))
               .apply(packageName.replace('.', '/'))
               .map(URL::getFile)
               .map(File::new)
               .flatMap(fileToClasses);
  }

  /**
   * Recursive method used to find all classes in a given directory and subdirs.
   *
   * @param directory   The base directory
   * @param packageName The package name for classes found inside the base directory
   * @return The classes
   */
  private @NotNull Stream<Class<?>> classes(@NotNull String packageName,
                                            @NotNull File directory) {
    return classes(
        directory,
        ((Predicate<File>) File::isDirectory).and(file1 -> !file1.getName().contains(".")),
        file -> file.getName().endsWith(".class"),
        file -> classes("%s.%s".formatted(packageName, file.getName()), file),
        CheckedFunction1.<String, Class<?>>of(Class::forName)
            .unchecked()
            .compose((File file3) -> "%s.%s".formatted(packageName, file3.getName().substring(0, file3.getName().length() - 6)))
            .andThen(Stream::of));
  }

  @NotNull
  @SneakyThrows
  private Stream<Class<?>> classes(@NotNull File directory,
                                   @NotNull Predicate<File> isCorrectNamedDirectory,
                                   @NotNull Predicate<File> isClass,
                                   @NotNull Function<File, Stream<Class<?>>> fromDirectory,
                                   @NotNull Function<File, Stream<Class<?>>> fromClass) {

    return Arrays.stream(directory.listFiles())
               .flatMap(file -> Match(file).of(
                   Case($(isCorrectNamedDirectory), fromDirectory),
                   Case($(isClass), fromClass),
                   Case($(), Stream.empty())
               ));
  }
}

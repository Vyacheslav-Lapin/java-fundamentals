package pro.vlapin.courses.java.fundamentals.oop.reflection;

import static java.util.Spliterator.ORDERED;
import static java.util.Spliterators.spliteratorUnknownSize;
import static java.util.stream.StreamSupport.stream;

import io.vavr.CheckedFunction1;
import io.vavr.CheckedFunction2;
import java.io.File;
import java.net.URL;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.function.Function;
import java.util.stream.Stream;
import lombok.*;
import lombok.experimental.UtilityClass;
import org.jetbrains.annotations.NotNull;

/**
 * @see <a href="https://dzone.com/articles/get-all-classes-within-package">Refactored from this DZone issue</a>
 */
@UtilityClass
public class ReflectionUtils {

  @SneakyThrows
  public <T> T callMethodByReflection(Object object, String methodName, Object... args) {
    //noinspection unchecked
    return (T) object.getClass()
                   .getMethod(methodName)
                   .invoke(object, args);
  }

  Function<String, Class<?>> CLASS_FOR_NAME = CheckedFunction1.<String, Class<?>>of(Class::forName).unchecked();

  /**
   * Scans all classes accessible from the context class loader which belong to the given package and subpackages.
   *
   * @param packageName The base package
   * @return The classes
   */
  public Stream<Class<?>> getTypesFromPackage(String packageName) {

    return CheckedFunction2.of(ClassLoader::getResources)
        .unchecked()
        .andThen(Enumeration::asIterator)
        .andThen(urlIterator -> spliteratorUnknownSize(urlIterator, ORDERED))
        .andThen(urlSpliterator -> stream(urlSpliterator, false))
        .reversed()
        .apply(packageName.replace('.', '/'))
        .compose(Thread::getContextClassLoader)
        .apply(Thread.currentThread())
        .map(URL::getFile)
        .map(File::new)
        .flatMap(dir -> findTypes(dir, packageName));
  }

  /**
   * Recursive method used to find all classes in a given directory and subdirs.
   *
   * @param directory   The base directory
   * @param packageName The package name for classes found inside the base directory
   * @return The classes
   */
  private Stream<Class<?>> findTypes(@NotNull File directory,
                                            @NotNull String packageName) {

    return Stream.of(directory)
        .filter(File::exists)
        .map(File::listFiles)
        .flatMap(Arrays::stream)
        .flatMap(file ->
                     file.isDirectory()
                         ? findTypes(file, "%s.%s".formatted(packageName, file.getName()))
                         : findType(packageName, file));
  }

  @NotNull
  private Stream<? extends Class<?>> findType(@NotNull String packageName,
                                                     @NotNull File file) {
    return Stream.of(file.getName())
        .filter(fileName -> fileName.endsWith(".class"))
        .map(fileName -> fileName.substring(0, fileName.length() - 6))
        .map(fileName -> CLASS_FOR_NAME.apply("%s.%s".formatted(packageName, fileName)));
  }
}

package pro.vlapin.courses.java.fundamentals.jdbc.cp;

import io.vavr.CheckedFunction3;
import lombok.Getter;
import lombok.SneakyThrows;
import lombok.Value;
import lombok.experimental.ExtensionMethod;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import pro.vlapin.courses.java.fundamentals.fp.Function3Utils;
import pro.vlapin.courses.java.fundamentals.io.InputStreamUtils;

import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Optional;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static lombok.AccessLevel.*;

@Value
@Getter(NONE)
@ExtensionMethod({
    Function3Utils.class,
})
public class ConnectionFactory implements Supplier<Stream<Connection>> {

  String url;
  String user;
  String password;

  int poolSize;

  String initScriptsPath;

  @Override
  @SneakyThrows
  public Stream<Connection> get() {

    Supplier<Connection> connectionSupplier =
        CheckedFunction3.<String, String, String, Connection>narrow(DriverManager::getConnection)
            .unchecked()
            .supply(url, user, password);

    return Stream.generate(connectionSupplier)
        .limit(poolSize);
  }

  @NotNull
  @Contract(" -> new")
  public <T extends Connection> BlockingQueue<T> getSizedBlockingQueue() {
    return new ArrayBlockingQueue<>(poolSize);
  }

  public Stream<Path> getSqlInitFiles() {
    //noinspection OptionalGetWithoutIsPresent
    return IntStream.iterate(1, operand -> operand + 1)
        .mapToObj(String::valueOf)
        .map(fileName -> String.format("/%s/%s.sql", initScriptsPath, fileName))
        .map(InputStreamUtils::getPath)
        .takeWhile(Optional::isPresent)
        .map(Optional::get);
  }

}

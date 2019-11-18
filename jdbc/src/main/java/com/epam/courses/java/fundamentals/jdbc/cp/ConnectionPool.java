package com.epam.courses.java.fundamentals.jdbc.cp;

import io.vavr.CheckedFunction1;
import io.vavr.Function2;
import java.io.Closeable;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import lombok.Cleanup;
import lombok.SneakyThrows;
import lombok.experimental.NonFinal;
import lombok.val;

public class ConnectionPool implements Closeable, Supplier<Connection> {

  BlockingQueue<PooledConnection> connectionQueue;

  @NonFinal
  volatile boolean opened = true;

  public ConnectionPool() {
    this("db");
  }

  @SneakyThrows
  public ConnectionPool(String fileName) {

    var connectionFactory = PropsBinder.from(fileName, ConnectionFactory.class);

    Function<Connection, PooledConnection> pooledConnectionFactory =
        Function2.narrow(PooledConnection::new)
            .apply(this::closePolledConnection);

    //    connectionQueue = new ArrayBlockingQueue<>(connectionFactory.getPoolSize());

    int poolSize = connectionFactory.getPoolSize();
    connectionQueue = Stream.generate(connectionFactory)
                          .limit(poolSize)
                          .map(pooledConnectionFactory)
                          .collect(Collectors.toCollection(() -> new ArrayBlockingQueue<>(poolSize)));

    Function<String, Optional<String>> getFileAsString =
        Function2.narrow(ConnectionPool::getFileAsString)
            .apply(connectionFactory.getInitScriptsPath());

    try (val connection = get();
         val statement = connection.createStatement()) {
      statement.executeUpdate(
          IntStream.iterate(1, operand -> operand + 1)
              .mapToObj(String::valueOf)
              .map(getFileAsString)
              .takeWhile(Optional::isPresent)
              .map(Optional::get)
              .collect(Collectors.joining()));
    }
  }

  @SneakyThrows
  private static Optional<String> getFileAsString(String initScriptsPath, String name) {
    val path = String.format("/%s/%s.sql", initScriptsPath, name);
    return Optional.ofNullable(ConnectionPool.class.getResource(path))
               .map(CheckedFunction1.narrow(URL::toURI).unchecked())
               .map(Paths::get)
               .map(CheckedFunction1.<Path, Stream<String>>narrow(Files::lines).unchecked())
               .map(stringStream -> {
                 try (stringStream) {
                   return stringStream.collect(Collectors.joining());
                 }});
  }

  @SneakyThrows
  private void closePolledConnection(PooledConnection pooledConnection) {
    if (!opened) pooledConnection.reallyClose();

    if (pooledConnection.isClosed())
      throw new ConnectionPoolException("Attempting to close closed connection.");

    if (pooledConnection.isReadOnly())
      pooledConnection.setReadOnly(false);

    if (!pooledConnection.getAutoCommit())
      pooledConnection.setAutoCommit(true);

    if (!connectionQueue.offer(pooledConnection))
      throw new ConnectionPoolException(
          new SQLException("Error allocating connection in the pool."));
  }

  @Override
  public void close() {
    opened = false;
    connectionQueue
        .forEach(PooledConnection::reallyClose);
  }

  @Override
  public Connection get() {
    try {
      return connectionQueue.take();
    } catch (InterruptedException e) {
      throw new ConnectionPoolException(
          "Error connecting to the data source.", e);
    }
  }

  private static String SQL =
      "select id, first_name as firstName, last_name as lastName, permission, dob, email, password, address, telephone from Person";

  public static void main(String... __) throws SQLException {
    @Cleanup val connectionPool = new ConnectionPool();
    @Cleanup val connection = connectionPool.get();
    @Cleanup val statement = connection.createStatement();
    @Cleanup val resultSet = statement.executeQuery(SQL);
    if (resultSet.next())
      System.out.println(resultSet.getString("firstName").equals("Jose"));
  }
}

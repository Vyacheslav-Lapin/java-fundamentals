package com.epam.courses.java.fundamentals.jdbc.cp;

import com.epam.courses.java.fundamentals.io.InputStreamUtils;
import com.epam.courses.java.fundamentals.io.PropsBinder;
import io.vavr.Function2;
import java.io.Closeable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.BlockingQueue;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
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

    connectionQueue = connectionFactory.get()
                          .map(pooledConnectionFactory)
                          .collect(Collectors.toCollection(connectionFactory::getSizedBlockingQueue));

    //init
    val sql = connectionFactory.getSqlInitFiles()
                  .map(InputStreamUtils::getFileAsString)
                  .collect(Collectors.joining());

    try (val connection = get();
         val statement = connection.createStatement()) {
      statement.executeUpdate(sql);
    }
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
}

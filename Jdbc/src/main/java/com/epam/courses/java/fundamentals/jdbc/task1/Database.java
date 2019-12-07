package com.epam.courses.java.fundamentals.jdbc.task1;

import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Database {

  @SneakyThrows

  public static void add(Connection connection) {
    Statement statement = connection.createStatement();
    statement.addBatch("INSERT INTO table1 VALUES (121, 999999)");
    statement.executeBatch();
    connection.commit();

    System.out.println("INSERT INTO table1 VALUES (121, 999999)");
    getWhere(connection);
  }

  @SneakyThrows
  public static void UPDATE(Connection connection) {
    Statement statement = connection.createStatement();
    statement.addBatch("UPDATE table1 SET  value = 999999 WHERE key=1");
    statement.addBatch("UPDATE table1 SET  value = 900000 WHERE key=2");
    statement.executeBatch();
    connection.commit();

    System.out.println("UPDATE table1 SET  value = 999999 WHERE key=1");
    System.out.println("UPDATE table1 SET  value = 900000 WHERE key=2");
    add(connection);
  }

  @SneakyThrows
  public static void getWhere(Connection connection) {
    ResultSet res = connection.prepareStatement("SELECT key, value FROM table1 WHERE (key = 121)").executeQuery();

    System.out.println("SELECT key, value FROM table1 WHERE (key = 121)");
    while (res.next()) {
      System.out.println(res.getInt("key") + " " + res.getInt("value"));
    }
    System.out.println();
  }

  @SneakyThrows
  private static void getAll(Connection connection) {
    try {
      System.out.println("SELECT * FROM table2");
      connection.prepareStatement("SELECT * FROM table2").executeQuery();
    } catch (SQLException e) {
      System.out.println("sql exception");
    }
  }

  @SneakyThrows
  public static void deleteTable(Connection connection) {
    getAll(connection);

    Statement statement = connection.createStatement();
    statement.addBatch("DROP TABLE table2");
    System.out.println("DROP TABLE table2");
    statement.executeBatch();

    getAll(connection);
  }
}

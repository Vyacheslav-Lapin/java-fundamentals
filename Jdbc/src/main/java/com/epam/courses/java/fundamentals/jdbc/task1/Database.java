package com.epam.courses.java.fundamentals.jdbc.task1;

import lombok.SneakyThrows;

import java.sql.*;

public class Database {

  @SneakyThrows
  private void insert(Connection connection) {
    Statement statement = connection.createStatement();
    String insertInto = "insert into users values(id='1', name='Oleg', age='21')";
    statement.executeUpdate(insertInto);
  }

  @SneakyThrows
  private void deleteTable(Connection connection) {
    Statement statement = connection.createStatement();
    String get = "drop table users";
    statement.executeUpdate(get);
  }

  @SneakyThrows
  private void getAll(Connection connection) {
    Statement statement = connection.createStatement();
    String getAll = "select*from users";
    statement.executeUpdate(getAll);
  }

  @SneakyThrows
  private void getConcreteField(Connection connection) {
    Statement statement = connection.createStatement();
    String get = "select name from users where id = 1";
    statement.executeUpdate(get);
  }

  @SneakyThrows
  private void update(Connection connection) {
    Statement statement = connection.createStatement();
    String update = "update users set name 'Eva' where id = '1' and name = 'OLEG' and ";
    statement.executeUpdate(update);
  }
}

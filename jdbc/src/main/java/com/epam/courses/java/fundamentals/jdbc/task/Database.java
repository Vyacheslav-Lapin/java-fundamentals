package com.epam.courses.java.fundamentals.jdbc.task;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
  private static final String DatabaseURL = "jdbc:mysql://localhost/";
  private static final String userName = "user";
  private static final String password = "password";

  public static void main(String... __) throws SQLException {
    try(Connection connection = DriverManager.getConnection(DatabaseURL,userName,password)){
      Database database = new Database();
      String tableName = "users";
      String name = "Andrey";
      database.createTable(connection,tableName);
      database.insert(connection,tableName);
      database.update(connection, tableName, name);
      database.showAll(connection, tableName);
      database.getField(connection);
      database.dropTable(connection, tableName);
    }
  }

  private void createTable(Connection connection, String tableName) throws SQLException{
    Statement statement = connection.createStatement();
    String create = "create table " + tableName + " ( UserID int not null, UserName char(20));";
    statement.executeUpdate(create);
  }

  private void insert(Connection connection, String tableName) throws SQLException{
    Statement statement = connection.createStatement();
    String insert = "insert into " + tableName + " values('1', 'Nikita')";
    statement.executeUpdate(insert);
  }

  private void update(Connection connection, String tableName, String name) throws SQLException{
    Statement statement = connection.createStatement();
    String update = "update " + tableName + " set UserName '" + name +"' where UserID = '1' and name = 'Nikita';";
    statement.executeUpdate(update);
  }

  private void showAll(Connection connection, String tableName) throws SQLException{
    Statement statement = connection.createStatement();
    String showAll = "select * from " + tableName;
    statement.executeUpdate(showAll);
  }

  private void getField(Connection connection) throws SQLException{
    Statement statement = connection.createStatement();
    String getField = "select UserName from users where UserId = 1;";
    statement.executeUpdate(getField);
  }

  private void dropTable(Connection connection, String tableName) throws SQLException{
    Statement statement = connection.createStatement();
    String drop = "drop table " + tableName + ";";
    statement.executeUpdate(drop);
  }

}

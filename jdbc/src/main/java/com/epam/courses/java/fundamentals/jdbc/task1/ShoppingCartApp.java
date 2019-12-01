package com.epam.courses.java.fundamentals.jdbc.task1;

import lombok.Builder;
import lombok.Cleanup;
import lombok.ToString;
import lombok.experimental.FieldNameConstants;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ShoppingCartApp {
  //@SneakyThrows
  public static void main(String... args) throws SQLException {
    @Cleanup var connection = DriverManager.getConnection("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1");
    @Cleanup var statement = connection.createStatement();
    statement.executeUpdate("create table book (id identity, title varchar)");
    statement.executeUpdate("insert into book(title) values('Peace and War')");
    statement.executeUpdate("insert into book(title) values('Peace and War-2')");
    statement.executeUpdate("insert into book(title) values('Dune')");

    printBooksBySql(statement, "select * from book");
    printBooksBySql(statement, "select * from book where title='Dune'");

    statement.executeUpdate("update book set title='Dune-2' where title='Dune'");
    printBooksBySql(statement, "select * from book");

    statement.executeUpdate("drop table book" );

  }

  private static void  printBooksBySql(Statement statement, String sql) throws SQLException {
    @Cleanup var res = statement.executeQuery(sql);
    while (res.next()) {
      var book =
          Book.builder().
              id(res.getInt(Book.Fields.id)).
              title(res.getString(Book.Fields.title)).build();
      System.out.println(book);
    }

  }

}

@Builder
@FieldNameConstants
@ToString
class Book {
  int id;
  String title;
}

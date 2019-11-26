package com.epam.courses.java.fundamentals.jdbc.practice.task1;

import com.epam.courses.java.fundamentals.jdbc.practice.task2.Book;
import lombok.Cleanup;
import lombok.SneakyThrows;

import java.sql.*;
import java.util.ArrayList;


/**
 * Создайте таблицу в БД и с помощью JDBC выполните следующие действия
 * - извлеките информацию из таблицы с помощью подготовленного запроса;
 * - обновите несколько записей в таблице;
 * - выберите конкретную запись в таблице;
 * - вставьте новую запись в таблицу;
 * - удалите таблицу.
 */

public class DBpractice {

  public static void main(String[] args) throws SQLException {
    @Cleanup var connection = DriverManager.getConnection("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1");
    @Cleanup Statement statement = connection.createStatement();

    // Creation
    statement.executeUpdate("create table Books " +
        "(id identity, Author varchar, Title varchar not null, genre varchar not null, shelf int)");

    // Filling in
    statement.executeUpdate("insert into Books(Author, Title, genre, shelf) values " +
        "('Solovyev', 'Hodga Nasreddin', 'fiction', '1')," +
        " ('Hoking', 'Black Holes', 'popscience', '2'), " +
        " ('Gumilev', 'Ethnogenesis', 'science', '3'), " +
        " ('Pushkin', 'Karamazoff Brothers', 'fiction', '1'), " +
        " ('Markov', 'Birth of Complexity', 'popscience', '2'), " +
        "('Bloch', 'Effective Java 3rd', 'programming', '3')");

    //Data deletion
    @Cleanup PreparedStatement deleteStatement = connection.prepareStatement(
        "delete from Books where Author = ?");
    deleteStatement.setString(1, "Hoking");
    deleteStatement.executeUpdate();

    //Update
    statement.executeUpdate("update Books set Author='Dostoevskiy' where Title='Karamazoff Brothers'");
    statement.executeUpdate("update Books set shelf=4 where genre='programming'");

    //Single-selection
    ArrayList<Book> books = new ArrayList<>();
    @Cleanup var resultSet = statement.executeQuery(
        "select id, Author, Title, genre, shelf as shelf_id from Books where id=1");
    while (resultSet.next()) books.add(
        (new Book(resultSet.getLong(Book.Fields.id),
            resultSet.getString(Book.Fields.Author),
            resultSet.getString(Book.Fields.Title),
            resultSet.getString(Book.Fields.genre),
            resultSet.getInt(Book.Fields.shelf_id))));
    for (Book book : books) System.out.println(book);

    //Insertion
    @Cleanup PreparedStatement insertStatement = connection.prepareStatement(
        "insert into Books(Author, Title, genre, shelf) values (?, ?, ?, ?)");
    insertStatement.setString(1, "Tolstoy");
    insertStatement.setString(2, "Anna Karenina");
    insertStatement.setString(3, "fiction");
    insertStatement.setString(4, "1");
    insertStatement.executeUpdate();

    //Table deletion
    Statement dropTab = connection.createStatement();
    System.out.println(dropTab.execute("drop table Books"));
  }
}

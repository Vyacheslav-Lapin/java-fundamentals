package com.epam.courses.java.fundamentals.jdbc.practice.task2.DAO;

import com.epam.courses.java.fundamentals.jdbc.practice.task2.Book;
import lombok.AllArgsConstructor;
import lombok.Cleanup;
import lombok.SneakyThrows;

import java.sql.*;
import java.util.ArrayList;

@AllArgsConstructor
public class Book_H2_DAO implements AbstractBookDAO {

  private Connection connection;

  public static String createStatement = "create table Books " +
      "(id identity, Author varchar, Title varchar not null, genre varchar not null, shelf int)";

  @Override
  @SneakyThrows
  public int insertBook(Book book) {
    @Cleanup PreparedStatement insertStatement = connection.prepareStatement(
        "insert into Books(Author, Title, genre, shelf) values (?, ?, ?, ?)");
    insertStatement.setString(1, book.getAuthor());
    insertStatement.setString(2, book.getTitle());
    insertStatement.setString(3, book.getGenre());
    insertStatement.setInt(4, book.getShelf_id());
    return insertStatement.executeUpdate();
  }

  @Override
  @SneakyThrows
  public int deleteBook(Book book) {
    @Cleanup PreparedStatement deleteStatement = connection.prepareStatement(
        "delete from Books where Author = ? and Title = ?");
    deleteStatement.setString(1, book.getAuthor());
    deleteStatement.setString(2, book.getTitle());
    return deleteStatement.executeUpdate();
  }

  @Override
  @SneakyThrows
  public Book getBookByTitle(String title){
    @Cleanup Statement statement = connection.createStatement();
    String bookTitle = title;
    ArrayList<Book> books = new ArrayList<>();
    @Cleanup ResultSet resultSet = statement.executeQuery("select id, Author, Title, genre, shelf as shelf_id from Books where Title=" + bookTitle);
    while (resultSet.next()) books.add(new Book(resultSet.getLong(Book.Fields.id),
        resultSet.getString(Book.Fields.Author),
        resultSet.getString(Book.Fields.Title),
        resultSet.getString(Book.Fields.genre),
        resultSet.getInt(Book.Fields.shelf_id)));
    return books.get(0);
  }

  @Override
  @SneakyThrows
  public ArrayList<Book> getAllBooks() {
    ArrayList<Book> books = new ArrayList<>();
    @Cleanup Statement statement = connection.createStatement();
    @Cleanup var resultSet = statement.executeQuery(
        "select id, Author, Title, genre, shelf as shelf_id from Books");
    while (resultSet.next()) books.add(
        (new Book(resultSet.getLong(Book.Fields.id),
            resultSet.getString(Book.Fields.Author),
            resultSet.getString(Book.Fields.Title),
            resultSet.getString(Book.Fields.genre),
            resultSet.getInt(Book.Fields.shelf_id))));
    return books;
  }

  @Override
  @SneakyThrows
  public void updateBookSetGenre(Book book, String newGenre) {
    @Cleanup PreparedStatement insertStatement = connection.prepareStatement(
        "update Books set genre = ? where Author = ? and Title = ?");
    insertStatement.setString(1, newGenre);
    insertStatement.setString(2, book.getAuthor());
    insertStatement.setString(3, book.getTitle());
    insertStatement.executeUpdate();
  }

  @Override
  @SneakyThrows
  public void updateBookSetShelf(Book book, int newShelf) {
    @Cleanup PreparedStatement insertStatement = connection.prepareStatement(
        "update Books set shelf = ? where Author = ? and Title = ?");
    insertStatement.setInt(1, newShelf);
    insertStatement.setString(2, book.getAuthor());
    insertStatement.setString(3, book.getTitle());
    insertStatement.executeUpdate();
  }
}

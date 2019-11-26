package com.epam.courses.java.fundamentals.jdbc.practice.task2;

import com.epam.courses.java.fundamentals.jdbc.practice.task2.DAO.Book_H2;
import lombok.Cleanup;
import lombok.SneakyThrows;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Спроектируйте БД, хранящую информацию, например, о домашней библиотеке.
 * Реализуйте функциональность добавления, поиска и удаления разнообразной информации из этой БД.
 * При реализации используйте (напишите) пул соединений и DAO.
 */

public class BookMain {
  public static void main(String[] args) throws SQLException {
    @Cleanup var connection = DriverManager.getConnection("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1");
    @Cleanup Statement statement = connection.createStatement();
    statement.executeUpdate("create table Books " +
        "(id identity, Author varchar, Title varchar not null, genre varchar not null, shelf int)");
    Book_H2 bookdao = new Book_H2(connection);
    bookdao.setBasicLibrary();
    bookdao.insertBook(new Book("London", "Martin Iden", "fiction", 1));
    bookdao.deleteBook(new Book("Hoking", "Black Holes", "popscience", 2));
    System.out.println(bookdao.getBookByTitle("'Ethnogenesis'"));
    ArrayList<Book> books = bookdao.getAllBooks();
    for (Book book : books) {
      bookdao.updateBookSetGenre(book, "otstoy");
      bookdao.updateBookSetShelf(book, 25);
    }
    bookdao.getAllBooks().forEach(System.out::println);
  }
}

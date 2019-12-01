package com.epam.courses.java.fundamentals.jdbc.practice.task2;

import com.epam.courses.java.fundamentals.jdbc.cp.ConnectionPool;
import com.epam.courses.java.fundamentals.jdbc.practice.task2.DAO.Book_H2_DAO;
import lombok.Cleanup;
import lombok.val;

import java.sql.SQLException;
import java.sql.Statement;

/**
 * Спроектируйте БД, хранящую информацию, например, о домашней библиотеке.
 * Реализуйте функциональность добавления, поиска и удаления разнообразной информации из этой БД.
 * При реализации используйте (напишите) пул соединений и DAO.
 */

public class BookMain {
  public static void main(String[] args) throws SQLException {
    @Cleanup val connectionPool = new ConnectionPool();
    @Cleanup val connection = connectionPool.get();
    @Cleanup Statement statement = connection.createStatement();
    statement.executeUpdate(Book_H2_DAO.createStatement);
    statement.executeUpdate("insert into Books(Author, Title, genre, shelf) values " +
        "('Bloch', 'Effective Java 3rd', 'programming', '3')");
    Book_H2_DAO bookdao = new Book_H2_DAO(connection);
    bookdao.getAllBooks().forEach(System.out::println);
  }
}

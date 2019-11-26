package com.epam.courses.java.fundamentals.jdbc.practice.task2.DAO;

import com.epam.courses.java.fundamentals.jdbc.practice.task2.Book;

import java.sql.SQLException;
import java.util.ArrayList;

public interface AbstractBookDAO {
  public int insertBook (Book book) throws SQLException;
  public int deleteBook (Book book) throws SQLException;
  public Book getBookByTitle (String title) throws SQLException;
  public ArrayList<Book> getAllBooks () throws SQLException;
  public void updateBookSetGenre (Book book, String newGenre) throws SQLException;
  public void updateBookSetShelf (Book book, int newShelf) throws SQLException;
}

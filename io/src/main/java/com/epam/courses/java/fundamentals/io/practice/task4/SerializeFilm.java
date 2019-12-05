package com.epam.courses.java.fundamentals.io.practice.task4;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

public class SerializeFilm {
  public static void main(String[] args) throws IOException {
    try (FileOutputStream fileOutputStream = new FileOutputStream("actors.bin");
         ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
      List<Film> filmList = Film.addFilms();
      objectOutputStream.writeObject(filmList);
    } catch (IOException e){
      System.out.println("Can't write to file");
      e.printStackTrace();
    }
  }
}

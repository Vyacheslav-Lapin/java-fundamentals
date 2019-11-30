package com.epam.courses.java.fundamentals.io.practice.task4;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

public class WriteFilm {

  public static void main(String[] args) throws IOException {
    try (FileOutputStream fos = new FileOutputStream("people.bin");
         ObjectOutputStream oos = new ObjectOutputStream(fos)) {
      List<Film> list = Film.initFilms();
        oos.writeObject(list);
    }
  }
}

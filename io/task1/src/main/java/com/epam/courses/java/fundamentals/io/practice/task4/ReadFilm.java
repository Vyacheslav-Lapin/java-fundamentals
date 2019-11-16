package com.epam.courses.java.fundamentals.io.practice.task4;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

public class ReadFilm {

  public static void main(String[] args) throws IOException, ClassNotFoundException {
    try (FileInputStream fis = new FileInputStream("people.bin");
         ObjectInputStream ois = new ObjectInputStream(fis)) {
      List<Film> list = (List<Film>) ois.readObject();
    }
  }
}

package com.epam.courses.java.fundamentals.IO.practice.task4;

import lombok.SneakyThrows;
import lombok.experimental.NonFinal;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;

/**
 * Дана коллекция фильмов, содержащая информацию об актерах, снимавшихся в главных ролях
 * (один актер мог сниматься и в нескольких фильмах).
 * Необходимо написать приложение, позволяющее при запуске восстанавливать коллекцию фильмов,
 * позволять ее модифицировать, а по завершении работы приложения – сохранять (в файл).
 * Для восстановления/сохранения коллекции использовать  сериализацию/десериализацию.
 */

public class MovieCollection implements Closeable {

  static File source = new File("io/src/main/java/com/epam/courses/java/fundamentals/IO/practice/task4/Storage.txt");

  private static MovieCollection instance;

  public static MovieCollection getInstance() {
    if (instance == null)
      synchronized (MovieCollection.class) {
        if (instance == null)
          instance = new MovieCollection();
      }
    return instance;
  }

  @NonFinal
  private HashSet<Movie> mainCollection;

  @SneakyThrows
  private MovieCollection() {
    this.mainCollection = new HashSet<>();
    try (BufferedReader sourceReader = new BufferedReader(new FileReader(source))) {
      ArrayList<String> movies = new ArrayList<>();
      String line;
      while ((line = sourceReader.readLine()) != null) {
        movies.add(line);
      }
      for (String movie : movies) mainCollection.add(deserialize(movie));
    }
  }

  private static Movie deserialize(String movie) {
    String[] mov = movie.split(":");
    return new Movie(mov[0], new Actor(mov[1]));
  }

  private static String serialize(Movie movie) {
    StringBuilder mov = new StringBuilder();
    mov.append(movie.getName()).append(":").append(movie.getMainRoleActor().getFullName());
    return mov.toString();
  }

  @Override
  public void close() throws IOException {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(source, false))) {
      StringBuilder s = new StringBuilder();
      getInstance().mainCollection.stream().map(MovieCollection::serialize).map((g) -> g += "\n").forEach(s::append);
      writer.write(s.toString().toCharArray());
    }
  }

  public synchronized void add(Movie movie) {
    mainCollection.add(movie);
  }

  public void remove(String name) {
    for (Movie movie : mainCollection) {
      if (name.equals(movie.getName())) {
        synchronized (this) {
          mainCollection.remove(movie);
          return;
        }
      }
    }
  }

  @SneakyThrows
  public static void main(String[] args) {
    getInstance().remove("Star Wars");
    getInstance().add(new Movie("Star Wars", new Actor("Hayden Christensen")));
    getInstance().add(new Movie("Star Wars", new Actor("Nataly Portman")));
    getInstance().close();
  }
}

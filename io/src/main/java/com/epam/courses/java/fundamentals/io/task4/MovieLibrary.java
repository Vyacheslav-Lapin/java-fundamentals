package com.epam.courses.java.fundamentals.io.task4;

import java.io.*;
import java.util.*;

public class MovieLibrary implements Serializable {
  public static final String PERSIST_PATH = ".movies.ser";
  private Set<Actor> actors = new HashSet<>();
  private Map<Movie, List<Actor>> moviesToActors = new HashMap<>();

  public void addToMovie(Movie movie, Actor actor) {
    actors.add(actor);
    moviesToActors.computeIfAbsent(movie, m -> new ArrayList<>()).add(actor);
  }

  public Actor findActorBySurname(String surname) {
    return actors.stream().filter(a -> a.getSurname().equals(surname)).findFirst().orElse(null);
  }

  public void persist() throws IOException {
    try (var out = new ObjectOutputStream(new FileOutputStream(PERSIST_PATH))) {
      out.writeObject(this);
    }
  }

  public static MovieLibrary restore() throws ClassNotFoundException, IOException {
    try (var in = new ObjectInputStream(new FileInputStream(PERSIST_PATH))) {
      return (MovieLibrary) in.readObject();
    }
  }
}

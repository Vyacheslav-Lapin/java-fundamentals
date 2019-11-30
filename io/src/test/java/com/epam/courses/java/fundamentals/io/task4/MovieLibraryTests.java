package com.epam.courses.java.fundamentals.io.task4;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class MovieLibraryTests {
  @Test
  void populateLibrary() throws IOException {
    populateAndPersistLibrary();
    Files.exists(Path.of(MovieLibrary.PERSIST_PATH));
  }

  private void populateAndPersistLibrary() throws IOException {
    var movieLibrary = new MovieLibrary();

    movieLibrary.addToMovie(new Movie("The Shawshank Redemption"), new Actor("Morgan", "Freeman"));
    movieLibrary.addToMovie(new Movie("Bruce Almighty"), new Actor("Morgan", "Freeman"));
    movieLibrary.addToMovie(new Movie("Bruce Almighty"), new Actor("Jim", "Carrey"));

    movieLibrary.persist();
  }
  
  @Test
  void checkLibraryRestoresInfoOnStartup() throws IOException, ClassNotFoundException {
    populateAndPersistLibrary();
    var movieLibrary = MovieLibrary.restore();
    assertNotNull(movieLibrary.findActorBySurname("Freeman"));
  }


}

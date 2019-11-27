package com.epam.courses.java.fundamentals.io.practice.task4;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class MovieCollection implements Serializable {

  List<Movie> movies = new ArrayList<>();

  public void addMovie(Movie f) {
    movies.add(f);
  }

  public Movie getMovie(String name) {
    Movie res = null;
    for (Movie m : movies) {
      if (m.getName().equals(name))
        res = m;
    }
    return res;
  }

  public static void save(MovieCollection mc) {
    File outfile = new File("io/src/main/java/com/epam/courses/java/fundamentals/io/practice/task4/file.out");
    try {
      outfile.createNewFile();
    } catch (IOException e) {
      e.printStackTrace();
    }
    try (FileOutputStream fos = new FileOutputStream(outfile);
         ObjectOutputStream oos = new ObjectOutputStream(fos)) {
      oos.writeObject(mc);
    } catch (IOException ex) {
      System.out.println(ex.getMessage());
    }
  }

  public static MovieCollection open() {
    MovieCollection col = null;
    String path = "io/src/main/java/com/epam/courses/java/fundamentals/io/practice/task4/file.out";
    try (FileInputStream fis = new FileInputStream(path);
         ObjectInputStream oin = new ObjectInputStream(fis)) {
      col = (MovieCollection) oin.readObject();
    } catch (IOException | ClassNotFoundException ex) {
      System.out.println(ex.getMessage());
    }
    return col;
  }


  public static void main(String[] args) {
    Actor a = new Actor("Ewan", "McGregor");
    Actor a1 = new Actor("Rebecca", "Ferguson");
    Movie m = new Movie("Doctor Sleep");
    m.addActor(a);
    m.addActor(a1);
    MovieCollection mc = new MovieCollection();
    mc.addMovie(m);
    Movie m1 = new Movie("Big Fish");
    Actor a2 = new Actor("Albert", "Finney");
    m1.addActor(a);
    m1.addActor(a2);
    mc.addMovie(m1);
    MovieCollection.save(mc);
  }

}

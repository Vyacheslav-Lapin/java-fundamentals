package com.epam.courses.java.fundamentals.io.practice.task4;

import java.util.Scanner;

public class MovieApp {

  public static void main(String[] args) {
    System.out.print("Welcome to movie collection! ");
    System.out.print("You can add a movie or actors here. ");
    System.out.print("Please enter supplement to add movie or add to add actor and movie's name: ");
    Scanner in = new Scanner(System.in);
    String action = in.next();
    String movie = in.nextLine().trim();
    MovieCollection col = MovieCollection.open();
    switch (action) {
      case "supplement":
        col.addMovie(new Movie(movie));
        MovieCollection.save(col);
        break;
      case "add":
        Movie choice = col.getMovie(movie);
        System.out.println("Please enter name and surname: ");
        String name = in.next();
        String surname = in.next();
        choice.addActor(new Actor(name,surname));
        MovieCollection.save(col);
        break;
    }
  }
}

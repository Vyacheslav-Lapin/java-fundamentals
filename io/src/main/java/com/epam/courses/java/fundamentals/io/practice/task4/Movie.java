package com.epam.courses.java.fundamentals.io.practice.task4;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Movie implements Serializable {

  List<Actor> actors = new ArrayList<>();

  String name;


  public Movie(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void addActor(Actor a){
    actors.add(a);
  }


  @Override
  public String toString() {
    return name;
  }
}

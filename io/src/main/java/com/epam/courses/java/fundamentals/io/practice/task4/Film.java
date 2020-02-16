package com.epam.courses.java.fundamentals.io.practice.task4;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;


public class Film implements Serializable {

  private static List<Film> filmList;
  private Actor[] actorName;
  private static final long IDofSerialVersion = 4477571271740L;

  Film(Actor... actorName){
    this.actorName = actorName;
  }

  public static List<Film> getFilmList(){
    return filmList;
  }

  public Actor[] getActorName() {
    return actorName;
  }

  public static void setFilmList(List<Film> filmList) {
    Film.filmList = filmList;
  }

  public void setActorName(Actor[] actorName) {
    this.actorName = actorName;
  }

  static List<Film> addFilms(){
    filmList = new ArrayList<>();
    Actor christian = new Actor("Christian Bale");
    Actor heath = new Actor("Heath Ledger");
    Actor hayden = new Actor("Hayden Christensen");
    Actor ewan = new Actor("Ewan McGregor");
    Film darkKnight = new Film(christian,heath);
    Film starWars = new Film(hayden, ewan);
    Film equilibrium = new Film(christian);
    Film awake = new Film(hayden);
    filmList.add(darkKnight);
    filmList.add(starWars);
    filmList.add(equilibrium);
    filmList.add(awake);
    return filmList;
  }

  @Override
  public String toString() {
    return "Film{ actor name: " + Arrays.toString(actorName) + " }";
  }
}

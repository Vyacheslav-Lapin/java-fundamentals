package com.epam.courses.java.fundamentals.io.practice.task4;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Film implements Serializable {

  private static final long serialVersionUID = 6529685098267757690L;

  private static List<Film> films;

  private Actor[] actorName;

  Film(Actor... actorName) {
    this.actorName = actorName;
  }

  public static List<Film> getFilms() {
    return films;
  }

  public Actor[] getActorName() {
    return actorName;
  }

  public static void setFilms(List<Film> films) {
    Film.films = films;
  }

  public void setActorName(Actor[] actorName) {
    this.actorName = actorName;
  }

  @Override
  public String toString() {
    return "Film{" +
        "actorName=" + Arrays.toString(actorName) +
        '}';
  }

  static List<Film> initFilms() {
    films = new ArrayList<>();
    Actor arnold = new Actor("Arnold Schwarzenegger");
    Actor linda = new Actor("Linda Hamilton");
    Actor milla = new Actor("Milla Jovovich");
    Actor brad = new Actor("Brad Pitt");
    Actor angelina = new Actor("Angelina Jolie");
    Film terminator = new Film(arnold, linda);
    Film sabotage = new Film(arnold);
    Film residentEvil = new Film(milla);
    Film troya = new Film(brad);
    Film hackers = new Film(angelina);
    films.add(terminator);
    films.add(sabotage);
    films.add(residentEvil);
    films.add(troya);
    films.add(hackers);
    return films;
  }
}

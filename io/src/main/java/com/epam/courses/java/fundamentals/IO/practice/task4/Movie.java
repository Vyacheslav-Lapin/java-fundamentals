package com.epam.courses.java.fundamentals.IO.practice.task4;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.NonFinal;

import java.util.Objects;

@Getter
@AllArgsConstructor
public class Movie {

  @NonFinal
  String name;
  @NonFinal
  Actor mainRoleActor;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Movie movie = (Movie) o;
    return name.equals(movie.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name);
  }
}

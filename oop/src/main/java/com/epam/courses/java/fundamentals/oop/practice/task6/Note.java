package com.epam.courses.java.fundamentals.oop.practice.task6;

import lombok.experimental.NonFinal;

import java.util.Objects;

public class Note {

  @NonFinal
  private String title;

  @NonFinal
  private String body;

  private int id;

  public Note(int id) {
    this.id = id;
  }

  public int getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public Note setTitle(String title) {
    this.title = title;
    return this;
  }

  public String getBody() {
    return body;
  }

  public Note setBody(String body) {
    this.body = body;
    return this;
  }
/*
  @Override
  public boolean equals(Object o) {
    return this == o || !(o == null || getClass() != o.getClass()) && id == ((Note) o).id;
  }

  @Override
  public int hashCode() {
    return id;
  }
*/
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Note note = (Note) o;
    return id == note.id &&
        title.equals(note.title) &&
        body.equals(note.body);
  }

  @Override
  public int hashCode() {
    return Objects.hash(title, body, id);
  }

  @Override
  public String toString() {
    return "Note{" + "title='" + title + '\'' +
               ", body='" + body + '\'' +
               ", id=" + id +
               '}';
  }
}

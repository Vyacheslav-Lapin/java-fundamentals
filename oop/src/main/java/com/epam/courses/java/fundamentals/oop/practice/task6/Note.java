package com.epam.courses.java.fundamentals.oop.practice.task6;

import lombok.experimental.NonFinal;

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

 @Override
  public boolean equals(Object o){
    if(this == o)
      return true;
    if(this == null || this.getClass() != o.getClass())
      return false;
    Note note = (Note)o;
    return this.id == note.id && this.title.equals(note.title) && this.body.equals(note.body);
  }

  @Override
  public int hashCode(){
    return Objects.hash(id,title,body);
  }

  @Override
  public String toString() {
    return "Note{" + "title='" + title + '\'' +
               ", body='" + body + '\'' +
               ", id=" + id +
               '}';
  }
}

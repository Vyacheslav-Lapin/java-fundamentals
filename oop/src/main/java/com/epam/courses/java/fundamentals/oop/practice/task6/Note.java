package com.epam.courses.java.fundamentals.oop.practice.task6;

import lombok.experimental.NonFinal;


public class Note {
  /**
   * Contains the title of the note.
   */
  @NonFinal
  private String title;
  /**
   * Contains the body of the note.
   */
  @NonFinal
  private String body;
  /**
   * Contains the id of the note.
   */
  private int id;

  /**
   * The constructor of the Note class.
   * @param id the id of the note
   */
  public Note(int id) {
    this.id = id;
  }

  /**
   * The accessor method for the id variable.
   * @return Returns an int - the id of the note.
   */
  public int getId() {
    return id;
  }

  /**
   * The accessor method for the title variable.
   * @return Returns the title of the note.
   */
  public String getTitle() {
    return title;
  }

  /**
   * The mutator method for the title variable.
   * @param title the title of the note
   * @return Note
   */
  public Note setTitle(String title) {
    this.title = title;
    return this;
  }

  /**
   * The accessor method for the body variable.
   * @return Returns the body of the note.
   */
  public String getBody() {
    return body;
  }
  /**
   * The mutator method for the body variable.
   * @param body the body of the note
   * @return Note
   */
  public Note setBody(String body) {
    this.body = body;
    return this;
  }

  /**
   *{@inheritDoc}
   */
  @Override
  public boolean equals(Object o) {
    return this == o || !(o == null || getClass() != o.getClass()) && id == ((Note) o).id;
  }

  /**
   *{@inheritDoc}
   */
  @Override
  public int hashCode() {
    return id;
  }

  /**
   *Overrides the standard toString() method of the Object class, giving the title, body and id of the note.
   * @return Returns the title, body and id of the note.
   */
  @Override
  public String toString() {
    return "Note{" + "title='" + title + '\'' +
               ", body='" + body + '\'' +
               ", id=" + id +
               '}';
  }
}


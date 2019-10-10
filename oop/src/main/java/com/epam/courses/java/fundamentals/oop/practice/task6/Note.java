package com.epam.courses.java.fundamentals.oop.practice.task6;

import lombok.experimental.NonFinal;

/**
 * Generates simple instances of Note
 * Note includes Id as immutable identifier, and changeable string properties Title and Body
 * @author Vyacheslav_Lapin
 * @author Andrey_Markov
 * @since 13.0
 */
public class Note {

  @NonFinal
  private String title;

  @NonFinal
  private String body;

  /**
   * Main identifier of instance (i.e. Primary Key)
   * Value of Id is being set only by constructor
  */
  private int id;

  /**
   *Creates a new Note with the specified Id
   * @param id requires attention to set value that matches position of instance in {@link NotePad}
   * @see #getId()
   */
  public Note(int id) {
    this.id = id;
  }

  /**
   * @return Id of instance
   * @see {@link #id}
   */
  public int getId() {
    return id;
  }
  /**
   * @return Title of object
   * @see {@link #title}
   */
  public String getTitle() {
    return title;
  }
  /**
   * @param title   string new value for object title
   */
  public Note setTitle(String title) {
    this.title = title;
    return this;
  }
  /**
   * @return Body of object
   */
  public String getBody() {
    return body;
  }

  /**
   * @param body   string new value for object body
   */

  public Note setBody(String body) {
    this.body = body;
    return this;
  }

  /**
   * @param o   object to compare with
   */
  @Override
  public boolean equals(Object o) {
    return this == o || !(o == null || getClass() != o.getClass()) && id == ((Note) o).id;
  }

  /**
   *
   */
  @Override
  public int hashCode() {
    return id;
  }

  /**
   *
   */
  @Override
  public String toString() {
    return "Note{" + "title='" + title + '\'' +
               ", body='" + body + '\'' +
               ", id=" + id +
               '}';
  }
}

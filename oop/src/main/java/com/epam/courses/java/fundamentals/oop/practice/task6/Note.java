package com.epam.courses.java.fundamentals.oop.practice.task6;

import lombok.experimental.NonFinal;

/**
 * Class {@code Note} is a container for text notes.
 * Note includes <code>id</code> as immutable identifier
 * and changeable string properties <code>title</code> and <code>body</code>
 * where <code>body</code> is very text note, and a title is a service tag.
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
   * Main identifier of instance (to be specific Primary Key)
   * Value of <code>id</code> is being set only by constructor {@link Note#Note(int)}
  */
  private int id;

  /**
   * Class constructor
   * Creates a new Note with the specified <code>id</code>
   * @param id requires attention to set value that matches position of instance in {@link NotePad}
   * @see #getId()
   */
  public Note(int id) {
    this.id = id;
  }

  /**
   * @return <code>id</code> of instance
   */
  public int getId() {
    return id;
  }
  /**
   * @return <code>title</code> of object
   */
  public String getTitle() {
    return title;
  }
  /**
   * @param title   string new value for <code>title</code>
   * @return this instance
   */
  public Note setTitle(String title) {
    this.title = title;
    return this;
  }
  /**
   * @return <code>body</code> of object
   */
  public String getBody() {
    return body;
  }

  /**
   * @param body   string new value for <code>body</code>
   * @return this instance
   */

  public Note setBody(String body) {
    this.body = body;
    return this;
  }

  /**
   * Indicates whether some other object is "equal to" this one.
   * @param o   the reference object with which to compare.
   * @return  {@code true} if this object is the same as the obj argument; {@code false} otherwise.
   */
  @Override
  public boolean equals(Object o) {
    return this == o || !(o == null || getClass() != o.getClass()) && id == ((Note) o).id;
  }

  /**
   * Returns a hash code value for this object.
   */
  @Override
  public int hashCode() {
    return id;
  }

  /**
   * Returns a string representation of this object.
   */
  @Override
  public String toString() {
    return "Note{" + "title='" + title + '\'' +
               ", body='" + body + '\'' +
               ", id=" + id +
               '}';
  }
}

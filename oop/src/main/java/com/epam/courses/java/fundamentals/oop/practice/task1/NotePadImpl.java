package com.epam.courses.java.fundamentals.oop.practice.task1;

import java.util.Arrays;
import lombok.experimental.NonFinal;
import org.jetbrains.annotations.Contract;

/**
 * The class NotePadImpl is used for storing array of notes and processing them
 *
 * @author Irina Panova
 */
public class NotePadImpl implements NotePad {

  private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

  @NonFinal
  Note[] notes;

  @NonFinal
  int index;

  @Contract(pure = true)
  public NotePadImpl(int initialCapacity) {
    assert initialCapacity > 0;
    this.notes = new Note[initialCapacity];
  }

  @Contract(pure = true)
  public NotePadImpl() {
    this(16);
  }

  /**
   * add notes is array according to their sequence
   *
   * @param title
   * @param body
   * @return object of a Note class
   */
  @Override
  public Note addNote(String title, String body) {

    var note = new Note(index++)
        .setTitle(title)
        .setBody(body);

    if (isPossibleToAdd())
      return notes[note.getId()] = note;
    else
      throw new RuntimeException("It`s impossible to add the Note - array already have a maximum size!");
  }

  private boolean isPossibleToAdd() {
    return index < notes.length || hasGrew();
  }

  private boolean hasGrew() {

    int capacity = notes.length << 1; // * 2 with overflow insurance

    if (capacity - index < 0) { // is previous operation has overflow as a result?
      if (index - MAX_ARRAY_SIZE <= 0)
        capacity = MAX_ARRAY_SIZE;
      else
        return false;
    }

    notes = Arrays.copyOf(notes, capacity);

    return true;
  }

  /**
   * check if the the particular record exists
   *
   * @param id
   * @return object of a Note class according its id
   */
  @Override
  public Note getNote(int id) {
    if (id < 0 || id >= index)
      throw new AssertionError();

    return notes[id];
  }

  @Override
  public Note[] getNotes() {
    return Arrays.copyOf(notes, index); // better then clone for that case: result haven`t null`s at his tail
  }

  /**
   * remove note from array and shift the elements
   *
   * @param id
   * @return null
   */
  @Override
  public Note remove(int id) {
    if (id < 0 || id >= index)
      throw new AssertionError();

    return notes[id] = null;
  }

  /**
   * edit note title and body according to its id
   *
   * @param id
   * @param title
   * @param body
   * @return modified object of a Note class
   */
  @Override
  public Note editNote(int id, String title, String body) {
    return getNote(id).setTitle(title).setBody(body);
  }

  public int getIndex() {
    return index - 1;
  }
}

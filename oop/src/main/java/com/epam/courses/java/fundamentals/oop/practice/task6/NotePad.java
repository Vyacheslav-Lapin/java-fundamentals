package com.epam.courses.java.fundamentals.oop.practice.task6;

import java.util.Arrays;
import lombok.experimental.NonFinal;

/**
 * include Notes. Default capacity 16 or choose another size.
 */
public class NotePad {

  private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

  @NonFinal
  private Note[] notes;

  @NonFinal
  private int index;

  public NotePad(int initialCapacity) {
    assert initialCapacity > 0;
    this.notes = new Note[initialCapacity];
  }

  public NotePad() {
    this(16);
  }

  /**
   * addNote - create and add new Note or null
   *
   * @param title set Title
   * @param body  set Body
   */
  public Note addNote(String title, String body) {
    Note note = new Note(index++).setTitle(title).setBody(body);
    return isPossibleToAdd() ? notes[note.getId()] = note :
        null; // throw new RuntimeException("It`s impossible to add the Note - array already have a maximum size!");
  }

  /**
   * remove Note and return null
   *
   * @param id using id for search
   */
  public void removeNote(int id) {
    if (getNote(id) != null) {
      notes[id] = null;
    } else System.out.println("It`s impossible to remove the Note with id = " + id);
  }

  /**
   * editNote - changed Note or null-link
   *
   * @param id    using id for search
   * @param title set Title
   * @param body  set Body
   */
  public void editNote(int id, String title, String body) {
    if (id >= 0 && id < index) {
      Note note = new Note(id).setTitle(title).setBody(body);
      notes[id] = note;
    } else System.out.println("It`s impossible to edit the Note with id = " + id);
  }

  private boolean isPossibleToAdd() {
    return index < notes.length || hasGrew();
  }

  private boolean hasGrew() {

    int capacity = notes.length << 1; // * 2 with overflow insurance

    if (capacity - index < 0) // is previous operation has overflow as a result?
      if (index - MAX_ARRAY_SIZE <= 0)
        capacity = MAX_ARRAY_SIZE;
      else
        return false;

    notes = Arrays.copyOf(notes, capacity);

    return true;
  }

  public Note getNote(int id) {
    assert id >= 0 && id < index;
    return notes[id];
  }

  /**
   * show allNotes
   */
  public Note[] getNotes() {
    return Arrays.copyOf(notes, index); // better then clone for that case: result haven`t null`s at his tail
  }
}

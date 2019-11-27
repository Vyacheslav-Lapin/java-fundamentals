package com.epam.courses.java.fundamentals.oop.practice.task6;

import java.util.Arrays;
import lombok.experimental.NonFinal;

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

  public Note addNote(String title, String body) {
    Note note = new Note(index++).setTitle(title).setBody(body);
    if (!isPossibleToAdd())
      throw new RuntimeException("It`s impossible to add the Note - array already have a maximum size!");
    return notes[note.getId()] = note;
  }

  private boolean isPossibleToAdd() {
    return index < notes.length || increaseCapacity();
  }

  private boolean increaseCapacity() {
    int capacity = notes.length << 1; // multiplication by 2 with overflow safety

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

  public Note[] getNotes() {
    return Arrays.copyOf(notes, index); // better than clone for that case: result haven`t null`s at it's tail
  }

}

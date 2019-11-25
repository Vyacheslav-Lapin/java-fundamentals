package com.epam.courses.java.fundamentals.oop.practice.task1;

import java.util.Arrays;
import lombok.experimental.NonFinal;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

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

  @Override
  public Note addNote(@NotNull String title, @NotNull String body) {

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

  @Override
  public Note remove(int id) {
    return null;
  }
}

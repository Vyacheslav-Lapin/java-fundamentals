package com.epam.courses.java.fundamentals.oop.practice.taskoop.task1;

import java.util.Arrays;

import lombok.experimental.NonFinal;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Contract;

public class NotePadImplement implements NotePad {

  private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

  @NonFinal
  Note[] notes;

  @NonFinal
  int i;

  @Contract(pure = true)
  public NotePadImplement(int initialCapacity) {
    assert initialCapacity > 0;
    this.notes = new Note[initialCapacity];
  }

  @Contract(pure = true)
  public NotePadImplement() {
    this(20);
  }

  @Override
  public Note addNote(@NotNull String title, @NotNull String body) {

    var note = new Note(i++)
        .setTitle(title)
        .setBody(body);

    if (isPossibleToAdd())
      return notes[note.getId()] = note;
    else
      throw new RuntimeException("Array has already reached maximum size!");
  }

  private boolean isPossibleToAdd() {
    return i < notes.length || hasGrew();
  }

  private boolean hasGrew() {

    int capacity = notes.length << 1;

    if (capacity - i < 0) {
      if (i - MAX_ARRAY_SIZE <= 0)
        capacity = MAX_ARRAY_SIZE;
      else
        return false;
    }

    notes = Arrays.copyOf(notes, capacity);

    return true;
  }

  @Override
  public Note getNote(int id) {
    if (id < 0 || id >= i)
      throw new AssertionError();

    return notes[id];
  }

  @Override
  public Note[] getNotes() {
    return Arrays.copyOf(notes, i); // better then clone for that case: result haven`t null`s at his tail
  }

  @Override
  public Note remove(int id) {
    return null;
  }
}

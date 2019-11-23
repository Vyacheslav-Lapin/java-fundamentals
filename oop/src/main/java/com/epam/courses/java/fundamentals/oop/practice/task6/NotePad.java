package com.epam.courses.java.fundamentals.oop.practice.task6;

import java.util.Arrays;
import lombok.experimental.NonFinal;
import org.jetbrains.annotations.NotNull;

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
    return isPossibleToAdd() ? notes[note.getId()] = note :
        null; // throw new RuntimeException("It`s impossible to add the Note - array already have a maximum size!");
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

  public void deleteNote(int id) {
    if (id < 0 || id > notes.length - 1)
      System.out.print("You wrote wrong index.");

    notes[id] = null;
    swapNodes(id);
  }

  public void deleteNote(String title) {
    for (int i = 0; i < notes.length; i++)
      if (notes[i] != null) {
        if (notes[i].getTitle().equals(title)) {
          notes[i] = null;
          swapNodes(i);
        }
      }
  }

  public void swapNodes(int id){
    for (int i = id; i < notes.length - 1; i++)
      if (notes[i] == null && notes[i + 1] != null) {
        notes[i] = notes[i + 1];
        notes[i + 1] = null;
      }
  }

  public Note getNote(int id) {
    assert id >= 0 && id < index;
    return notes[id];
  }

  public Note[] getNotes() {
    return Arrays.copyOf(notes, index); // better then clone for that case: result haven`t null`s at his tail
  }



  public boolean updateNote(int id, String title, String body) {
    if (id >= 0 && id < index) {
      notes[id].setTitle(title).setBody(body);

      return true;
    }
    return false;
  }

  public boolean updateNote(Note note) {
    if (note.getId() >= 0 && note.getId() < index) {
      notes[note.getId()] = note;

      return true;
    }

    return false;
  }

  public void updateTitle(int id , String newTitle){
    if(id < 0 || id > notes.length)
      System.out.print("Element not found. Incorrect index!");
    notes[id].setTitle(newTitle);
  }

  public void updateBody(int id, String newBody){
    if(id < 0 || id > notes.length)
      System.out.print("Element not found. Incorrect index!");
    notes[id].setBody(newBody);
  }
}

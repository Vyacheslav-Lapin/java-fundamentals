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

  /**
   * Creates and adds note to notepad with parameters
   * @param title
   * @param body
   * @author Dmitry Zhiburtovich
*/

  public void addNote(String title, String body) {
    Note note = new Note(index++).setTitle(title).setBody(body);
    if (isPossibleToAdd()) {
      notes[note.getId()] = note;
    }
    else  throw new RuntimeException("It's impossible to add the Note - array already have a maximum size!");
  }

  /**
   * Deletes note with parameter "id" from notepad and sorts other notes in order
   * @param id
   * @author Dmitry Zhiburtovich
   */

  public void deleteNote(int id) {
    if (id > notes.length-1 || id < 0) throw new RuntimeException("Invalid Id");
    notes[id] = null;
    for (int i = id; i < notes.length - 1; i++) {
      if (notes[i] == null && notes[i + 1] != null) {
        notes[i] = notes[i + 1];
        notes[i + 1] = null;
  } }
  }

  /**
   * Shows all information about notes, which contain id, title and body
   * @author Dmitry Zhiburtovich
   */

  public void showNotes() {
  for (int i = 0; i < this.getNotes().length; i++) {
      if (this.getNote(i) != null) System.out.println("ID ===== " + this.getNote(i).getId() +
          " TITLE ===== " + this.getNote(i).getTitle() + " BODY ===== " + this.getNote(i).getBody());
  }
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
    if (id < 0 || id >= index) throw new AssertionError();
    return notes[id];
  }

  public Note[] getNotes() {
    return Arrays.copyOf(notes, index); // better then clone for that case: result haven`t null`s at his tail
  }
}

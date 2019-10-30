package com.epam.courses.java.fundamentals.oop.practice.task6;

import lombok.experimental.NonFinal;
import lombok.val;

import java.util.Arrays;

public class NotePad {
  /**
   * Determines the maximum size of the array.
   */
  private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;
  /**
   * Refers to the array of notes.
   */
  @NonFinal
  private Note[] notes;
  /**
   * Refers to the number of the note.
   */
  @NonFinal
  private int index;

  /**
   * The constructor of the class which takes the initial capacity as the parameter.
   * @param initialCapacity The initial capacity of the array.
   */
  public NotePad(int initialCapacity) {
    assert initialCapacity > 0;
    this.notes = new Note[initialCapacity];
  }

  /**
   * The constructor of the class with no parameters.
   */
  public NotePad() {
    this(16);
  }

  /**
   * Adds the new note to the notes[] array.
   * @param title the title of the note
   * @param body the body of the note
   * @return returns the note which was added or throws a Runtime exception if the array has already reached its maximum size.
   * @throws RuntimeException if the array has reached its maximum size and adding the note is not possible.
   */
  public Note addNote(String title, String body) {
    Note note = new Note(index++).setTitle(title).setBody(body);
    val ret = isPossibleToAdd() ? notes[note.getId()] = note : null;
    if (ret == null)
      throw new RuntimeException("It`s impossible to add the Note - the array already has maximum size!");

    return ret;
  }

  /**
   * Checks whether adding a note is possible.
   * @return true if the the number of the note is less than the size of the array, so it is still possible to add a note, or calls the tryToGrow() method.
   */
  private boolean isPossibleToAdd() {
    return index < notes.length || tryToGrow();
  }

  /**
   * Causes the array to increase its capacity, returns true or false depending on whether the operation was successful.
   * @return true if the array has increased its capacity, false otherwise
   */
  private boolean tryToGrow() {

    int capacity = notes.length << 1; // * 2 with overflow insurance

    if (capacity - index < 0) // is previous operation has overflow as a result?
      if (index - MAX_ARRAY_SIZE <= 0)
        capacity = MAX_ARRAY_SIZE;
      else
        return false;

    notes = Arrays.copyOf(notes, capacity);

    return true;
  }

  /**
   * Shows the note using its id.
   * @param id the id of the note
   * @return Note
   */
  public Note getNote(int id) {
    assert id >= 0 && id < index;
    return notes[id];
  }

  /**
   * Shows all the notes in the notepad.
   * @return array of notes
   */
  public Note[] getNotes() {
    return Arrays.copyOf(notes, index); // better then clone for that case: result haven`t null`s at his tail
  }

  /**
   * Changes the title of the note from the old to the new one.
   * @param id the id of the note
   * @param newTitle the new title of the note
   */
  public void updateTitle(int id, String newTitle){
    Note note = getNote(id);
    note.setTitle(newTitle);
  }

  /**
   * Changes the body of the note from the old to the new one.
   * @param id the id of the note
   * @param newBody the new body of the note
   */
  public void updateBody(int id, String newBody){
    Note note = getNote(id);
    note.setBody(newBody);
  }

  /**
   * Removes the note from the note pad, setting its value to null. May cause memory leaks.
   * @param id the id of the note
   */
  public void remove(int id){
    Note note = getNote(id);
    note = null;
  }
}

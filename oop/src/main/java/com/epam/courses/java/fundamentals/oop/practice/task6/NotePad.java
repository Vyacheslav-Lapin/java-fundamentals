package com.epam.courses.java.fundamentals.oop.practice.task6;

import java.util.Arrays;
import lombok.experimental.NonFinal;

/**
 * Class {@code Notepad} is a storage for many instances of <code>Note</code>.
 * NotePad includes array of notes, which are accessible by id.
 * @author Vyacheslav_Lapin
 * @author Andrey_Markov
 * @since 13.0
 */
public class NotePad {

  private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

  /**
   * Main field of class, object's contents
   */
  @NonFinal
  private Note[] notes;

  /**
   * Keeps position and <code>id</code> of next <code>Note</code> to be generated
   */
  @NonFinal
  private int index;

  /**
   * @return current <code>index</code> of this object
   */
  public int getIndex() {
    return index;
  }

  /**
   * Class constructor
   * @param initialCapacity   capacity of <code>notes</code>
   */
  public NotePad(int initialCapacity) {
    if(initialCapacity <= 0) throw new RuntimeException("Invalid initialCapacity: capacity must be greater then 0!");
    this.notes = new Note[initialCapacity];
  }

  /**
   * Default constructor, set basic <code>notes</code> capacity of 16.
   */
  public NotePad() {
    this(16);
  }

  /**
   * Adds new object of <code>Note</code> in <code>notes</code>
   * with <code>id</code> field matching position of object in array
   * @param title  string value for <code>title</code>
   * @param body   string value for <code>body</code>
   * @return new instance of <code>Note</code> and adds this instance in <code>notes</code>
   * on position of <code>index</code>
   * @exception RuntimeException is thrown when array of <code>notes</code> has maximum size
   * and new <code>Note</code> cannot be added
   */
  public Note addNote(String title, String body) {
    Note note = new Note(index++).setTitle(title).setBody(body);
    if (isPossibleToAdd()) return notes[note.getId()] = note;
    else throw new RuntimeException("It`s impossible to add the Note - array already have a maximum size!");
  }

  /**
   * Checks if <code>notes</code> has free slots to add new object
   * or, otherwise, calls {@link NotePad#hasGrew()}
   * @return <code>true</code> if after method completion <code>notes</code> has free space for new object
   * and no if array has reached maximum size
   */
  private boolean isPossibleToAdd() {
    return index < notes.length || hasGrew();
  }

  /**
   * @return <code>true</code> if length of <code>notes</code> has been increased successfully
   * and no if array has reached maximum size
   */
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

  /**
   * Sets new values of string parameters in <code>Note</code> specified by <code>id</code>
   * @param id        required to select certain note
   * @param newTitle  string new title for note
   * @param newBody   string new body for note
   * @return object of <code>Note</code> with edited fields <code>title</code> and <code>body</code>
   */
  public Note editNote(int id, String newTitle, String newBody){
    return getNote(id).setTitle(newTitle).setBody(newBody);
  }

  /**
   * @param id required to return certain note
   * @return <code>Note</code> from <code>notes</code> specified by <code>id</code>
   * @exception RuntimeException is thrown when <code>id</code> is invalid for this <code>NotePad</code>
   */
  public Note getNote(int id) {
    if (id < 0) throw new RuntimeException("Invalid note id: id must be greater then 0!");
    if (id >= index) throw new RuntimeException("Invalid note id: Note with this id is out of this NotePad");
    return notes[id];
  }

  /**
   * @return <code>notes</code>
   */
  public Note[] getNotes() {
    return Arrays.copyOf(notes, index); // better then clone for that case: result haven`t null`s at his tail
  }

  /**
   * Sends string representation of oll <code>Note</code> in this <code>NotePad</code> to console
   */
  public void viewAllNotes(){
    for (Note a : getNotes()){
      System.out.println(a.toString());
    }
  }

  /**
   * Deletes one <code>Note</code> in <code>notes</code>
   * After method completion all <code>id</code> values keep matching to array positions
   * and order of objects remains the same
   * @param id   required to select certain note
   */
  public void deleteNote(int id) {
    for (int i = id; i < (index-1); i++){
      notes[i] = new Note(i).setTitle(notes[i+1].getTitle()).setBody(notes[i+1].getBody());
    }
    notes[index-1] = null;
    index--;
  }
}

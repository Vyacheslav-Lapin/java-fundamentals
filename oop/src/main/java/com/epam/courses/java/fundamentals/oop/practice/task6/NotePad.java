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
   * @param title  string value for <code>title</code>
   * @param body   string value for <code>body</code>
   * @return new instance of <code>Note</code> and adds this instance in <code>notes</code>
   * on position of <code>index</code>
   * @exception RuntimeException is thrown when array of <code>notes</code> has maximum size
   * and new <code>Note</code> cannot be added
   */
  public Note addNote(String title, String body) {
    Note note = new Note(index++).setTitle(title).setBody(body);
    if (isPossibleToAdd()) {
      return notes[note.getId()] = note;
    }
    else {
      throw new RuntimeException("It`s impossible to add the Note - array already have a maximum size!");
    }
  }

  /**
   *
   */
  private boolean isPossibleToAdd() {
    return index < notes.length || hasGrew();
  }

  /**
   *
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
   * @param id        required to select certain note
   * @param newTitle  string new title for note
   * @param newBody   string new body for note
   */
  public Note editNote(int id, String newTitle, String newBody){
    return getNote(id).setTitle(newTitle).setBody(newBody);
  }

  /**
   * @param id
   * @exception RuntimeException
   */
  public Note getNote(int id) {
    if (id < 0) throw new RuntimeException("Invalid note id: id must be greater then 0!");
    if (id >= index) throw new RuntimeException("Invalid note id: Note with this id is out of this NotePad");
    return notes[id];
  }

  /**
   * @return
   */
  public Note[] getNotes() {
    return Arrays.copyOf(notes, index); // better then clone for that case: result haven`t null`s at his tail
  }

  /**
   *
   */
  public void viewAllNotes(){
    for (Note a : getNotes()){
      System.out.println(a.toString());
    }
  }

  /**
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

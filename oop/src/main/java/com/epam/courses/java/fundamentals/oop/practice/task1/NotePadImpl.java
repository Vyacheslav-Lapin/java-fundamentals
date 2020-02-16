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

  public Note remove(int id) {
    if(id < 0 || id > notes.length - 1)
      System.out.print("Wrong index!");
    notes[id] = null;
    notesSwapHelper(id);
    return null;
  }

  public void remove(String title){
    for(int i = 0; i < notes.length; i++)
      if(notes[i] != null) {
        if (notes[i].getTitle().equals(title)) {
          notes[i] = null;
          notesSwapHelper(i);
        }
      }
  }

  public void notesSwapHelper(int id){
    for(int i = id; i < notes.length - 1; i++)
      if(notes[i] == null && notes[i + 1] != null){
        notes[i] = notes[i+1];
        notes[i+1] = null;
      }
  }

  public void show(){
    for(int i = 0; i < this.getNotes().length; i ++)
      if(this.getNote(i) != null)
        System.out.println("|Id № " + (this.getNote(i).getId()) + " | Title: " + this.getNote(i).getTitle() + " | Body: " + this.getNote(i).getBody() + " |");
    //else
    //System.out.println("|Id №<empty> | Title: <empty> | Body: <empty> ");
  }


  public void updateTitle(int id , String newTitle){
    if(id < 0 || id > notes.length)
      System.out.print("Element not found. Incorrect index!");
    notes[id].setTitle(newTitle);
  }

  public void updateTitle(String oldTitle, String newTitle){
    boolean flag = false;
    for(int i = 0; i < notes.length; i++)
      if(notes[i] != null)
        if(notes[i].getTitle().equals(oldTitle)) {
          notes[i].setTitle(newTitle);
          flag = true;
        }
    if(!flag)
      System.out.println("Note with this title not found.");
  }

  public void updateBody(int id, String newBody){
    if(id < 0 || id > notes.length)
      System.out.print("Element not found. Incorrect index!");
    notes[id].setBody(newBody);
  }

  public void updateBody(String oldTitle, String newBody){
    boolean flag = false;
    for(int i = 0; i < notes.length; i++)
      if(notes[i] != null)
        if(notes[i].getTitle().equals(oldTitle)) {
          notes[i].setBody(newBody);
          flag = true;
        }
    if(!flag)
      System.out.println("Note with this title not found.");
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

}

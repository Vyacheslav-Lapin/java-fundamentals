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
    return isPossibleToAdd() ? notes[note.getId()] = note :
               null; // throw new RuntimeException("It`s impossible to add the Note - array already have a maximum size!");
  }

  public boolean editNote(String oldTitle, String newTitle){
    return edit(findNote(oldTitle),newTitle,null);
  }

  public boolean editNote(String oldTitle, String oldBody, String newTitle){
    return edit(findNote(oldTitle,oldBody),newTitle,null);
  }

  public boolean editNote(String oldTitle, String oldBody, String newTitle, String newBody){
    return edit(findNote(oldTitle,oldBody),newTitle,newBody);
  }

  public boolean editNote(int index, String newTitle, String newBody){
    return edit(findNote(index),newTitle,newBody);
  }

  private boolean edit(Note item,String title, String body){
    if (item!=null){
      if (title!=null)
        item.setTitle(title);
      if (body!=null)
        item.setBody(body);
      return true;
    }
    else return false;
  }

  public void showNotes(){
    for(Note note:notes){
      note.toString();
    }
  }

  public Note findNote(String title){
    for(Note item:notes){
      if (item.getTitle()==title)
        return item;
    }
    return null;
  }

  public Note findNote(int index){
    for(Note item:notes){
      if (item.getId()==index)
        return item;
    }
    return null;
  }

  public Note findNote(String title, String body){
    for(Note item:notes){
      if (item.getTitle()==title && item.getBody()==body)
        return item;
    }
    return null;
  }

  public boolean deleteNote(String title){
    return delete(findNote(title));
  }

  public boolean deleteNote(String title, String body){
    return delete(findNote(title, body));
  }

  public boolean deleteNote(int index){
    return delete(findNote(index));
  }

  private boolean delete(Note item){
    if (item==null) {
      int id = item.getId();
      Note temp;
      notes[id] = null;
      for (int i = id; i < index - 1; i++) {
        if (notes[i + 1] == null) {
          notes[i] = null;
          break;
        }
        notes[i] = notes[i + 1];
        notes[i].setId(notes[i].getId()-1);
      }
      index--;
      return true;
    }
    else
      return false;
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

  public Note[] getNotes() {
    return Arrays.copyOf(notes, index); // better then clone for that case: result haven`t null`s at his tail
  }
}

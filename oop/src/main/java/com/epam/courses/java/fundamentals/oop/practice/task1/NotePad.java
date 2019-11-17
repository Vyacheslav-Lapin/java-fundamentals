package com.epam.courses.java.fundamentals.oop.practice.task1;

import java.util.Arrays;
import java.util.Scanner;

import lombok.experimental.NonFinal;

public class NotePad {

 // private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;
//
 // @NonFinal
 // private Note[] notes;
//
 // @NonFinal
 // private int index;
//
 // public NotePad(int initialCapacity) {
 //   assert initialCapacity > 0;
 //   this.notes = new Note[initialCapacity];
 // }
//
 // public NotePad() {
 //   this(16);
 // }
//
 // public Note addNote(String title, String body) {
 //   Note note = new Note(index++).setTitle(title).setBody(body);
 //   return isPossibleToAdd() ? notes[note.getId()] = note :
 //       null; // throw new RuntimeException("It`s impossible to add the Note - array already have a maximum size!");
 // }
//
 // public void deleteNote(int id) {
 //   if (id >= 0 && id < index) {
 //     notes[id] = null;
 //   }
 // }
 // private boolean isPossibleToAdd() {
 //   return index < notes.length || hasGrew();
 // }
//
 // private boolean hasGrew() {
//
 //   int capacity = notes.length << 1; // * 2 with overflow insurance
//
 //   if (capacity - index < 0) // is previous operation has overflow as a result?
 //     if (index - MAX_ARRAY_SIZE <= 0)
 //       capacity = MAX_ARRAY_SIZE;
 //     else
 //       return false;
//
 //   notes = Arrays.copyOf(notes, capacity);
//
 //   return true;
 // }
//
 // public Note getNote(int id) {
 //   assert id >= 0 && id < index;
 //   return notes[id];
 // }
//
 // public Note[] getNotes() {
 //   return Arrays.copyOf(notes, index); // better then clone for that case: result haven`t null`s at his tail
 // }
//
 // public void updateNote(int id) {
 //   Scanner scanner = new Scanner(System.in);
 //   String title = scanner.nextLine();
 //   String body = scanner.nextLine();
 //   Note note = new Note(id,body,title).setTitle(title).setBody(body);
 //   notes[id] = note;
 // }

/* For Test
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    NotePad np = new NotePad();
    np.addNote("Oleg", "Hello");
    np.addNote("Eva", "Hello");
    np.addNote("Katy", "Hello");
    np.addNote("Mama", "Hello");
    for (int i = 0; i < np.notes.length; i++) {
      System.out.println(i + "  " + np.getNote(i));
    }
    System.out.println("Введите индекс");
    np.deleteNote(sc.nextInt());
    for (int i = 0; i < np.notes.length; i++) {
      System.out.println(i + "  " + np.getNote(i));
    }
    System.out.println("Введите индекс");
    np.updateNote(sc.nextInt());
    for (int i = 0; i < np.notes.length; i++) {
      System.out.println(i + "  " + np.getNote(i));
    }

    System.out.println(np.getNote(sc.nextInt()));
    System.out.println(np.getNote(sc.nextInt()));

    System.out.println("Введите индекс");
    np.deleteNote(sc.nextInt());
    for (int i = 0; i < np.notes.length; i++) {
      System.out.println(i + "  " + np.getNote(i));
    }
  }

 */
}

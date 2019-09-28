/* По классике, вставлю кусочек своего говнокода =)
  public class Task6 {
    public static void main(String[] args) {
        Note note = new Note();
        note.addPage("Privet");
        note.addPage("Kak dela?");
        note.printAllPage();
        note.editPage(1,"Good");
        note.printAllPage();
        note.deletePage(1);
        note.printAllPage();
    }
}
class Note {
    NotePage[] notePages = new NotePage[10];
    public void addPage(String pageText) {

            for (int i=0;i<notePages.length;i++) {
                if (notePages[i]==null) {
                    notePages[i] = new NotePage(pageText);
                    i=notePages.length; //можно использовать break
                }
            }

    }
    void deletePage(int pageNumber) {
        notePages[pageNumber]=null;
    }
    void editPage (int pageNumber,String newText) {
        notePages[pageNumber]=new NotePage(newText);
    }
    void printAllPage() {
        for (NotePage page:notePages) {
            if (page!=null) System.out.println(page);
        }
        System.out.println();
    }
}

class NotePage {
    String pageText;
    NotePage(String pageText) {
        this.pageText=pageText;
    }

    @Override
    public String toString() {
        return this.pageText;
    }
}

 */
/**
 * Class NotePad. Хранит листы типа Note в массиве notes[].
 * Создается конструктором с параметром int = количество страниц, либо пустым конструктором тогда кол-во страниц = 16.
 * Метод addNote() добавляет новую страницу, предварительно проверяя наличие места в массиве, если места нет увеличивает массив
 * либо при невозможности увеличения выкидывает ошибку.
 * getNote(index) возвращает лист с номером index.
 * printNotes(array) возвращает String из элементов типа Note массива array.
 * deleteNote(index) заменяет titel и body листа с индексом index на "Deleted". Как удалиться лист совсем не придумал,
 * при попытке notes[index]=null выкидывает ошибку.
 */
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

  public String printNotes(Note[] nno) {
    String str="";
    for (Note nn:nno) {
      str+=nn.toString()+" ";
    }
    return str;
  }

  public void deleteNote(int id) {
    notes[id]=new Note(id).setTitle("Deleted").setBody("Deleted");
  }

  public Note[] getNotes() {
    return Arrays.copyOf(notes, index); // better then clone for that case: result haven`t null`s at his tail
  }

  public static void main(String[] args) {
    NotePad np = new NotePad();
    np.addNote("Title 1", "Body1");
    np.addNote("Title 2", "Body2");
    np.addNote("Title 3", "Body3");
    System.out.println(np.getNote(1));
    System.out.println(np.printNotes(np.getNotes()));
    np.deleteNote(1);
    System.out.println(np.printNotes(np.getNotes()));

  }
}

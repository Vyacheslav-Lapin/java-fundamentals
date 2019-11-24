package com.epam.courses.java.fundamentals.oop.practice.task1;

import java.util.Arrays;
import lombok.experimental.NonFinal;
import org.jetbrains.annotations.Contract;

/** Класс Блокнот со свойствами <i>index</i> и массивом записей <i>notes</i>
 *
 */
public class NotePadImpl implements NotePad {

  private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

  @NonFinal
  Note[] notes;

  @NonFinal
  int index;
  /**
   * Конструктор - создание нового объекта заданного объема
   * @param initialCapacity - первоначальный объем массива
   * @see NotePadImpl#NotePadImpl()
   */
  @Contract(pure = true)
  public NotePadImpl(int initialCapacity) {
    assert initialCapacity > 0;
    this.notes = new Note[initialCapacity];
  }

  /**
   * Конструктор - создание нового объекта c объемом 16
   * @see NotePadImpl#NotePadImpl(int)
   */
  @Contract(pure = true)
  public NotePadImpl() {
    this(16);
  }

  /**
   * Функция добавления записи
   * @param title
   * @param body
   * @return возвращает добавленную запись
   */
  @Override
  public Note addNote(String title, String body) {

    var note = new Note(index++)
                   .setTitle(title)
                   .setBody(body);

    if (isPossibleToAdd())
      return notes[note.getId()] = note;
    else
      throw new RuntimeException("It`s impossible to add the Note - array already have a maximum size!");
  }

  /**
   * Процедура проверки размера массива для добавления записи
   * @return если добавление невозможно вызывает функцию для увеличения размера массива
   */
  private boolean isPossibleToAdd() {
    return index < notes.length || hasGrew();
  }

  /**
   * Функция увеличения массива в 2 раза
   * @return подтверждение увеличения
   */
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

  /**
   * Получение одной записи по свойству <i>id</i>
   * @param id
   * @return возвращает полученную запись, если возможно
   * @throws AssertionError если id за границами массива
   */
  @Override
  public Note getNote(int id) {
    if (id < 0 || id >= index)
      throw new AssertionError();

    return notes[id];
  }

  /**
   * Показывает все записи
   * @return массив всех записей
   */
  @Override
  public Note[] getNotes() {
    return Arrays.copyOf(notes, index); // better then clone for that case: result haven`t null`s at his tail
  }

  /**
   * Удаление записей по свойству <i>id</i>
   * @param id
   * @return удаленную запись
   */
  @Override
  public Note remove(int id) {
    Note deletedNote = getNote(id);
    for(int i = id; i < notes.length - 1; i++){
        notes[i] = notes[i+1];
    }
    index--;
    return deletedNote;
  }

  /**
   * Редактирование заголовка записи по свойству <i>id</i>
   * @param id
   * @param title
   * @return Отредактированную запись
   * @see NotePadImpl#editBody(int, String)
   */
  @Override
  public Note editTitle(int id, String title){
   Note editedNote = getNote(id);
   editedNote.setTitle(title);
   return editedNote;
  }

  /**
   * Редактирование тела записи по свойству <i>id</i>
   * @param id
   * @param body
   * @return Отредактированную запись
   * @see NotePadImpl#editTitle(int, String)
   */
  @Override
  public Note editBody(int id, String body){
    Note editedNote = getNote(id);
    editedNote.setBody(body);
    return editedNote;
  }

}


package com.epam.courses.java.fundamentals.oop.practice.task1;

import org.jetbrains.annotations.NotNull;

public interface NotePad {

  Note addNote(String title, String body);

  default Note addNote(@NotNull Note note) {
    return addNote(note.getTitle(), note.getBody());
  }

  default Note replace(@NotNull Note note) {
    return note.getId() == 0 ?
               addNote(note) :
               addNote(remove(note.getId()));
  }

  Note getNote(int id);

  Note[] getNotes();

  Note remove(int id);

  default Note remove(@NotNull Note note) {
    return remove(note.getId());
  }

  Note editNote(int id, String title, String body);
}

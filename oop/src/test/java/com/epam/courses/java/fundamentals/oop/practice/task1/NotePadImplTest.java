package com.epam.courses.java.fundamentals.oop.practice.task1;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;

class NotePadImplTest {

  private static NotePadImpl notePad = new NotePadImpl();

  @BeforeAll
  static void initializeNotePad() {
    notePad.addNote("Note 0","Some text 0");
    notePad.addNote("Note 1","Some text 1");
    notePad.addNote("Note 2","Some text 2");
  }

  @Test
  @DisplayName("addNote method works correctly")
  void testAddNote() {
    assertThat(notePad.getIndex()).isEqualTo(2);
  }

  @Test
  @DisplayName("getNote method works correctly")
  void testGetNote() {
    assertThat(notePad.getNote(0).getId()).isEqualTo(0);
    assertThat(notePad.getNote(0).getTitle().toString()).isEqualTo("Note 0");
    assertThat(notePad.getNote(0).getBody().toString()).isEqualTo("Some text 0");
  }

  @Test
  @DisplayName("editNote method works correctly")
  void testEditNote() {
    notePad.editNote(1,"New note 1","New text 1");

    assertThat(notePad.getNote(1).getId()).isEqualTo(1);
    assertThat(notePad.getNote(1).getTitle().toString()).isEqualTo("New note 1");
    assertThat(notePad.getNote(1).getBody().toString()).isEqualTo("New text 1");
  }

  @Test(expected = NullPointerException.class)
  @DisplayName("remove method works correctly")
  void testRemove() {
    notePad.remove(2);
    notePad.getNote(2).getId();
  }
}

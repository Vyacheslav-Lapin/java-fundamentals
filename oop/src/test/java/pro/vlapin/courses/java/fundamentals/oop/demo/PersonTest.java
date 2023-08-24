package pro.vlapin.courses.java.fundamentals.oop.demo;

import static org.assertj.core.api.Assertions.assertThat;

import pro.vlapin.courses.java.fundamentals.oop.demo.lombok.superbuilder.Person;
import lombok.val;
import org.junit.jupiter.api.Test;

class PersonTest {

  @Test
  void singilar() {
    val vasya = Person.builder()
                    .name("Vasya")
                    .contact("222-33-22")
                    .contact("vasya@ya.ru")
                    .contact("skype:vasya.pupkin")
                    .build();

    assertThat(vasya.getAge())
        .isEqualTo(16);

    assertThat(vasya.getContacts())
        .containsAnyOf("222-33-22");

  }
}

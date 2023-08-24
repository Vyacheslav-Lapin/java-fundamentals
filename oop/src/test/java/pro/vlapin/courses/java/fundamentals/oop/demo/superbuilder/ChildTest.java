package pro.vlapin.courses.java.fundamentals.oop.demo.superbuilder;

import static org.assertj.core.api.Assertions.assertThat;

import pro.vlapin.courses.java.fundamentals.oop.demo.lombok.superbuilder.Child;
import lombok.val;
import org.junit.jupiter.api.Test;

class ChildTest {

  @Test
  void test() {
    val child = Child.builder()
                      .parentName("Andrea")
                      .parentAge(38)
                      .childName("Emma")
                      .childAge(6)
                      .build();

    assertThat(child.getParentName()).isEqualTo("Andrea");
    assertThat(child.getParentAge()).isEqualTo(38);
    assertThat(child.getChildName()).isEqualTo("Emma");
    assertThat(child.getChildAge()).isEqualTo(6);
  }
}

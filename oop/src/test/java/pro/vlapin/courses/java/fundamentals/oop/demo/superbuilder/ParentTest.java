package pro.vlapin.courses.java.fundamentals.oop.demo.superbuilder;

import static org.assertj.core.api.Assertions.assertThat;

import pro.vlapin.courses.java.fundamentals.oop.demo.lombok.superbuilder.Parent;
import lombok.val;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ParentTest {

  @Test
  @DisplayName("build method works correctly")
  void build() {
    val johnSmith = Parent.builder()
                         .parentAge(55)
                         .parentName("John Smith")
                         .build();

    assertThat(johnSmith.getParentAge()).isEqualTo(55);
    assertThat(johnSmith.getParentName()).isEqualTo("John Smith");
  }
}

package pro.vlapin.courses.java.fundamentals.fp.demo.vavr;

import static org.assertj.core.api.Assertions.assertThat;

import io.vavr.Tuple;
import io.vavr.Tuple4;
import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TupleTest {

  Tuple4<Integer, String, Double, Long> tuple = Tuple.of(1, "blablabla", .0, 42L); // (1, blablabla, 0.0, 42)

  @Test
  @DisplayName("Simple tuple works correctly")
  void simpleTupleWorksCorrectlyTest() {
    assertThat(tuple._1).isEqualTo(1);
  }

  @Test
  @DisplayName("tuple multiple map works correctly")
  void tupleMultipleMapWorksCorrectlyTest() {
    assertThat(tuple.map(
        i -> i * 8,
        s -> s + "vr",
        d -> d + .5,
        l -> l - 20
    ))
        .isEqualTo(Tuple.of(8, "blablablavr", .5, 22L));
  }

  @Test
  @DisplayName("tuple map works correctly")
  void tupleMapWorksCorrectlyTest() {
    assertThat(tuple.map((i, s, d, l) -> Tuple.of(i * 8, s + "vr", d + .5, l - 20)))
        .isEqualTo(Tuple.of(8, "blablablavr", .5, 22L));
  }

  @Test
  @SneakyThrows
  @DisplayName("transform tuple to another class object")
  void transformTupleToAnotherClassObjectTest() {
    assertThat(tuple.<String>apply((i, s, d, l) -> s + "vr" + i * 8 + d + .5 + (l - 20)))
        .isEqualTo("blablablavr80.00.522");
  }
}

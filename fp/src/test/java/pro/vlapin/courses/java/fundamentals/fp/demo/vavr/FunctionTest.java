package pro.vlapin.courses.java.fundamentals.fp.demo.vavr;

import static org.assertj.core.api.Assertions.assertThat;

import io.vavr.Function0;
import io.vavr.Function1;
import io.vavr.Function2;
import io.vavr.PartialFunction;
import io.vavr.Tuple;
import io.vavr.Tuple2;
import io.vavr.control.Option;
import java.util.Random;
import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class FunctionTest {

  Function2<String, String, String> combineName =
      (lastName, firstName) -> firstName + " " + lastName;

  Function1<Integer, Integer> plusOne = a -> a + 1;
  Function1<Integer, Integer> multiplyByTwo = a -> a * 2;

  Function1<Long, Integer> simpleRandom = Function1.<Long, Random>of(Random::new)
                                              .andThen(Random::nextInt);

  @Test
  @DisplayName("function creates correctly")
  void functionCreatesCorrectlyTest() {
    assertThat(combineName.apply("Griffin", "Peter")).isEqualTo("Peter Griffin");
  }

  @Test
  @SneakyThrows
  @DisplayName("andThen works correctly")
  void andThenWorksCorrectlyTest() {
    Function1<Integer, Integer> add1AndMultiplyBy2 = plusOne.andThen(multiplyByTwo);
    assertThat(add1AndMultiplyBy2.apply(2)).isEqualTo(6);
  }

  @Test
  @SneakyThrows
  @DisplayName("compose works correctly")
  void composeWorksCorrectlyTest() {
    Function1<Integer, Integer> add1AndMultiplyBy2 = multiplyByTwo.compose(plusOne);
    assertThat(add1AndMultiplyBy2.apply(2)).isEqualTo(6);
  }

  @Test
  @SneakyThrows
  @DisplayName("tupling")
  void tuplingTest() {
    Function1<Tuple2<String, String>, String> tupledcombineName = combineName.tupled();
    Tuple2<String, String> params = Tuple.of("Griffin", "Peter");
    assertThat(tupledcombineName.apply(params)).isEqualTo("Peter Griffin");
  }

  @Test
  @DisplayName("Curring works correctly")
  void curringWorksCorrectlyTest() {
    // На основе базовой строим новую функцию с одним переданным элементом
    Function1<String, Function1<String, String>> curried = combineName.curried();
    Function1<String, String> makeGriffinName = curried.apply("Griffin");

    assertThat(makeGriffinName.apply("Peter")).isEqualTo("Peter Griffin");
    assertThat(makeGriffinName.apply("Lois")).isEqualTo("Lois Griffin");
  }

  @Test
  @SneakyThrows
  @DisplayName("reverse")
  void reverseTest() {
    assertThat(combineName.reversed().apply("Peter").apply("Griffin")).isEqualTo("Peter Griffin");
  }

  @Test
  @DisplayName("Simple cash works correctly")
  void simpleCashWorksCorrectlyTest() {
    Function0<Double> hashCache = Function0.of(Math::random).memoized();
    assertThat(hashCache.apply()).isEqualTo(hashCache.apply());
  }

  @Test
  @DisplayName("Cache with params works correctly")
  void cacheWithParamsWorksCorrectlyTest() {
    Function1<Long, Integer> memoizedRandom = simpleRandom.memoized();

    assertThat(memoizedRandom.apply(10L)).isEqualTo(memoizedRandom.apply(10L));
    assertThat(memoizedRandom.apply(10L)).isNotEqualTo(memoizedRandom.apply(20L));

    assertThat(simpleRandom).matches(f -> !f.isMemoized());
    assertThat(memoizedRandom).matches(Function1::isMemoized);
  }

  @Test
  @SneakyThrows
  @DisplayName("lifting works correctly")
  void liftingWorksCorrectlyTest() {
    Function2<Integer, Integer, Option<Integer>> safeDivide =
        Function2.lift((a, b) -> a / b);

    assertThat(safeDivide.apply(1, 0)).isEmpty();
    assertThat(safeDivide.apply(4, 2)).isNotEmpty();
  }

  @Test
  @SneakyThrows
  @DisplayName("PartialFunction works correctly")
  void partialFunctionWorksCorrectlyTest() {

    PartialFunction<Tuple2<Integer, Integer>, Integer> partial =
        Function2.<Integer, Integer, Integer>of((a, b) -> a / b)
            .tupled()
            .partial(iiTuple2 -> iiTuple2._2 != 0);
    assertThat(partial.isDefinedAt(Tuple.of(1, 0))).isFalse();

    Function1<Tuple2<Integer, Integer>, Option<Integer>> lift = partial.lift();
    assertThat(lift.apply(Tuple.of(1, 0))).isEmpty();

//    PartialFunction<Tuple2<Integer, Integer>, Integer> unlift =
//        PartialFunction.unlift(lift);
//    assertThat(unlift.isDefinedAt(Tuple.of(1, 0))).isFalse();
  }
}

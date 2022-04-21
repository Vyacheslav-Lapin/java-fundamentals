package com.epam.courses.java.fundamentals.fp;

import io.vavr.CheckedConsumer;
import io.vavr.CheckedPredicate;
import io.vavr.Function0;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import lombok.Cleanup;
import lombok.SneakyThrows;
import lombok.val;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

@FunctionalInterface
public interface Val<T> extends Function0<T> {

  @Contract(pure = true)
  static <T> @NotNull Val<T> val(@NotNull T t) {
    return () -> t;
  }

//  @Contract(pure = true)
//  static <T extends AutoCloseable> @NotNull CloseableVal<T> closeableVal(@NotNull T t) {
//    return () -> t;
//  }

  //  @Contract(pure = true)
  //  static <T, U extends Val<T>> @NotNull U val(@NotNull T t, @NotNull AutoCloseable autoCloseable) {
  //    Runnable close = CheckedRunnable.of(autoCloseable::close).unchecked();
  ////    noinspection unchecked
  //    return (U) Match(t).of(
  //        Case($(instanceOf(AutoCloseable.class)),
  //            obj -> {
  //              return Optional.of((T & AutoCloseable) obj)
  //                         .map(t1 -> CloseableVal.from(t1, close))
  //                         .orElseThrow();
  //            }), // it will never happen because of instanceof-check 3 rows higher
  //        Case($(), obj -> (Val<T>) () -> {
  //          close.run();
  //          return obj;
  //        })
  //    );
  //  }

  @Contract(pure = true)
  static <T> @NotNull Val<T> val(@NotNull Supplier<T> tSupplier) {
    return val(tSupplier.get());
  }

//  @Contract(pure = true)
//  static <T extends AutoCloseable> @NotNull Val<T> closeableVal(@NotNull Supplier<T> tSupplier) {
//    return closeableVal(tSupplier.get());
//  }

  default <R> @NotNull Val<R> map(@NotNull Function<@NotNull T, @NotNull R> mapper) {
    return mapper
               .andThen(Val::val)
               .apply(get());
  }

//  @SneakyThrows
//  default <R> @NotNull Val<R> mapChecked(@NotNull CheckedFunction1<@NotNull T, @NotNull R> mapper) {
//    return map(mapper.unchecked());
//  }

  @Contract("_ -> this")
  default @NotNull Val<T> peek(@NotNull Consumer<@NotNull T> consumer) {
    consumer.accept(get());
    return this;
  }

  @Contract("_ -> this")
  @SuppressWarnings("unchecked")
  default @NotNull Val<T> peek(@NotNull Consumer<@NotNull T>... consumers) {
    for (val consumer : consumers)
      consumer.accept(get());
    return this;
  }

//  @Contract("_ -> this")
//  default @NotNull Val<T> peekChecked(@NotNull CheckedConsumer<@NotNull T> consumer) {
//    return peek(consumer.unchecked());
//  }

//  @Contract("_ -> this")
//  @SuppressWarnings("unchecked")
//  default @NotNull Val<T> peekChecked(@NotNull CheckedConsumer<@NotNull T>... consumers) {
//    noinspection unchecked
//    return peek(
//        Arrays.stream(consumers)
//            .map(CheckedConsumer::unchecked)
//            .toArray(Consumer[]::new));
//  }

  default <R1, R2> @NotNull Val<R2> map2(@NotNull Function<@NotNull T, @NotNull R1> mapper1,
                                         @NotNull Function<@NotNull R1, @NotNull R2> mapper2) {
    return mapper1
               .andThen(mapper2)
               .andThen(Val::val)
               .apply(get());
  }

  default <R1, R2, R3> @NotNull Val<R3> map3(@NotNull Function<@NotNull T, @NotNull R1> mapper1,
                                             @NotNull Function<@NotNull R1, @NotNull R2> mapper2,
                                             @NotNull Function<@NotNull R2, @NotNull R3> mapper3) {
    return mapper1
               .andThen(mapper2)
               .andThen(mapper3)
               .andThen(Val::val)
               .apply(get());
  }

  default <R1, R2, R3, R4> @NotNull Val<R4> map4(@NotNull Function<@NotNull T, @NotNull R1> mapper1,
                                                 @NotNull Function<@NotNull R1, @NotNull R2> mapper2,
                                                 @NotNull Function<@NotNull R2, @NotNull R3> mapper3,
                                                 @NotNull Function<@NotNull R3, @NotNull R4> mapper4) {
    return mapper1
               .andThen(mapper2)
               .andThen(mapper3)
               .andThen(mapper4)
               .andThen(Val::val)
               .apply(get());
  }

  @Contract("_, _ -> this")
  default @NotNull Val<T> anAssert(@NotNull Predicate<@NotNull T> predicate,
                                   @NotNull Supplier<@NotNull ? extends RuntimeException> throwableSupplier) {
    if (predicate.test(get()))
      return this;
    else
      throw throwableSupplier.get();
  }

//  @Contract("_ -> this")
//  default <U extends Val<T>> @NotNull U anAssert(@NotNull Predicate<@NotNull T> predicate) {
//    return anAssert(predicate,
//        () -> new RuntimeException(
//            "predicate result is false for parameter value " + get()));
//  }

  @Contract("_, _ -> this")
  default <U extends Val<T>> @NotNull U ifPeek(@NotNull Predicate<@NotNull T> predicate,
                                               @NotNull Consumer<@NotNull T> consumer) {
    T t = get();
    if (predicate.test(t))
      consumer.accept(t);

    //noinspection unchecked
    return (U) this;
  }

  @Contract("_, _, _ -> this")
  default <U extends Val<T>> @NotNull U ifElsePeek(@NotNull Predicate<@NotNull T> predicate,
                                                   @NotNull Consumer<@NotNull T> consumerTrue,
                                                   @NotNull Consumer<@NotNull T> consumerFalse) {
    T t = get();
    if (predicate.test(t))
      consumerTrue.accept(t);
    else
      consumerFalse.accept(t);

    //noinspection unchecked
    return (U) this;
  }

//  default <U extends Val<T>> @NotNull U ifMap(@NotNull Predicate<@NotNull T> predicate,
//                                              @NotNull UnaryOperator<@NotNull T> mapper) {
//    noinspection unchecked
//    return predicate.test(get()) ? map(mapper) : (U) this;
//  }

//  default <U extends Val<T>> @NotNull U ifMapChecked(@NotNull CheckedPredicate<@NotNull T> predicate,
//                                                     @NotNull CheckedFunction1<@NotNull T, @NotNull T> mapper) {
//    return ifMap(predicate.unchecked(), mapper.unchecked()::apply);
//  }

//  default <U extends Val<T>> @NotNull U ifNotMap(@NotNull Predicate<@NotNull T> predicate,
//                                                 @NotNull UnaryOperator<@NotNull T> mapper) {
//    return ifMap(predicate.negate(), mapper);
//  }
//
//  default <R, U extends Val<R>> @NotNull U ifElseMap(@NotNull Predicate<@NotNull T> predicate,
//                                                     @NotNull Function<@NotNull T, @NotNull R> mapperIfTrue,
//                                                     @NotNull Function<@NotNull T, @NotNull R> mapperIfFalse) {
//    return predicate.test(get()) ? map(mapperIfTrue) : map(mapperIfFalse);
//  }

  @FunctionalInterface
  interface CloseableVal<T extends AutoCloseable> extends Val<T> {

    @Contract(pure = true)
    static <T extends AutoCloseable> @NotNull CloseableVal<T> from(T t) {
      return () -> t;
    }

    static <T extends AutoCloseable> @NotNull CloseableVal<T> from(T t, Runnable close) {
      return () -> {
        close.run();
        return t;
      };
    }

//    @Override
//    default <R, U extends Val<R>> @NotNull U map(@NotNull Function<@NotNull T, @NotNull R> mapper) {
//      val t = get();
//      return mapper
//                 .andThen(Val::<R, U>val)
//                 .andThen(closeableVal -> closeableVal.closeAfterApply(t))
//                 .apply(t);
//    }

//    default <R, U extends Val<R>> @NotNull U mapWithoutClose(@NotNull Function<@NotNull T, @NotNull R> mapper) {
//      return Val.super.map(mapper);
//    }
//
//    @Override
//    default <U extends Val<R2>, R1, R2> @NotNull U map2(@NotNull Function<@NotNull T, @NotNull R1> mapper1,
//                                                        @NotNull Function<@NotNull R1, @NotNull R2> mapper2) {
//      @Cleanup T t = get();
//      return mapper1
//                 .andThen(mapper2)
//                 .andThen(Val::<R2, U>val)
//                 .apply(t);
//    }

//    default <U extends Val<R2>, R1, R2> @NotNull U map2WithoutClose(@NotNull Function<@NotNull T, @NotNull R1> mapper1,
//                                                                    @NotNull Function<@NotNull R1, @NotNull R2> mapper2) {
//      return Val.super.map2(mapper1, mapper2);
//    }
//
//    @Override
//    default <U extends Val<R3>, R1, R2, R3> @NotNull U map3(@NotNull Function<@NotNull T, @NotNull R1> mapper1,
//                                                            @NotNull Function<@NotNull R1, @NotNull R2> mapper2,
//                                                            @NotNull Function<@NotNull R2, @NotNull R3> mapper3) {
//      @Cleanup T t = get();
//      return mapper1
//                 .andThen(mapper2)
//                 .andThen(mapper3)
//                 .andThen(Val::<R3, U>val)
//                 .apply(t);
//    }

//    default <U extends Val<R3>, R1, R2, R3> @NotNull U map3WithoutClose(@NotNull Function<@NotNull T, @NotNull R1> mapper1,
//                                                                        @NotNull Function<@NotNull R1, @NotNull R2> mapper2,
//                                                                        @NotNull Function<@NotNull R2, @NotNull R3> mapper3) {
//      return Val.super.map3(mapper1, mapper2, mapper3);
//    }
//
//    @Override
//    default <U extends Val<R4>, R1, R2, R3, R4> @NotNull U map4(@NotNull Function<@NotNull T, @NotNull R1> mapper1,
//                                                                @NotNull Function<@NotNull R1, @NotNull R2> mapper2,
//                                                                @NotNull Function<@NotNull R2, @NotNull R3> mapper3,
//                                                                @NotNull Function<@NotNull R3, @NotNull R4> mapper4) {
//      @Cleanup T t = get();
//      return mapper1
//                 .andThen(mapper2)
//                 .andThen(mapper3)
//                 .andThen(mapper4)
//                 .andThen(Val::<R4, U>val)
//                 .apply(t);
//    }
//
//    default <U extends Val<R4>, R1, R2, R3, R4> @NotNull U map4WithoutClose(@NotNull Function<@NotNull T, @NotNull R1> mapper1,
//                                                                            @NotNull Function<@NotNull R1, @NotNull R2> mapper2,
//                                                                            @NotNull Function<@NotNull R2, @NotNull R3> mapper3,
//                                                                            @NotNull Function<@NotNull R3, @NotNull R4> mapper4) {
//      return Val.super.map4(mapper1, mapper2, mapper3, mapper4);
//    }
  }
}

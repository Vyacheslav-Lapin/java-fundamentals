package pro.vlapin.courses.java.fundamentals.fp;

import java.util.function.Function;

@FunctionalInterface
public interface VarArgsFunction<T, R> extends Function<T[], R> {

  @Override
  @SuppressWarnings("unchecked")
  R apply(T... ts);
}

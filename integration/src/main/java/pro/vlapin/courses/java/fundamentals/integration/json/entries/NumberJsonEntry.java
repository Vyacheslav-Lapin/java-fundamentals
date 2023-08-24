package pro.vlapin.courses.java.fundamentals.integration.json.entries;

import pro.vlapin.courses.java.fundamentals.integration.json.visitors.JsonEntryVisitor;
import java.util.function.DoubleSupplier;
import java.util.function.LongSupplier;
import lombok.Getter;
import lombok.experimental.SuperBuilder;
import org.jetbrains.annotations.NotNull;

@Getter
@SuperBuilder(toBuilder = true)
public class NumberJsonEntry extends JsonEntry<Double> implements DoubleSupplier, LongSupplier {

  double value;

  static NumberJsonEntry from(double value, String name) {
    return NumberJsonEntry.builder()
               .key(name)
               .value(value)
               .build();
  }

  @Override
  public Double getValue() {
    return value;
  }

  @Override
  public double getAsDouble() {
    return value;
  }

  @Override
  public long getAsLong() {
    return Math.round(value);
  }

  @Override
  public void visit(@NotNull JsonEntryVisitor jsonEntryVisitor) {
    jsonEntryVisitor.accept(this);
  }
}

package pro.vlapin.courses.java.fundamentals.integration.json.visitors;

import pro.vlapin.courses.java.fundamentals.integration.json.entries.ArrayJsonEntry;
import pro.vlapin.courses.java.fundamentals.integration.json.entries.BooleanJsonEntry;
import pro.vlapin.courses.java.fundamentals.integration.json.entries.NullJsonEntry;
import pro.vlapin.courses.java.fundamentals.integration.json.entries.NumberJsonEntry;
import pro.vlapin.courses.java.fundamentals.integration.json.entries.ObjectJsonEntry;
import pro.vlapin.courses.java.fundamentals.integration.json.entries.StringJsonEntry;
import org.jetbrains.annotations.NotNull;

public interface JsonEntryVisitor {

  void accept(@NotNull ObjectJsonEntry jsonEntry);
  void accept(@NotNull ArrayJsonEntry jsonEntry);
  void accept(@NotNull StringJsonEntry jsonEntry);
  void accept(@NotNull BooleanJsonEntry jsonEntry);
  void accept(@NotNull NumberJsonEntry jsonEntry);
  void accept(@NotNull NullJsonEntry jsonEntry);
}

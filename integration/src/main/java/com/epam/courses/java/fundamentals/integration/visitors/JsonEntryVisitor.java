package com.epam.courses.java.fundamentals.integration.visitors;

import com.epam.courses.java.fundamentals.integration.entries.ArrayJsonEntry;
import com.epam.courses.java.fundamentals.integration.entries.BooleanJsonEntry;
import com.epam.courses.java.fundamentals.integration.entries.NullJsonEntry;
import com.epam.courses.java.fundamentals.integration.entries.NumberJsonEntry;
import com.epam.courses.java.fundamentals.integration.entries.ObjectJsonEntry;
import com.epam.courses.java.fundamentals.integration.entries.StringJsonEntry;
import org.jetbrains.annotations.NotNull;

public interface JsonEntryVisitor {

  void accept(@NotNull ObjectJsonEntry jsonEntry);
  void accept(@NotNull ArrayJsonEntry jsonEntry);
  void accept(@NotNull StringJsonEntry jsonEntry);
  void accept(@NotNull BooleanJsonEntry jsonEntry);
  void accept(@NotNull NumberJsonEntry jsonEntry);
  void accept(@NotNull NullJsonEntry jsonEntry);
}

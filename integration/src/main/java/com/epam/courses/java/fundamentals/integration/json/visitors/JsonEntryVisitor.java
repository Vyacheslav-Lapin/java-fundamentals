package com.epam.courses.java.fundamentals.integration.json.visitors;

import com.epam.courses.java.fundamentals.integration.json.entries.ArrayJsonEntry;
import com.epam.courses.java.fundamentals.integration.json.entries.BooleanJsonEntry;
import com.epam.courses.java.fundamentals.integration.json.entries.NullJsonEntry;
import com.epam.courses.java.fundamentals.integration.json.entries.NumberJsonEntry;
import com.epam.courses.java.fundamentals.integration.json.entries.ObjectJsonEntry;
import com.epam.courses.java.fundamentals.integration.json.entries.StringJsonEntry;
import org.jetbrains.annotations.NotNull;

public interface JsonEntryVisitor {

  void accept(@NotNull ObjectJsonEntry jsonEntry);
  void accept(@NotNull ArrayJsonEntry jsonEntry);
  void accept(@NotNull StringJsonEntry jsonEntry);
  void accept(@NotNull BooleanJsonEntry jsonEntry);
  void accept(@NotNull NumberJsonEntry jsonEntry);
  void accept(@NotNull NullJsonEntry jsonEntry);
}

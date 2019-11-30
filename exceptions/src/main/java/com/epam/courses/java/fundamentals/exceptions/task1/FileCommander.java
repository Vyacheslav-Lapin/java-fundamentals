package com.epam.courses.java.fundamentals.exceptions.task1;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.NonFinal;
import lombok.val;

import java.nio.file.Path;
import java.util.Arrays;

public class FileCommander extends ConsoleCommander {
  @Getter
  @Setter
  @NonFinal
  private Path curDirPath = Path.of(".");

  @Override
  protected void printOnUnknownCommand(String command) {
    System.out.println("Can't recognize command '" + command + "', please try again");
  }

  @Override
  protected void evalCommand(String commandWithArgs) throws UnknownCommandException {
    val words = commandWithArgs.split("\\s+");
    val commandWord = words[0];
    val args = Arrays.copyOfRange(words, 1, words.length);
    val command = CommandsFactory.create(commandWord, args, this);
    command.exec();
  }

  @Override
  protected void printPrompt() {
    System.out.println(curDirPath.toAbsolutePath().toString() + ">");
  }

  @Override
  protected boolean isExitCommand(String command) {

    return command.equals("q");
  }
}

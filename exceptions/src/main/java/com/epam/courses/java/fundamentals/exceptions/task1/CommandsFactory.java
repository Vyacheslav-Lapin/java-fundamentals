package com.epam.courses.java.fundamentals.exceptions.task1;

public class CommandsFactory {
  public static Command create(String command, String[] args, FileCommander fileCommander) throws UnknownCommandException {
    switch (command) {
      case "ls" -> {
        return new ListFilesInDirectoryCommand(fileCommander.getCurDirPath());
      }
      case "cd" ->{
        return new ChangeDirCommand(args[0], fileCommander);
      }
      default -> throw new UnknownCommandException(command );
    }
  }
}

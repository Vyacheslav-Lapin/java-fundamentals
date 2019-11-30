package com.epam.courses.java.fundamentals.exceptions.task1;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.val;

import java.nio.file.Path;

@AllArgsConstructor
public class ChangeDirCommand implements Command {
  @Getter
  String newDir;
  FileCommander fileCommander;

  @Override
  public void exec() {
    val newDirPath = Path.of(newDir);
    if (!newDirPath.toFile().exists())
      throw new ChangeDirCommandException("Path '" + newDirPath + "' doesn't exist");
    fileCommander.setCurDirPath(newDirPath);
  }
}

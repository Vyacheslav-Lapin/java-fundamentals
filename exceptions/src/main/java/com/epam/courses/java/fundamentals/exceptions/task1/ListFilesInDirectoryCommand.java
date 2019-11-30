package com.epam.courses.java.fundamentals.exceptions.task1;

import lombok.Data;

import java.io.File;
import java.nio.file.Path;
import java.security.AccessControlException;
import java.util.Arrays;

@Data
public class ListFilesInDirectoryCommand implements Command {
  Path curDirPath;

  @Override
  public void exec() {
    File[] files;
    try {
      files = curDirPath.toFile().listFiles();
    } catch (AccessControlException ex) {
      throw new FileCommanderException("No access rights to list files", ex);
    }

    Arrays.stream(files != null ? files : new File[0]).forEach(f -> System.out.println("\t" + f.getName()));

  }
}

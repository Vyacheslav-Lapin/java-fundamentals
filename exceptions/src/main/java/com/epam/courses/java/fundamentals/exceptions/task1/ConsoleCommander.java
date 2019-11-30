package com.epam.courses.java.fundamentals.exceptions.task1;

import lombok.val;

import java.util.Scanner;

public abstract class ConsoleCommander {
  private Scanner scanner = new Scanner(System.in);

  public void run() {
    while (true) {
      printPrompt();
      val command = scanner.nextLine();
      if (isExitCommand(command))
        break;
      try {
        evalCommand(command);
      } catch (UnknownCommandException e) {
        printOnUnknownCommand(e.getCommand());
      } catch (RuntimeException ex) {
        System.out.println("Cannot exec command: " + ex.getMessage());
      }
    }
  }

  protected abstract void printOnUnknownCommand(String command);

  protected abstract void evalCommand(String command) throws UnknownCommandException;

  protected abstract void printPrompt();

  protected abstract boolean isExitCommand(String command);

}

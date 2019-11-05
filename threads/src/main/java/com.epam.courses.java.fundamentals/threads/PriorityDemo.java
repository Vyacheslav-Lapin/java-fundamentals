package com.epam.courses.java.fundamentals.threads;

public class PriorityDemo {
  public static void main(String... __) {
    Thread.currentThread().setPriority(Thread.MAX_PRIORITY);

    Clicker[] his = {
        new Clicker(),
        new Clicker(),
        new Clicker(),
        new Clicker(),
        new Clicker(),
        new Clicker()
    };

    Clicker[] los = {
        new Clicker(),
        new Clicker(),
        new Clicker(),
        new Clicker(),
        new Clicker(),
        new Clicker()
    };

    for (Clicker hi : his) hi.setPriority(Thread.MAX_PRIORITY);
    for (Clicker lo : los) lo.setPriority(Thread.MIN_PRIORITY);

    for (Clicker hi : his) hi.start();
    for (Clicker lo : los) lo.start();

    try {
      Thread.sleep(50);
    } catch (InterruptedException e) {
      System.out.println("Main thread interrupted.");
    }

    for (Clicker lo : los) lo.stopClick();
    for (Clicker hi : his) hi.stopClick();

    try {
      for (Clicker lo : los) lo.join();
      for (Clicker hi : his) hi.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    for (Clicker lo : los) System.out.println("lo.getClick() = " + lo.getClick());
    for (Clicker hi : his) System.out.println("hi.getClick() = " + hi.getClick());
  }
}

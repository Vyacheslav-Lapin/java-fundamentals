package com.epam.courses.java.fundamentals.threads.demo;

public class PriorityDemo {
  public static void main(String... __) {
    Thread.currentThread().setPriority(Thread.MAX_PRIORITY);

    Clicker[] his = {
        new Clicker(),
        new Clicker(),
        new Clicker(),
        new Clicker(),
        new Clicker(),
        new Clicker(),
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
        new Clicker(),
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

    long loClicks = 0L;
    long hiClicks = 0L;

    for (Clicker lo : los) {
      int click = lo.getClick();
      System.out.println("lo.getClick() = " + click);
      loClicks += click;
    }
    for (Clicker hi : his) {
      int click = hi.getClick();
      System.out.println("hi.getClick() = " + click);
      hiClicks += click;
    }

    long delta = hiClicks - loClicks;
    System.out.printf("loClicks = %d;\nhiClicks = %d;\ndelta    = %d(%d%%)",
        loClicks,
        hiClicks,
        delta,
        Math.round(delta / 1.0 / hiClicks * 100));
  }
}

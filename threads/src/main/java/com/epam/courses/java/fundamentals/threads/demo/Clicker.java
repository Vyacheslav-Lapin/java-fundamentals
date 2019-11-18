package com.epam.courses.java.fundamentals.threads.demo;

import lombok.Getter;
import lombok.experimental.NonFinal;

class Clicker extends Thread {

  @NonFinal
  @Getter
  int click;

  @NonFinal
  private volatile boolean running = true;

  public void run() {
    while (running) click++;
  }

  public void stopClick() {
    running = false;
  }
}

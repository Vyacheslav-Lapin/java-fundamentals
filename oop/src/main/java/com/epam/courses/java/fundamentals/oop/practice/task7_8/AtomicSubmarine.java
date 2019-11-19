package com.epam.courses.java.fundamentals.oop.practice.task7_8;

import lombok.experimental.NonFinal;

@SubmarineInformation(length = 115, depth = 240, color = "black")
public class AtomicSubmarine implements Submarine {

  @NonFinal
  AtomicSubmarineEngine engine;

  @NonFinal
  boolean engineStatus;

  public AtomicSubmarine() {
    this.engine = new AtomicSubmarineEngine();
  }

  public void sailing() {
    engine.startEngine();
    System.out.println(printMessage());
  }

  public void stopping() {
    engine.stopEngine();
    System.out.println(printMessage());
  }

  public String printMessage() {
    return engine.isEngineWorking() ? "in navigation" : "stop navigation";
  }

  public static void main(String... __) throws InterruptedException {
    var atomicBoat = new AtomicSubmarine();
    atomicBoat.sailing();
    Thread.sleep(1000);
    atomicBoat.stopping();
  }

  class AtomicSubmarineEngine {

    public void startEngine() {
      engineStatus = true;
    }

    public void stopEngine() {
      engineStatus = false;
    }

    public boolean isEngineWorking() {
      return engineStatus;
    }
  }
}

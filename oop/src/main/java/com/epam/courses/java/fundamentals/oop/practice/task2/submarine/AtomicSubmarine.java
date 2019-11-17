package com.epam.courses.java.fundamentals.oop.practice.task2.submarine;

public class AtomicSubmarine {

  private String name;
  private int productionYear;

  AtomicSubmarine(String name, int productionYear) {
    this.name = name;
    this.productionYear = productionYear;
  }

  static class EngineForAtomicSubmarine {

    static void startMotion(AtomicSubmarine atomicSubmarine) {
      System.out.println("Movement of " + atomicSubmarine.name + " has been started");
    }
  }

  public static void main(String[] args) {
    AtomicSubmarine atomicSubmarine = new AtomicSubmarine("Atom", 2019);
    EngineForAtomicSubmarine.startMotion(atomicSubmarine);
  }
}

package com.epam.courses.java.fundamentals.oop.practice.task7;

import lombok.SneakyThrows;
import lombok.experimental.NonFinal;

/**
 * Разработайте класс АтомнаяЛодка, создайте внутренний класс – ДвигательДляАтомнойЛодки.
 * Создайте объект АтомнаяЛодка и “запустите его в плавание”.
 */

public class SSBN implements Runnable {

  @NonFinal
  String name;

  @NonFinal
  private SSBN_PowerSupply engine;

  @NonFinal
  Type type;

  public enum Type {MISSILE, ATTACKING;}

  static class SSBN_PowerSupply {
    @NonFinal
    long totalPower;
    @NonFinal
    int numberOfReactors;

    public SSBN_PowerSupply(long totalPower, int numberOfReactors) {
      this.totalPower = totalPower;
      this.numberOfReactors = numberOfReactors;
    }
  }

   SSBN(String name, SSBN_PowerSupply engine, Type type) {
    this.name = name;
    this.engine = engine;
    this.type = type;
  }

  @SneakyThrows
  @Override
  public void run() {
    for (int i = 60; i > 0; i--) {
      System.out.println("Vzzzz-Dr-Dr-Dr-bl-bl-bl");
      Thread.sleep(500);
    }
  }

  public static void main(String[] args) {
    SSBN Moskva = new SSBN("Moskva", new SSBN_PowerSupply(5000, 2), Type.MISSILE);
    Moskva.run();
  }
}


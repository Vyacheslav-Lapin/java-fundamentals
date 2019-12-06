package com.epam.courses.java.fundamentals.oop.practice.taskoop.task6;

import com.epam.courses.java.fundamentals.oop.practice.task7.FloatSound;
import lombok.SneakyThrows;

/**
 * Разработайте класс АтомнаяЛодка, создайте внутренний класс – ДвигательДляАтомнойЛодки.
 * Создайте объект АтомнаяЛодка и “запустите его в плавание”.
 */
@FloatSound(sound = "Vzzzz-Dr-Dr-Dr-bl-bl-bl")
public class SSBN implements Runnable {

  String name;

  private SSBN_PowerSupply engine;

  Type type;

  public enum Type {MISSILE, ATTACKING;}

  class SSBN_PowerSupply {

    long totalPower;

    int numberOfReactors;

    SSBN_PowerSupply(long totalPower, int numberOfReactors) {
      this.totalPower = totalPower;
      this.numberOfReactors = numberOfReactors;
    }
  }

   SSBN(String name, long totalPower, int numberOfReactors, Type type) {
    this.name = name;
    this.engine = new SSBN_PowerSupply(totalPower, numberOfReactors);
    this.type = type;
  }

  @SneakyThrows
  @Override
  public void run() {
    for (int i = 60; i > 0; i--) {
      String sound = this.getClass().getAnnotation(FloatSound.class).sound();
      System.out.println(sound);
      Thread.sleep(500);
    }
  }

  public static void main(String[] args) {
    SSBN Moskva = new SSBN("Moskva",5000, 2, Type.MISSILE);
    Moskva.run();
  }
}


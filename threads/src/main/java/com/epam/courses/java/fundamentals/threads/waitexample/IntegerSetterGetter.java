package com.epam.courses.java.fundamentals.threads.waitexample;

import java.util.Random;
import lombok.experimental.NonFinal;

public class IntegerSetterGetter extends Thread {

  SharedResource resource;
  Random rand = new Random();
  @NonFinal
  boolean run = true;

  public IntegerSetterGetter(String name, SharedResource resource) {
    super(name);
    this.resource = resource;
  }

  public void stopThread() {
    run = false;
  }

  public void run() {
    int action;

    try {
      while (run) {
        action = rand.nextInt(1_000);
        if (action % 2 == 0) getIntegersFromResource();
        else setIntegersIntoResource();
      }
      System.out.printf("Поток %s завершил работу.\n", getName());
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  private void getIntegersFromResource() throws InterruptedException {
    Integer number;

    synchronized (resource) {
      System.out.printf("Поток %s хочет извлечь число.\n", getName());
      number = resource.getElement();
      while (number == null) {
        System.out.printf("Поток %s ждет пока очередь заполнится.\n", getName());
        resource.wait();
        System.out.printf("Поток %s возобновил работу.\n", getName());
        number = resource.getElement();
      }
      System.out.printf("Поток %s извлек число %d\n", getName(), number);
    }
  }

  private void setIntegersIntoResource() {
    Integer number = rand.nextInt(500);
    synchronized (resource) {
      resource.setElement(number);
      System.out.printf("Поток %s записал число %d\n", getName(), number);
      resource.notify();
    }
  }

}

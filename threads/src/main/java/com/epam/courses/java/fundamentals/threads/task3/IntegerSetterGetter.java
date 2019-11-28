package com.epam.courses.java.fundamentals.threads.task3;

import java.util.Random;

class IntegerSetterGetter extends Thread {

  private final SharedResource resource;
  private boolean run;
  private Random rand = new Random();

  IntegerSetterGetter(String name, SharedResource resource) {
    super(name);
    this.resource = resource;
    run = true;
  }

  void stopThread() {
    run = false;
  }

  public void run() {
    int action;
    try {
      while (run) {
        action = rand.nextInt(1000);
        if (action % 2 == 0) {
          getIntegersFromResource();
        } else {
          setIntegersIntoResource();
        }
      }
      System.out.println("Поток " + getName() + " завершил работу.");
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
  private void getIntegersFromResource() throws InterruptedException {
    Integer number;
    synchronized (resource) {
      System.out.println("Поток " + getName() + " хочет извлечь число");
      number = resource.getElement();
      while (number == null) {
        System.out.println("Поток " + getName() + " ждет, пока очередь заполнится.");
        resource.wait();
        System.out.println("Поток " + getName() + " возобновил работу.");
        number = resource.getElement();
      }
      System.out.println("Поток " + getName() + " извлек число " + number);
    }
  }

  private void setIntegersIntoResource() throws InterruptedException {
    Integer number = rand.nextInt(500);
    synchronized (resource) {
      resource.setElement(number);
      System.out.println("Поток "  + getName() +" записал число " + number);
      resource.notifyAll();
    }
  }
}

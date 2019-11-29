package com.epam.courses.java.fundamentals.threads.practice.task3;

import lombok.experimental.NonFinal;

import java.util.Random;

public class IntegerSetterGetter extends Thread{
  private SharedResource resource;
  private RandomGenerator rand;
  @NonFinal
  private boolean run;
  private Random randNum = new Random();

  public IntegerSetterGetter(String name, SharedResource resource, RandomGenerator rand) {
    super(name);
    this.resource = resource;
    this.rand = rand;
    run = true;
  }

  public void stopThread() {
    run = false;
  }

  public void run() {
    boolean randGen;

    try {
      while (run) {
        synchronized (rand){
          randGen = rand.getBool();
        }
        if(randGen) getIntegersFromResource();
        else setIntegersIntoResource();
        }
      System.out.println("Поток " + getName() + " завершил работу.");
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  private void getIntegersFromResource() throws InterruptedException {
    Integer number;

    synchronized (resource) {
      System.out.println("Поток " + getName() + " хочет извлечь число.");
      number = resource.getELement();
      while (number == null) {
        System.out.println("Поток " + getName() + " ждет пока очередь заполнится.");
        resource.wait();
        System.out.println("Поток " + getName() + " возобновил работу.");
        number = resource.getELement();
      }
      System.out.println("Поток " + getName() + " извлек число " + number);
    }
  }

  private void setIntegersIntoResource() throws InterruptedException {
    int number = randNum.nextInt(500);
    synchronized (resource) {
      resource.setElement(number);
      System.out.println("Поток " + getName() + " записал число " + number);
      resource.notify();
      resource.wait(2);
    }
  }

}

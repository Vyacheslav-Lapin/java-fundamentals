package com.epam.courses.java.fundamentals.threads.practice.task3;

/**
 * Перепишите код приложения для темы Wait, notify так, чтобы ситуация,
 * когда все потоки хотят прочитать из очереди, не могла возникнуть
 */
public class UserResourceThread {
  public static void main(String[] args) throws InterruptedException {
    SharedResource res = new SharedResource();
    IntegerSetterGetter t1 = new IntegerSetterGetter("1", res);
    IntegerSetterGetter t2 = new IntegerSetterGetter("2", res);
    IntegerSetterGetter t3 = new IntegerSetterGetter("3", res);
    IntegerSetterGetter t4 = new IntegerSetterGetter("4", res);
    IntegerSetterGetter t5 = new IntegerSetterGetter("5", res);

    t1.start();
    t2.start();
    t3.start();
    t4.start();
    t5.start();

    Thread.sleep(100);

    t1.stopThread();
    t2.stopThread();
    t3.stopThread();
    t4.stopThread();
    t5.stopThread();

    t1.join();
    t2.join();
    t3.join();
    t4.join();
    t5.join();

    System.out.println("main");
  }
}

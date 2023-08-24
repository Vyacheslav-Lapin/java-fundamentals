package pro.vlapin.courses.java.fundamentals.oop.demo;

public class SinchronizedSingleton {

  private static SinchronizedSingleton instance;

  private SinchronizedSingleton() {
  }

  public static SinchronizedSingleton getInstance() {
    if (instance == null)
      synchronized (SinchronizedSingleton.class) {
        if (instance == null)
          instance = new SinchronizedSingleton();
      }
    return instance;
  }

}

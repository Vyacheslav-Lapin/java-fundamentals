package com.epam.courses.java.fundamentals.oop.practice.task7;


import com.epam.courses.java.fundamentals.oop.practice.task8.Boat;

@Boat(color = "black")
public class AtomicBoat {

  private Engine eng;

  public class Engine {
    public void launch() {
      System.out.println("Запуск двигателя");
    }
  }

  public AtomicBoat(){
    eng = new Engine();
    eng.launch();
  }

  public void swim(){
    System.out.println("Лодка плывет");
  }

}

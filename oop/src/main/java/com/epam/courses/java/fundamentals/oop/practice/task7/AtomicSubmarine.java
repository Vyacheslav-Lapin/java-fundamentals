package com.epam.courses.java.fundamentals.oop.practice.task7;

import com.epam.courses.java.fundamentals.oop.practice.task8.SuccessSwiming;

@SuccessSwiming
public class AtomicSubmarine {
  private String name;
  private int yearOfCreation;
  private Engine engine;

  public AtomicSubmarine(String name, int yearOfCreation){
    this.name = name;
    this.yearOfCreation = yearOfCreation;
    this.engine = new Engine();
  }

  public String getName() {
    return name;
  }

  public int getYearOfCreation() {
    return yearOfCreation;
  }

  public Engine getEngine() {
    return engine;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setYearOfCreation(int yearOfCreation) {
    this.yearOfCreation = yearOfCreation;
  }

  public void launchInSwiming(){
    this.engine.working = true;
    System.out.println("Engine is work!");
  }

  public static class Engine{
    boolean working;

    public Engine(){
      this.working = false;
    }

  }

}

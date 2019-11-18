package com.epam.courses.java.fundamentals.oop.practice.submarine;

public class NuclearSubmarine {
  private Engine engine;
  public NuclearSubmarine(){
    this.engine = new Engine();
  }
  public void embarkShip(){
    engine.start();
  }
  private void printMessage(String message){
    System.out.print(message);
  }
  private class Engine{
    public void start(){
      printMessage("The submarine is floating");
    }
  }
}

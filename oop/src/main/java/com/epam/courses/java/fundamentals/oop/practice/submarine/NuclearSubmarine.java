package com.epam.courses.java.fundamentals.oop.practice.submarine;

@Size(length = 100, width =50 )
class NuclearSubmarine {
  private Engine engine;

  NuclearSubmarine(){
    this.engine = new Engine();
  }

  void embarkShip(){
    engine.start();
  }
  private void printMessage(String message){
    System.out.print(message);
  }
  private class Engine{
    void start(){
      printMessage("The submarine is floating");
    }
  }
}

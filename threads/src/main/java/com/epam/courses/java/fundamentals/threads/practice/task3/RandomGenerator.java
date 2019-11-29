package com.epam.courses.java.fundamentals.threads.practice.task3;

import lombok.NoArgsConstructor;
import lombok.experimental.NonFinal;

import java.util.Random;

@NoArgsConstructor
public class RandomGenerator {
  private Random random = new Random();
  @NonFinal
  int counter = 0;

  public boolean getBool() {
    boolean res = false;
    int action = random.nextInt(1000);
    if (action % 2 == 0) {
      if (counter>2){
        counter = 0;
      }else {
        res = true;
        counter++;
      }
    }
    return res;
  }
}

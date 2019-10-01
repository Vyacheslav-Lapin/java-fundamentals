package com.epam.courses.java.fundamentals.intro.practice.task4;

/**
 * MaxFinder.
 */
public class MaxFinder {

  private double[] as;

  public MaxFinder(double... as) {
    this.as = as;
  }

  public double getMaximum() {
	  double max=0.0; 
	  for(int i =0; i<as.length -2; i++) {
		  double curr = as[i]+as[i+1];
		  if(curr>max) max= curr;
	  }
    
    return max;
  }
}

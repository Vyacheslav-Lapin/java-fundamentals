package com.epam.courses.java.fundamentals.oop.demo.overloading;

import java.util.Date;

public class DatePrinter {

  public int printDate(String s) {
		System.out.println("String s=" + s);
		return 1;
	}
	public void printDate(int day, int month, int year) {
		System.out.println("int day=" + day);
	}
	public static void printDate(Date d) {
		System.out.println("Date d=" + d);
	}
}

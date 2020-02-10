package com.epam.courses.java.fundamentals.web;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello")
public class HelloController extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest request,
                        HttpServletResponse response) {
    System.out.println("Hello, World!");
  }

  @Override
  protected void doGet(HttpServletRequest request,
                       HttpServletResponse response) {
    doPost(request, response);
  }
}

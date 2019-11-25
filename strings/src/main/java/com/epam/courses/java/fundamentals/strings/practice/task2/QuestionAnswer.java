package com.epam.courses.java.fundamentals.strings.practice.task2;

import java.io.File;
import java.net.*;
import java.util.Locale;

import java.util.ResourceBundle;


public class QuestionAnswer {
    private Locale locale;
    private ResourceBundle bundle;

    public QuestionAnswer(Locale locale){
      this.locale = locale;
      File file = new File("strings/src/main/resources");

      URL[] urls = new URL[0];
      try {
        urls = new URL[]{
            file.toURI().toURL()
        };
      } catch (MalformedURLException e) {
        e.printStackTrace();
      }


      ClassLoader loader = new URLClassLoader(urls);
        bundle = ResourceBundle.getBundle("prop", this.locale, loader);
    }

    public String getAnswer(String key){
        return bundle.getString(key);
    }

    public String getQuestions(){
        return bundle.getString("0");
    }
}


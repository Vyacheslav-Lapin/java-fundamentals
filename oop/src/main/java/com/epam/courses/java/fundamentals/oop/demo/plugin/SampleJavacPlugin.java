package com.epam.courses.java.fundamentals.oop.demo.plugin;

import com.sun.source.util.JavacTask;
//import javax.naming.Context;

public class SampleJavacPlugin implements com.sun.source.util.Plugin {

  @Override
  public String getName() {
    return "MyPlugin";
  }

  @Override
  public void init(JavacTask task, String... args) {
//    task.

    System.out.println("Hello from " + getName());

//    Context context = ((com.sun.tools.javac.api.BasicJavacTask) task).getContext();
//    Context context = task.getContext();
//    Log.instance(context)
//        .printRawLines(Log.WriterKind.NOTICE, "Hello from " + getName());
  }
}

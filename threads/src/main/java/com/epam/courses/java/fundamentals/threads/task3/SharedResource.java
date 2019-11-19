package com.epam.courses.java.fundamentals.threads.task3;

import java.util.ArrayList;
import java.util.List;

class SharedResource {

  private List<Integer> list;

  SharedResource() {
    list = new ArrayList<Integer>();
  }

  void setElement(Integer element) {
    list.add(element);
  }

  Integer getELement() {
    if (list.size() > 0) {
      return list.remove(0);
    }
    return null;
  }
}

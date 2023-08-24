package pro.vlapin.courses.java.fundamentals.oop.demo.generics;

import lombok.experimental.NonFinal;

class Glove {
//class Glove<T> {
  @NonFinal private Object taken;
//  @NonFinal private T taken;
  public void take(Object o) { taken = o; }
//  public void take(T o) { taken = o; }

  public Object get() { return taken; }
//  public T get() { return taken; }
}

//public class Message < T1, T2 >{
//	T1 id;
//	T2 name;
//}

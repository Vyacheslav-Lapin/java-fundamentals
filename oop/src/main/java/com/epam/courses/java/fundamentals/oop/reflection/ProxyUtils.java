package com.epam.courses.java.fundamentals.oop.reflection;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
//import org.openqa.selenium.By;
//import wd.locator.XPath;

public class ProxyUtils {

  public static <T> T toProxy(T self, InvocationHandler invocationHandler) {
    //noinspection unchecked
    return (T) Proxy.newProxyInstance(
        ProxyUtils.class.getClassLoader(),
        self.getClass().getInterfaces(),
        (proxy, method, args) -> {
          if (method.getDeclaringClass() == Object.class)
            return switch (method.getName()) {
              case "equals" -> args[0] != null && args[0].equals(self);
              case "hashCode" -> System.identityHashCode(self);
              case "toString" -> String.format("%s@%x", self.getClass().getName(), System.identityHashCode(self));
              default -> throw new IllegalStateException(String.valueOf(method));
            };
          return invocationHandler.invoke(proxy, method, args);
        });
  }

  public static <T> T toProxy(Class<T> anInterface, InvocationHandler invocationHandler) {
    //noinspection unchecked
    return (T) Proxy.newProxyInstance(
        ProxyUtils.class.getClassLoader(),
        new Class<?>[] {anInterface},
        (proxy, method, args) -> {
          if (method.getDeclaringClass() == Object.class)
            switch (method.getName()) {
            case "equals":
              return args[0] == proxy;
            case "hashCode":
              return System.identityHashCode(proxy);
            case "toString":
              return String.format("%s@%x", proxy.getClass().getName(), System.identityHashCode(proxy));
            default:
              throw new IllegalStateException(String.valueOf(method));
            }
          return invocationHandler.invoke(proxy, method, args);
        });
  }

//  public static <T> T generateByXPath(Class<T> anInterface) {
//    return ProxyUtils.toProxy(anInterface, (proxy, method, args) -> {
//      String xpath = method.getAnnotation(XPath.class).value();
//      Parameter[] parameters = method.getParameters();
//      for (int i = 0; i < parameters.length; i++)
//        xpath = xpath.replaceAll(String.format("\\$\\{%s}", parameters[i].getName()), args[i].toString());
//      return method.getReturnType().getConstructor(By.class).newInstance(By.xpath(xpath));
//    });
//  }
}

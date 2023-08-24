package pro.vlapin.courses.java.fundamentals.oop.reflection;

//@UtilityClass
public class ListPrototypeProxy {

//  @SuppressWarnings("java:S1905")
//  public <T> T proxy(List<T> list,
//                     int index,
//                     Function<T, ?> prototypeMarkerFieldExtractor) {
//
//    val that = list.get(index);
//    val markerFieldValue = prototypeMarkerFieldExtractor.apply(that);
//
//    val prototype = (index != 0
//                         && prototypeMarkerFieldExtractor.apply(list.get(index - 1))
//                                .equals(markerFieldValue)) ?
//                        getProto(list, index, prototypeMarkerFieldExtractor, markerFieldValue)
//                        : null;
//
//    val methodInterceptor = (MethodInterceptor) (obj, method, args, proxy) -> {
//      if (method.getName().equals("isPrototype")) return prototype != null;
//      if (method.getName().equals("getRealObject")) return that;
//      val result = method.invoke(obj, args);
//      return result == null && method.getName().startsWith("get") ?
//                 method.invoke(prototype, args)
//                 : result;
//    };
//
//    noinspection unchecked
//    return (T) Enhancer.create(that.getClass(),
//        new Class<?>[]{Proxy.class, MaybeProto.class},
//        methodInterceptor);
//  }
//
//  private <T> T getProto(List<T> list,
//                         int index,
//                         Function<T, ?> prototypeMarkerFieldExtractor,
//                         Object markerFieldValue) {
//    val li = list.listIterator(index - 1);
//    while (li.hasPrevious())
//      if (!prototypeMarkerFieldExtractor.apply(li.previous()).equals(markerFieldValue)
//              || li.previousIndex() == -1)
//        return li.next();
//    return null;
//  }
//
//  public <T> Stream<T> proxy(Stream<T> stream,
//                             Function<T, ?> prototypeMarkerFieldExtractor) {
//    val list = stream.toList();
//    if (list.isEmpty())
//      return Stream.empty();
//
//    val listIterator = list.listIterator();
//    return Stream.iterate(list.get(0),
//        __ -> listIterator.hasNext(),
//        __ -> proxy(list, listIterator.nextIndex(), prototypeMarkerFieldExtractor));
//  }
//}
//
//@FunctionalInterface
//interface Proxy<T> {
//  T getRealObject();
//}
//
//interface MaybeProto {
//  boolean isPrototype();
}

package pro.vlapin.courses.java.fundamentals.oop.demo.processor;

import static javax.lang.model.SourceVersion.*;

import java.util.Set;
import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import org.jetbrains.annotations.NotNull;

/**
 * javac -d target/classes -cp src/main/java src/main/java/common/oop/annotations/processor/AnnotationProcessor.java
 * javac -d target/classes -cp target/classes -processor common.oop.annotations.processor.AnnotationProcessor common/oop/annotations/processor/DataClass.java
 */
@SuppressWarnings("unused")
@SupportedSourceVersion(RELEASE_14)
@SupportedAnnotationTypes("common.oop.annotations.processor.ClassAnnotation")
public class AnnotationProcessor extends AbstractProcessor {

  @Override
  @SuppressWarnings("java:S106")
  public boolean process(@NotNull Set<? extends TypeElement> annotations,
                         RoundEnvironment roundEnv) {

    System.out.println(roundEnv);
    System.out.println("Annotations size: " + annotations.size());

    Set<? extends Element> elements = roundEnv.getElementsAnnotatedWith(ClassAnnotation.class);

    System.out.printf("Total elements annotated with %s: %d%n",
        ClassAnnotation.class.getCanonicalName(),
        elements.size());

    for (var element : elements)
      System.out.println(element.getSimpleName());

    return false;
  }
}

package me.day08.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface AnnotationName {
    // ElementType.TYPE - 클래스 / 인터페이스 / 열거타입
    // ElementType.FIELD - 필드
    // ElementType.METHOD - 메소드
    String elementName1();
    int elementName2() default 5;
}

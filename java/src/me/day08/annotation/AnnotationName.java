package me.day08.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface AnnotationName {
    // 엘리먼트 타입으로 기본 데이터 타입이나 객체, 열거 타입이 올 수 있음
    String elementName1();
    int elementName2() default 5;
}

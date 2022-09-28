package me.day08.annotation;

public class Service {
    @PrintAnnotation
    public void method1() {
        System.out.println("method1");
    }

    @PrintAnnotation("*")
    public void method2() {
        System.out.println("method2");
    }

    @PrintAnnotation(value = "#", number = 2)
    public void method3() {
        System.out.println("method3");
    }
}

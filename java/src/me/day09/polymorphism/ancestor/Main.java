package me.day09.polymorphism.ancestor;

public class Main {
    public static void main(String[] args) {
        A a1 = new B();
        A a2 = new C();
        A a3 = new D();
        A a4 = new E();

        B b1 = new D();
        C c1 = new E();

//        B b2 = new E(); // 불가
//        C c2 = new D(); // 불가
    }
}

package me.day07.constructor;

class A {}
class B {}

public class ConstructorNotGoodCode {
    private A a;
    private B b;

    public ConstructorNotGoodCode() {
        a = new A();
        b = new B();
    }
}

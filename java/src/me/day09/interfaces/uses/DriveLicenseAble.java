package me.day09.interfaces.uses;

public interface DriveLicenseAble {
    int a = 0; // static final

    void renew(); // 무조건 구현 클래스에서 재정의 해야함
    default void renew1() { // 재정의를 해도 되고 안해도 되는 함수
        System.out.println("Renew Your License....");
    }
    static void staticMethod() {
        System.out.println("Static Method");
    }

}

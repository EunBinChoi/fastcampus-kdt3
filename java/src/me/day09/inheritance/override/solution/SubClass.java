package me.day09.inheritance.override.solution;

public class SubClass extends SuperClass {
    @Override
    public String getClassName() { // 부모 클래스의 함수 재정의
        return SubClass.class.getName();
    }
}

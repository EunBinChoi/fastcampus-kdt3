package me.day09.inheritance.override.solution;

public class Main {
    public static void main(String[] args) {
        SuperClass superClass = new SuperClass();
        System.out.println(superClass.getClassName()); // me.day09.inheritance.override.solution.SuperClass

        SubClass subClass = new SubClass();
        System.out.println(subClass.getClassName()); // me.day09.inheritance.override.solution.SubClass
    }
}

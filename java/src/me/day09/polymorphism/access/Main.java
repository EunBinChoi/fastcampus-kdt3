package me.day09.polymorphism.access;

public class Main {
    public static void main(String[] args) {
        SuperClass superClass = new SubClass();
        System.out.println(superClass.getSuperInt());
        System.out.println(superClass.getSuperStr());
        System.out.println(((SubClass)superClass).getSubInt());
        System.out.println(((SubClass)superClass).getSubStr());
    }
}


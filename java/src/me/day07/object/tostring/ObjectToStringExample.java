package me.day07.object.tostring;

public class ObjectToStringExample {
    public static void main(String[] args) {
        Student student = new Student();
        System.out.println(student); // Student 클래스의 toString을 정의하지 않으면 객체의 고유 ID값 반환
    }
}

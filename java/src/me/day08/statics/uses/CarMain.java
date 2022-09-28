package me.day08.statics.uses;

public class CarMain {
    public static void main(String[] args) {
        System.out.println(Car.getBrandName()); // 객체 생성 전에도 호출 가능


        Car car = new Car();
        System.out.println(car);
        System.out.println(Car.getBrandName());

    }
}

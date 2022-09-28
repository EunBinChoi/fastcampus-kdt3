package me.day08.statics.block;

public class Car {
    private int speed;
    private static final String BRNAD = "APPLE";

    public void run() {
        System.out.println(String.format("속도 %d로 달립니다....", speed));
    }

    public static void main(String[] args) {
        Car car = new Car();
        car.speed = 60;
        car.run();

        System.out.println(Car.BRNAD);
        System.out.println(car.BRNAD); // 오류는 안나지만 권장하지 않음
    }
}

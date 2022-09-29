package me.day09.inheritance.use.example;


public class Main {
    public static void main(String[] args) {
        final int NUM_CAR = 10;
        Car[] cars = new Car[NUM_CAR];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car();
        }
        for (int i = 0; i < cars.length; i++) {
            System.out.println(cars[i]);
        }
        System.out.println();

        SportCar[] sportCars = new SportCar[NUM_CAR];
        for (int i = 0; i < sportCars.length; i++) {
            sportCars[i] = new SportCar();
        }
        for (int i = 0; i < cars.length; i++) {
            System.out.println(sportCars[i]);
        }
    }
}

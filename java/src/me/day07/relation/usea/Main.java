package me.day07.relation.usea;

public class Main {
    public static void main(String[] args) {
        Car car = new Car("0001", "KONA", "HYUNDAI", 60);
        SportCar sportCar = new SportCar("0002", "911 TURBO S", "PORSCHE", 150, 930);

        Person person = new Person();
        person.drive(car);
        person.drive(sportCar);
    }
}

package me.day07.relation.isa;

public class Main {
    public static void main(String[] args) {
        Car car = new Car();
//        car.ID;
//        car.modelName;
//        car.company;
//        car.speed;
//        car.getID();
//        car.getModelName();
//        car.getCompany();
//        car.getSpeed();

        SportCar sportCar = new SportCar();
        // 부모한테 상속받은 필드와 메소드 사용가능
//        sportCar.ID;
//        sportCar.modelName;
//        sportCar.company;
//        sportCar.speed;
//        sportCar.getID();
//        sportCar.getModelName();
//        sportCar.getCompany();
//        sportCar.getSpeed();

        // 자식 본인의 필드와 메소드도 사용가능
//        sportCar.turbo;
//        sportCar.getTurbo();
    }
}

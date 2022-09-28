package me.day07.practice.practice01;

public class SportCar extends Car {

    int turbo;

    public SportCar() {}

    public SportCar(int turbo) {
        this.turbo = turbo;
    }

    public SportCar(String ID, String modelName, String company, int speed, int turbo) {
        super(ID, modelName, company, speed);
        this.turbo = turbo;
    }

    public int getTurbo() {
        return turbo;
    }

    public void setTurbo(int turbo) {
        this.turbo = turbo;
    }

    @Override
    public String toString() {
        return "SportCar{" + super.toString() + ", " + // 부모 객체 호출
                "turbo=" + turbo +
                '}';
    }
}
package me.day09.inheritance.use.example;

public class Car {
    protected String ID; // auto-generated
    protected String modelName;
    protected int speed;
    protected static final String COMPANY = "TESLA";
    protected static int numOfCar = 0;

    public Car() {
        numOfCar++;
        ID = String.format("%04d", numOfCar);
    }

    public Car(String modelName, int speed) {
        numOfCar++;
        this.ID = String.format("%04d", numOfCar);
        this.modelName = modelName;
        this.speed = speed;
    }

    public String getID() {
        return ID;
    }

    public String getModelName() {
        return modelName;
    }

    public int getSpeed() {
        return speed;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public static int getNumOfCar() {
        return numOfCar;
    }

    public static void setNumOfCar(int numOfCar) {
        Car.numOfCar = numOfCar;
    }

    @Override
    public String toString() {
        return "Car{" +
                "ID='" + ID + '\'' +
                ", modelName='" + modelName + '\'' +
                ", speed=" + speed +
                '}';
    }
}

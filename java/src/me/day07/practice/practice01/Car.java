package me.day07.practice.practice01;

public class Car {
    String ID;
    String modelName;
    String company;
    int speed;

    public Car() {}

    public Car(String ID, String modelName, String company, int speed) {
        this.ID = ID;
        this.modelName = modelName;
        this.company = company;
        this.speed = speed;
    }

    public String getID() {
        return ID;
    }

    public String getModelName() {
        return modelName;
    }

    public String getCompany() {
        return company;
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

    public void setCompany(String company) {
        this.company = company;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @Override
    public String toString() {
        return "Car{" +
                "ID='" + ID + '\'' +
                ", modelName='" + modelName + '\'' +
                ", company='" + company + '\'' +
                ", speed=" + speed +
                '}';
    }
}

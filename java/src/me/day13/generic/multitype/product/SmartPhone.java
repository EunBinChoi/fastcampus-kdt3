package me.day13.generic.multitype.product;

import java.util.Objects;

public class SmartPhone extends Product {
    protected int numOfCameras;
    protected int numOfSensors;

    public SmartPhone() {
    }
    public SmartPhone(String modelName, String companyName, int numOfCameras, int numOfSensors) {
        super(modelName, companyName);
        this.numOfCameras = numOfCameras;
        this.numOfSensors = numOfSensors;
    }

    public int getNumOfCameras() {
        return numOfCameras;
    }

    public void setNumOfCameras(int numOfCameras) {
        this.numOfCameras = numOfCameras;
    }

    public int getNumOfSensors() {
        return numOfSensors;
    }

    public void setNumOfSensors(int numOfSensors) {
        this.numOfSensors = numOfSensors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SmartPhone that = (SmartPhone) o;
        return numOfCameras == that.numOfCameras && numOfSensors == that.numOfSensors;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), numOfCameras, numOfSensors);
    }

    @Override
    public String toString() {
        return "SmartPhone{" +
                "numOfCameras=" + numOfCameras +
                ", numOfSensors=" + numOfSensors +
                ", modelName='" + modelName + '\'' +
                ", companyName='" + companyName + '\'' +
                '}';
    }
}

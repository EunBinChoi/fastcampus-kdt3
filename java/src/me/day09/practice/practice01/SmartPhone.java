package me.day09.practice.practice01;

import java.util.Objects;

public class SmartPhone extends MobileElectronic {
    protected Integer numOfCameras;
    protected Integer numOfSensors;


    public SmartPhone() {
    }

    public SmartPhone(Integer numOfCameras, Integer numOfSensors) {
        this.numOfCameras = numOfCameras;
        this.numOfSensors = numOfSensors;
    }

    public SmartPhone(CommuncationMethod communcationMethod, Integer weight, Integer numOfCameras, Integer numOfSensors) {
        super(communcationMethod, weight);
        this.numOfCameras = numOfCameras;
        this.numOfSensors = numOfSensors;
    }

    public Integer getNumOfCameras() {
        return numOfCameras;
    }

    public void setNumOfCameras(Integer numOfCameras) {
        this.numOfCameras = numOfCameras;
    }

    public Integer getNumOfSensors() {
        return numOfSensors;
    }

    public void setNumOfSensors(Integer numOfSensors) {
        this.numOfSensors = numOfSensors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SmartPhone that = (SmartPhone) o;
        return numOfCameras.equals(that.numOfCameras) && numOfSensors.equals(that.numOfSensors);
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
                ", communcationMethod=" + communcationMethod +
                ", weight=" + weight +
                ", productNo='" + productNo + '\'' +
                ", modelName='" + modelName + '\'' +
                ", companyName=" + companyName +
                ", dateOfMade=" + dateOfMade +
                ", authMethod=" + authMethod +
                '}';
    }
}

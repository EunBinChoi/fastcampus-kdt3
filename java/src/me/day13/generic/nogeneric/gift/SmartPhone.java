package me.day13.generic.nogeneric.gift;

import java.util.Objects;

public class SmartPhone {
    protected String productNo;
    protected String companyName;
    protected String modelName;
    protected int numOfCameras;
    protected int numOfSensors;

    public SmartPhone() {
    }

    public SmartPhone(String productNo, String companyName, String modelName, int numOfCameras, int numOfSensors) {
        this.productNo = productNo;
        this.companyName = companyName;
        this.modelName = modelName;
        this.numOfCameras = numOfCameras;
        this.numOfSensors = numOfSensors;
    }

    public String getProductNo() {
        return productNo;
    }

    public void setProductNo(String productNo) {
        this.productNo = productNo;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
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
        SmartPhone that = (SmartPhone) o;
        return numOfCameras == that.numOfCameras && numOfSensors == that.numOfSensors && productNo.equals(that.productNo) && companyName.equals(that.companyName) && modelName.equals(that.modelName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productNo, companyName, modelName, numOfCameras, numOfSensors);
    }

    @Override
    public String toString() {
        return "SmartPhone{" +
                "productNo='" + productNo + '\'' +
                ", companyName='" + companyName + '\'' +
                ", modelName='" + modelName + '\'' +
                ", numOfCameras=" + numOfCameras +
                ", numOfSensors=" + numOfSensors +
                '}';
    }
}

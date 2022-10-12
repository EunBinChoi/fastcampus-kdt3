package me.day14.collection.use.gift;

import java.util.Objects;

public class SmartPhone extends Item {
    protected String modelName;
    private int numOfCameras;
    private int numOfSensors;

    public SmartPhone() {
    }

    public SmartPhone(String productNo) {
        this.productNo = productNo;
    }

    public SmartPhone(String productNo, String companyName) {
        this.productNo = productNo;
        this.companyName = companyName;
    }

    public SmartPhone(String productNo, String companyName, int numOfCameras, int numOfSensors) {
        this.productNo = productNo;
        this.companyName = companyName;
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
        return numOfCameras == that.numOfCameras && numOfSensors == that.numOfSensors && productNo.equals(that.productNo) && companyName.equals(that.companyName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productNo, companyName, numOfCameras, numOfSensors);
    }

    @Override
    public String toString() {
        return "SmartPhone{" +
                "productNo='" + productNo + '\'' +
                ", companyName='" + companyName + '\'' +
                ", numOfCameras=" + numOfCameras +
                ", numOfSensors=" + numOfSensors +
                '}';
    }
}

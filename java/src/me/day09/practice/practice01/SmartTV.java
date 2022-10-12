package me.day09.practice.practice01;

import java.util.Date;
import java.util.Objects;

public class SmartTV extends NonMobileElectronic {
    protected Integer inch;

    public SmartTV() {
    }

    public SmartTV(Integer inch) {
        this.inch = inch;
    }

    public SmartTV(String address, Integer inch) {
        super(address);
        this.inch = inch;
    }

    public SmartTV(String modelName, Company companyName, Date dateOfMade, AuthMethod[] authMethod, String address, Integer inch) {
        super(modelName, companyName, dateOfMade, authMethod, address);
        this.inch = inch;
    }

    public Integer getInch() {
        return inch;
    }

    public void setInch(Integer inch) {
        this.inch = inch;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SmartTV smartTV = (SmartTV) o;
        return inch.equals(smartTV.inch);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), inch);
    }

    @Override
    public String toString() {
        return "SmartTV{" +
                "inch=" + inch +
                ", address='" + address + '\'' +
                ", productNo='" + productNo + '\'' +
                ", modelName='" + modelName + '\'' +
                ", companyName=" + companyName +
                ", dateOfMade=" + dateOfMade +
                ", authMethod=" + authMethod +
                '}';
    }
}

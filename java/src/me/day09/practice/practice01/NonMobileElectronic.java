package me.day09.practice.practice01;

import java.util.Date;
import java.util.Objects;

public class NonMobileElectronic extends Electronic {
    protected String address;

    public NonMobileElectronic() {
    }

    public NonMobileElectronic(String address) {
        this.address = address;
    }

    public NonMobileElectronic(String modelName, Company companyName, Date dateOfMade, AuthMethod[] authMethod, String address) {
        super(modelName, companyName, dateOfMade, authMethod);
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        NonMobileElectronic that = (NonMobileElectronic) o;
        return address.equals(that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), address);
    }

    @Override
    public String toString() {
        return "NonMobileElectronic{" +
                "address='" + address + '\'' +
                ", productNo='" + productNo + '\'' +
                ", modelName='" + modelName + '\'' +
                ", companyName=" + companyName +
                ", dateOfMade=" + dateOfMade +
                ", authMethod=" + authMethod +
                '}';
    }
}

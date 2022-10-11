package me.day13.generic.nogeneric.gift;

import java.util.Objects;

public class Tablet {
    protected String productNo;
    protected String companyName;
    protected String modelName;
    protected boolean hasPencil;

    public Tablet() {
    }

    public Tablet(String productNo, String companyName, String modelName, boolean hasPencil) {
        this.productNo = productNo;
        this.companyName = companyName;
        this.modelName = modelName;
        this.hasPencil = hasPencil;
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

    public boolean isHasPencil() {
        return hasPencil;
    }

    public void setHasPencil(boolean hasPencil) {
        this.hasPencil = hasPencil;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tablet tablet = (Tablet) o;
        return hasPencil == tablet.hasPencil && productNo.equals(tablet.productNo) && companyName.equals(tablet.companyName) && modelName.equals(tablet.modelName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productNo, companyName, modelName, hasPencil);
    }

    @Override
    public String toString() {
        return "Tablet{" +
                "productNo='" + productNo + '\'' +
                ", companyName='" + companyName + '\'' +
                ", modelName='" + modelName + '\'' +
                ", hasPencil=" + hasPencil +
                '}';
    }
}

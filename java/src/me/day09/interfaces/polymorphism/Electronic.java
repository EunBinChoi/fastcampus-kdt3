package me.day09.interfaces.polymorphism;

import java.util.Objects;

public class Electronic {
    protected String productNo;
    protected String modelName;
    protected String companyName;

    public Electronic() {
    }

    public Electronic(String productNo, String modelName, String companyName) {
        this.productNo = productNo;
        this.modelName = modelName;
        this.companyName = companyName;
    }

    public String getProductNo() {
        return productNo;
    }

    public void setProductNo(String productNo) {
        this.productNo = productNo;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Electronic that = (Electronic) o;
        return Objects.equals(productNo, that.productNo) && Objects.equals(modelName, that.modelName) && Objects.equals(companyName, that.companyName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productNo, modelName, companyName);
    }

    @Override
    public String toString() {
        return "Electronic{" +
                "productNo='" + productNo + '\'' +
                ", modelName='" + modelName + '\'' +
                ", companyName='" + companyName + '\'' +
                '}';
    }
}

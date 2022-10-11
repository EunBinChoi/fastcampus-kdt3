package me.day13.generic.multitype.product;

import java.util.Objects;

public class Product {

    protected String modelName;
    protected String companyName;

    public Product() {
    }

    public Product(String modelName, String companyName) {
        this.modelName = modelName;
        this.companyName = companyName;
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
        Product product = (Product) o;
        return modelName.equals(product.modelName) && companyName.equals(product.companyName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(modelName, companyName);
    }

    @Override
    public String toString() {
        return "Product{" +
                "modelName='" + modelName + '\'' +
                ", companyName='" + companyName + '\'' +
                '}';
    }
}

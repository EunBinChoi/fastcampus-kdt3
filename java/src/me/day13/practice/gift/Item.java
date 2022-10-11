package me.day13.practice.gift;

import java.util.Objects;

public abstract class Item {

    protected String productNo;
    protected String companyName;
    public Item() {
    }

    public Item(String productNo, String companyName) {
        this.productNo = productNo;
        this.companyName = companyName;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return productNo.equals(item.productNo) && companyName.equals(item.companyName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productNo, companyName);
    }

    @Override
    public String toString() {
        return "Item{" +
                "productNo='" + productNo + '\'' +
                ", companyName='" + companyName + '\'' +
                '}';
    }
}

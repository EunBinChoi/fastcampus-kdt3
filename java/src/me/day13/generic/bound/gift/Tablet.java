package me.day13.generic.bound.gift;

import java.util.Objects;

public class Tablet extends Item {
    protected String modelName;
    private boolean hasPencil;

    public Tablet() {
    }

    public Tablet(String productNo, String companyName, String modelName, boolean hasPencil) {
        super(productNo, companyName);
        this.modelName = modelName;
        this.hasPencil = hasPencil;
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
        if (!super.equals(o)) return false;
        Tablet tablet = (Tablet) o;
        return hasPencil == tablet.hasPencil && modelName.equals(tablet.modelName);
    }


    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), modelName, hasPencil);


    }

    @Override
    public String toString() {
        return "Tablet{" +
                "modelName='" + modelName + '\'' +
                ", hasPencil=" + hasPencil +
                ", productNo='" + productNo + '\'' +
                ", companyName='" + companyName + '\'' +
                '}';
    }

}

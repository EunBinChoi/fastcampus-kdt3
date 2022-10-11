package me.day13.generic.multitype.product;


import java.util.Objects;

public class Tablet extends Product {
    protected boolean hasPencil;

    public Tablet() {
    }

    public Tablet(String modelName, String companyName, boolean hasPencil) {
        super(modelName, companyName);
        this.hasPencil = hasPencil;
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
        return hasPencil == tablet.hasPencil;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), hasPencil);
    }

    @Override
    public String toString() {
        return "Tablet{" +
                "hasPencil=" + hasPencil +
                ", modelName='" + modelName + '\'' +
                ", companyName='" + companyName + '\'' +
                '}';
    }
}

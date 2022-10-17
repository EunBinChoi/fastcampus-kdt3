package me.day09.practice.practice01;

import java.util.Objects;

public class Tablet extends MobileElectronic {
    protected Boolean hasPencil;

    public Tablet() {
    }

    public Tablet(Boolean hasPencil) {
        this.hasPencil = hasPencil;
    }

    public Tablet(MobileElectronic.CommuncationMethod communcationMethod, Integer weight, Boolean hasPencil) {
        super(communcationMethod, weight);
        this.hasPencil = hasPencil;
    }

    public Boolean getHasPencil() {
        return hasPencil;
    }

    public void setHasPencil(Boolean hasPencil) {
        this.hasPencil = hasPencil;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Tablet tablet = (Tablet) o;
        return hasPencil.equals(tablet.hasPencil);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), hasPencil);
    }

    @Override
    public String toString() {
        return "Tablet{" +
                "hasPencil=" + hasPencil +
                ", communcationMethod=" + communcationMethod +
                ", weight=" + weight +
                ", productNo='" + productNo + '\'' +
                ", modelName='" + modelName + '\'' +
                ", companyName=" + companyName +
                ", dateOfMade=" + dateOfMade +
                ", authMethod=" + authMethod +
                '}';
    }
}

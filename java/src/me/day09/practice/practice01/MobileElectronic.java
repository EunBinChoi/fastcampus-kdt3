package me.day09.practice.practice01;

import java.util.Objects;

public class MobileElectronic extends Electronic {
    public enum CommuncationMethod { FIVE_G, FOUR_G, THREE_G }

    protected CommuncationMethod communcationMethod;
    protected Integer weight;

    public MobileElectronic() {
    }

    public MobileElectronic(CommuncationMethod communcationMethod, Integer weight) {
        this.communcationMethod = communcationMethod;
        this.weight = weight;
    }

    public CommuncationMethod getCommuncationMethod() {
        return communcationMethod;
    }

    public void setCommuncationMethod(CommuncationMethod communcationMethod) {
        this.communcationMethod = communcationMethod;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MobileElectronic that = (MobileElectronic) o;
        return communcationMethod == that.communcationMethod && weight.equals(that.weight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(communcationMethod, weight);
    }

    @Override
    public String toString() {
        return "MobileElectronic{" +
                "communcationMethod=" + communcationMethod +
                ", weight=" + weight +
                '}';
    }
}

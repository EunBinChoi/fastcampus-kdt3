package me.day07.oop;

import java.util.Objects;

public class Parameter {
    private int minimumPay;
    private int minimumTime;

    public Parameter() {}

    public Parameter(int minimumPay, int minimumTime) {
        this.minimumPay = minimumPay;
        this.minimumTime = minimumTime;
    }

    public int getMinimumPay() {
        return minimumPay;
    }

    public void setMinimumPay(int minimumPay) {
        this.minimumPay = minimumPay;
    }

    public int getMinimumTime() {
        return minimumTime;
    }

    public void setMinimumTime(int minimumTime) {
        this.minimumTime = minimumTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Parameter parameter = (Parameter) o;
        return minimumPay == parameter.minimumPay && minimumTime == parameter.minimumTime;
    }

    @Override
    public int hashCode() {
        return Objects.hash(minimumPay, minimumTime);
    }

    @Override
    public String toString() {
        return "Parameter{" +
                "minimumPay=" + minimumPay +
                ", minimumTime=" + minimumTime +
                '}';
    }
}

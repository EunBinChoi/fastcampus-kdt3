package me.smartstore.project.groups;

import java.util.Objects;

public class Parameter {
    private int minimumSpentTime;
    private int minimumTotalPay;

    public Parameter() {
    }

    public Parameter(int minimumSpentTime, int minimumTotalPay) {
        this.minimumSpentTime = minimumSpentTime;
        this.minimumTotalPay = minimumTotalPay;
    }

    public int getMinimumSpentTime() {
        return this.minimumSpentTime;
    }

    public void setMinimumSpentTime(int minimumSpentTime) {
        this.minimumSpentTime = minimumSpentTime;
    }

    public int getMinimumTotalPay() {
        return this.minimumTotalPay;
    }

    public void setMinimumTotalPay(int minimumTotalPay) {
        this.minimumTotalPay = minimumTotalPay;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o != null && this.getClass() == o.getClass()) {
            Parameter parameter = (Parameter)o;
            return this.minimumSpentTime == parameter.minimumSpentTime && this.minimumTotalPay == parameter.minimumTotalPay;
        } else {
            return false;
        }
    }

    public int hashCode() {
        return Objects.hash(this.minimumSpentTime, this.minimumTotalPay);
    }

    public String toString() {
        return "Parameter{minimumSpentTime=" + this.minimumSpentTime + ", minimumTotalPay=" + this.minimumTotalPay + "}";
    }
}

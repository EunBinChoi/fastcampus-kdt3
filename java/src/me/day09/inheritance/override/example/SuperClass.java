package me.day09.inheritance.override.example;

import java.util.Objects;

public class SuperClass {
    protected int intVar;
    protected String strVar;

    public SuperClass() {}

    public SuperClass(int intVar, String strVar) {
        this.intVar = intVar;
        this.strVar = strVar;
    }

    public int getIntVar() {
        return intVar;
    }

    public void setIntVar(int intVar) {
        this.intVar = intVar;
    }

    public String getStrVar() {
        return strVar;
    }

    public void setStrVar(String strVar) {
        this.strVar = strVar;
    }

    public String getClassName() {
        return SuperClass.class.getName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SuperClass that = (SuperClass) o;
        return intVar == that.intVar && strVar.equals(that.strVar);
    }

    @Override
    public int hashCode() {
        return Objects.hash(intVar, strVar);
    }

    @Override
    public String toString() {
        return "SuperClass{" +
                "intVar=" + intVar +
                ", strVar='" + strVar + '\'' +
                '}';
    }
}

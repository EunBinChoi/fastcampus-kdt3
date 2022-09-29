package me.day09.polymorphism.access;

import java.util.Objects;

public class SuperClass {
    protected int superInt;
    protected String superStr;

    public SuperClass() {
    }

    public SuperClass(int superInt, String superStr) {
        this.superInt = superInt;
        this.superStr = superStr;
    }

    public int getSuperInt() {
        return superInt;
    }

    public void setSuperInt(int superInt) {
        this.superInt = superInt;
    }

    public String getSuperStr() {
        return superStr;
    }

    public void setSuperStr(String superStr) {
        this.superStr = superStr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SuperClass that = (SuperClass) o;
        return superInt == that.superInt && Objects.equals(superStr, that.superStr);
    }

    @Override
    public int hashCode() {
        return Objects.hash(superInt, superStr);
    }

    @Override
    public String toString() {
        return "SuperClass{" +
                "superInt=" + superInt +
                ", superStr='" + superStr + '\'' +
                '}';
    }
}

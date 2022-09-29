package me.day09.polymorphism.access;

import java.util.Objects;

public class SubClass extends SuperClass {
    private int subInt;
    private String subStr;

    public SubClass() {
    }

    public SubClass(int superInt, String superStr, int subInt, String subStr) {
        super(superInt, superStr);
        this.subInt = subInt;
        this.subStr = subStr;
    }

    public int getSubInt() {
        return subInt;
    }

    public void setSubInt(int subInt) {
        this.subInt = subInt;
    }

    public String getSubStr() {
        return subStr;
    }

    public void setSubStr(String subStr) {
        this.subStr = subStr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SubClass subClass = (SubClass) o;
        return subInt == subClass.subInt && Objects.equals(subStr, subClass.subStr);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), subInt, subStr);
    }

    @Override
    public String toString() {
        return "SubClass{" +
                "subInt=" + subInt +
                ", subStr='" + subStr + '\'' +
                ", superInt=" + superInt +
                ", superStr='" + superStr + '\'' +
                '}';
    }
}

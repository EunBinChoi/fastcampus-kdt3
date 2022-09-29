package me.day09.inheritance.finals;

public final class SuperClass {
    protected int intVar;
    protected String stringVar;

    public SuperClass() {
    }

    public SuperClass(int intVar, String stringVar) {
        this.intVar = intVar;
        this.stringVar = stringVar;
    }

    public int getIntVar() {
        return intVar;
    }

    public void setIntVar(int intVar) {
        this.intVar = intVar;
    }

    public String getStringVar() {
        return stringVar;
    }

    public void setStringVar(String stringVar) {
        this.stringVar = stringVar;
    }

    @Override
    public String toString() {
        return "SuperClass{" +
                "intVar=" + intVar +
                ", stringVar='" + stringVar + '\'' +
                '}';
    }
}
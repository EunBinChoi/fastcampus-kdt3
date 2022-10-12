package me.day09.practice.practice02;

import me.day09.practice.practice01.Electronic;

import java.util.Arrays;

public class Electronics {
    protected Electronic[] electronics;
    private static final int DEFAULT_SIZE = 10;

    public Electronics() {
        electronics = new Electronic[DEFAULT_SIZE];
    }

    public Electronics(int size) {
        electronics = new Electronic[size];
    }

    public Electronics(Electronic[] electronics) {
        this.electronics = electronics;
    }

    public Electronic get(int i) {
        return electronics[i];
    }

    public Electronic find(String key) {
        for (int i = 0; i < electronics.length; i++) {
            if (electronics[i] != null) {
                if (electronics[i].getProductNo() != null) {
                    if (electronics[i].getProductNo().equals(key)) {
                        return electronics[i];
                    }
                }
            }
        }
        return null;
    }

    public Electronic[] getElectronics() {
        return electronics;
    }

    public void setElectronics(Electronic[] electronics) {
        this.electronics = electronics;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Electronics that = (Electronics) o;
        return Arrays.equals(electronics, that.electronics);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(electronics);
    }

    @Override
    public String toString() {
        return "Electronics{" +
                "electronics=" + Arrays.toString(electronics) +
                '}';
    }
}

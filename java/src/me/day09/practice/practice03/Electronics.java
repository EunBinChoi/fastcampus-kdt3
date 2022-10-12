package me.day09.practice.practice03;

import me.day09.practice.practice01.Electronic;

import java.util.Arrays;

public class Electronics {
    protected Electronic[] electronics;
    protected static final int DEFAULT_SIZE = 10;
    protected int count = 0; // 각 인스턴스마다 count 변수 새로 필요함.

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

    public void add(Electronic electronic) {
        electronics[count] = electronic;
        count++;
    }

    public ClassifiedElectronics[] groupByCompanyName() {
        ClassifiedElectronics[] groups
                = { new ClassifiedElectronics(Electronic.Company.SAMSUNG),
                new ClassifiedElectronics(Electronic.Company.LG),
                new ClassifiedElectronics(Electronic.Company.APPLE) }; // { SAMSUNG, LG, APPLE }

        for (int i = 0; i < Electronic.Company.values().length; i++) {
            for (int j = 0; j < electronics.length; j++) {
                if (electronics[j] != null) {
                    if (electronics[j].getCompanyName() != null) {
                        if (electronics[j].getCompanyName().equals(Electronic.Company.values()[i])) {
                            if (groups[i] != null) {
                                groups[i].add(electronics[j]);
                            }
                        }
                    }
                }
            }
        }
        return groups;
    }

    public Electronic[] getElectronics() {
        return electronics;
    }

    public void setElectronics(Electronic[] electronics) {
        this.electronics = electronics;
    }

    public int getCount() {
        return count;
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
                ", count=" + count +
                '}';
    }
}

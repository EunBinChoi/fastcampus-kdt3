package me.day09.practice.practice03;

import me.day09.practice.practice01.Electronic;

import java.util.Arrays;

public class ClassifiedElectronics extends Electronics {
    protected Electronic.Company company;

    public ClassifiedElectronics() {
        super();
    }

    public ClassifiedElectronics(Electronic.Company company) {
        super();
        this.company = company;
    }


    public ClassifiedElectronics(int size, Electronic.Company company) {
        super(size);
        this.company = company;
    }

    public ClassifiedElectronics(Electronic[] electronics, Electronic.Company company) {
        super(electronics);
        this.company = company;
    }

    public Electronic.Company getCompany() {
        return company;
    }

    public void setCompany(Electronic.Company company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "ClassifiedElectronics{" +
                "company=" + company +
                ", electronics=" + Arrays.toString(Arrays.copyOf(electronics, count)) +
                '}';
    }
}

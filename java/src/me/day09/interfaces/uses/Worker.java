package me.day09.interfaces.uses;

public class Worker implements DriveLicenseAble {
    @Override
    public void renew() {
        System.out.println("Renew Driver License");
    }

    @Override
    public void renew1() {
        System.out.println("Renew Worker License ... ");
    }
}

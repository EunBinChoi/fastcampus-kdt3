package me.day09.interfaces.uses;

public class Worker implements DriveLicenseAble {
    @Override
    public void renew() {
        System.out.println("Renew Driver License");
    }
}

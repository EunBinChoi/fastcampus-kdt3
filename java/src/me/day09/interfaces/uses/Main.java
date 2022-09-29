package me.day09.interfaces.uses;

public class Main {
    public static void main(String[] args) {
        DriveLicenseAble driveLicenseAble = new DriveLicenseAble() {
            @Override
            public void renew() {
                System.out.println("Renew Driver License");
            }
        };
    }
}

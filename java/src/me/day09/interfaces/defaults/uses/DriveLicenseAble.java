package me.day09.interfaces.defaults.uses;

public interface DriveLicenseAble {
    public default void renew() {
        System.out.println("Renew Drive License");
    }
}

package me.day09.interfaces.defaults.problem;

public interface Driveable {
    default void on() {
        System.out.println("POWER ON");
    }
    default void off() {
        System.out.println("POWER OFF");
    }
}

package me.day09.interfaces.defaults.problem;

public class Car implements Driveable, Sleepable {

    @Override
    public void on() {
        Driveable.super.on();
    }

    @Override
    public void off() {
        Driveable.super.off();
    }
}

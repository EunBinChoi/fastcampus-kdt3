package me.day09.interfaces.polymorphism;

public interface RemoteControllable {
    static final int MAX_VOLUME = 10;
    int MIN_VOLUME = 0; // static final 생략 가능

    abstract void on();
    void off(); // abstract 생략 가능
    void setVolume(int volume); // abstract 생략 가능
    void toggleMute();
    void changeBattery();
    default void alarmLowBattery() {
        System.out.println("Very Low Battery.. Please Replace Battery");
    }
}

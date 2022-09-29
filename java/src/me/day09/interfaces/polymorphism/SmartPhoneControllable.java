package me.day09.interfaces.polymorphism;

public interface SmartPhoneControllable extends RemoteControllable {
    static final int MAX_VOLUME = 100;
    int MIN_VOLUME = 0; // static final 생략 가능

    void listenVoice();
}

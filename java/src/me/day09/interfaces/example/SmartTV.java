package me.day09.interfaces.example;

public class SmartTV implements SmartPhoneControllable {
    private int volume;
    private boolean isMute;

    @Override
    public void on() {
        System.out.println(GeneralRefrig.class.getName() + " on");
    }

    @Override
    public void off() {
        System.out.println(GeneralRefrig.class.getName() + " off");
    }

    @Override
    public void setVolume(int volume) {
        this.volume = volume;
    }

    @Override
    public void toggleMute() {
        isMute = !isMute;
    }

    @Override
    public void changeBattery() {
        System.out.println(GeneralRefrig.class.getName() + " change battery...");
    }

    @Override
    public void listenVoice() {
        System.out.println(GeneralRefrig.class.getName() + " listening your voice...");
    }
}

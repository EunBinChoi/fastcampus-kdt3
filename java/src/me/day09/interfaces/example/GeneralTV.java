package me.day09.interfaces.example;

public class GeneralTV implements RemoteControllable {
    private int volume;
    private boolean isMute;

    @Override
    public void on() {
        System.out.println(GeneralTV.class.getName() + " on");
    }

    @Override
    public void off() {
        System.out.println(GeneralTV.class.getName() + " off");
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
        System.out.println(GeneralTV.class.getName() + " change battery...");
    }
}

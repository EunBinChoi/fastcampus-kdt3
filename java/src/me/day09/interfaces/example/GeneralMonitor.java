package me.day09.interfaces.example;

public class GeneralMonitor implements RemoteControllable {
    private int volume;
    private boolean isMute;

    @Override
    public void on() {
        System.out.println(GeneralMonitor.class.getName() + " on");
    }

    @Override
    public void off() {
        System.out.println(GeneralMonitor.class.getName() + " off");
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
        System.out.println(GeneralMonitor.class.getName() + " change battery...");
    }
}

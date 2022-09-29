package me.day09.interfaces.polymorphism;

public class Main {
    public static void main(String[] args) {
        RemoteControllable remoteControllable1 = new GeneralMonitor();
        RemoteControllable remoteControllable2 = new GeneralRefrig();
        RemoteControllable remoteControllable3 = new GeneralTV();
    }
}

package me.day09.interfaces.polymorphism;

public class Main {
    public static void main(String[] args) {
        RemoteControllable remoteControllable1 = new GeneralMonitor();
        RemoteControllable remoteControllable2 = new GeneralRefrig();
        RemoteControllable remoteControllable3 = new GeneralTV();
        remoteControllable3.on();
        remoteControllable3.setVolume(100);
        remoteControllable3.toggleMute();
        remoteControllable3.off();
        System.out.println();

        SmartPhoneControllable smartPhoneControllable1 = new SmartRefrig();
        SmartPhoneControllable smartPhoneControllable2 = new SmartTV();
        smartPhoneControllable2.on();
        smartPhoneControllable2.setVolume(100);
        smartPhoneControllable2.toggleMute();
        smartPhoneControllable2.listenVoice();
        smartPhoneControllable2.off();
        System.out.println();

        ////////////////////////////////////////////////////////////
        // 객체 배열
        RemoteControllable[] remoteControllables = { new GeneralMonitor(), new GeneralRefrig(), new GeneralTV() };
        for (int i = 0; i < remoteControllables.length; i++) {
            remoteControllables[i].off();
            remoteControllables[i].setVolume(10);
            remoteControllables[i].toggleMute();
            remoteControllables[i].off();
            System.out.println();
        }


        SmartPhoneControllable[] smartPhoneControllables = { new SmartRefrig(), new SmartTV() };
        for (int i = 0; i < smartPhoneControllables.length; i++) {
            smartPhoneControllables[i].off();
            smartPhoneControllables[i].setVolume(10);
            smartPhoneControllables[i].toggleMute();
            smartPhoneControllables[i].listenVoice();
            smartPhoneControllables[i].off();
            System.out.println();
        }


    }
}

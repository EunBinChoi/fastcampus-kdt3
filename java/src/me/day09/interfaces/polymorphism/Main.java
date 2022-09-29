package me.day09.interfaces.polymorphism;

public class Main {
    public static void main(String[] args) {
        RemoteControllable remoteControllable1 = new GeneralMonitor();
        RemoteControllable remoteControllable2 = new GeneralRefrig();
        RemoteControllable remoteControllable3 = new GeneralTV();
        ((GeneralTV)remoteControllable3).setProductNo("0001");
        ((GeneralTV)remoteControllable3).setModelName("OLED");
        ((GeneralTV)remoteControllable3).setCompanyName("LG");
        ((GeneralTV)remoteControllable3).setVolume(5);
        System.out.println(remoteControllable3);
        System.out.println();

        remoteControllable3.on();
        remoteControllable3.setVolume(100);
        remoteControllable3.toggleMute();
        remoteControllable3.off();
        System.out.println(remoteControllable3);
        System.out.println();

        SmartPhoneControllable smartPhoneControllable1 = new SmartRefrig();
        SmartPhoneControllable smartPhoneControllable2 = new SmartTV();
        ((SmartTV)smartPhoneControllable2).setProductNo("0002");
        ((SmartTV)smartPhoneControllable2).setModelName("OLED-SMART");
        ((SmartTV)smartPhoneControllable2).setCompanyName("LG");
        ((SmartTV)smartPhoneControllable2).setVolume(10);
        System.out.println(smartPhoneControllable2);
        System.out.println();

        smartPhoneControllable2.on();
        smartPhoneControllable2.setVolume(100);
        smartPhoneControllable2.toggleMute();
        smartPhoneControllable2.listenVoice();
        smartPhoneControllable2.off();
        System.out.println(smartPhoneControllable2);
        System.out.println();

        ////////////////////////////////////////////////////////////////////////////////
        // 객체 배열
        RemoteControllable[] remoteControllables = { new GeneralMonitor(), new GeneralRefrig(), new GeneralTV() };
        for (int i = 0; i < remoteControllables.length; i++) {
            remoteControllables[i].on();
            remoteControllables[i].setVolume(10);
            remoteControllables[i].toggleMute();
            remoteControllables[i].off();
            System.out.println();
        }


        SmartPhoneControllable[] smartPhoneControllables = { new SmartRefrig(), new SmartTV() };
        for (int i = 0; i < smartPhoneControllables.length; i++) {
            smartPhoneControllables[i].on();
            smartPhoneControllables[i].setVolume(10);
            smartPhoneControllables[i].toggleMute();
            smartPhoneControllables[i].listenVoice();
            smartPhoneControllables[i].off();
            System.out.println();
        }
    }
}

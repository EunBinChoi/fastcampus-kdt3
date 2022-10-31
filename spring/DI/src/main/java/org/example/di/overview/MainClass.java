package org.example.di.overview;

import org.example.di.overview.battery.AnotherBattery;
import org.example.di.overview.battery.Battery;
import org.example.di.overview.battery.OneBattery;
import org.example.di.overview.battery.OtherBattery;
import org.example.di.overview.toy.CBToy;
import org.example.di.overview.toy.NBToy;

// 스프링 컨테이너
public class MainClass {
    public static void main(String[] args) {
        CBToy cbToy = new CBToy();
        System.out.println("cbToy = " + cbToy);
        cbToy.getBattery().charge();
        System.out.println("cbToy = " + cbToy);
        System.out.println();


        NBToy nbToy = new NBToy();
        Battery battery = new OneBattery();
        nbToy.setBattery(battery);
        System.out.println("nbToy = " + nbToy);

        battery = new AnotherBattery();
        nbToy.setBattery(battery);
        System.out.println("nbToy = " + nbToy);

        battery = new OtherBattery();
        nbToy.setBattery(battery);
        System.out.println("nbToy = " + nbToy);

    }
}

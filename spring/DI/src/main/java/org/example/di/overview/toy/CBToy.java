package org.example.di.overview.toy;

import org.example.di.overview.battery.ChargeBattery;

public class CBToy {
    private ChargeBattery battery;

    public CBToy() {
        battery = new ChargeBattery();
    }


    public ChargeBattery getBattery() {
        return battery;
    }


    @Override
    public String toString() {
        return "CBToy{" +
                "battery=" + battery +
                '}';
    }
}

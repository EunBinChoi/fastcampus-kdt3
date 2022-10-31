package org.example.di.overview.toy;

import org.example.di.overview.battery.Battery;

public class NBToy {
    private Battery battery;

    public NBToy() {}
    public NBToy(Battery battery) {
        this.battery = battery;
    }

    public void setBattery(Battery battery) {
        this.battery = battery;
    }

    public Battery getBattery() {
        return battery;
    }

    @Override
    public String toString() {
        return "CBToy{" +
                "battery=" + battery +
                '}';
    }
}

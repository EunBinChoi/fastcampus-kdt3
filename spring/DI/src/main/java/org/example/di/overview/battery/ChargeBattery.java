package org.example.di.overview.battery;

public class ChargeBattery {
    private int remain;

    public ChargeBattery() {
    }

    public ChargeBattery(int remain) {
        this.remain = remain;
    }

    public void charge() {
        System.out.println("charging ... ");
        remain = 100;
    }

    @Override
    public String toString() {
        return "ChargeBattery{" +
                "remain=" + remain +
                '}';
    }
}

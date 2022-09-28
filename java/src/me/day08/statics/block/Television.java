package me.day08.statics.block;

public class Television {
    private static final String BRAND;
    private static final String MODEL;
    private static final String INFO;
    private static int numOfTelevision = 0;

    static {
        BRAND = "SUMSUNG";
        MODEL = "QLED";
        INFO = BRAND + "-" + MODEL;
    }

    public Television() {
        numOfTelevision++;
    }

    public static String getBrand() {
        return Television.BRAND;
    }

    public static String getModel() {
        return Television.MODEL;
    }

    public static String getInfo() {
        return Television.INFO;
    }

    public static int getNumOfTelevision() {
        return numOfTelevision;
    }

    public static void setNumOfTelevision(int numOfTelevision) {
        Television.numOfTelevision = numOfTelevision;
    }

    @Override
    public String toString() {
        return "Television{}";
    }
}

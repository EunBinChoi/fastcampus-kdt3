package me.day08.statics.uses;

import java.util.Arrays;
import java.util.Objects;

public class Car { // 테슬라 자동차만 만드는 공장
    private String ID;
    private String modelName;
    private String color;
    private String[] options;

    private static final String BRAND = "TESLA"; // 정적 필드

    public Car() {}

    public Car(String ID, String modelName, String color, String[] options) {
        this.ID = ID;
        this.modelName = modelName;
        this.color = color;
        this.options = options;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String[] getOptions() {
        return options;
    }

    public void setOptions(String[] options) {
        this.options = options;
    }


    public static String getBrandName() {  // 정적 메소드
        return Car.BRAND;
    }

    @Override
    public String toString() {
        return "Car{" +
                "ID='" + ID + '\'' +
                ", modelName='" + modelName + '\'' +
                ", color='" + color + '\'' +
                ", options=" + Arrays.toString(options) +
                '}';
    }
}

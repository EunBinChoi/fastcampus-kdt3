package me.day09.interfaces.uses;

public class Main {
    public static void main(String[] args) {
        DriveLicenseAble driveLicenseAble = new UnivStudent();
        DriveLicenseAble driveLicenseAble1 = new Worker();
        driveLicenseAble.renew1();
        driveLicenseAble1.renew1();
        DriveLicenseAble.staticMethod();
        UnivStudent.staticMethod();

//        DriveLicenseAble driveLicenseAble2 = new DriveLicenseAble();
    }
    public static void a(DriveLicenseAble driveLicenseAble) {
        // DriveLicenseAble driveLicenseAble = new UnivStudent();
        // DriveLicenseAble driveLicenseAble = new Worker();
    }
}

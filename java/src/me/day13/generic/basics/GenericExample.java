package me.day13.generic.basics;


import me.day13.generic.basics.gift.Note;
import me.day13.generic.basics.gift.Pen;
import me.day13.generic.basics.gift.SmartPhone;
import me.day13.generic.basics.gift.Tablet;

public class GenericExample {
    public static void main(String[] args) {
        GiftBox<Note> noteBox = new GiftBox<>();
        noteBox.setGift(new Note("1001", "모닝글로리", true));
        System.out.println("noteBox = " + noteBox);

        // 형 변환 후 사용해야 함
        noteBox.getGift().setHasLine(false); // 형변환 불필요.
//        ((Pen)noteBox.getGift()).setInkColor("빨강"); // 컴파일러 오류.
        System.out.println("noteBox = " + noteBox);
        System.out.println();

        GiftBox<Pen> penBox = new GiftBox<>();
        penBox.setGift(new Pen("2001", "모닝글로리", "검정"));
        System.out.println("penBox = " + penBox);

        penBox.getGift().setInkColor("파랑"); // 형변환 불필요.
        System.out.println("penBox = " + penBox);
        System.out.println();

        GiftBox<Tablet> tableBox = new GiftBox<>();
        tableBox.setGift(new Tablet("3001", "APPLE", "IPAD-AIR3", true));
        System.out.println("tableBox = " + tableBox);

        tableBox.getGift().setHasPencil(false);
        System.out.println("tableBox = " + tableBox);
        System.out.println();


        GiftBox<SmartPhone> smartPhoneBox = new GiftBox<>();
        smartPhoneBox.setGift(new SmartPhone("4001", "SAMSUNG", "Z-FOLD4", 3, 20));
        System.out.println("smartPhoneBox = " + smartPhoneBox);

        smartPhoneBox.getGift().setNumOfCameras(5);
        smartPhoneBox.getGift().setNumOfSensors(30);
        System.out.println("smartPhoneBox = " + smartPhoneBox);
        System.out.println();
    }
}

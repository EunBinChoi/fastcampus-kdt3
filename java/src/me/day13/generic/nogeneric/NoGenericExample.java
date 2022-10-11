package me.day13.generic.nogeneric;

import me.day13.generic.nogeneric.gift.Note;
import me.day13.generic.nogeneric.gift.Pen;
import me.day13.generic.nogeneric.gift.SmartPhone;
import me.day13.generic.nogeneric.gift.Tablet;

public class NoGenericExample {
    public static void main(String[] args) {
        GiftBox noteBox = new GiftBox();
        noteBox.setGift(new Note("1001", "모닝글로리", true));
        System.out.println("noteBox = " + noteBox);

//        noteBox.getGift().setHasLine(false); // 불가 (Object 객체 내에 setHasLine() 함수 없음)

        // 형 변환 후 사용해야 함
        ((Note)noteBox.getGift()).setHasLine(false);
        // ClassCastException 실행 오류
        // 컴파일러가 오류를 잡지 못함
        // Object -> Pen 으로 형변환 가능하기 때문에
        System.out.println("noteBox = " + noteBox);
        System.out.println();

        GiftBox penBox = new GiftBox();
        penBox.setGift(new Pen("2001", "모닝글로리", "검정"));
        System.out.println("penBox = " + penBox);

//        penBox.getGift().setInkColor("파랑"); // 불가 (Object 객체 내에 setInkColor() 함수 없음)

        ((Pen)penBox.getGift()).setInkColor("파랑");
        System.out.println("penBox = " + penBox);
        System.out.println();


        GiftBox tableBox = new GiftBox();
        tableBox.setGift(new Tablet("3001", "APPLE", "IPAD-PRO5", true));
        System.out.println("tableBox = " + tableBox);

//        tableBox.getGift().setHasPencil(false); // 불가 (Object 객체 내에 setHasPencil() 함수 없음)
        ((Tablet) tableBox.getGift()).setHasPencil(false);
        System.out.println("tableBox = " + tableBox);
        System.out.println();


        GiftBox smartPhoneBox = new GiftBox();
        smartPhoneBox.setGift(new SmartPhone("4001", "SAMSUNG", "Z-FOLD4", 3, 20));
        System.out.println("smartPhoneBox = " + smartPhoneBox);

//        smartPhoneBox.getGift().setNumOfCameras(5); // 불가 (Object 객체 내에 setNumOfCameras() 함수 없음)
//        smartPhoneBox.getGift().setNumOfSensors(30); // 불가 (Object 객체 내에 setNumOfSensors() 함수 없음)
        ((SmartPhone) smartPhoneBox.getGift()).setNumOfCameras(5);
        ((SmartPhone) smartPhoneBox.getGift()).setNumOfSensors(30);
        System.out.println("smartPhoneBox = " + smartPhoneBox);
        System.out.println();


    }
}

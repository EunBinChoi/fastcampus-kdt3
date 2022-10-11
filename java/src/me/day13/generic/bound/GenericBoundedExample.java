package me.day13.generic.bound;


import me.day13.generic.bound.gift.*;

public class GenericBoundedExample {
    public static void main(String[] args) {

        Gifts<Note> randomNotes = new Gifts<>();
        randomNotes.add(new Note("1001", "모닝글로리", true));
        randomNotes.add(new Note("2001", "바른손", false));
        randomNotes.add(new Note("3001", "바른손", true));
        randomNotes.add(new Note("4001", "모닝글로리", false));


        for (int i = 0; i < randomNotes.getCount(); i++) {
            randomNotes.get(i).setHasLine(true);
            System.out.println("randomNotes.getGifts().get(i) = " + randomNotes.get(i));
        }

        System.out.println();
        randomNotes.remove(new Note("1001", "모닝글로리", true));
        randomNotes.remove(new Note("2001", "바른손", true));
        randomNotes.remove(new Note("3001", "바른손", true));
        randomNotes.remove(new Note("4001", "모닝글로리", true));
        randomNotes.remove(new Note("4001", "모닝글로리", true));
        System.out.println();
        System.out.println();

        //////////////////////////////////////////////////////////////////////////////////////////


        Gifts<Pen> randomPens = new Gifts<>();
        randomPens.add(new Pen("1001", "모닝글로리", "빨강"));
        randomPens.add(new Pen("2001", "바른손", "검정"));
        randomPens.add(new Pen("3001", "바른손", "검정"));
        randomPens.add(new Pen("4001", "모닝글로리", "파랑"));


        for (int i = 0; i < randomPens.getCount(); i++) {
            randomPens.get(i).setInkColor("검정");
            System.out.println("randomPens.getGifts().get(i) = " + randomPens.get(i));
        }

        System.out.println();
        randomPens.remove(new Pen("1001", "모닝글로리", "검정"));
        randomPens.remove(new Pen("2001", "바른손", "검정"));
        randomPens.remove(new Pen("3001", "바른손", "검정"));
        randomPens.remove(new Pen("4001", "모닝글로리", "검정"));
        randomPens.remove(new Pen("4001", "모닝글로리", "검정"));
        System.out.println();
        System.out.println();

        //////////////////////////////////////////////////////////////////////////////////////////


        Gifts<Tablet> randomTables = new Gifts<>();
        randomTables.add(new Tablet("1001", "SAMSUNG", "GALAXY-TAB S8", true));
        randomTables.add(new Tablet("2001", "APPLE", "IPAD-AIR3", false));
        randomTables.add(new Tablet("3001", "APPLE", "IPAD-PRO3", false));
        randomTables.add(new Tablet("4001", "SAMSUNG", "GALAXY-TAB S8+", true));

        for (int i = 0; i < randomTables.getCount(); i++) {
            randomTables.get(i).setHasPencil(true);
            System.out.println("randomTables.getGifts().get(i) = " + randomTables.get(i));
        }

        System.out.println();
        randomTables.remove(new Tablet("1001", "SAMSUNG", "GALAXY-TAB S8", true));
        randomTables.remove(new Tablet("2001", "APPLE", "IPAD-AIR3", true));
        randomTables.remove(new Tablet("3001", "APPLE", "IPAD-PRO3", true));
        randomTables.remove(new Tablet("4001", "SAMSUNG", "GALAXY-TAB S8+", true));
        randomTables.remove(new Tablet("4001", "SAMSUNG", "GALAXY-TAB S8+", true));
        System.out.println();
        System.out.println();

        //////////////////////////////////////////////////////////////////////////////////////////


        Gifts<SmartPhone> randomSmartPhone = new Gifts<>();
        randomSmartPhone.add(new SmartPhone("1001", "SAMSUNG", 3, 20));
        randomSmartPhone.add(new SmartPhone("2001", "LG", 2, 10));
        randomSmartPhone.add(new SmartPhone("3001", "LG", 3, 10));
        randomSmartPhone.add(new SmartPhone("4001", "SAMSUNG", 2, 15));

        for (int i = 0; i < randomSmartPhone.getCount(); i++) {
            randomSmartPhone.get(i).setNumOfCameras(3);
            randomSmartPhone.get(i).setNumOfSensors(20);
            System.out.println("randomSmartPhone.getGifts().get(i) = " + randomSmartPhone.get(i));
        }

        System.out.println();
        randomSmartPhone.remove(new SmartPhone("1001", "SAMSUNG", 3, 20));
        randomSmartPhone.remove(new SmartPhone("2001", "LG", 3, 20));
        randomSmartPhone.remove(new SmartPhone("3001", "LG", 3, 20));
        randomSmartPhone.remove(new SmartPhone("4001", "SAMSUNG", 3, 20));
        randomSmartPhone.remove(new SmartPhone("4001", "SAMSUNG", 3, 20));
        System.out.println();
        System.out.println();


    }
}

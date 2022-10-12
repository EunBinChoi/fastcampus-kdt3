package me.day14.practice.practice01;

import java.util.Map;

public class SMSApplication {
    private static SMSApplication smsApp;
//    private Map<String, Student> studentDB = DataBase.getTableList().get(0);


    public static SMSApplication getInstance() {
        if (smsApp == null) {
            smsApp = new SMSApplication();
        }
        return smsApp;
    }

    public SMSApplication testMode() {
        String[] sNums = { "H39r8djakndfae32", "H39asdfaelu42o23", "H39iiemamca8w9h4", "H39lkmn754fghia7",
                "H39plo865cuy8k92", "H39mnbviiaed89q1", "H399omjjyv56t3d5", "H39lczaqwg644gj8", "H39ymbcsh74thgh2",
                "H39lesvj7544vf89" };

        String[] sIds = { "rabbit", "hippo", "raccoon", "elephant", "lion", "tiger", "pig", "horse", "bird", "deer" };

        String[] sPws = { "96539", "94875", "15284", "48765", "28661", "60915", "30028", "29801", "28645", "28465" };

        String[] sNames = { "agatha", "barbara", "chris", "doris", "elva", "fiona", "holly", "jasmin", "lena",
                "melissa" };

        int[] sAges = { 19, 22, 20, 27, 19, 21, 19, 25, 22, 24 };
        String[] sGenders = { "M", "W", "W", "M", "M", "M", "W", "M", "W", "W" };
        String[] sMajors = { "English Literature", "Korean Language and Literature", "French Language and Literature",
                "Philosophy", "History", "Law", "Statistics", "Computer", "Economics", "Public Administration" };

        for (int i = 0; i < sNums.length; i++) {
//            studentDB.put(sNums[i], new Student(sIds[i], sPws[i], sNames[i], sAges[i], sGenders[i], sMajors[i]));
        }
        return this;
    }

    public void run() {
//        System.out.println("studentDB = " + studentDB);


    }
}

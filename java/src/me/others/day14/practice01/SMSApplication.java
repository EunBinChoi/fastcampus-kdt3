package me.others.day14.practice01;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public class SMSApplication {
    private static SMSApplication smsApp;
    private DataBase dataBase = DataBase.getInstance();

    public static SMSApplication getInstance() {
        if (smsApp == null) {
            smsApp = new SMSApplication();
        }
        return smsApp;
    }

    public SMSApplication testMode() {
        final int NUM = 10;
        String[] sNums = {
                "H39r8djakndfae32", "H39asdfaelu42o23", "H39iiemamca8w9h4", "H39lkmn754fghia7", "H39plo865cuy8k92",
                "H39mnbviiaed89q1", "H399omjjyv56t3d5", "H39lczaqwg644gj8", "H39ymbcsh74thgh2", "H39lesvj7544vf89" };

        String[] sIds = { "rabbit", "hippo", "raccoon", "elephant", "lion", "tiger", "pig", "horse", "bird", "deer" };
        String[] sPws = { "96539", "94875", "15284", "48765", "28661", "60915", "30028", "29801", "28645", "28465" };
        String[] sNames = { "agatha", "barbara", "chris", "doris", "elva", "fiona", "holly", "jasmin", "lena", "melissa" };

        Integer[] sAges = { 19, 22, 20, 27, 19, 21, 19, 25, 22, 24 };
        String[] sGenders = { "M", "W", "W", "M", "M", "M", "W", "M", "W", "W" };
        String[] sMajors = { "English Literature", "Korean Language and Literature", "French Language and Literature",
                "Philosophy", "History", "Law", "Statistics", "Computer", "Economics", "Public Administration" };

        Table table = new Table();
        List<Column> columnList = table.getColumnList();
        columnList.addAll(List.of(
                new Column("sNums"),
                new Column("sIds"),
                new Column("sPws"),
                new Column("sNames"),
                new Column("sAges"),
                new Column("sGenders"),
                new Column("sMajors")
        ));

        Map<String, Student> data = table.getData();

        for (int i = 0; i < NUM; i++) {
            data.put(sNums[i], new Student(sIds[i], sPws[i], sNames[i], sAges[i], sGenders[i], sMajors[i]));
        }
        table.setData(data);

        dataBase.getTableList().add(table);

        return this;
    }

    public void run() {
        StudentDao studentDao = StudentDao.getInstance();

        Student s1 = studentDao.select("H39r8djakndfae32");
        System.out.println("s1 = " + s1 + "\n");

        Predicate<Student> predicate1 = (s) -> (s.getsAge() >= 25);
        Students s2 = studentDao.select(predicate1);
        System.out.println("s2 = " + s2 + "\n");

        Students s3 = studentDao.select();
        System.out.println("s3 = " + s3 + "\n");

        Student s4 = studentDao.insert("H39r8djakndfae99", new Student("monkey", "29899", "sally", 30, "W", "Java"));
        System.out.println("s4 = " + s4);
        System.out.println("studentDao = " + DataBase.getInstance().getTableList().get(0).getData());
        System.out.println();

        Students students = new Students();
        students.getStudents().addAll(List.of(
                new Student("monkey2", "29899", "sally", 30, "W", "JSP"),
                new Student("monkey3", "29899", "sally", 30, "W", "Servlet")));

        List<String> keys = List.of("H39r8djakndfae88", "H39r8djakndfae00");
        int count1 = studentDao.insert(keys, students);
        System.out.println("count1 = " + count1);
        System.out.println("studentDao = " + DataBase.getInstance().getTableList().get(0).getData());
        System.out.println();

        Predicate<Student> predicate2 = (s) -> (s.getsAge() >= 20);
        int count2 = studentDao.delete(predicate2);
        System.out.println("count2 = " + count2);
        System.out.println("studentDao = " + DataBase.getInstance().getTableList().get(0).getData());
        System.out.println();

        Student s5 = studentDao.delete("H39r8djakndfae32");
        System.out.println("s5 = " + s5);
        System.out.println("studentDao = " + DataBase.getInstance().getTableList().get(0).getData());
        System.out.println();

        Predicate<Student> predicate3 = (s) -> (s.getsAge() <= 20);
        int count3 = studentDao.update(predicate3, new Column("sMajor"), "Programming");
        System.out.println("count3 = " + count3);
        System.out.println("studentDao = " + DataBase.getInstance().getTableList().get(0).getData());
    }
}

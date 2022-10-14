package me.others.day14.practice01;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public class StudentDao {
    private static StudentDao studentDao;
    private Map<String, Student> map = DataBase.getInstance().getTableList().get(0).getData();

    public static StudentDao getInstance() {
        if (studentDao == null) {
            studentDao = new StudentDao();
        }
        return studentDao;
    }


    public Student select(String key) {
        Iterator<String> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            String num = iterator.next();
            Student student = map.get(num);

            if (num != null) {
                if (num.equals(key)) {
                    return student;
                }
            }
        }
        return null;
    }


    public Students select(Predicate<Student> condition) {
        Students students = new Students();
        Iterator<String> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            String num = iterator.next();
            Student student = map.get(num);

            if (condition != null) {
                if (condition.test(student)) {
                    students.getStudents().add(student);
                }
            }
        }

        return students;
    }


    public Students select() {
        Students studentAll = new Students();
        for (Student student : map.values()) {
            studentAll.getStudents().add(student);
        }
        return studentAll;
    }



    public Student insert(String key, Student student) {
        if (map.containsKey(key)) {
            System.out.println("duplicated key.");
            return null;
        }
        map.put(key, student);
        return student;
    }

    public int insert(List<String> keys, Students students) {
        int count = 0;

        for (int i = 0; i < keys.size(); i++) {
            String key = keys.get(i);
            Student student = students.getStudents().get(i);

            if (map.containsKey(key)) {
                System.out.println("duplicated key.");
                continue;
            }
            map.put(key, student);
            count++;
        }
        return count;
    }

    public int update(Predicate<Student> condition, Column column, Object value) {
        int count = 0;
        Iterator<String> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            String num = iterator.next();
            Student student = map.get(num);

            if (condition != null) {
                if (condition.test(student)) {
                    if (column != null && column.getColumnName() != null) {
                        if (column.getColumnName().equals("sId")) {
                            map.get(num).setsId((String) value);
                        } else if (column.getColumnName().equals("sPw")) {
                            map.get(num).setsPw((String) value);
                        } else if (column.getColumnName().equals("sName")) {
                            map.get(num).setsName((String) value);
                        } else if (column.getColumnName().equals("sAge")) {
                            map.get(num).setsAge((Integer) value);
                        } else if (column.getColumnName().equals("sGender")) {
                            map.get(num).setsGender((String) value);
                        } else if (column.getColumnName().equals("sMajor")) {
                            map.get(num).setsMajor((String) value);
                        } else {
                            continue;
                        }
                        count++;
                    }
                }
            }
        }

        return count;
    }

    public int delete() {
        return delete(s -> true);
    }

    public int delete(Predicate<Student> condition) {
        int count = 0;
        Iterator<String> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            String num = iterator.next();
            Student student = map.get(num);

            if (condition != null) {
                if (condition.test(student)) {
                    iterator.remove();
                    count++;
                }
            }
        }

        return count;
    }

    public Student delete(String key) {

        Iterator<String> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            String num = iterator.next();
            Student student = map.get(key);
            if (num != null) {
                if (num.equals(key)) {
                    iterator.remove();
                    return student;
                }
            }
        }
        return null;
    }

}
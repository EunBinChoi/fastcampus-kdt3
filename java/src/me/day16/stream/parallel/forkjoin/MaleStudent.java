package me.day16.stream.parallel.forkjoin;


import java.util.ArrayList;
import java.util.List;

public class MaleStudent {
    private List<Student> list; // 요소를 저장할 컬렉션

    public MaleStudent() {
        list = new ArrayList<>();
        System.out.printf("[ %s MaleStudent() ]\n", Thread.currentThread().getName()); // 스레드 이름
    }

    public void accumulate(Student student) { // 요소를 수집하는 메소드
        list.add(student);
        System.out.printf("[ %s accumulate() ]\n", Thread.currentThread().getName()); // 스레드 이름
    }

    public void combine(MaleStudent maleStudent) { // 두 MaleStudent를 결합하는 메소드 (병렬처리 시 사용)
        list.addAll(maleStudent.getList());
        System.out.printf("[ %s combine() ]\n", Thread.currentThread().getName()); // 스레드 이름
    }

    public List<Student> getList() {
        return list;
    }

    @Override
    public String toString() {
        return "MaleStudent{" +
                "list=" + list +
                '}';
    }
}

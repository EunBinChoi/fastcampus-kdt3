package me.day13.generic.wildcard.course.register;

import java.util.Objects;

public class Worker extends Person {
    private String workerNo;
    private String department;
    private String position;

    public Worker() {
    }

    public Worker(String workerNo, String department, String position) {
        this.workerNo = workerNo;
        this.department = department;
        this.position = position;
    }

    public Worker(String name, Gender gender, String regNum, String workerNo, String department, String position) {
        super(name, gender, regNum);
        this.workerNo = workerNo;
        this.department = department;
        this.position = position;
    }

    public String getWorkerNo() {
        return workerNo;
    }

    public void setWorkerNo(String workerNo) {
        this.workerNo = workerNo;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Worker worker = (Worker) o;
        return workerNo.equals(worker.workerNo) && department.equals(worker.department) && position.equals(worker.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), workerNo, department, position);
    }

    @Override
    public String toString() {
        return "Worker{" +
                "workerNo='" + workerNo + '\'' +
                ", department='" + department + '\'' +
                ", position='" + position + '\'' +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", regNum='" + regNum + '\'' +
                '}';
    }
}

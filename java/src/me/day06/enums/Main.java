package me.day06.enums;

public class Main {
    public static void main(String[] args) {
        // 열거형 사용
        System.out.println(Employee.COMPANY + "에는 다음과 같은 부서가 있습니다.");
        for (Department department: Department.values()) {
            System.out.printf("%s[%d], ", department.getDepartmentName(), department.ordinal());
        }
        System.out.println();
        System.out.println(Employee.COMPANY + "에는 다음과 같은 직책이 있습니다.");
        for (Position position: Position.values()) {
            System.out.printf("%s[%d], ", position.getPositionName(), position.ordinal());
        }
        System.out.println();
        System.out.println();

        // 열거형 + 클래스 사용
        Employee employee1 = new Employee();
        System.out.println(employee1);

        Employee employee2 = new Employee("Sally", Position.STAFF, Department.DEVELOP);
        System.out.println(employee2);

        Employee employee3 = new Employee("James", Position.DIRECTOR, Department.ADMIN);
        System.out.println(employee3);

        Employee employee4 = new Employee("Amy", Position.SENIOR, Department.LAW);
        System.out.println(employee4);
    }
}

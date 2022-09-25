package me.day06.enums;

public enum Department {
    ADMIN("경영관리부서"), DEVELOP("개발부서"), RESEARCH("연구부서"),
    LAW("법무부서"), MARKETING("홍보부서"), PRODUCTION("생산부서");
    private String departmentName = null;


    // 클래스처럼 사용가능
    Department(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentName() { return departmentName; }

    public void setDepartmentName(String departmentName) { this.departmentName = departmentName; }
}

package me.day07.object.tostring;

public enum Semester {
    EXCEED("초과학기"), EIGHTH("8학기"), SEVENTH("7학기"),
    SIXTH("6학기"), FIFTH("5학기"), FOURTH("4학기"),
    THIRD("3학기"), SECOND("2학기"), FIRST("1학기");
    private String semesterNames = null;

    Semester(String semesterNames) {
        this.semesterNames = semesterNames;
    }

    public String getSemesterNames() {
        return semesterNames;
    }

    public void setSemesterNames(String semesterNames) {
        this.semesterNames = semesterNames;
    }
}

package me.day07.oop;

public enum Grade {
    NORMAL("일반"), VIP("우수"), VVIP("최우수");
    private String gradeName = null;

    Grade(String gradeName) {
        this.gradeName = gradeName;
    }

    public String getGradeName() {
        return gradeName;
    }

    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
    }
}

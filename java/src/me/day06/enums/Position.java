package me.day06.enums;

public enum Position {
    PRESIDENT("사장"), DIRECTOR("이사"), MANAGER("과장"),
    SENIOR("주임"), STAFF("사원");
    private String positionName = null;

    // 클래스처럼 사용가능
    Position(String positionName) { this.positionName = positionName; }

    public String getPositionName() { return positionName; }

    public void setPositionName(String positionName) { this.positionName = positionName; }

}

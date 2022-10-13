package me.smartstore.project.groups;

public enum GroupType {
    NONE("해당없음"), GENERAL("일반고객"), VIP("우수고객"), VVIP("최우수고객");

    String groupType = "";

    GroupType(String groupType) {
        this.groupType = groupType;
    }

    public String getGroupType() {
        return this.groupType;
    }

    public void setGroupType(String groupType) {
        this.groupType = groupType;
    }
}

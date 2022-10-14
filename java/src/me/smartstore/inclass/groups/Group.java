package me.smartstore.inclass.groups;

import java.util.Objects;

public class Group {
    private GroupType groupType;
    private Parameter parameter;

    public Group() {
    }

    public Group(GroupType groupType, Parameter parameter) {
        this.groupType = groupType;
        this.parameter = parameter;
    }

    public GroupType getGroupType() {
        return groupType;
    }

    public void setGroupType(GroupType groupType) {
        this.groupType = groupType;
    }

    public Parameter getParameter() {
        return parameter;
    }

    public void setParameter(Parameter parameter) {
        this.parameter = parameter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return groupType == group.groupType && parameter.equals(group.parameter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(groupType, parameter);
    }

    @Override
    public String toString() {
        if (groupType == null) {
            return "No group.";
        } else if (parameter == null) {
            return "GroupType : " + groupType + "\n Parameter: null";
        } else {
            return "GroupType : " + groupType + "\n Parameter: " + parameter;
        }
    }
}


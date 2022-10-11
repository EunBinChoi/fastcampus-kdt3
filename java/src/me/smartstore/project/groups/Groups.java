package me.smartstore.project.groups;

import me.smartstore.project.customers.Customer;

public class Groups {
    private int count;
    private Group[] groups;

    public Groups() {
        this.groups = new Group[GroupType.values().length];
    }

    public Groups(int maxSize) {
        this.groups = new Group[maxSize];
    }

    public int getCount() {
        return this.count;
    }

    public int length() {
        return this.groups.length;
    }

    public boolean isNullOrEmpty() {
        return this.groups == null || this.count == 0;
    }

    public void initialize() {
        int i = 0;
        GroupType[] var2 = GroupType.values();
        int var3 = var2.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            GroupType groupType = var2[var4];
            this.groups[i] = new Group(groupType, (Parameter)null);
            ++i;
        }

    }

    public void add(Group group) {
        Group grp = this.find(group.getType());
        if (grp != null) {
            this.edit(group);
        } else {
            this.groups[this.count] = group;
            ++this.count;
        }

    }

    public Group get(int i) {
        return this.groups[i];
    }

    public void edit(Group group) {
        Group grp = this.find(group.getType());
        if (grp != null) {
            grp.setParam(group.getParam());
        }

    }

    public Group find(GroupType groupType) {
        Group[] var2 = this.groups;
        int var3 = var2.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            Group grp = var2[var4];
            if (grp.getType() == groupType) {
                return grp;
            }
        }

        return null;
    }

    public Group findGroupFor(Customer cust) {
        if (this.groups != null && cust != null) {
            for(int i = this.groups.length - 1; i >= 0; --i) {
                Parameter param = this.groups[i].getParam();
                if (param != null && cust.getSpentTime() >= param.getMinimumSpentTime() && cust.getTotalPay() >= param.getMinimumTotalPay()) {
                    return this.groups[i];
                }
            }

            return null;
        } else {
            return null;
        }
    }

    public String toString() {
        String str = "";

        for(int i = 0; i < this.count; ++i) {
            str = str + " " + this.groups[i].toString() + "\n";
        }

        return str;
    }
}

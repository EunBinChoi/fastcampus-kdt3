package me.smartstore.project.groups;

import me.smartstore.project.customers.Customers;

public class Group {
    private GroupType type;
    private Parameter param;

    public Group() {
        this(null, null);
    }

    public Group(GroupType type, Parameter param) {
        this.type = type;
        this.param = param;
    }

    public GroupType getType() {
        return this.type;
    }

    public void setType(GroupType type) {
        this.type = type;
    }

    public Parameter getParam() {
        return this.param;
    }

    public void setParam(Parameter param) {
        this.param = param;
    }

    public Customers getCustomers(Customers allCustomers) {
        return allCustomers.findCustomers(this);
    }

    public void update(GroupType type, Parameter param) {
        this.type = type;
        this.param = param;
    }

    public boolean equals(Object o) {
        return o != null && o instanceof Group && this.type.equals(((Group)o).type);
    }

    public String toString() {
        if (this.type == null) {
            return "No group.";
        } else if (this.param == null) {
            return "GroupType: " + this.type + "\nParameter: null";
        } else {
            GroupType var10000 = this.type;
            return "GroupType: " + var10000 + "\nParameter: " + this.param;
        }
    }
}

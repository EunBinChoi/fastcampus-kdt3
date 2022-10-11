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
		return type;
	}

	public void setType(GroupType type) {
		this.type = type;
	}

	public Parameter getParam() {
		return param;
	}

	public void setParam(Parameter param) {
		this.param = param;
	}
	
	public Customers getCustomers(Customers allCustomers) {
		return allCustomers.findCustomers(this);
	}
	
	public void edit(GroupType type, Parameter param) {
		this.type = type;
		this.param = param;
	}
	
	@Override
	public boolean equals(Object o) {
		if( o != null && o instanceof Group ) {
			if( type.equals(((Group)o).type))
				return true;
		}
		
		return false;
	}

	@Override
	public String toString() {
		if( type == null ) {
			return "No group.";
		} else if( param == null ) {
			return "GroupType: " + type + " is not set yet. Please set first.";
		} else {
			return "GroupType: " + type + "\nParameter: " + param.toString();
		}
	}
	
}


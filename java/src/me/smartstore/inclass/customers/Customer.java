package me.smartstore.inclass.customers;

import java.util.Objects;

public class Customer {
	protected String serialNO; /* auto-generated */
	protected String name;
	protected String userID;
	protected int spentTime;
	protected int totalPay;

	private static int AUTO_GENERATOR = 0;

	public Customer() {
		AUTO_GENERATOR++;
		serialNO = String.format("%04d", AUTO_GENERATOR);
	}

	public Customer(String name, String userID, int spentTime, int totalPay) {
		AUTO_GENERATOR++;
		serialNO = String.format("%04d", AUTO_GENERATOR);
		this.name = name;
		this.userID = userID;
		this.spentTime = spentTime;
		this.totalPay = totalPay;
	}

	public String getSerialNO() {
		return serialNO;
	}

	private void setSerialNO(String serialNO) {
		this.serialNO = serialNO;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public int getSpentTime() {
		return spentTime;
	}

	public void setSpentTime(int spentTime) {
		this.spentTime = spentTime;
	}

	public int getTotalPay() {
		return totalPay;
	}

	public void setTotalPay(int totalPay) {
		this.totalPay = totalPay;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Customer customer = (Customer) o;
		return spentTime == customer.spentTime && totalPay == customer.totalPay && serialNO.equals(customer.serialNO) && name.equals(customer.name) && userID.equals(customer.userID);
	}

	@Override
	public int hashCode() {
		return Objects.hash(serialNO, name, userID, spentTime, totalPay);
	}


}

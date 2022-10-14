package me.smartstore.inclass.groups;

import java.util.Objects;

public class Parameter {
	private int minimumSpentTime;
	private int minimumTotalPay;

	public Parameter() {
	}

	public Parameter(int minimumSpentTime, int minimumTotalPay) {
		this.minimumSpentTime = minimumSpentTime;
		this.minimumTotalPay = minimumTotalPay;
	}

	public int getMinimumSpentTime() {
		return minimumSpentTime;
	}

	public void setMinimumSpentTime(int minimumSpentTime) {
		this.minimumSpentTime = minimumSpentTime;
	}

	public int getMinimumTotalPay() {
		return minimumTotalPay;
	}

	public void setMinimumTotalPay(int minimumTotalPay) {
		this.minimumTotalPay = minimumTotalPay;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Parameter parameter = (Parameter) o;
		return minimumSpentTime == parameter.minimumSpentTime && minimumTotalPay == parameter.minimumTotalPay;
	}

	@Override
	public int hashCode() {
		return Objects.hash(minimumSpentTime, minimumTotalPay);
	}

	@Override
	public String toString() {
		return "Parameter{" +
				"minimumSpentTime=" + minimumSpentTime +
				", minimumTotalPay=" + minimumTotalPay +
				'}';
	}
}

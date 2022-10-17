package me.day09.practice.practice01;

import java.util.Objects;

public class User {
    private Member memberInfo;
    private Electronic electronicDevice;
    private String paymentPolicy;

    // User는 모든 필드를 가져야만 생성 가능

    public User(Member memberInfo, Electronic electronicDevice, String paymentPolicy) {
        this.memberInfo = memberInfo;
        this.electronicDevice = electronicDevice;
        this.paymentPolicy = paymentPolicy;
    }

    public Member getMemberInfo() {
        return memberInfo;
    }

    public void setMemberInfo(Member memberInfo) {
        this.memberInfo = memberInfo;
    }

    public Electronic getElectronicDevice() {
        return electronicDevice;
    }

    public void setElectronicDevice(Electronic electronicDevice) {
        this.electronicDevice = electronicDevice;
    }

    public String getPaymentPolicy() {
        return paymentPolicy;
    }

    public void setPaymentPolicy(String paymentPolicy) {
        this.paymentPolicy = paymentPolicy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return memberInfo.equals(user.memberInfo) && electronicDevice.equals(user.electronicDevice) && paymentPolicy.equals(user.paymentPolicy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberInfo, electronicDevice, paymentPolicy);
    }

    @Override
    public String toString() {
        return "User{" +
                "memberInfo=" + memberInfo +
                ", electronicDevice=" + electronicDevice +
                ", paymentPolicy='" + paymentPolicy + '\'' +
                '}';
    }
}

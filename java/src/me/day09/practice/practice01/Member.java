package me.day09.practice.practice01;

import java.util.Objects;

public class Member {
    private String serialNo; /* auto-generated */
    private String memberID;
    private String memberPassword;
    private String memberPhoneNumber;
    private String memberEmail;
    private String memberBirthDate;

    private static int count = 0;

    public Member() {
        generateKey();
    }

    public Member(String memberID, String memberPassword, String memberEmail) {
        this.memberID = memberID;
        this.memberPassword = memberPassword;
        this.memberEmail = memberEmail;
        generateKey();
    }

    public Member(String memberID, String memberPassword, String memberPhoneNumber, String memberEmail, String memberBirthDate) {
        this.memberID = memberID;
        this.memberPassword = memberPassword;
        this.memberPhoneNumber = memberPhoneNumber;
        this.memberEmail = memberEmail;
        this.memberBirthDate = memberBirthDate;
        generateKey();
    }

    private void generateKey() {
        count++; // 0 <=  < 10000
        serialNo = String.format("%05d", count); // 0 <   <= 10000
    }

    public String getSerialNo() {
        return serialNo;
    }

    private void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public String getMemberID() {
        return memberID;
    }

    public void setMemberID(String memberID) {
        this.memberID = memberID;
    }

    public String getMemberPassword() {
        return memberPassword;
    }

    public void setMemberPassword(String memberPassword) {
        this.memberPassword = memberPassword;
    }

    public String getMemberPhoneNumber() {
        return memberPhoneNumber;
    }

    public void setMemberPhoneNumber(String memberPhoneNumber) {
        this.memberPhoneNumber = memberPhoneNumber;
    }

    public String getMemberEmail() {
        return memberEmail;
    }

    public void setMemberEmail(String memberEmail) {
        this.memberEmail = memberEmail;
    }

    public String getMemberBirthDate() {
        return memberBirthDate;
    }

    public void setMemberBirthDate(String memberBirthDate) {
        this.memberBirthDate = memberBirthDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return serialNo.equals(member.serialNo) && memberID.equals(member.memberID)
                && memberPassword.equals(member.memberPassword) && memberPhoneNumber.equals(member.memberPhoneNumber)
                && memberEmail.equals(member.memberEmail) && memberBirthDate.equals(member.memberBirthDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serialNo, memberID, memberPassword, memberPhoneNumber, memberEmail, memberBirthDate);
    }

    @Override
    public String toString() {
        return "Member{" +
                "serialNo='" + serialNo + '\'' +
                ", memberID='" + memberID + '\'' +
                ", memberPassword='" + memberPassword + '\'' +
                ", memberPhoneNumber='" + memberPhoneNumber + '\'' +
                ", memberEmail='" + memberEmail + '\'' +
                ", memberBirthDate='" + memberBirthDate + '\'' +
                '}';
    }
}

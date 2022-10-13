package me.day09.practice.practice04;

import java.util.Arrays;
import java.util.Objects;

public class Member {
    protected String serialNo; /* auto-generated */
    protected String memberID;
    protected String memberPassword;
    protected String memberPhoneNumber;
    protected String memberEmail;
    protected String memberBirthDate;

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

    private boolean isRule1(String candidate) {
        String current = memberPhoneNumber.replace("010-", "");
        String candi = candidate.replace("010-", "");

        if (current.length() != candi.length()) return false;

        int[] diffs = new int[current.length()]; // 현재 핸드폰번호와 다른 인덱스를 저장
        int count = 0;
        for (int i = 0; i < current.length(); i++) {
            if (current.charAt(i) != candi.charAt(i)) {
                diffs[count] = i;
                count++;
            }
        }
        if (count == 2) {
            if (diffs[0] + 1 == diffs[1]) {
                return true;
            }
        }
        return false;
    }

    private boolean isRule2(String candidate) {
        String[] currentArray = memberPhoneNumber.split("-");
        String[] candiArray = candidate.split("-");

        if (currentArray[1] == null || candiArray[1] == null) return false;
        if (currentArray[1].length() != candiArray[1].length()) return false;

        return currentArray[1].equals(candiArray[1]);
    }

    private boolean isRule3(String candidate) {
        String[] currentArray = memberPhoneNumber.split("-");
        String[] candiArray = candidate.split("-");

        if (currentArray[2] == null || candiArray[2] == null) return false;
        if (currentArray[2].length() != candiArray[2].length()) return false;

        return currentArray[2].equals(candiArray[2]);
    }

    private boolean isRule4(String candidate) {
        String current = memberPhoneNumber.replace("010-", "");
        String candi = candidate.replace("010-", "");

        if (current.length() != candi.length()) return false;

        int count = 0;
        for (int i = 0; i < current.length(); i++) {
            if (current.charAt(i) != candi.charAt(i)) {
                count++;
            }
        }

        return (count == 3);
    }

    public String getNewPhoneNumber(String[] candidates) {
        for (int i = 0; i < candidates.length; i++) {
            if (isRule1(candidates[i])) {
                return candidates[i];
            } else if (isRule2(candidates[i])) {
                return candidates[i];
            } else if (isRule3(candidates[i])) {
                return candidates[i];
            } else if (isRule4(candidates[i])) {
                return candidates[i];
            }
        }
        return memberPhoneNumber;
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

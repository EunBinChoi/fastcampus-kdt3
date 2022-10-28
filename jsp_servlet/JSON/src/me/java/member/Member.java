package me.java.member;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

public class Member {
    private String uId = "";
    private String uPw = "";
    private String uEmail = "";

    public Member() {
    }

    public Member(String uId, String uPw) {
        this.uId = uId;
        this.uPw = uPw;
    }

    public Member(String uId, String uPw, String uEmail) {
        this.uId = uId;
        this.uPw = uPw;
        this.uEmail = uEmail;
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public String getuPw() {
        return uPw;
    }

    public void setuPw(String uPw) {
        this.uPw = uPw;
    }

    public String getuEmail() {
        return uEmail;
    }

    public void setuEmail(String uEmail) {
        this.uEmail = uEmail;
    }

    /**
     * SHA-256으로 해싱하는 메소드
     * */
    private String sha256(String password) {
        if (password == null || password.equals("")) return null;

        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

        // 바이트를 16진수로 변환
        messageDigest.update(password.getBytes());
        return String.format("%064x", new BigInteger(1, messageDigest.digest()));

    }

    /**
     * SHA-512으로 해싱하는 메소드
     * */
    private String sha512(String password) {
        if (password == null || password.equals("")) return null;

        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance("SHA-512");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

        // 바이트를 16진수로 변환
        messageDigest.update(password.getBytes());
        return String.format("%0128x", new BigInteger(1, messageDigest.digest()));

    }

    public boolean isIdPwdEquals(Member member) {
        return uId.equals(member.uId) && uPw.equals(member.uPw);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return uId.equals(member.uId) && uPw.equals(member.uPw) && uEmail.equals(member.uEmail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uId, uPw, uEmail);
    }

    @Override
    public String toString() {
        return "Member{" +
                "uId='" + uId + '\'' +
                ", uPw='" + uPw + '\'' +
                ", uEmail='" + uEmail + '\'' +
                '}';
    }
}
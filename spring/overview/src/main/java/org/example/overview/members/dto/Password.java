package org.example.overview.members.dto;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

public class Password {
    private static Password password = null;
    private String uPw = "";

    private Password() {}

    private Password(String uPw) {
        uPw = sha256(uPw);
    }

    public static Password getInstance() {
        if (password == null) {
            password = new Password();
        }
        return password;
    }

    public static Password of(String uPw, boolean needEncode) {
        if (password == null) {
            password = new Password();
        }

        if (needEncode) {
            password.setuPw(password.sha256(uPw));
        } else {
            password.setuPw(uPw);
        }
        return password;
    }

    public String getuPw() {
        return uPw;
    }

    public void setuPw(String uPw) {
        this.uPw = uPw;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Password password = (Password) o;
        return uPw.equals(password.uPw);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uPw);
    }

    @Override
    public String toString() {
        return "Password{" +
                "uPw='" + uPw + '\'' +
                '}';
    }
}

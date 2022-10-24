package member;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

public class Password {
    private String password;
    private String hashPassword; // 암호화된 패스워드 (데이터베이스에 저장)

    public Password(String password) {
        this(password, true);
    }

    public Password(String password, boolean needHash) {
        if (needHash) {
            this.password = password;
            this.hashPassword = sha256(password);
        } else {
            this.password = "";
            this.hashPassword = password;
        }
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password, boolean needHash) {
        if (needHash) {
            this.password = password;
            this.hashPassword = sha256(password);
        } else {
            this.password = "";
            this.hashPassword = password;
        }
    }

    public String getHashPassword() {
        return hashPassword;
    }

    public void setHashPassword(String hashPassword) {
        this.hashPassword = hashPassword;
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
        return hashPassword.equals(password.hashPassword);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hashPassword);
    }

    @Override
    public String toString() {
        return "Password{" +
                "hashPassword='" + hashPassword + '\'' +
                '}';
    }
}

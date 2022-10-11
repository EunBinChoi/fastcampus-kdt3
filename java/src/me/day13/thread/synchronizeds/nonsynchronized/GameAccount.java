package me.day13.thread.synchronizeds.nonsynchronized;

import java.util.Objects;

public class GameAccount { // 공유된 객체
    private String userID;
    private String userPassword;

    public GameAccount() {
    }

    public GameAccount(String userID, String userPassword) {
        this.userID = userID;
        this.userPassword = userPassword;
    }

    public static GameAccount getNewInstance(GameAccount origin) {
        return new GameAccount(origin.getUserID(), origin.getUserPassword());
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        System.out.println("[Before Revised] : " + Thread.currentThread().getName() + " : " + this.userID);
        this.userID = userID;

        // 수정하려면 시간 소요
        try {
            Thread.sleep(5000);
        } catch(InterruptedException e) {
            System.out.println(e);
        }

        System.out.println("[After Revised] : " + Thread.currentThread().getName() + " : " + this.userID);
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        System.out.println("[Before Revised] : " + Thread.currentThread().getName() + " : " + this.userPassword);
        this.userPassword = userPassword;

        // 수정하려면 시간 소요
        try {
            Thread.sleep(5000);
        } catch(InterruptedException e) {
            System.out.println(e);
        }

        System.out.println("[After Revised] : " + Thread.currentThread().getName() + " : " + this.userPassword);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameAccount that = (GameAccount) o;
        return userID.equals(that.userID) && userPassword.equals(that.userPassword);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userID, userPassword);
    }

    @Override
    public String toString() {
        return "GameAccount{" +
                "userID='" + userID + '\'' +
                ", userPassword='" + userPassword + '\'' +
                '}';
    }

}

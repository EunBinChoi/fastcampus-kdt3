package me.day13.thread.synchronizeds.nonsynchronized;

public class GameUser1 extends Thread {

    private GameAccount gameAccount;

    public GameUser1() {
    }

    public GameUser1(String name) {
        super(name);
    }

    public GameUser1(GameAccount gameAccount) {
        this.gameAccount = gameAccount;
    }

    public GameUser1(String name, GameAccount gameAccount) {
        super(name);
        this.gameAccount = gameAccount;
    }

    @Override
    public void run() {
        gameAccount.setUserPassword("abcd1111!");
    }

    @Override
    public String toString() {
        return "GameUser1{" +
                "gameAccount=" + gameAccount +
                '}';
    }
}

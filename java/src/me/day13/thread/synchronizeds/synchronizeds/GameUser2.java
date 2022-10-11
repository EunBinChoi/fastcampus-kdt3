package me.day13.thread.synchronizeds.synchronizeds;

public class GameUser2 extends Thread {

    private GameAccount gameAccount;

    public GameUser2() {}

    public GameUser2(String name) {
        super(name);
    }

    public GameUser2(GameAccount gameAccount) {
        this.gameAccount = gameAccount;
    }

    public GameUser2(String name, GameAccount gameAccount) {
        super(name);
        this.gameAccount = gameAccount;
    }

    @Override
    public void run() {
        gameAccount.setUserPassword("abcd2222!");
    }

    @Override
    public String toString() {
        return "GameUser2{" +
                "gameAccount=" + gameAccount +
                '}';
    }
}

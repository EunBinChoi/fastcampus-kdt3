package me.day13.thread.synchronizeds.synchronizeds;

public class SynchronizedExample {

    public static void main(String[] args) {
        GameAccount gameAccount = new GameAccount("abcd", "abcd1234!");

        GameUser1 gameUser1 = new GameUser1("gameUser1", gameAccount);
        GameUser2 gameUser2 = new GameUser2("gameUser2", gameAccount);
        gameUser1.start(); // "abcd1234!" -> "abcd1111!"
        gameUser2.start(); // "abcd1234!" -> "abcd2222!"

        System.out.println("gameAccount = " + gameAccount);

    }
}

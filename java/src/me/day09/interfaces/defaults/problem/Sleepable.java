package me.day09.interfaces.defaults.problem;

public interface Sleepable {
    default void on() {
        System.out.println("POWER ON");
    }
    default void off() {
        System.out.println("POWER OFF");
    }
    default void foldSeat() {
        System.out.println("Fold Seat for Camping in Car ... ");
    }
    default void unfoldSeat() {
        System.out.println("Unfold Seat for Camping in Car ... ");
    }
}

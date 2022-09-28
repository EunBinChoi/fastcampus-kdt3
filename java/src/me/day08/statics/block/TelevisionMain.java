package me.day08.statics.block;

public class TelevisionMain {
    public static void main(String[] args) {
        System.out.println(Television.getBrand());
        System.out.println(Television.getModel());
        System.out.println(Television.getInfo());

        Television television = new Television();
        System.out.println(television);
    }
}

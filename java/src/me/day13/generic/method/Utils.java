package me.day13.generic.method;

import me.day13.generic.method.decoration.Decorations;

public interface Utils {
    static <T> Box<T> boxing(T item) {
        Box<T> box = new Box<>();
        box.setItem(item);
        return box;
    }

    static <T, D> void decoration(Box<T> box, Decorations decoration) {
        System.out.println(box + " is decorated with "+ decoration);
    }

    static <T> T unboxing(Box<T> box) {
        T item = box.getItem();
        return item;
    }
}

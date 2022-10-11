package me.day13.generic.method;

import java.util.Objects;

/** <T>: T는 타입 파라미터 (T, K, V, R, E)
 *
 *  T: type
 *  K: key, V: value
 *  R: return
 *  E: element
 * */
public class Box<T> {
    private T item;

    public Box() {
    }

    public Box(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Box<?> box = (Box<?>) o;
        return item.equals(box.item);
    }

    @Override
    public int hashCode() {
        return Objects.hash(item);
    }

    @Override
    public String toString() {
        return "Box{" +
                "item=" + item +
                '}';
    }
}

package me.day13.generic.bound;


import me.day13.generic.bound.gift.Item;

import java.util.Arrays;
import java.util.Objects;

public class Gifts<T extends Item> {

    private static final int DEFULAT_SIZE = 10;
    private int size;

    private T[] gifts;
    private int count;

    public Gifts() {
        gifts = (T[]) new Item[DEFULAT_SIZE];
        this.size = DEFULAT_SIZE;
    }

    public Gifts(int size) {
        gifts = (T[]) new Item[size];
        this.size = size;
    }

    public T get(int i) {
        return gifts[i];
    }

    public void set(int i, T element) {
        // TODO: set(int i, T element) method implementation
    }


    public void add(T element) {
        if (count < size) {
            gifts[count] = element;
            count++;
        } else {
            T[] origin = Arrays.copyOf(gifts, count);
            size *= 2;
            gifts = Arrays.copyOf(origin, size);
            add(element);
        }
    }

    public void add(int i, T element) {
        // TODO: add(int i, T element) method implementation
    }

    public void clear() {
        // TODO: clear() method implementation
    }

    public void pop() {
        // TODO: pop() method implementation
    }

    public void remove(int i ) {
        // TODO: remove(int i) method implementation
    }

    public void remove(T element) {
        int elementIndex = -1;
        for (int i = 0; i < count; i++) {
            if (gifts[i] != null) {
                if (gifts[i].equals(element)) {
                    elementIndex = i;
                }
            }
        }
        if (elementIndex == -1) {
            System.out.println(element + " can't be found.");
        } else {
            gifts[elementIndex] = null;
            for (int i = elementIndex+1; i < count; i++) {
                gifts[i-1] = gifts[i];
            }
            count--;

            System.out.println(element + " removed successfully.");
        }
    }


    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public T[] getGifts() {
        return gifts;
    }

    public void setGifts(T[] gifts) {
        this.gifts = gifts;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gifts<?> that = (Gifts<?>) o;
        return size == that.size && count == that.count && Arrays.equals(gifts, that.gifts);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(size, count);
        result = 31 * result + Arrays.hashCode(gifts);
        return result;
    }

    @Override
    public String toString() {
        return "RandomGiftBox{" +
                "size=" + size +
                ", gifts=" + Arrays.toString(gifts) +
                ", count=" + count +
                '}';
    }
}

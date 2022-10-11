package me.day13.generic.extend;


import me.day13.generic.extend.gift.Item;

import java.util.Arrays;
import java.util.Objects;

public class Gifts<E extends Item> {

    private static final int DEFULAT_SIZE = 10;
    private int size;

    private E[] gifts;
    private int count;

    public Gifts() {
        gifts = (E[]) new Item[DEFULAT_SIZE];
        this.size = DEFULAT_SIZE;
    }

    public Gifts(int size) {
        gifts = (E[]) new Item[size];
        this.size = size;
    }

    public E get(int i) {
        return gifts[i];
    }

    public void add(E element) {
        if (count < size) {
            gifts[count] = element;
            count++;
        } else {
            E[] origin = Arrays.copyOf(gifts, count);
            size *= 2;
            gifts = Arrays.copyOf(origin, size);
            add(element);
        }
    }

    public void remove(E element) {
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

    public E[] getGifts() {
        return gifts;
    }

    public void setGifts(E[] gifts) {
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

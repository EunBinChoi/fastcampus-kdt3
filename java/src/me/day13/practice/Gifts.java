package me.day13.practice;


import me.day13.practice.gift.Item;

import java.util.Arrays;
import java.util.Objects;

public class Gifts<T extends Item> {

    private static final int DEFULAT_SIZE = 2;
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

    public void trimToSize() {
        gifts = Arrays.copyOf(gifts, count);
    }

    public void print() {
        if (count == 0) {
            System.out.println("Nothing to print in array.");
            return;
        }

        for (int i = 0; i < count; i++) {
            System.out.println(gifts[i]);
        }
    }

    public boolean isNull(T element) {
        return (element == null);
    }

    public boolean isEmpty() {
        return (count == 0);
    }

    public int isDuplicatedProductNo(T element) {
        for (int i = 0; i < gifts.length; i++) {
            if (gifts[i] != null) {
                if (gifts[i].getProductNo() != null) {
                    if (gifts[i].getProductNo().equals(element.getProductNo())) {
                        return i;
                    }
                }
            }
        }
        return -1;
    }


    public boolean isIndexInRange(int i, boolean isAddMethod) {
        return isAddMethod ? (i >= 0 && i <= count) : (i >= 0 && i < count);
    }


    public T get(int i) {
        if (!isIndexInRange(i , false)) {
            System.out.println("Input index [" + i + "] is too small or large." );
            return null;
        }

        return gifts[i];

    }

    public void set(int i, T element) {
        // TODO: set(int i, T element) method implementation
        if (!isIndexInRange(i , false)) {
            System.out.println("Input index [" + i + "] is too small or large." );
            return;
        }

        if (isNull(element)) {
            System.out.println("Input element null. " + element);
            return;
        }

        int duplicatedIdx = isDuplicatedProductNo(element);
        if (duplicatedIdx != -1) {
            System.out.println("Duplicated productNo. Duplicated element => " + gifts[duplicatedIdx]);
            return;
        }

        gifts[i] = element;
    }


    public void add(T element) {
        if (isNull(element)) {
            System.out.println("Input element null. " + element);
            return;
        }

        int duplicatedIdx = isDuplicatedProductNo(element);
        if (duplicatedIdx != -1) {
            System.out.println("Duplicated productNo. Duplicated element => " + gifts[duplicatedIdx]);
            return;
        }

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
        if (!isIndexInRange(i , true)) {
            System.out.println("Input index [" + i + "] is too small or large." );
            return;
        }

        if (isNull(element)) {
            System.out.println("Input element null. " + element);
            return;
        }

        int duplicatedIdx = isDuplicatedProductNo(element);
        if (duplicatedIdx != -1) {
            System.out.println("Duplicated productNo. Duplicated element => " + gifts[duplicatedIdx]);
            return;
        }

        if (count + 1 < size) {
            for (int j = count; j > i; j--) {
                gifts[j] = gifts[j-1];
            }
            gifts[i] = element;
            count++;

        } else {
            T[] origin = Arrays.copyOf(gifts, count);
            size *= 2;
            gifts = Arrays.copyOf(origin, size);
            add(i, element);
        }

    }

    public void clear() {
        // TODO: clear() method implementation
        if (isEmpty()) {
            System.out.println("Array is Empty.");
            return;
        }

        Arrays.fill(gifts, null);
        count = 0;
    }

    public void pop() {
        // TODO: pop() method implementation
        if (isEmpty()) {
            System.out.println("Array is Empty.");
            return;
        }

        if (gifts.length > 0) {
            gifts[count-1] = null;
            count--;
        }
    }

    public void remove(int i) {
        // TODO: remove(int i) method implementation

        if (isEmpty()) {
            System.out.println("Array is Empty.");
            return;
        }

        if (!isIndexInRange(i , false)) {
            System.out.println("Input index [" + i + "] is too small or large." );
            return;
        }

        gifts[i] = null;
        for (int j = i + 1; j < count; j++) {
            gifts[j - 1] = gifts[j];
        }
        count--;
    }

    public void remove(T element) {

        if (isEmpty()) {
            System.out.println("Array is Empty.");
            return;
        }

        if (isNull(element)) {
            System.out.println("Input element null. " + element);
            return;
        }

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
        return Arrays.copyOf(gifts, count);
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
                ", gifts=" + Arrays.toString(Arrays.copyOf(gifts, count)) +
                ", count=" + count +
                '}';
    }
}

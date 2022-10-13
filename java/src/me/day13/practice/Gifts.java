package me.day13.practice;


import me.day13.practice.gift.Item;

import java.util.Arrays;
import java.util.Objects;

public class Gifts<T extends Item> {

    private static final int DEFULAT_SIZE = 2;
    private int size; // 배열 크기. capacity

    private T[] gifts;
    private int count; // 실제 인스턴스 개수

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

    private boolean isNull(T element) {
        return (element == null);
    }

    public boolean isEmpty() {
        return (count == 0);
    }

    public int isKeyDuplicated(T element) { // suppose key is productNo in Note instance
        for (int i = 0; i < count; i++) {
            if (gifts[i] != null) {
                if (gifts[i].getProductNo() != null) {
                    if (gifts[i].getProductNo().equals(element.getProductNo())) {
                        return i; // return duplicated element index
                    }
                }
            }
        }
        return -1; // not duplicated.
    }


    public boolean isIndexInRange(int i, boolean isAddMethod) {
        return isAddMethod ? (i >= 0 && i <= count) : (i >= 0 && i < count);
    }
    // 배열 = {1, 2, 3, 4}
    // 인덱스 = 0 ~ 3
    // count = 4
    // add(4, 100) => {1, 2, 3, 4, 100} (O)
    // add(5, 200) => {1, 2, 3, 4, null, 200} (X)
    // set(4, 100) => error
    // remove(4) => error


    public T get(int i) {
        if (isEmpty()) {
            System.out.println("Array is Empty.");
            return null;
        }

        if (!isIndexInRange(i , false)) {
            System.out.println("Input index [" + i + "] is too small or large." );
            return null;
        }

        return gifts[i];
    }

    public void set(int i, T element) {

        if (isEmpty()) {
            System.out.println("Array is Empty.");
            return;
        }

        if (!isIndexInRange(i , false)) {
            System.out.println("Input index [" + i + "] is too small or large." );
            return;
        }

        if (isNull(element)) {
            System.out.println("Input element null. " + element);
            return;
        }

        int duplicatedIdx = isKeyDuplicated(element);
        if (duplicatedIdx != -1) {
            System.out.println("Duplicated productNo. Duplicated element => " + gifts[duplicatedIdx]);
            return;
        }

        gifts[i] = element;
    }


    public T add(T element) {
        if (isNull(element)) {
            System.out.println("Input element null. " + element);
            return null;
        }

        int duplicatedIdx = isKeyDuplicated(element);
        if (duplicatedIdx != -1) {
            System.out.println("Duplicated productNo. Duplicated element => " + gifts[duplicatedIdx]);
            return null;
        }

        if (count < size) {
            gifts[count] = element;
            count++;
        } else { // doubling
            T[] origin = Arrays.copyOf(gifts, count); // {1, 2, 3}
            size *= 2; // size: 3 -> 6, count: 3
            gifts = Arrays.copyOf(origin, size); // {1, 2, 3, null, null, null}
            add(element);
        }
        return element;
    }

    public T add(int i, T element) {
        // {1, 2, 3, 4}
        // add(2, 100);
        // {1, 2, 100, 3, 4}

        if (!isIndexInRange(i , true)) {
            System.out.println("Input index [" + i + "] is too small or large." );
            return null;
        }

        if (isNull(element)) {
            System.out.println("Input element null. " + element);
            return null;
        }

        int duplicatedIdx = isKeyDuplicated(element);
        if (duplicatedIdx != -1) {
            System.out.println("Duplicated productNo. Duplicated element => " + gifts[duplicatedIdx]);
            return null;
        }

        if (count < size) { // {1, 2, 3, 4, null} => {1, 2, 100, 3, 4}
            for (int j = count; j > i; j--) {
                gifts[j] = gifts[j-1];
            }
            gifts[i] = element;
            count++;

        } else { // {1, 2, 3, 4} => {1, 2, 3, 4, null, null, null, null} => {1, 2, 100, 3, 4, null, null, null}
            T[] origin = Arrays.copyOf(gifts, count);
            size *= 2;
            gifts = Arrays.copyOf(origin, size);
            add(i, element);
        }
        return element;
    }

    public void clear() {
        if (isEmpty()) {
            System.out.println("Array is Empty.");
            return;
        }

        Arrays.fill(gifts, null);
        count = 0;
    }

    public T pop() {
        if (isEmpty()) {
            System.out.println("Array is Empty.");
            return null;
        }

        T popNode = gifts[count-1];
        gifts[count-1] = null;
        count--;
        return popNode;
    }

    public T remove(int i) {

        if (isEmpty()) { // array empty
            System.out.println("Array is Empty.");
            return null;
        }

        if (!isIndexInRange(i , false)) { // 0 <= i < count
            System.out.println("Input index [" + i + "] is too small or large." );
            return null;
        }

        // {1, 2, 3, 4, 5} => {1, 2, 4, 4, 5} => {1, 2, 3, 4, 5, 5} => {1, 2, 3, 4, 5, null}
        // {1, 2, 4, 5}
        T removeNode = gifts[i];
        gifts[i] = null;
        for (int j = i + 1; j < count; j++) {
            gifts[j - 1] = gifts[j];
        }
        gifts[count-1] = null;
        count--;
        return removeNode;
    }

    public T remove(T element) {

        if (isEmpty()) {
            System.out.println("Array is Empty.");
            return null;
        }

        if (isNull(element)) {
            System.out.println("Input element null. " + element);
            return null;
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
            gifts[count-1] = null;
            count--;

            System.out.println(element + " removed successfully.");
        }
        return element;
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

package me.day14.collection.use;


import me.day14.collection.use.gift.Item;

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

    private boolean isNull(T element) { // 인자로 들어온 객체가 null 인지 확인
        return (element == null);
    }

    public boolean isEmpty() { // 현재 배열의 길이가 0인지 확인
        return (count == 0);
    }

    public int isDuplicatedKey(T element) {
        for (int i = 0; i < count; i++) {
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

        int duplicatedIdx = isDuplicatedKey(element);
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

        int duplicatedIdx = isDuplicatedKey(element);
        if (duplicatedIdx != -1) {
            System.out.println("Duplicated productNo. Duplicated element => " + gifts[duplicatedIdx]);
            return null;
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
        return element;
    }

    public T add(int i, T element) {
        if (!isIndexInRange(i , true)) {
            System.out.println("Input index [" + i + "] is too small or large." );
            return null;
        }

        if (isNull(element)) {
            System.out.println("Input element null. " + element);
            return null;
        }

        int duplicatedIdx = isDuplicatedKey(element);
        if (duplicatedIdx != -1) {
            System.out.println("Duplicated productNo. Duplicated element => " + gifts[duplicatedIdx]);
            return null;
        }

        if (count  < size) {
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

        if (isEmpty()) {
            System.out.println("Array is Empty.");
            return null;
        }

        if (!isIndexInRange(i , false)) {
            System.out.println("Input index [" + i + "] is too small or large." );
            return null;
        }

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

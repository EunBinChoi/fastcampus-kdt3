package me.day13.generic.implement;


import java.util.Arrays;
import java.util.Objects;

public class StorageImpl<T extends Clothes> implements Storage<T> {
    private static final int DEFULAT_SIZE = 10;
    private int size;

    private T[] list;
    private int count;

    public StorageImpl() {
        list = (T[]) new Clothes[DEFULAT_SIZE];
        this.size = DEFULAT_SIZE;
    }

    public StorageImpl(int size) {
        list = (T[]) new Clothes[size];
        this.size = size;
    }

    public T get(int i) {
        return list[i];
    }

    public void add(T element) {
        if (count < size) {
            list[count] = element;
            count++;
        } else {
            T[] origin = Arrays.copyOf(list, count);
            size *= 2;
            list = Arrays.copyOf(origin, size);
            add(element);
        }
    }

    public void remove(T element) {
        int elementIndex = -1;
        for (int i = 0; i < count; i++) {
            if (list[i] != null) {
                if (list[i].equals(element)) {
                    elementIndex = i;
                }
            }
        }
        if (elementIndex == -1) {
            System.out.println(element + " can't be found.");
        } else {
            list[elementIndex] = null;
            for (int i = elementIndex+1; i < count; i++) {
                list[i-1] = list[i];
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

    public T[] getList() {
        return list;
    }

    public void setList(T[] list) {
        this.list = list;
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
        StorageImpl<?> storage = (StorageImpl<?>) o;
        return size == storage.size && count == storage.count && Arrays.equals(list, storage.list);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(size, count);
        result = 31 * result + Arrays.hashCode(list);
        return result;
    }

    @Override
    public String toString() {
        return "StorageImpl{" +
                "size=" + size +
                ", list=" + Arrays.toString(list) +
                ", count=" + count +
                '}';
    }
}

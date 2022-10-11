package me.day13.generic.implement;

import java.util.Objects;

class Clothes {
    private String type;
    private String season;
    private String color;

    public Clothes() {
    }

    public Clothes(String type, String season, String color) {
        this.type = type;
        this.season = season;
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Clothes clothes = (Clothes) o;
        return type.equals(clothes.type) && season.equals(clothes.season) && color.equals(clothes.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, season, color);
    }

    @Override
    public String toString() {
        return "Clothes{" +
                "type='" + type + '\'' +
                ", season='" + season + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}

public class ImplementExample {
    public static void main(String[] args) {
        StorageImpl<Clothes> storage = new StorageImpl<>();
        storage.add(new Clothes("셔츠", "가을", "블루"));
        storage.add(new Clothes("반바지", "여름", "검정"));
        storage.add(new Clothes("니트", "겨울", "베이지"));
        System.out.println();

        for (int i = 0; i < storage.getCount(); i++) {
            System.out.println("storage.get(i) = " + storage.get(i));
        }

        System.out.println();
        storage.remove(new Clothes("셔츠", "가을", "블루"));
        storage.remove(new Clothes("반바지", "여름", "검정"));
        storage.remove(new Clothes("니트", "겨울", "베이지"));
    }
}

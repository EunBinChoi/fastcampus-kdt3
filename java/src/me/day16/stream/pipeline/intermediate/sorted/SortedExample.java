package me.day16.stream.pipeline.intermediate.sorted;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

class Fruit implements Comparable<Fruit> {
    private String name;
    private Integer price;

    public Fruit() {
    }

    public Fruit(String name, Integer price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Integer getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public int compareTo(Fruit o) {
        return Integer.compare(price, o.price);
    }
}


public class SortedExample {
    public static void main(String[] args) {
        // 숫자 요소일 경우
        IntStream intStream = Arrays.stream(new int[] {5, 3, 2, 1, 4});
        intStream
                .sorted()
                .forEach(n -> System.out.print(n + ", "));
        System.out.println();
        System.out.println();

        // 객체 요소일 경우
        List<Fruit> fruitList = Arrays.asList(
                new Fruit("b", 3000),
                new Fruit("b", 1000),
                new Fruit("a", 3000),
                new Fruit("c", 2000)
        );

        fruitList.stream()
                .sorted() // 기본 비교 방법으로 정렬
                .forEach(s -> System.out.print(s.getPrice() + ", "));
        System.out.println();

        fruitList.stream()
                .sorted(Comparator.naturalOrder()) // 기본 비교 방법으로 정렬
                .forEach(s -> System.out.print(s.getPrice() + ", "));
        System.out.println();

        fruitList.stream()
                .sorted(Comparator.reverseOrder()) // 기본 비교 방법과 정반대 방법으로 정렬
                .forEach(s -> System.out.print(s.getPrice() + ", "));
        System.out.println();


        // 새로운 비교 방법 제시
        Comparator<Fruit> fruitComparator
                = Comparator.comparing(Fruit::getName)
                .thenComparing(Fruit::getPrice);
        fruitList.stream()
                .sorted(fruitComparator) // 새로운 비교 방법 정렬
                .forEach(s -> System.out.print(s + ", "));
        System.out.println();
        System.out.println();

        // null 포함된 객체 요소일 경우
        List<Fruit> fruitListWithNull = Arrays.asList(
                new Fruit("b", 3000),
                new Fruit("b", 1000),
                new Fruit("a", 3000),
                new Fruit("c", 2000),
                null,
                null
        );
        Comparator<Fruit> fruitComparatorWithNullFirst
                = Comparator.nullsFirst(fruitComparator);
        fruitListWithNull.stream()
                .sorted(fruitComparatorWithNullFirst) // 새로운 비교 방법 정렬
                .forEach(s -> System.out.print(s + ", "));
        System.out.println();

        Comparator<Fruit> fruitComparatorWithNullLast
                = Comparator.nullsLast(fruitComparator);
        fruitListWithNull.stream()
                .sorted(fruitComparatorWithNullLast) // 새로운 비교 방법 정렬
                .forEach(s -> System.out.print(s + ", "));
    }
}
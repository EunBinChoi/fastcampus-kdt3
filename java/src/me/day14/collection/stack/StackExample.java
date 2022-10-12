package me.day14.collection.stack;

import java.util.List;
import java.util.Stack;

class Book {
    private String title;

    public Book() {
    }

    public Book(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title +
                '}';
    }
}

public class StackExample {
    public static void main(String[] args) {
        Stack<Book> books = new Stack<>();

        // 원소 삽입
        books.push(new Book("Harry Potter"));

        // Stack은 Vector 자식 클래스이기 때문에 일반 List 인터페이스 메소드도 사용 가능
        books.add(new Book("Christmas Carol"));
        books.addAll(List.of(
                new Book("Effective Java"), new Book("Clean Code"), new Book("Spring Framework Bible")));
        System.out.println("books = " + books);
        System.out.println("books.size() = " + books.size());
        System.out.println();

        for (int i = 0; i < books.size(); i++) {
            System.out.println("books.get(i) = " + books.get(i));
        }
        System.out.println();


        // 스택에서 맨 위의 객체를 가져옴 (제거 ❌)
        Book peekBook = books.peek();
        System.out.println("peekBook = " + peekBook);
        System.out.println("books = " + books);
        System.out.println("books.size() = " + books.size());
        System.out.println();

        // 스택에서 맨 위의 객체를 가져옴 (제거 ⭕️)
        Book popBook = books.pop();
        System.out.println("popBook = " + popBook);
        System.out.println("books = " + books);
        System.out.println("books.size() = " + books.size());
        System.out.println();

        // Stack은 Vector 자식 클래스이기 때문에 일반 List 인터페이스 메소드도 사용 가능
        // Stack 순서 무시 (권장하지 않음)
        Book popBook2 = books.remove(1);
        System.out.println("popBook2 = " + popBook2);
        System.out.println("books = " + books);
        System.out.println("books.size() = " + books.size());
        System.out.println();


        // 들어간 순서와 반대로 스택에서 꺼내옴
        // 스택에서 맨 위의 객체를 가져옴 (제거 ⭕️)
        while(!books.isEmpty()) {
            System.out.println("books.pop() = " + books.pop());
        }

    }
}

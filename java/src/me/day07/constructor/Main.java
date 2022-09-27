package me.day07.constructor;

public class Main {
    public static void main(String[] args) {
        // 기본 생성자
        // 생성자가 아무것도 없을 때 기본 생성자는 컴파일러가 자동 생성함
        DefaultConstructorExample defaultConstructorExample = new DefaultConstructorExample();
        System.out.println(defaultConstructorExample);

        ArgumentConstructorExample argumentConstructorExample1 = new ArgumentConstructorExample(10);
        ArgumentConstructorExample argumentConstructorExample2 = new ArgumentConstructorExample("abc");
        ArgumentConstructorExample argumentConstructorExample3 = new ArgumentConstructorExample(20, "def");
//        ArgumentConstructorExample argumentConstructorExample4 = new ArgumentConstructorExample(); // 기본 생성자는 없기 때문에 오류

    }
}

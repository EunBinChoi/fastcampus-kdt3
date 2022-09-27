package me.day07.object.equals;

public class ObjectEqualsMain {
    public static void main(String[] args) {
        ObjectEqualsExample objectEqualsExample1 = new ObjectEqualsExample(10, "abc");
        ObjectEqualsExample objectEqualsExample2 = new ObjectEqualsExample(10, "abc");

        System.out.println("objectEqualsExample1 = " + objectEqualsExample1);
        System.out.println("objectEqualsExample2 = " + objectEqualsExample2);
        System.out.println("고유한 ID가 동일한지 확인 = " + (objectEqualsExample1 == objectEqualsExample2));
        System.out.println();
        if (objectEqualsExample1 != null) {
            System.out.println("objectEqualsExample1.hashCode() = " + objectEqualsExample1.hashCode());
            System.out.println("objectEqualsExample1.hashCode() = " + objectEqualsExample2.hashCode());
            System.out.println("objectEqualsExample1.hashCode() = " + objectEqualsExample1.equals(objectEqualsExample2));
            // 내용물이 같으면 사실상 같은 객체임
            // 두 객체의 해쉬코드가 같으면 객체는 같다라고 판단
            // 따라서 equals 재정의시 hashCode도 같이 재정의함
            // 두 객체 동등비교의 성능 높이기 위함
        }
    }
}

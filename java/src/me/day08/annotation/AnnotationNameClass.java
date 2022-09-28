package me.day08.annotation;

public class AnnotationNameClass {
    // 생성자는 지정 불가
    // {ElementType.TYPE, ElementType.FIELD, ElementType.METHOD
    // 클래스 / 필드 / 메소드만 붙일 수 있음
//    @AnnotationName(elementName1 = "abc", elementName2 = 10)
//    public Foo() {
//    }

    @AnnotationName(elementName1 = "abc", elementName2 = 10)
    public void func1() {}

    @AnnotationName(elementName1 = "abc")
    public void func2() {}

    // 오류 (elementName1 기본값 없음)
//    @AnnotationName(elementName2 = 20)
//    public void func3() {}
}

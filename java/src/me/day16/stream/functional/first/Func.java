package me.day16.stream.functional.first;

@FunctionalInterface
public interface Func {
    void method(String str); // 추상 메소드 1개 (implement 1개)
}

// Func func = a -> sout(a);
// Func func = new Func() {
//    @Override
//    void method(String a) {
//        sout(a);
//    }
// }
// func.method(3);

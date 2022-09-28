package me.day08.annotation;

import java.lang.reflect.Method;

public class PrintAnnotationClass {
    public static void main(String[] args) {
        Method[] methods = Service.class.getDeclaredMethods();
        for (Method method : methods) {
            // PrintAnnotation 적용되었는지 확인
            if (method.isAnnotationPresent(PrintAnnotation.class)) {
                // PrintAnnotation 객체 얻기
                PrintAnnotation printAnnotation = method.getAnnotation(PrintAnnotation.class);

                // 메소드 이름 출력
                System.out.println("[" + method.getName() + "]");
                // 구분선 출력
                for (int i = 0; i < printAnnotation.number(); i++) {
                    System.out.print(printAnnotation.value());
                }
                System.out.println();

                try {
                    // 메소드 호출 (리플렉션)
                    method.invoke(new Service());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

package me.day12.api.util.stringtokenzier;

import java.util.Arrays;
import java.util.Iterator;
import java.util.StringTokenizer;

public class StringTokenizerExample {
    public static void main(String[] args) {
        final String str = "홍홍, 박박, 김김";
        String[] splitString = str.split(", ");
        for (String s: splitString) {
            System.out.println("s = " + s);
        }
        System.out.println();

        StringTokenizer stringTokenizer1 = new StringTokenizer(str, ", ");
        int count = stringTokenizer1.countTokens();
        System.out.println("count = " + count);
        System.out.println();

        for (int i = 0; i < count; i++) {
            String token = stringTokenizer1.nextToken();
            System.out.println("token = " + token);
        }
        System.out.println();

        StringTokenizer stringTokenizer2 = new StringTokenizer(str, ", ");
        while (stringTokenizer2.hasMoreElements()) {
            //String token = stringTokenizer2.nextToken();
            Object token = stringTokenizer2.nextElement();
            System.out.println("token = " + token);
        }
        System.out.println();
        
        StringTokenizer stringTokenizer3 = new StringTokenizer(str, ", ");
        Iterator<Object> iterator = stringTokenizer3.asIterator();
        while (iterator.hasNext()) {
            Object token = iterator.next();
            System.out.println("token = " + token);
        }
        System.out.println();


        /////////////////////////////////////////////////////////////////////////////////////
        /////////////////////////////////////////////////////////////////////////////////////
        // StringTokenizer vs String split()
        // String split() - 빈 문자열도 토큰으로 인식, 정규식 사용 가능, 잘라낸 결과를 배열에 담아서 반환 (데이터 양이 많은 경우 성능 떨어짐)
        // StringTokenizer - 빈 문자열은 토큰으로 인식하지 않음

        String data = "100,,,200,300";
        String[] strings = data.split(","); // regex 넣을 수 있음
        for (int i = 0; i < strings.length; i++) {
            System.out.println("strings[i] = " + strings[i]);
        }
        System.out.println("strings.length = " + strings.length);
        System.out.println();

        StringTokenizer stringTokenizer = new StringTokenizer(data, ",");
        while (stringTokenizer.hasMoreTokens()) {
            System.out.println("stringTokenizer.nextToken() = " + stringTokenizer.nextToken());
        }
        System.out.println("stringTokenizer.countTokens() = " + stringTokenizer.countTokens());

    }
}

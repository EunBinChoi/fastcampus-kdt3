package me.day05.string;

public class StringReplaceExample {
    static final String SMALL_LETTER_REGEX = "[a-z]";
    static final String NOT_ALNUM_REGEX = "[^a-z0-9]";
    static final String KOREAN_REGEX = "[가-힣]";
    public static void main(String[] args) {
        String str1 = "hello world world";
        String str2 = "hello world world";
        String replace1 = str1.replace("world", "WORLD");
        System.out.println("replace1 = " + replace1);
        String replace2 = str2.replace('w', 'W');
        System.out.println("replace2 = " + replace2);
        System.out.println();

        String strAll1 = "hello world world";
        String strAll2 = "hello world world";
        String strAll3 = "hello world world";
        String replaceAll1 = strAll1.replaceAll("world", "WORLD");
//        String replaceAll2 = strAll2.replaceAll('w', 'W'); // 문자 불가
        String replaceAll3 = strAll3.replaceAll(SMALL_LETTER_REGEX, "_"); // 정규 표현식 사용가능
        System.out.println("replaceAll1 = " + replaceAll1);
//        System.out.println("replaceAll2 = " + replaceAll2);
        System.out.println("replaceAll3 = " + replaceAll3);
        System.out.println();

        // 입력 데이터 형식 확인 (포맷 확인)
        String strAll4 = "abasdasd!!012345^~*#";
        String replaceAllRegEx1 = strAll4.toLowerCase().replaceAll(NOT_ALNUM_REGEX, ""); // 영문자와 숫자 이외 문자 제거
        System.out.println("replaceAllRegEx1 = " + replaceAllRegEx1);

        String strAll5 = "가나다라마바사ABCDEFG";
        String replaceAllRegEx2 = strAll5.replaceAll(KOREAN_REGEX, ""); // 한글 제거
        System.out.println("replaceAllRegEx2 = " + replaceAllRegEx2);
        System.out.println();
    }
}
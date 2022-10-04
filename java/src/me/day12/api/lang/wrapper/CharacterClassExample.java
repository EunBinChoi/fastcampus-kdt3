package me.day12.api.lang.wrapper;

import org.openjdk.jol.vm.VM;

public class CharacterClassExample {
    public static void main(String[] args) {
        // 기초 자료형은 데이터만 저장하고 관련 함수는 없음
        // 기초 자료형과 관련 메서드를 포함하고 있는 랩퍼 클래스를 만듦
        // 랩퍼 클래스의 메소드는 대부분 static 메소드
        // byte, short, int, long, char, boolean, float, double (기초 자료형)
        // Byte, Short, Integer, Long, Character, Boolean, Float, Double (랩퍼 클래스)

        ///////////////////////////////////////////////////////////////
        /////////////////// char -> Character (Boxing) ////////////////
        ///////////////////////////////////////////////////////////////
        Character character1 = 'a';
        Character character2 = Character.valueOf('a');
        Character character3 = new Character('a');
        Character character4 = new Character('a');
        System.out.println(character1 == character2); // 주소 비교, true
        System.out.println(character3 == character4); // 주소 비교, false
        System.out.println(character1.equals(character2)); // 내용 비교, true
        System.out.println(character3.equals(character4)); // 내용 비교, true
        System.out.println();

        System.out.println(VM.current().addressOf('a'));
        System.out.println(VM.current().addressOf('a'));
        System.out.println(VM.current().addressOf(new Integer('a')));
        System.out.println(VM.current().addressOf(new Integer('a')));
        System.out.println();

        Character character5 = '가';
        Character character6 = Character.valueOf('가');
        Character character7 = new Character('가');
        Character character8 = new Character('가');
        System.out.println(character5 == character6); // 주소 비교, true
        System.out.println(character7 == character8); // 주소 비교, false
        System.out.println(character5.equals(character6)); // 내용 비교, true
        System.out.println(character7.equals(character8)); // 내용 비교, true
        System.out.println();

        // 존재하지 않는 문자는 메모리에 할당되어있지 않음 (주소가 다 새롭게 할당)
        System.out.println(VM.current().addressOf('댥'));
        System.out.println(VM.current().addressOf('댥'));
        System.out.println(VM.current().addressOf('햫'));
        System.out.println(VM.current().addressOf('햫'));
        System.out.println(VM.current().addressOf(new Integer('댥')));
        System.out.println(VM.current().addressOf(new Integer('댥')));
        System.out.println(VM.current().addressOf(new Integer('햫')));
        System.out.println(VM.current().addressOf(new Integer('햫')));
        System.out.println();

        /////////////////////////////////////////////////////////////////
        ///////////////// Character -> char (UnBoxing) //////////////////
        /////////////////////////////////////////////////////////////////
        Character character = 'a'; // boxing (특별한 함수 없이도 가능)
        char charValue = character; // unboxing (특별한 함수 없이도 가능)
        char charValue2 = character.charValue(); // unboxing (charValue() 함수 호출도 가능)
        System.out.println("Boxing = " + character);
        System.out.println("UnBoxing = " + charValue);
        System.out.println("UnBoxing = " + charValue2);
        System.out.println();

        //////////////////////////////////////////////////////////////////
        ////////////////////////// 정수 변수에 저장 //////////////////////////
        /////////////////////////////////////////////////////////////////
        // 정수 변수에 저장도 가능함
        // 문자는 사실 정수로 저장되기 때문에 (유니코드 값)
        character = 'a'; // boxing (특별한 함수 없이도 가능)
        int intValue = character; // unboxing 해서 int 변수에 저장 가능
        int intValue2 = character.charValue(); // unboxing 해서 int 변수에 저장 가능
        System.out.println("Boxing = " + character);
        System.out.println("UnBoxing = " + intValue);
        System.out.println("UnBoxing = " + intValue2);
        System.out.println();

        ///////////////////////////////////////////////////////////////
        ///////////////// Character 클래스 메소드 ////////////////////////
        //////////////////////////////////////////////////////////////
        System.out.println("Character.TYPE = " + Character.TYPE);
        System.out.println("Character.SIZE = " + Character.SIZE);
        System.out.println("Character.BYTES = " + Character.BYTES);
        System.out.println("Character.MAX_VALUE = " + Character.MAX_VALUE);
        System.out.println("Character.MIN_VALUE = " + Character.MIN_VALUE);
        System.out.println();

        // compare
        char c1 = 'a';
        char c2 = 'z';
        System.out.println("c1과 c2 비교 = " + Character.compare(c1, c2)); // 'a' - 'z'


        // String -> char
        String str = "a";
        char parseChar = str.charAt(0);
        System.out.println("parseChar = " + parseChar);

        // char -> String
        char c = 'a';
        String toStringChar = Character.toString(c);
        System.out.println("toStringChar = " + toStringChar);
        System.out.println();

        // isDigit: '0' ~ '9'
        System.out.println("isDigit = " + Character.isDigit('0'));
        System.out.println("isDigit = " + Character.isDigit('1'));
        System.out.println("isDigit = " + Character.isDigit('2'));
        System.out.println("isDigit = " + Character.isDigit('3'));
        System.out.println("isDigit = " + Character.isDigit('4'));
        System.out.println("isDigit = " + Character.isDigit('5'));
        System.out.println("isDigit = " + Character.isDigit('6'));
        System.out.println("isDigit = " + Character.isDigit('7'));
        System.out.println("isDigit = " + Character.isDigit('8'));
        System.out.println("isDigit = " + Character.isDigit('9'));
        System.out.println();

        // isWhitespace: ' ', '\t', '\r','\n'
        System.out.println("isWhitespace = " + Character.isWhitespace(' '));
        System.out.println("isWhitespace = " + Character.isWhitespace('\t'));
        System.out.println("isWhitespace = " + Character.isWhitespace('\r'));
        System.out.println("isWhitespace = " + Character.isWhitespace('\n'));
        System.out.println();

        // isAlphabetic
        System.out.println("isAlphabetic = " + Character.isAlphabetic('a'));
        System.out.println("isAlphabetic = " + Character.isAlphabetic('b'));
        System.out.println("isAlphabetic = " + Character.isAlphabetic('z'));
        System.out.println("isAlphabetic = " + Character.isAlphabetic('Q'));
        System.out.println("isAlphabetic = " + Character.isAlphabetic('R'));
        System.out.println("isAlphabetic = " + Character.isAlphabetic('P'));
        System.out.println("isAlphabetic = " + Character.isAlphabetic('가')); // true
        System.out.println("isAlphabetic = " + Character.isAlphabetic('댥')); // true
        System.out.println("isAlphabetic = " + Character.isAlphabetic('1')); // false
        System.out.println("isAlphabetic = " + Character.isAlphabetic('2')); // false
        System.out.println("isAlphabetic = " + Character.isAlphabetic('5')); // false
        System.out.println("isAlphabetic = " + Character.isAlphabetic(' ')); // false
        System.out.println("isAlphabetic = " + Character.isAlphabetic('\n')); // false
        System.out.println("isAlphabetic = " + Character.isAlphabetic('\t')); // false
        System.out.println();

        // isLetter (** 일반적으로 사용)
        System.out.println("isLetter = " + Character.isLetter('a'));
        System.out.println("isLetter = " + Character.isLetter('b'));
        System.out.println("isLetter = " + Character.isLetter('z'));
        System.out.println("isLetter = " + Character.isLetter('Q'));
        System.out.println("isLetter = " + Character.isLetter('R'));
        System.out.println("isLetter = " + Character.isLetter('P'));
        System.out.println("isLetter = " + Character.isLetter('가')); // true
        System.out.println("isLetter = " + Character.isLetter('댥')); // true
        System.out.println("isLetter = " + Character.isLetter('1')); // false
        System.out.println("isLetter = " + Character.isLetter('2')); // false
        System.out.println("isLetter = " + Character.isLetter('5')); // false
        System.out.println("isLetter = " + Character.isLetter(' ')); // false
        System.out.println("isLetter = " + Character.isLetter('\n')); // false
        System.out.println("isLetter = " + Character.isLetter('\t')); // false
        System.out.println();

        // isAlphabetic vs isLetter
        System.out.println("isAlphabetic(𝐕) = " + Character.isAlphabetic('\u2164')); // ROMAN NUMERAL FIVE
        System.out.println("isLetter(𝐕)     = " + Character.isLetter('\u2164')); // ROMAN NUMERAL FIVE
        System.out.println();

        // isUpperCase
        System.out.println("isUpperCase() = " + Character.isUpperCase('a'));
        System.out.println("isUpperCase() = " + Character.isUpperCase('A'));
        System.out.println("isUpperCase() = " + Character.isUpperCase('1'));
        System.out.println("isUpperCase() = " + Character.isUpperCase(' '));
        System.out.println();

        // isLowerCase
        System.out.println("isLowerCase() = " + Character.isLowerCase('a'));
        System.out.println("isLowerCase() = " + Character.isLowerCase('A'));
        System.out.println("isLowerCase() = " + Character.isLowerCase('1'));
        System.out.println("isLowerCase() = " + Character.isLowerCase(' '));
        System.out.println();

        // toUpperCase, toUpperCase
        System.out.println("toUpperCase() = " + Character.toUpperCase('a'));
        System.out.println("toLowerCase() = " + Character.toLowerCase('A'));
        System.out.println("toUpperCase() = " + Character.toUpperCase('1'));
        System.out.println("toLowerCase() = " + Character.toLowerCase('1'));
        System.out.println();

        // UPPERCASE_LETTER, LOWERCASE_LETTER
        System.out.println("UPPERCASE_LETTER = " + (Character.UPPERCASE_LETTER == Character.getType('U')));
        System.out.println("LOWERCASE_LETTER = " + (Character.LOWERCASE_LETTER == Character.getType('u')));
        System.out.println("UPPERCASE_LETTER = " + (Character.UPPERCASE_LETTER == Character.getType('Z')));
        System.out.println("LOWERCASE_LETTER = " + (Character.LOWERCASE_LETTER == Character.getType('z')));
        System.out.println("UPPERCASE_LETTER = " + (Character.UPPERCASE_LETTER == Character.getType('A')));
        System.out.println("LOWERCASE_LETTER = " + (Character.LOWERCASE_LETTER == Character.getType('A'))); // false
        System.out.println();

        // TITLECASE_LETTER
        // https://www.fileformat.info/info/unicode/char/01f2/index.htm
        System.out.println("TITLECASE_LETTER = " + (Character.TITLECASE_LETTER == Character.getType('\u01f2')));

        // LETTER_NUMBER
        https://www.fileformat.info/info/unicode/char/2164/index.htm
        System.out.println("LETTER_NUMBER = " + (Character.LETTER_NUMBER == Character.getType('\u2164')));
        System.out.println();
    }
}

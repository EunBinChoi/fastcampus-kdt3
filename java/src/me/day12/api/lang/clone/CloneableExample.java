package me.day12.api.lang.clone;

import java.lang.reflect.Field;
import java.util.Objects;

class Country {
    private String country;

    public Country(String country) {
        this.country = country;
    }
}

class PhoneNumber {
    private String owner;
    private String phoneNumber;
    private final Country[] COUNTRY = {new Country("KR"), new Country("JP"), new Country("US")};

    public PhoneNumber() {
    }

    public PhoneNumber(String owner, String phoneNumber) {
        this.owner = owner;
        this.phoneNumber = phoneNumber;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Country[] getCOUNTRY() {
        return COUNTRY;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhoneNumber that = (PhoneNumber) o;
        return Objects.equals(owner, that.owner) && Objects.equals(phoneNumber, that.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(owner, phoneNumber);
    }

    @Override
    public PhoneNumber clone() throws RuntimeException {
        try {
            PhoneNumber cloned = (PhoneNumber) super.clone(); // 타입 캐스팅
//            cloned.COUNTRY = COUNTRY.clone(); // final이기 때문에 복사 불가
            return cloned;
        } catch (CloneNotSupportedException e) {
            // 아무처리를 하지 않거나 RuntimeException으로 감쌀 수 있음
            throw new RuntimeException();
        }
    }

    public static PhoneNumber getNewInstance(PhoneNumber origin) {
        try {
            PhoneNumber cloned = new PhoneNumber(origin.owner, origin.phoneNumber);
            Field countryField = PhoneNumber.class.getDeclaredField("COUNTRY");
            countryField.setAccessible(true);
            countryField.set(cloned, origin.COUNTRY.clone());
            return cloned;
        } catch (NoSuchFieldException e) {
            throw new RuntimeException();
        } catch (IllegalAccessException e) {
            throw new RuntimeException();
        }
    }
}

public class CloneableExample {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
//        System.out.println("1. clone()을 통한 복제");
//        PhoneNumber phoneNumber = new PhoneNumber();
//        PhoneNumber cloned = phoneNumber.clone();
//        System.out.println("phoneNumber == cloned : " + (phoneNumber == cloned));
//        System.out.println("phoneNumber.equals(cloned) : " + (phoneNumber.equals(cloned)));
//        System.out.println("phoneNumber.getClass() == cloned.getClass() : " + (phoneNumber.getClass() == cloned.getClass()));
//        System.out.println();
//
//        System.out.println(phoneNumber.getCOUNTRY()); // 주소 동일. final 필드에 대해서는 복사 어려움
//        System.out.println(cloned.getCOUNTRY()); // 주소 동일. final 필드에 대해서는 복사 어려움
//        System.out.println();

        System.out.println("2. 팩토리 메소드를 통한 복제");
        PhoneNumber phoneNumber2 = new PhoneNumber();
        PhoneNumber cloned2 = PhoneNumber.getNewInstance(phoneNumber2);
        System.out.println("phoneNumber2 == cloned2 : " + (phoneNumber2 == cloned2));
        System.out.println("phoneNumber2.equals(cloned2) : " + (phoneNumber2.equals(cloned2)));
        System.out.println("phoneNumber2.getClass() == cloned2.getClass() : " + (phoneNumber2.getClass() == cloned2.getClass()));
        System.out.println();

        System.out.println(phoneNumber2.getCOUNTRY()); // 주소 다름
        System.out.println(cloned2.getCOUNTRY()); // 주소 다름
        System.out.println();
        System.out.println();


    }

}

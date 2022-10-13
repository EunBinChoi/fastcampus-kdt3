package me.day03.practice;

public class Practice05 {
    public static void main(String[] args) {
        int year = 2020;
        int month = 2;
        int totalDays = 0;

        switch(month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                totalDays = 31;
                break;

            case 4:
            case 6:
            case 9:
            case 11:
                totalDays = 30;
                break;

            case 2:
                if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
                    totalDays = 29;
                } else {
                    totalDays = 28;
                }

                break;
        }

        System.out.printf("%d년 %d월의 총 일수는 %d일 입니다\n", year, month, totalDays);
    }
}

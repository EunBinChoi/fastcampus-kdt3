package me.day03.conditional;

public class SwitchIntExample {
    public static void main(String[] args) {
        int num = 10;

        switch(num) {
            case 1: // num == 1
                System.out.println("1");
                break;
            case 2: // num == 2
                System.out.println("2");
                break;
            case 3: // num == 3
                System.out.println("3");
                break;
            case 4: // num == 4
                System.out.println("4");
                break;
            case 5: // num == 5
                System.out.println("5");
                break;
            default: // 다 아니라면
                System.out.println("others");
                break;
        }
    }
}
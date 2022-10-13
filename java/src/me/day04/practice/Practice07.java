package me.day04.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Practice07 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] menus = {"김밥", "라면", "떡볶이", "돈까스", "종료"};
        int[] prices = { 2500, 3000, 4000, 5000 };
        int minPrice = min(prices);

        System.out.print("현금 얼마를 가지고 있니? ");
        int money = Integer.parseInt(bufferedReader.readLine());
        if (money < minPrice) {
            System.out.println("김밥천국 입장불가. 나중에 와주세요.");
            return;
        }
        while(true) {
            System.out.println("\n\n메뉴 선택해주세요.");
            System.out.println("=================================");
            for (int i = 0; i < menus.length ; i++) {
                if (i == menus.length - 1) {
                    System.out.printf("%d. %s\n", i + 1, menus[i]);
                } else {
                    System.out.printf("%d. %s (%d)\n", i + 1, menus[i], prices[i]);
                }
            }
            System.out.println("=================================");
            System.out.print("메뉴 주문 번호 => ");
            int choice = Integer.parseInt(bufferedReader.readLine());

            if (!(choice >= 1 && choice <= menus.length)) {
                System.out.printf("메뉴 선택 오류. 1 ~ %d번 메뉴를 선택해주세요.", menus.length);
                continue;
            }
            if (choice == menus.length) {
                System.out.println("종료.");
                break;
            }

            if (prices[choice-1] > money) {
                System.out.println("돈이 부족하여 메뉴를 선택할 수 없습니다.");
            } else {
                System.out.printf("%s 선택하셨습니다.\n", menus[choice-1]);
                money -= prices[choice-1];
                System.out.printf("잔돈은 %d 입니다.\n", money);
            }

            if (money < minPrice) {
                System.out.println("더 이상 주문할 수 없습니다.");
                System.out.println("지금까지 선택하신 식사 주문이 완료되었습니다.");
                break;
            }
        }
        bufferedReader.close();
    }
    public static int min(int[] array) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }
}

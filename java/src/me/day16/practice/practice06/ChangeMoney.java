package me.day16.practice.practice06;

public class ChangeMoney {
    private int[] changeMoneys;

    public ChangeMoney() {
//      0번째 : 500원  |   1번째 : 100원  |   2번째 : 50원   |   3번째 : 10원
        changeMoneys = new int[4];
    }

    public void setChangeMoney(int money) { 
        int temp = 0;
        changeMoneys[0] = money / 500;
        temp = money % 500;
        changeMoneys[1] = temp / 100;
        temp = temp % 100;
        changeMoneys[2] = temp / 50;
        temp = temp % 50;
        changeMoneys[3] = temp / 10;
    }
    public int[] getChangeMoney() {
        return this.changeMoneys;
    }
}

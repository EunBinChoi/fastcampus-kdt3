package me.day16.practice.practice06;

public class ChangeModule {
    enum COIN {
        KRW500(500), KRW100(100), KRW50(50), KRW10(10);
        private int value;
        COIN(int value){
            this.value = value;
        }
    }

    public CoinSet getChangeCoinSet(int changeAmount) {
        CoinSet coinSet = new CoinSet();
        int remainChangeAmount = changeAmount;
        for(COIN coin : COIN.values()) {
            remainChangeAmount = addCoinsToCoinSet(remainChangeAmount, coinSet, coin.value);
        }
        return coinSet;
    }

    private int addCoinsToCoinSet(int remainChangeAmount, CoinSet coinSet, int coin) {
        while (remainChangeAmount >= coin) {
            remainChangeAmount -= coin;
            coinSet.add(coin);
        }
        return remainChangeAmount;
    }
}

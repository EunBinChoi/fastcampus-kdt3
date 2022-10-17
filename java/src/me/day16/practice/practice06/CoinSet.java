package me.day16.practice.practice06;

import java.util.ArrayList;
import java.util.List;

public class CoinSet {
    private List<Integer> coinSets = new ArrayList<Integer>();

    public void add(int coin) {
        this.coinSets.add(coin);

    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof CoinSet)) {
            return false;
        }
        return this.toString().equals(obj.toString());
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for(Integer coin : this.coinSets) {
            builder.append(coin);
        }
        return builder.toString();
    }

}
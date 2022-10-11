package me.day13.generic.nogeneric;

import java.util.Objects;

public class GiftBox {
    private Object gift;

    public GiftBox() {
    }

    public GiftBox(Object gift) {
        this.gift = gift;
    }

    public Object getGift() {
        return gift;
    }

    public void setGift(Object gift) {
        this.gift = gift;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GiftBox that = (GiftBox) o;
        return gift.equals(that.gift);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gift);
    }

    @Override
    public String toString() {
        return "RandomGiftBox{" +
                "gift=" + gift +
                '}';
    }
}

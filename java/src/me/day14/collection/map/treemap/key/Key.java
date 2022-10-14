package me.day14.collection.map.treemap.key;

public class Key implements Comparable<Key> {
    private String serialNo;
    private String productNo;

    public Key() {
    }

    public Key(String serialNo, String productNo) {
        this.serialNo = serialNo;
        this.productNo = productNo;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public String getProductNo() {
        return productNo;
    }

    public void setProductNo(String productNo) {
        this.productNo = productNo;
    }

    @Override
    public String toString() {
        return "Key{" +
                "serialNo='" + serialNo + '\'' +
                ", productNo='" + productNo + '\'' +
                '}';
    }

    @Override
    public int compareTo(Key o) {
        return serialNo.compareTo(o.serialNo) * -1;
    }
}

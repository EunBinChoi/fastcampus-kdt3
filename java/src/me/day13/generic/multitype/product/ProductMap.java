package me.day13.generic.multitype.product;

import java.util.HashMap;
import java.util.Objects;

public class ProductMap<K, V> extends HashMap {
    protected K key; // 제품 일련번호
    protected V value; // 제품 객체

    public ProductMap() {
    }

    public ProductMap(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductMap<?, ?> product = (ProductMap<?, ?>) o;
        return key.equals(product.key) && value.equals(product.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, value);
    }

    @Override
    public String toString() {
        return "Product{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }
}

package me.day13.generic.inheritance;


import java.util.Objects;

public class Product<T, M> {
    private T kind;
    private M model;

    public Product() {
    }

    public Product(T kind, M model) {
        this.kind = kind;
        this.model = model;
    }

    public T getKind() {
        return kind;
    }

    public void setKind(T kind) {
        this.kind = kind;
    }

    public M getModel() {
        return model;
    }

    public void setModel(M model) {
        this.model = model;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product<?, ?> product = (Product<?, ?>) o;
        return kind.equals(product.kind) && model.equals(product.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(kind, model);
    }

    @Override
    public String toString() {
        return "Product{" +
                "kind=" + kind +
                ", model=" + model +
                '}';
    }
}

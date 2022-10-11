package me.day13.generic.inheritance;

import java.util.Objects;

public class ChildProduct<T, M, C> extends Product<T, M> {
    private C company;

    public ChildProduct() {
    }

    public ChildProduct(C company) {
        this.company = company;
    }

    public ChildProduct(T kind, M model, C company) {
        super(kind, model);
        this.company = company;
    }

    public C getCompany() {
        return company;
    }

    public void setCompany(C company) {
        this.company = company;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ChildProduct<?, ?, ?> that = (ChildProduct<?, ?, ?>) o;
        return company.equals(that.company);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), company);
    }

    @Override
    public String toString() {
        return "ChildProduct{" + super.toString() + ", " +
                "company=" + company +
                '}';
    }
}

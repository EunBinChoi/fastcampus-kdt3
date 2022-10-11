package me.day13.generic.method.gift;

import java.util.Objects;

public class Note {
    protected String productNo;
    protected String companyName;
    protected boolean hasLine;

    public Note() {
    }

    public Note(String productNo) {
        this.productNo = productNo;
    }

    public Note(String productNo, String companyName, boolean hasLine) {
        this.productNo = productNo;
        this.companyName = companyName;
        this.hasLine = hasLine;
    }

    public String getProductNo() {
        return productNo;
    }

    public void setProductNo(String productNo) {
        this.productNo = productNo;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public boolean hasLine() {
        return hasLine;
    }

    public void setHasLine(boolean hasLine) {
        this.hasLine = hasLine;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Note note = (Note) o;
        return hasLine == note.hasLine && productNo.equals(note.productNo) && companyName.equals(note.companyName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productNo, companyName, hasLine);
    }

    @Override
    public String toString() {
        return "Note{" +
                "productNo='" + productNo + '\'' +
                ", companyName='" + companyName + '\'' +
                ", hasLine=" + hasLine +
                '}';
    }
}

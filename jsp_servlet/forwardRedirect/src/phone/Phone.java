package phone;

import java.util.Objects;

public class Phone {
    private String first;
    private String middle;
    private String last;

    public Phone() {
    }

    public Phone(String first, String middle, String last) {
        this.first = first;
        this.middle = middle;
        this.last = last;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getMiddle() {
        return middle;
    }

    public void setMiddle(String middle) {
        this.middle = middle;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Phone phone = (Phone) o;
        return first.equals(phone.first) && middle.equals(phone.middle) && last.equals(phone.last);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, middle, last);
    }

    @Override
    public String toString() {
        return "Phone{" + first + "-" +
                middle + "-" +
                 last  + '}';
    }
}

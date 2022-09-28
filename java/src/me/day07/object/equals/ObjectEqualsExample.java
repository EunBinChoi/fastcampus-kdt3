package me.day07.object.equals;

import java.util.Objects;

public class ObjectEqualsExample {
    private int intVariable;
    private String strVariable;

    public ObjectEqualsExample() {}

    public ObjectEqualsExample(int intVariable, String strVariable) {
        this.intVariable = intVariable;
        this.strVariable = strVariable;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ObjectEqualsExample that = (ObjectEqualsExample) o;
        return intVariable == that.intVariable && strVariable.equals(that.strVariable);
    }

    @Override
    public int hashCode() { // 객체의 고유한 ID값
        return Objects.hash(intVariable, strVariable);
    }

//    @Override
//    public String toString() {
//        return "ObjectEqualsExample{" +
//                "intVariable=" + intVariable +
//                ", strVariable='" + strVariable + '\'' +
//                '}';
//    }
}

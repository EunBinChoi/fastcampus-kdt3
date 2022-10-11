package me.day12.api.lang.compare;

import java.util.Comparator;

public class ComparatorByGender implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        return o1.getGender().compareTo(o2.getGender());
    }
}

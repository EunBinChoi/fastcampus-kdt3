package me.day14.practice.practice01;

import java.util.HashMap;
import java.util.Map;

public class Table<K, V> {

    enum Column {
        sId, sPw, sName, sAge, sGender, sMajor;
    }

    private Map<K, V> table;

}

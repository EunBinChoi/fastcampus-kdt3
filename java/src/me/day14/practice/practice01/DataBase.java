package me.day14.practice.practice01;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;



public class DataBase {
    private static List<Table> tableList = new LinkedList<>();

    public static List<Table> getTableList() {
        return tableList;
    }
}

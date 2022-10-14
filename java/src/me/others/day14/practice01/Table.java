package me.others.day14.practice01;

import java.util.*;

public class Table<K, V> {
    private List<Column> columnList;
    private Map<K, V> data;


    public Table() {
        columnList = new LinkedList<>();
        data = new HashMap<>();
    }

    public Table(List<Column> columnList, Map<K, V> data) {
        this.columnList = columnList;
        this.data = data;
    }

    public List<Column> getColumnList() {
        return columnList;
    }

    public void setColumnList(List<Column> columnList) {
        this.columnList = columnList;
    }

    public Map<K, V> getData() {
        return data;
    }

    public void setData(Map<K, V> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Table{" +
                "columnList=" + columnList +
                ", data=" + data +
                '}';
    }
}

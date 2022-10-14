package me.others.day14.practice01;

import java.util.LinkedList;
import java.util.List;

public class DataBase {
    private static DataBase dataBase;
    private List<Table> tableList;

    public static DataBase getInstance() {
        if (dataBase == null) {
            dataBase = new DataBase();
        }
        return dataBase;
    }

    public DataBase() {
        tableList = new LinkedList<>();
    }

    public DataBase(List<Table> tableList) {
        this.tableList = tableList;
    }


    public List<Table> getTableList() {
        return tableList;
    }

    public void setTableList(List<Table> tableList) {
        this.tableList = tableList;
    }

    @Override
    public String toString() {
        return "DataBase{" +
                "tableList=" + tableList +
                '}';
    }
}

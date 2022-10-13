package me.smartstore.project.menu;

public enum OrderType {
    ASCENDING("오름차순"), DESCENDING("내림차순");

    String sortType = "";

    OrderType(String sortType) {
        this.sortType = sortType;
    }

    public String getSortType() {
        return this.sortType;
    }

    public void setSortType(String sortType) {
        this.sortType = sortType;
    }
}

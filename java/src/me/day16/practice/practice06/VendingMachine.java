package me.day16.practice.practice06;

public class VendingMachine {
    private int money;
    private int selectedProduct;

    public VendingMachine() {
    }

    public int getMoney() {
        return this.money;
    }

    public void setInputMoney(int money) {
        if(money < 0) {
            throw new IllegalArgumentException("투입 금액은 0보다 커야 합니다. : " + money);
        }
        this.money += money;
    }

    public void setSelectedProduct(int selectedProduct) {
        this.selectedProduct = selectedProduct;
    }

    public int getSelectedProduct() {
        return this.selectedProduct;
    }

    public int inputMoneyAndProductDeduct() {
        this.money -= this.selectedProduct;
        return this.money;
    }

}
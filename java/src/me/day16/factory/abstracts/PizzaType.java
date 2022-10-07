package me.day16.factory.abstracts;

public enum PizzaType {
    CHEESE("치즈"), PEPPERONI("페퍼로니"), CLAM("해물"), VEGGIE("베지");
    private String pizzaType;

    PizzaType(String pizzaType) {
        this.pizzaType = pizzaType;
    }

    public String getPizzaType() {
        return pizzaType;
    }

    public void setPizzaType(String pizzaType) {
        this.pizzaType = pizzaType;
    }
}
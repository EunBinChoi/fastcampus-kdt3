package me.day16.factory.method;

public enum PizzaStyle {
    NY("뉴욕"), CHICAGO("시카고");
    private String pizzaStyle;

    PizzaStyle(String pizzaStyle) {
        this.pizzaStyle = pizzaStyle;
    }

    public String getPizzaStyle() {
        return pizzaStyle;
    }

    public void setPizzaStyle(String pizzaStyle) {
        this.pizzaStyle = pizzaStyle;
    }
}

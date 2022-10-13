package me.others.pattern.factory.method;

import me.others.pattern.factory.simple.PizzaType;

public class DependentPizzaStore {

	public Pizza createPizza(String style, String type) {
		if (style == null || type == null) {
			System.out.println("Error: invalid type of pizza");
			return null;
		}

		Pizza pizza = null;
		if (style.equals(PizzaStyle.NY)) {
			if (type.equals(PizzaType.CHEESE)) {
				pizza = new NYStyleCheesePizza();
			} else if (type.equals(PizzaType.VEGGIE)) {
				pizza = new NYStyleVeggiePizza();
			} else if (type.equals(PizzaType.CLAM)) {
				pizza = new NYStyleClamPizza();
			} else if (type.equals(PizzaType.PEPPERONI)) {
				pizza = new NYStylePepperoniPizza();
			}
		} else if (style.equals(PizzaStyle.CHICAGO)) {
			if (type.equals(PizzaType.CHEESE)) {
				pizza = new ChicagoStyleCheesePizza();
			} else if (type.equals(PizzaType.VEGGIE)) {
				pizza = new ChicagoStyleVeggiePizza();
			} else if (type.equals(PizzaType.CLAM)) {
				pizza = new ChicagoStyleClamPizza();
			} else if (type.equals(PizzaType.PEPPERONI)) {
				pizza = new ChicagoStylePepperoniPizza();
			}
		}
		pizza.prepare();
		pizza.bake();
		pizza.cut();
		pizza.box();
		return pizza;
	}
}

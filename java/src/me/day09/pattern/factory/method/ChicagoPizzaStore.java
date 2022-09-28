package me.day08.pattern.factory.method;

import me.day08.pattern.factory.simple.PizzaType;

public class ChicagoPizzaStore extends PizzaStore {

	public Pizza createPizza(PizzaType item) {
		if (item == null) return null;

		if (item.equals(PizzaType.CHEESE)) {
			return new NYStyleCheesePizza();
		} else if (item.equals(PizzaType.VEGGIE)) {
			return new NYStyleVeggiePizza();
		} else if (item.equals(PizzaType.CLAM)) {
			return new NYStyleClamPizza();
		} else if (item.equals(PizzaType.PEPPERONI)) {
			return new NYStylePepperoniPizza();
		}
		return null;
	}
}

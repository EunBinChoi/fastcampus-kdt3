package me.others.pattern.factory.simple;

public class SimplePizzaFactory {

	public Pizza createPizza(PizzaType type) {
		if (type == null) return null;

		if (type.equals(PizzaType.CHEESE)) {
			return new CheesePizza();
		} else if (type.equals(PizzaType.PEPPERONI)) {
			return new PepperoniPizza();
		} else if (type.equals(PizzaType.CLAM)) {
			return new ClamPizza();
		} else if (type.equals(PizzaType.VEGGIE)) {
			return new VeggiePizza();
		}
		return null;
	}
}

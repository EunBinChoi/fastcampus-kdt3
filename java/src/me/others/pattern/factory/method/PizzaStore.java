package me.others.pattern.factory.method;

public abstract class PizzaStore {

	abstract Pizza createPizza(PizzaType item);

	public Pizza orderPizza(PizzaType type) {
		Pizza pizza = createPizza(type);
		System.out.println("--- Making a " + pizza.getName() + " ---");
		pizza.prepare();
		pizza.bake();
		pizza.cut();
		pizza.box();
		return pizza;
	}
}

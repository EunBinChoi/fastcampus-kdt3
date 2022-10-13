package me.others.pattern.factory.abstracts;

public class NYPizzaStore extends PizzaStore {

	protected Pizza createPizza(PizzaType item) {
		if (item == null) return null;

		Pizza pizza = null;
		PizzaIngredientFactory ingredientFactory =
				new NYPizzaIngredientFactory();

		if (item.equals(PizzaType.CHEESE)) {

			pizza = new CheesePizza(ingredientFactory);
			pizza.setName("New York Style Cheese Pizza");

		} else if (item.equals(PizzaType.VEGGIE)) {

			pizza = new VeggiePizza(ingredientFactory);
			pizza.setName("New York Style Veggie Pizza");

		} else if (item.equals(PizzaType.CLAM)) {

			pizza = new ClamPizza(ingredientFactory);
			pizza.setName("New York Style Clam Pizza");

		} else if (item.equals(PizzaType.PEPPERONI)) {

			pizza = new PepperoniPizza(ingredientFactory);
			pizza.setName("New York Style Pepperoni Pizza");

		}
		return pizza;
	}
}

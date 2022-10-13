package me.others.pattern.factory.abstracts;

public class ChicagoPizzaStore extends PizzaStore {

	protected Pizza createPizza(PizzaType item) {
		if (item == null) return null;

		Pizza pizza = null;
		PizzaIngredientFactory ingredientFactory =
				new ChicagoPizzaIngredientFactory();

		if (item.equals(PizzaType.CHEESE)) {
			pizza = new CheesePizza(ingredientFactory);
			pizza.setName("Chicago Style Cheese Pizza");

		} else if (item.equals(PizzaType.VEGGIE)) {
			pizza = new VeggiePizza(ingredientFactory);
			pizza.setName("Chicago Style Veggie Pizza");

		} else if (item.equals(PizzaType.CLAM)) {
			pizza = new ClamPizza(ingredientFactory);
			pizza.setName("Chicago Style Clam Pizza");

		} else if (item.equals(PizzaType.PEPPERONI)) {
			pizza = new PepperoniPizza(ingredientFactory);
			pizza.setName("Chicago Style Pepperoni Pizza");

		}
		return pizza;
	}
}

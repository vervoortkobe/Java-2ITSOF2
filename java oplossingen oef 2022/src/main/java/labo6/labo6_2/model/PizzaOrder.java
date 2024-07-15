package labo6.labo6_2.model;

public class PizzaOrder {
	private Pizza pizza;
	private PizzaSize pizzaSize;
	private PizzaBottom pizzaBottom;
	
	public Pizza getPizza() {
		return pizza;
	}
	public void setPizza(Pizza pizza) {
		this.pizza = pizza;
	}
	public PizzaSize getPizzaSize() {
		return pizzaSize;
	}
	public void setPizzaSize(PizzaSize pizzaSize) {
		this.pizzaSize = pizzaSize;
	}
	public PizzaOrder(Pizza pizza, PizzaSize pizzaSize, PizzaBottom bottom) {
		super();
		this.pizza = pizza;
		this.pizzaSize = pizzaSize;
		this.pizzaBottom = bottom;
	}
	@Override
	public String toString() {
		return "PizzaOrder [pizza=" + pizza + ", pizzaSize=" + pizzaSize + "]";
	}
	public PizzaBottom getPizzaBottom() {
		return pizzaBottom;
	}

	
}

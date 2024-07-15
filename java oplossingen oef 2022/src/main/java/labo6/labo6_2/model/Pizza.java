package labo6.labo6_2.model;

import java.util.List;

public class Pizza {
	private String name;
	private Double Price;
	private String category;
	private List<String> ingredients;
	
	public Pizza(String name, Double price, String category, List<String> ingredients) {
		super();
		this.name = name;
		this.Price = price;
		this.category = category;
		this.ingredients = ingredients;
	}

	public Double getPrice() {
		return Price;
	}

	public void setPrice(Double price) {
		Price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public List<String> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<String> ingredients) {
		this.ingredients = ingredients;
	}

	public Pizza(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Pizza [name=" + name + ", Price=" + Price + ", category=" + category + ", ingredients=" + ingredients
				+ "]";
	}


	
	
}

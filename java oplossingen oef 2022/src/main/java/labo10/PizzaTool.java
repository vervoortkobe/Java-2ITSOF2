package labo10;

import labo10.model.Pizza;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


public class PizzaTool {
	private List<Pizza> pizzas;
	private Set<String> ingredients;
	private Set<String> categories;

	public PizzaTool() {
		pizzas = new ArrayList<>();
		ingredients = new HashSet<>();
		categories = new HashSet<>();
	}

	public List<Pizza> getPizzas() {
		return pizzas;
	}

	public List<Pizza> getPizzasWithCat(String cat) {
		if (cat == null) {
			return new ArrayList<>();
		}
		return pizzas.parallelStream().filter(p -> cat.equals(p.getCategory())).collect(Collectors.toList());
	}

	public List<Pizza> getPizzasWithIngredient(String ingredient) {
		if (ingredient == null) {
			return new ArrayList<>();
		}
		return pizzas.parallelStream().filter(p -> p.getIngredients().contains(ingredient))
				.collect(Collectors.toList());
	}

	public void importCsvData() {
		List<Pizza> newPizzas = new ArrayList<>();

		try {
			File inputF = new File("pizza-list.csv");
			InputStream inputFS = new FileInputStream(inputF);
			BufferedReader br = new BufferedReader(new InputStreamReader(inputFS));
			newPizzas = br.lines().skip(1).map(l -> mapToPizza(l)).filter(x -> x != null).collect(Collectors.toList());
			br.close();
			Set<String> ingredients = new HashSet<>();
			for (Pizza pizza : newPizzas) {
				ingredients.addAll(pizza.getIngredients());
				categories.add(pizza.getCategory());
			}
			this.pizzas = newPizzas;
			this.ingredients = ingredients;
		} catch (IOException e) {
			System.out.println(e);
		}

	}

	private Pizza mapToPizza(String input) throws IndexOutOfBoundsException{
		String[] items = input.split(";");
		Double price = Double.parseDouble(items[1].replaceAll("€", "").replace(",", "."));
		List<String> ingredients = Arrays.asList(items[3].split(", | en | & "));
		Pizza pizza = new Pizza(items[0], price, items[2], ingredients);
		return pizza;
	}

	public List<String> getCategories() {
		return pizzas.stream().map(p -> p.getCategory()).distinct().collect(Collectors.toList());
	}
	
	public Set<String> getIngredients() {
		return ingredients;
	}

}

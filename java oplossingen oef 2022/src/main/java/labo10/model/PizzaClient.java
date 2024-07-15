package labo10.model;

import java.util.ArrayList;
import java.util.List;

public class PizzaClient {
	private String name;
	private List<PizzaOrder> orders;
	private Double totalPrice;
	
	
	public Double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public PizzaClient(String name) {
		super();
		this.name = name;
		orders = new ArrayList<PizzaOrder>();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<PizzaOrder> getOrders() {
		return orders;
	}
	public void addOrder(PizzaOrder order) {
		orders.add(order);
	}
	public void setOrders(List<PizzaOrder> orders) {
		this.orders = orders;
	}
	@Override
	public String toString() {
		return "PizzaClient [name=" + name + ", orders=" + orders + ", totalPrice=" + totalPrice + "]";
	}
	
}

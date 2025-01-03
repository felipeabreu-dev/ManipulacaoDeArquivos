package model.entities;

import java.text.DecimalFormat;
import java.util.Locale;

public class Products {
	private String name;
	private double price;
	private int quantity;
	
	public Products() {
	}

	public Products(String name, double price, int quantity) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public double totValue() {
		return price*quantity;
	}

	@Override
	public String toString() {
		Locale.setDefault(Locale.US);
		DecimalFormat df = new DecimalFormat("#0.00");
		StringBuilder builder = new StringBuilder();
		builder.append(name + "," + df.format(totValue()));
		return builder.toString();
	}
}

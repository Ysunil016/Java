package com.thoughtworks.Bean;

public class Item {

	private String name;
	private float price;
	private int quantity;
	private boolean isGoods;
	private boolean isImported;

	private float priceAfterTax;

	public Item(String name, float price, int quantity, boolean isGoods, boolean isImported) {
		super();
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.isGoods = isGoods;
		this.isImported = isImported;
	}

	public String getName() {
		return name;
	}

	public float getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}

	public boolean isGoods() {
		return isGoods;
	}

	public boolean isImported() {
		return isImported;
	}

	public float getPriceAfterTax() {
		return priceAfterTax;
	}

	public void setPriceAfterTax(float priceAfterTax) {
		this.priceAfterTax = priceAfterTax;
	}

	@Override
	public String toString() {
		return "Item [name=" + name + ", price=" + price + ", quantity=" + quantity + ", isGoods=" + isGoods
				+ ", isImported=" + isImported + ", priceAfterTax=" + priceAfterTax + "]";
	}

//	@Override
//	public String toString() {
//		return quantity + " " + name + " " + priceAfterTax;
//	}

}

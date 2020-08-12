package com.thoughtworks.Implementations;

import java.util.List;

import com.thoughtworks.Bean.Item;

public class ItemDisplay implements com.thoughtworks.Interface.ItemDisplay {

	@Override
	public void displayItemList(List<Item> items) {
		for (Item item : items) {
			System.out.println(item.getQuantity() + " " + item.getName() + ":" + item.getPriceAfterTax());
		}
	}

	@Override
	public void displaySalesTax(List<Item> items) {
		float salesTax = 0;
		for (Item item : items) {
			salesTax += item.getPriceAfterTax() - item.getPrice();
		}
		System.out.println("Sales Tax: " + salesTax);
	}

	@Override
	public void displayTotalPrice(List<Item> items) {
		float totalPrice = 0;
		for (Item item : items) {
			totalPrice += item.getPriceAfterTax();
		}
		System.out.println("Total: " + totalPrice);

	}

}

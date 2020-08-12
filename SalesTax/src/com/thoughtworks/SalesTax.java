package com.thoughtworks;

import java.util.Arrays;
import java.util.List;

import com.thoughtworks.Bean.Item;
import com.thoughtworks.Implementations.TaxCalculator;
import com.thoughtworks.Interface.ItemDisplay;
import com.thoughtworks.Interface.TaxCalculationInterface;
import com.thoughtworks.Parser.StringItemParser;

public class SalesTax {

	private TaxCalculationInterface taxCalculator = new TaxCalculator();

	private ItemDisplay itemDisplay = new com.thoughtworks.Implementations.ItemDisplay();

	List<Item> calculatedItems;

	// Dummy Test Main Method
	public static void main(String[] args) {
		List<String> itemsList = Arrays.asList("1 imported bottle of perfume at 27.99", "1 bottle of perfume at 18.99",
				"1 packet of headache pills at 9.75", "1 box of imported chocolates at 11.25");
		SalesTax sT = new SalesTax();
		sT.run(itemsList);
	}

	// Main Function to Run
	public void run(List<String> itemsList) {
		List<Item> allItems = new StringItemParser(itemsList).parseItems();
		for (Item item : allItems) {
			taxCalculator.calculateTax(item);
		}
		this.calculatedItems = allItems;
		displayItems(allItems);
	}

	// Display Manager
	public void displayItems(List<Item> items) {
		itemDisplay.displayItemList(items);
		itemDisplay.displaySalesTax(items);
		itemDisplay.displayTotalPrice(items);
	}

}

package com.thoughtworks.Interface;

import java.util.List;

import com.thoughtworks.Bean.Item;

public interface ItemDisplay {
	void displayItemList(List<Item> items);

	void displaySalesTax(List<Item> items);

	void displayTotalPrice(List<Item> items);
}

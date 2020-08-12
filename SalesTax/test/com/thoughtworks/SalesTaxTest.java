package com.thoughtworks;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.thoughtworks.Bean.Item;
import com.thoughtworks.Implementations.TaxCalculator;
import com.thoughtworks.Interface.TaxCalculationInterface;
import com.thoughtworks.Parser.StringItemParser;

public class SalesTaxTest {

	@Test
	public void test() {

	}

	@Test
	public void runTest() {
		List<String> itemsList = new ArrayList<>() {
			private static final long serialVersionUID = 1L;
			{
				add("1 imported box of chocolates at 10.00");
			}
		};

		List<Item> allItems = new StringItemParser(itemsList).parseItems();
		TaxCalculationInterface taxCalculator = new TaxCalculator();

		float totalPrice = 0;
		for (Item item : allItems) {
			taxCalculator.calculateTax(item);
			totalPrice += item.getPriceAfterTax();
		}

		assertEquals(10.5, totalPrice, 0.05);
	}

}

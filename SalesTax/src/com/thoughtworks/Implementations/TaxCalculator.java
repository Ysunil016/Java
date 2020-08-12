package com.thoughtworks.Implementations;

import com.thoughtworks.Bean.Item;
import com.thoughtworks.Interface.TaxCalculationInterface;

public class TaxCalculator implements TaxCalculationInterface {

	private float SALES_TAX = (float) 0.1;
	private float IMPORT_TAX = (float) 0.05;

	@Override
	public void calculateTax(Item item) {

		item.setPriceAfterTax(item.getPrice());
		if (item.isGoods()) {
			float priceAfterTax = item.getPriceAfterTax();
			float calculatedTax = calculateSalesTax(item.getPrice());
			item.setPriceAfterTax(priceAfterTax + calculatedTax);
		}
		if (item.isImported()) {
			float priceAfterTax = item.getPriceAfterTax();
			float calculatedTax = calculateImportTax(item.getPrice());
			item.setPriceAfterTax(priceAfterTax + calculatedTax);
		}
	}

	// Calculating Sales Taxes
	private float calculateSalesTax(float price) {
		return flotingPrecision(price * SALES_TAX);
	}

	// Calculating Import Taxes
	private float calculateImportTax(float price) {
		return flotingPrecision(price * IMPORT_TAX);
	}

	// Precision Asked
	private float flotingPrecision(float val) {
		return (float) Math.round(val * 10) / 10;
	}

}

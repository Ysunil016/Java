package com.thoughtworks.Parser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.thoughtworks.Bean.Item;

public class StringItemParser {

	List<String> allItemsInString;

	Exemptions exemptions;

	// Constructor to Set the List of Items
	public StringItemParser(List<String> itemsList) {
		this.exemptions = new Exemptions();
		this.allItemsInString = itemsList;
	}

	// Method to Parse the Item from List Of String to List of Items.
	public List<Item> parseItems() {
		List<Item> allItemsObject = new ArrayList<>();

		for (String itemString : this.allItemsInString) {
			itemString = itemString.trim();
			String[] splitString = itemString.split(" ");
			if (splitString.length > 3)
				allItemsObject.add(generateItemObject(splitString));
		}
		return allItemsObject;
	}

	// Conversion of Single String to Item Object
	private Item generateItemObject(String[] splitString) {
		int lengthOfSplittedString = splitString.length;
		int quantity = Integer.parseInt(splitString[0]);
		float price = Float.parseFloat(splitString[lengthOfSplittedString - 1]);

		boolean isItemGood = findIfItemIsGood(splitString);
		boolean isItemImported = findIfItemIsImported(splitString);

		return new Item(String.join(" ", Arrays.copyOfRange(splitString, 1, lengthOfSplittedString - 2)), price,
				quantity, isItemGood, isItemImported);
	}

	// Finding if Item is Imported
	private boolean findIfItemIsImported(String[] splitString) {
		for (String str : splitString) {
			if (str.toLowerCase().equals("imported")) {
				return true;
			}
		}
		return false;
	}

	// Finding if Item is Good
	private boolean findIfItemIsGood(String[] splitString) {
		for (String str : splitString) {
			if (exemptions.isExemption(str)) {
				return false;
			}
		}
		return true;
	}

}

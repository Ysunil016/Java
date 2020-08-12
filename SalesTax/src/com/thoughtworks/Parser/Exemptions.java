package com.thoughtworks.Parser;

import java.util.HashSet;

public class Exemptions {
	HashSet<String> allExemptionsItems = new HashSet<>() {
		private static final long serialVersionUID = 1L;

		{
			add("book");
			add("pills");
			add("chocolate");
			add("chocolates");
		}
	};

	public boolean isExemption(String item) {
		item = item.toLowerCase();
		return allExemptionsItems.contains(item);
	}

}
